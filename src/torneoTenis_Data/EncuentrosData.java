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
import java.time.LocalDate;
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
    
    public EncuentrosData(Conectar conexionEncuentros){
        this.conn = (Connection) conexionEncuentros.getConexion();
    }
    
    public void guardarEncuentros(Encuentros enc){
        String query = "INSERT INTO encuentros(fechaEnc, estadoEnCurso, ganador, activo)VALUES (?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(2, Date.valueOf(enc.getFechaEnc()));
            ps.setInt(3, enc.getEstadoEnCurso());
            ps.setInt(4, enc.getGanador());
            ps.setBoolean(8, enc.isActivo());
            
            ps.executeUpdate();
            ResultSet rst = ps.getGeneratedKeys();
            
            if(rst.next()){
                enc.setId_encuentro(rst.getInt(1));
                JOptionPane.showMessageDialog(null, "Encuentro Guardado Correctamente");
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nEncuentro No Guardado");
        }
    }
    
    public void guardarTantos(){
        
    }
    public void ganadorEncuentro(int id_jugador) {
        
    }
    
    public void actualizarEncuentro(int id_encuentro){
        
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
