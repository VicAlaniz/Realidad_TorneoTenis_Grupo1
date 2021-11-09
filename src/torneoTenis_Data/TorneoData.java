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
import torneotenis.Jugador;
import torneotenis.Torneo;

/**
 *
 * @author Familia
 */
public class TorneoData {
    private Connection conn = null;
    
    public TorneoData(Conectar conexionTorneo){
        this.conn = (Connection) conexionTorneo.getConexion();
    }
    
   public void guardarTorneo(Torneo t) {
       String query = "INSERT INTO torneos (nombre, fecha_ini, fecha_fin, activo) VALUES (?,?,?,?)";

        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, t.getNombre());
                ps.setDate(2, Date.valueOf(t.getFecha_ini()));
                ps.setDate(3, Date.valueOf(t.getFecha_fin()));
                ps.setBoolean(4, t.isActivo());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()){
                    t.setId_torneo(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Torneo Registrado Correctamente");
                }
                ps.close();
        } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nTorneo No Registrado");
          }
       
   }
   
   public void actualizarTorneo(Torneo t){
      
        String query = "UPDATE torneos SET nombre = ?, fecha_ini = ?, fecha_fin = ?, activo = ?  WHERE id_torneo = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
                ps.setString(1, t.getNombre());
                ps.setDate(2, Date.valueOf(t.getFecha_ini()));
                ps.setDate(3, Date.valueOf(t.getFecha_fin()));
                ps.setBoolean(4, t.isActivo());
                ps.setInt(5, t.getId_torneo());
                
                ps.executeUpdate();

            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Torneo Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Actualizar el Torneo");
             }
            ps.close();
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nTorneo No Encontrado");
         }
   }
   
   public List<Torneo> listaDeTorneos() {
       
       ArrayList<Torneo> listaDeTorneos = new ArrayList<>();
        
        String query = "SELECT * FROM torneos WHERE activo = true";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Torneo t = new Torneo();
                t.setId_torneo(rs.getInt("id_torneo"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_ini(rs.getDate("fecha_ini").toLocalDate());
                t.setFecha_fin(rs.getDate("fecha_fin").toLocalDate());
                t.setActivo(rs.getBoolean("activo"));
                
                listaDeTorneos.add(t);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nTorneos No Encontrados");
         }
        return listaDeTorneos;
   }
   
   public void borrarTorneo(int id_torneo) {
       String query = "UPDATE torneos SET activo = false WHERE id_torneo = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, id_torneo);
            ps.setInt(1, id_torneo);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Torneo Eliminado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Eliminar el Torneo");
             }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nTorneo No Encontrado");
         }
       
   } 
   public Torneo buscarTorneo(String nombreTorneo) {
       Torneo t = null;
        
        String query = "SELECT * FROM torneos WHERE nombre = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombreTorneo);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                t = new Torneo();
                t.setId_torneo(rs.getInt("id_torneo"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_ini(rs.getDate("fecha_ini").toLocalDate());
                t.setFecha_fin(rs.getDate("fecha_fin").toLocalDate());
                t.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nTorneo No Encontrado");
         }
        return t;
       
   }
   
    public Torneo buscarTorneoXId(int id) {
       Torneo t = null;
        
        String query = "SELECT * FROM torneos WHERE id_torneo = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                t = new Torneo();
                t.setId_torneo(rs.getInt("id_torneo"));
                t.setNombre(rs.getString("nombre"));
                t.setFecha_ini(rs.getDate("fecha_ini").toLocalDate());
                t.setFecha_fin(rs.getDate("fecha_fin").toLocalDate());
                t.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nTorneo No Encontrado");
         }
        return t;
       
   }
   
   public List<Jugador> listaJugadoresXTorneo(int id_torneo){
       ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
        
        String query = "SELECT jugador.id_jugador, jugador.nombreApellido, jugador.activo "
                + "FROM torneos, encuentros, jugador "
                + "WHERE torneos.id_torneo = ? "
                + "AND torneos.id_torneo = encuentros.id_torneo "
                + "AND jugador.id_jugador = encuentros.id_jugador1 " 
                + "UNION "
                + "SELECT jugador.id_jugador, jugador.nombreApellido, jugador.activo "
                + "FROM torneos, encuentros, jugador " 
                + "WHERE torneos.id_torneo = ? "
                + "AND torneos.id_torneo = encuentros.id_torneo " 
                + "AND jugador.id_jugador = encuentros.id_jugador2 ";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_torneo);
            ps.setInt(2, id_torneo);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Jugador j = new Jugador();
                j.setId_jugador(rs.getInt("id_jugador"));
                j.setNombreApellido(rs.getString("nombreApellido"));
                j.setActivo(rs.getBoolean("activo"));
                
                listaDeJugadores.add(j);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nTorneos sin jugadores");
         }
        return listaDeJugadores;  
    }
   public List<Torneo> listaTorneosXJugador(int id_jugador){
        ArrayList<Torneo> listaDeTorneosXJugador = new ArrayList<>();
        
        String query = "SELECT torneos.id_torneo, torneos.nombre, torneos.activo "
                + "FROM torneos, encuentros, jugador "
                + "WHERE jugador.id_jugador = ? "
                + "AND torneos.id_torneo = encuentros.id_torneo "
                + "AND jugador.id_jugador = encuentros.id_jugador1 "
                + "UNION "
                + "SELECT torneos.id_torneo, torneos.nombre, torneos.activo " 
                + "FROM torneos, encuentros, jugador " 
                + "WHERE jugador.id_jugador = ? " 
                + "AND torneos.id_torneo = encuentros.id_torneo " 
                + "AND jugador.id_jugador = encuentros.id_jugador2 ";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_jugador);
            ps.setInt(2, id_jugador);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Torneo t = new Torneo();
                t.setId_torneo(rs.getInt("id_torneo"));
                t.setNombre(rs.getString("nombre"));
                t.setActivo(rs.getBoolean("activo"));
                
                listaDeTorneosXJugador.add(t);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEste jugador no participa en ningun torneo"+ex.getMessage());
         }
        return listaDeTorneosXJugador;  
    }
   public void calcularRanking(int id_jugador){
        
    }
   
  
   
}
