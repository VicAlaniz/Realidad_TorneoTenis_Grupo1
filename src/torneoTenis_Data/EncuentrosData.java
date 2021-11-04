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
        String query = "INSERT INTO encuentros (fechaEnc, estadoEnCurso, ganador, id_jugador1, id_jugador2, id_estadio, id_torneo, activo) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(enc.getFechaEnc()));
            ps.setInt(2, enc.getEstadoEnCurso());
            ps.setInt(3, enc.getGanador().getId_jugador());
            ps.setInt(4, enc.getJugador1().getId_jugador());
            ps.setInt(5, enc.getJugador2().getId_jugador());
            ps.setInt(6, enc.getEstadio().getId_estadio());
            ps.setInt(7, enc.getTorneo().getId_torneo());
            ps.setBoolean(8, enc.isActivo());
            
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
         Encuentros e = new Encuentros();
        
        String query = "SELECT * FROM encuentros WHERE id_encuentro = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){

                e.setId_encuentro(rs.getInt("id_encuentro"));
                e.setFechaEnc(rs.getDate("fechaEnc").toLocalDate());
                e.setEstadoEnCurso(rs.getInt("estadoEnCurso"));
                e.setGanador(rs.getInt("ganador"));
                e.setJugador1(rs.getInt());
                e.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nSponsor no encontrado");
         }
        return s; 
    }
    public void ganadorEncuentro(int id_jugador) {
        
    }
    
    public void actualizarEncuentro(Encuentros enc){
        
    }
    
    public List<Encuentros> listaDeEncuentros(int estadoEnCurso){
        
        ArrayList<Encuentros> listaDeEncuentros = new ArrayList<>();
        
        String query = "SELECT * FROM encuentros WHERE activo = false";
         
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                
                Encuentros enc = new Encuentros();
                
                enc.setId_encuentro(rst.getInt(1));
                enc.setFechaEnc(rst.getDate(2).toLocalDate());
                enc.setEstadoEnCurso(rst.getInt(3));
                enc.setGanador(rst.getInt(4));
                //enc.setJugador1(rst.getInt(5));
                //enc.setJugador2(rst.getInt(6));
                //enc.setEstadio(rst.getInt(7));
                //enc.setTorneo(rst.getInt(8));
                enc.setActivo(rst.getBoolean(9));
                
                listaDeEncuentros.add(enc);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nNo hay Encuentros");   
        }
        return listaDeEncuentros;
    }

    public List<Encuentros> listaEncuentrosXJugador(int id_jugador){
        
        return list;
    }
    
    public List<Jugador> listaJugadoresXTorneo(int id_torneo){
        
    }
    public List<Torneo> listaTorneosXJugador(int id_jugador){
        
    }
     public void calcularRanking(int ganador){
        
    }
}
