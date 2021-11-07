/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneotenis.Conectar;
import torneotenis.Estadio;

/**
 *
 * @author Familia
 */
public class EstadioData {
    private Connection conn = null;
    
    public EstadioData(Conectar conexionEstadio){
        this.conn = (Connection) conexionEstadio.getConexion();
    }
    
    public void guardarEstadio(Estadio est){
        String query = "INSERT INTO estadio(nombre, ciudad, ancho, largo, categoria, habilitado, direccion, capacidad, activo) VALUES (?,?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, est.getNombre());
                ps.setString(2, est.getCiudad());
                ps.setFloat (3, est.getAncho());
                ps.setFloat(4, est.getLargo());
                ps.setString(5, est.getCategoria());
                ps.setBoolean(6, est.isHabilitado());
                ps.setString(7, est.getDireccion());
                ps.setInt(8, est.getCapacidad());
                ps.setBoolean(9, est.isActivo());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()){
                    est.setId_estadio(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Estadio Registrado Correctamente");
                }
                ps.close();
        } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nEstadio No Registrado");
          }
        
    }
    
    public Estadio buscarEstadio(String nombreEstadio){
        
        Estadio est = null;
        
        String query = "SELECT * FROM estadio WHERE nombre = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombreEstadio);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                est = new Estadio();
                est.setId_estadio(rs.getInt("id_estadio"));
                est.setNombre(rs.getString("nombre"));
                est.setCiudad(rs.getString("ciudad"));
                est.setAncho(rs.getFloat("ancho"));
                est.setLargo(rs.getFloat("largo"));
                est.setCategoria(rs.getString("categoria"));
                est.setHabilitado(rs.getBoolean("habilitado"));
                 est.setDireccion(rs.getString("direccion"));
                est.setCapacidad(rs.getInt("capacidad"));
                est.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEstadio No Encontrado");
         }
        return est;
    }
    public Estadio buscarEstadioXId(int id){
        
        Estadio est = null;
        
        String query = "SELECT * FROM estadio WHERE id_estadio = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                est = new Estadio();
                est.setId_estadio(rs.getInt("id_estadio"));
                est.setNombre(rs.getString("nombre"));
                est.setCiudad(rs.getString("ciudad"));
                est.setAncho(rs.getFloat("ancho"));
                est.setLargo(rs.getFloat("largo"));
                est.setCategoria(rs.getString("categoria"));
                est.setHabilitado(rs.getBoolean("habilitado"));
                 est.setDireccion(rs.getString("direccion"));
                est.setCapacidad(rs.getInt("capacidad"));
                est.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEstadio No Encontrado");
         }
        return est;
    }
    
    public void actualizarEstadio(Estadio est){
        String query = "UPDATE estadio SET nombre = ?, ciudad = ?, ancho = ?, largo = ?, categoria = ?, habilitado = ?, direccion = ?, capacidad = ?, activo = ?  WHERE id_estadio = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
                ps.setString(1, est.getNombre());
                ps.setString(2, est.getCiudad());
                ps.setFloat(3, est.getAncho());
                ps.setFloat(4, est.getLargo());
                ps.setString(5, est.getCategoria());
                ps.setBoolean(6, est.isHabilitado());
                ps.setString(7, est.getDireccion());
                 ps.setInt(8, est.getCapacidad());
                ps.setBoolean(9, est.isActivo());
                ps.setInt(10, est.getId_estadio());
                
                ps.executeUpdate();

            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Estadio Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Actualizar el Estadio");
             }
            ps.close();
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nEstadio No Encontrado");
         }
        
    }
    public List<Estadio> listaDeEstadios(){
        
     ArrayList<Estadio> listaDeEstadios = new ArrayList<>();
        
        String query = "SELECT * FROM estadio WHERE activo = true";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Estadio e = new Estadio();
                e.setId_estadio(rs.getInt("id_estadio"));
                e.setNombre(rs.getString("nombre"));
                e.setCiudad(rs.getString("ciudad"));
                e.setAncho(rs.getFloat("ancho"));
                e.setAncho(rs.getFloat("largo"));
                e.setCategoria(rs.getString("categoria"));
                e.setHabilitado(rs.getBoolean("habilitado"));
                e.setDireccion(rs.getString("direccion"));
                e.setCapacidad(rs.getInt("capacidad"));
                e.setActivo(rs.getBoolean("activo"));
                
                listaDeEstadios.add(e);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEstadios No Encontrados");
         }
        return listaDeEstadios;
    }
        
    //}
    public void borrarEstadio(int id_estadio){
         String query = "UPDATE estadio SET activo = false WHERE id_estadio = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, id_estadio);
            ps.setInt(1, id_estadio);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Estadio Eliminado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Eliminar el Estadio");
             }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEstadio No Encontrado");
         }
        
    }  
}
