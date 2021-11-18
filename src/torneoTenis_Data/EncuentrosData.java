/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneotenis.Conectar;
import torneotenis.Encuentros;
import torneotenis.Estadio;
import torneotenis.Jugador;
import torneotenis.Torneo;

/**
 *
 * @author Familia
 */
public class EncuentrosData {
    private Connection conn = null;
    private JugadorData jd = null;
    private TorneoData td = null;
    private EstadioData ed = null;
    
    public EncuentrosData(Conectar conn){
        this.conn = (Connection) conn.getConexion();
        jd = new JugadorData(conn);
        td = new TorneoData(conn);
        ed = new EstadioData(conn);
        
    }
    
    public void guardarEncuentros(Encuentros enc){
        String query = "INSERT INTO encuentros (fechaEnc, estadoEnCurso, id_jugador1, id_jugador2, id_estadio, id_torneo, activo) VALUES (?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(enc.getFechaEnc()));
            ps.setInt(2, enc.getEstadoEnCurso());
            //ps.setInt(3, enc.getGanador().getId_jugador());
            ps.setInt(3, enc.getJugador1().getId_jugador());
            ps.setInt(4, enc.getJugador2().getId_jugador());
            ps.setInt(5, enc.getEstadio().getId_estadio());
            ps.setInt(6, enc.getTorneo().getId_torneo());
            ps.setBoolean(7, enc.isActivo());
            
            ps.executeUpdate();
            ResultSet rst = ps.getGeneratedKeys();
            
            if(rst.next()){
                enc.setId_encuentro(rst.getInt(1));
                JOptionPane.showMessageDialog(null, "Encuentro Guardado Correctamente");
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEncuentro No Guardado"+ex.getMessage());
        }
    }
    
    public Encuentros buscarEncuentro(int id){
         Encuentros enc = new Encuentros();
        
        String query = "SELECT * FROM encuentros WHERE id_encuentro = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                enc.setId_encuentro(rst.getInt("id_encuentro"));
                enc.setFechaEnc(rst.getDate("fechaEnc").toLocalDate());
                enc.setEstadoEnCurso(rst.getInt("estadoEnCurso"));
                Jugador gan = jd.buscarJugadorXId(rst.getInt("ganador"));
                enc.setGanador(gan);
                Jugador j1 = jd.buscarJugadorXId(rst.getInt("id_jugador1"));
                enc.setJugador1(j1);
                Jugador j2 = jd.buscarJugadorXId(rst.getInt("id_jugador2"));
                enc.setJugador2(j2);
                Estadio es = ed.buscarEstadioXId(rst.getInt("id_estadio"));
                enc.setEstadio(es);
                Torneo tor = td.buscarTorneoXId(rst.getInt("id_torneo"));
                enc.setTorneo(tor);
                enc.setActivo(true);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEncuentro no encontrado");
         }
        return enc; 
    }
    public void ganadorEncuentro(Encuentros enc) {
         String query = "UPDATE encuentros SET ganador = ?  WHERE id_encuentro = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
                
                ps.setInt(1, enc.getGanador().getId_jugador());
                ps.setInt(2, enc.getId_encuentro());
                
                ps.executeUpdate();

            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Ganador Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Actualizar el Ganador");
             }
            ps.close();
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nJugador No Encontrado");
         }
    }
    
    public void actualizarEncuentro(Encuentros enc){
         String query = "UPDATE encuentros SET fechaEnc = ?, estadoEnCurso = ?, ganador = ?, id_jugador1 = ?, id_jugador2 = ?, id_estadio = ?, id_torneo = ?, activo = ?  WHERE id_encuentro = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
                
            ps.setDate(1, Date.valueOf(enc.getFechaEnc()));
            ps.setInt(2, enc.getEstadoEnCurso());
            ps.setInt(3, enc.getGanador().getId_jugador());
            ps.setInt(4, enc.getJugador1().getId_jugador());
            ps.setInt(5, enc.getJugador2().getId_jugador());
            ps.setInt(6, enc.getEstadio().getId_estadio());
            ps.setInt(7, enc.getTorneo().getId_torneo());
            ps.setBoolean(8, enc.isActivo());
            ps.setInt(9, enc.getId_encuentro());
                
                ps.executeUpdate();

            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Encuentro Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Actualizar encuentro");
             }
            ps.close();
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nEncuentro No Encontrado");
         }
    }
    
    public void borrarEncuentro(int id) {
        String query = "UPDATE encuentros SET activo = false WHERE id_encuentro = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, id);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Encuentro Eliminado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Eliminar Encuentro");
             }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEncuentro No Encontrado");
         }
    }
    public List<Jugador> listaPosibleGanador(int id_encuentro){
        ArrayList<Jugador> listaDeJugadoresXPartido = new ArrayList<>();
        String query = "SELECT encuentros.id_jugador1, encuentros.id_jugador2 FROM encuentros WHERE encuentros.id_encuentro = ? ";
           try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_encuentro);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Jugador j1 = new Jugador();
                j1 = jd.buscarJugadorXId(rs.getInt("id_jugador1"));
                
                
                Jugador j2 = new Jugador();
                j2 = jd.buscarJugadorXId(rs.getInt("id_jugador2"));
                //Jugador j = new Jugador();
                //j.setId_jugador(rs.getInt("id_jugador1"));
               
                //Jugador j2 = new Jugador();
                //j2.setId_jugador(rs.getInt("id_jugador2"));
                
                 listaDeJugadoresXPartido.add(j1);
                 listaDeJugadoresXPartido.add(j2);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nNo hay jugadores"+ ex.getMessage());   
        }
        return  listaDeJugadoresXPartido;
    }       
    
    public List<Encuentros> listaDeEncuentros(){
        
     ArrayList<Encuentros> listaDeEncuentros = new ArrayList<>();
        
        String query = "SELECT * FROM encuentros WHERE activo = true";
         
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                
                Encuentros enc = new Encuentros();    
                enc.setId_encuentro(rst.getInt("id_encuentro"));
                enc.setFechaEnc(rst.getDate("fechaEnc").toLocalDate());
                enc.setEstadoEnCurso(rst.getInt("estadoEnCurso"));
                Jugador gan = jd.buscarJugadorXId(rst.getInt("ganador"));
                enc.setGanador(gan);
                Jugador j1 = jd.buscarJugadorXId(rst.getInt("id_jugador1"));
                enc.setJugador1(j1);
                Jugador j2 = jd.buscarJugadorXId(rst.getInt("id_jugador2"));
                enc.setJugador2(j2);
                Estadio es = ed.buscarEstadioXId(rst.getInt("id_estadio"));
                enc.setEstadio(es);
                Torneo tor = td.buscarTorneoXId(rst.getInt("id_torneo"));
                enc.setTorneo(tor);
                enc.setActivo(true);
                
                listaDeEncuentros.add(enc);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nNo hay Encuentros"+ ex.getMessage());   
        }
        return listaDeEncuentros;
    }

    public List<Encuentros> listaEncuentrosXJugador(int id_jugador){
        
        ArrayList<Encuentros> listaDeEncuentrosXJugador = new ArrayList<>();
        
        String query = "SELECT encuentros.id_encuentro, encuentros.fechaEnc "
                + "FROM encuentros, jugador "
                + "WHERE jugador.id_jugador = ? "
                + "AND jugador.id_jugador = encuentros.id_jugador1 "
                + "UNION "
                + "SELECT encuentros.id_encuentro, encuentros.fechaEnc "
                + "FROM encuentros, jugador " 
                + "WHERE jugador.id_jugador = ? " 
                + "AND jugador.id_jugador = encuentros.id_jugador2";
        
            try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_jugador);
            ps.setInt(2, id_jugador);
            ResultSet rs = ps.executeQuery();
                         
           while(rs.next()){
                Encuentros e = new Encuentros();
                e.setId_encuentro(rs.getInt("id_encuentro"));
                e.setFechaEnc(rs.getDate("fechaEnc").toLocalDate());
               
                
                listaDeEncuentrosXJugador.add(e);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEste jugador no participa en ningun encuentro"+ex.getMessage());
         }
        return listaDeEncuentrosXJugador;  
    }
  public List<Encuentros> listaDeEncuentrosFuturos(){
        
     ArrayList<Encuentros> listaDeEncuentrosFuturos = new ArrayList<>();
        
        String query = "SELECT * FROM encuentros WHERE fechaEnc >= CURDATE() AND activo = true";
         
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                
                Encuentros enc = new Encuentros();    
                enc.setId_encuentro(rst.getInt("id_encuentro"));
                enc.setFechaEnc(rst.getDate("fechaEnc").toLocalDate());
                enc.setEstadoEnCurso(rst.getInt("estadoEnCurso"));
                Jugador gan = jd.buscarJugadorXId(rst.getInt("ganador"));
                enc.setGanador(gan);
                Jugador j1 = jd.buscarJugadorXId(rst.getInt("id_jugador1"));
                enc.setJugador1(j1);
                Jugador j2 = jd.buscarJugadorXId(rst.getInt("id_jugador2"));
                enc.setJugador2(j2);
                Estadio es = ed.buscarEstadioXId(rst.getInt("id_estadio"));
                enc.setEstadio(es);
                Torneo tor = td.buscarTorneoXId(rst.getInt("id_torneo"));
                enc.setTorneo(tor);
                enc.setActivo(true);
                
                listaDeEncuentrosFuturos.add(enc);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nNo hay Encuentros"+ ex.getMessage());   
        }
        return listaDeEncuentrosFuturos;
    }  
   
}
