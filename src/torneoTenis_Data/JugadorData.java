/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneotenis.Conectar;
import torneotenis.Jugador;

/**
 *
 * @author rataq
 */
public class JugadorData {
    private Connection conn = null;
    
    public JugadorData(Conectar conexionJugador){
        this.conn = (Connection) conexionJugador.getConexion();
    }
    
    public void registrarJugador(Jugador jugador){
        String query = "INSERT INTO jugador(nombreApellido, dni, fechaNac, altura, peso, estilo, manoHabil, activo)VALUES (?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, jugador.getNombreApellido());
                ps.setInt(2, jugador.getDni());
                ps.setDate(3, Date.valueOf(jugador.getFechaNac()));
                ps.setFloat(4, jugador.getAltura());
                ps.setFloat(5, jugador.getPeso());
                ps.setString(6, jugador.getEstilo());
                ps.setString(7, jugador.getManoHabil());
                ps.setBoolean(8, jugador.isActivo());

                ps.executeUpdate();
                ResultSet rst = ps.getGeneratedKeys();

                if(rst.next()){
                    jugador.setId_jugador(rst.getInt(1));
                    JOptionPane.showMessageDialog(null, "Jugador Registrado Correctamente");
                }
                ps.close();
        } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nJugador No Registrado");
          }
    }

    public Jugador buscarJugador(String tenista){
        Jugador j = null;
        
        String query = "SELECT * FROM jugador WHERE nombreApellido = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tenista);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                j = new Jugador();
                j.setId_jugador(rst.getInt("id_jugador"));
                j.setNombreApellido(rst.getString("nombreApellido"));
                j.setDni(rst.getInt("dni"));
                j.setFechaNac(rst.getDate("fechaNac").toLocalDate());
                j.setAltura(rst.getFloat("altura"));
                j.setPeso(rst.getFloat("peso"));
                j.setEstilo(rst.getString("estilo"));
                j.setManoHabil(rst.getString("manoHabil"));
                j.setActivo(rst.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nJugador No Encontrado");
         }
        return j;
    }
    
    public void actualizarJugador(Jugador t){
        String query = "UPDATE jugador SET nombreApellido = ?, dni = ?, fechaNac = ?, altura = ?, peso = ?, estilo = ?, manoHabil = ?, activo = ?  WHERE id_jugador = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
                ps.setString(1, t.getNombreApellido());
                ps.setInt(2, t.getDni());
                ps.setDate(3, Date.valueOf(t.getFechaNac()));
                ps.setFloat(4, t.getAltura());
                ps.setFloat(5, t.getPeso());
                ps.setString(6, t.getEstilo());
                ps.setString(7, t.getManoHabil());
                ps.setBoolean(8, t.isActivo());
                ps.setInt(9, t.getId_jugador());
                
                ps.executeUpdate();

            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Jugador Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Actualizar el jugador");
             }
            ps.close();
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nJugador No Encontrado");
         }
    }
    
    public void eliminarJugador(int dni){
        String query = "UPDATE jugador SET activo = false WHERE dni = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, dni);
            ps.setInt(1, dni);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Jugador Eliminado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Intentar Eliminar el Jugador");
             }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nJugador No Encontrado");
         }
    }
    
    public List<Jugador> listaDeJugadores(){
        ArrayList<Jugador> listaDeJugadores = new ArrayList<>();
        
        String query = "SELECT * FROM jugador WHERE activo = true";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                Jugador j = new Jugador();
                j.setId_jugador(rst.getInt("id_jugador"));
                j.setNombreApellido(rst.getString("nombreApellido"));
                j.setDni(rst.getInt("dni"));
                j.setFechaNac(rst.getDate("fechaNac").toLocalDate());
                j.setAltura(rst.getFloat("altura"));
                j.setPeso(rst.getFloat("peso"));
                j.setEstilo(rst.getString("estilo"));
                j.setManoHabil(rst.getString("manoHabil"));
                j.setActivo(rst.getBoolean("activo"));
                
                listaDeJugadores.add(j);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nJugador No Encontrado");
         }
        return listaDeJugadores;
    }
}
