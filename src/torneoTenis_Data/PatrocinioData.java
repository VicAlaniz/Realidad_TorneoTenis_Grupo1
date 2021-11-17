/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import torneotenis.Conectar;
import torneotenis.Jugador;
import torneotenis.Patrocinio;
import torneotenis.Sponsor;


/**
 *
 * @author Familia
 */
public class PatrocinioData {
    private Connection conn = null;
    private SponsorData sd = null;
    private JugadorData jd = null;
    
    public PatrocinioData(Conectar conn){
        this.conn = (Connection) conn.getConexion();
        sd = new SponsorData(conn);
        jd = new JugadorData(conn);
    }
    
    public void guardarPatrocinio(Patrocinio p){
     String query = "INSERT INTO patrocinio(id_sponsor, id_jugador, activo) VALUES (?, ?, ?)";
    
        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getSponsor().getId_sponsor());
            ps.setInt(2, p.getJugador().getId_jugador());
            ps.setBoolean(3, p.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                p.setId_patrocinio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Patrocinio creado");
            }
            ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo firmar el contrato");
        }
    }

    public void borrarPatrocinio(int id_sponsor, int id_jugador) {
        String query = "UPDATE patrocinio SET activo = false WHERE id_sponsor = ? AND id_jugador = ?";
        
        
        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_sponsor);
            ps.setInt(2, id_jugador);
            
            if (ps.executeUpdate()>0){
               JOptionPane.showMessageDialog(null, "Patrocinio borrado");  
             }
             else {
                 JOptionPane.showMessageDialog(null, "Error al borrar patrocinio");
             }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }     
    }
 
    public List<Patrocinio> listaDePatrocinios() {
        Patrocinio p = null;
      ArrayList<Patrocinio> listaPatrocinio = new ArrayList<>();
         String query = "SELECT * FROM patrocinio WHERE activo = true";

        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p = new Patrocinio();
                p.setId_patrocinio(rs.getInt("id_patrocinio"));
                Jugador j = jd.buscarJugadorXId(rs.getInt("id_jugador"));
                p.setJugador(j);
                Sponsor s = sd.buscarSponsorXId(rs.getInt("id_sponsor"));
                p.setSponsor(s);
                p.setActivo(true);

                listaPatrocinio.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return listaPatrocinio;  
    }
   
    /*public List<Patrocinio> obtenerPatrocinioXJugador(int id){
        Patrocinio p = null;
        ArrayList<Patrocinio> patrociniosXJugador = new ArrayList<>();

        String query = "SELECT * FROM patrocinio WHERE id_jugador = ? AND activo = true";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id); 
            ResultSet rs = ps.executeQuery();            
            
            while(rs.next()){
                p = new Patrocinio();
                p.setId_patrocinio(rs.getInt("id_patrocinio"));
                Jugador j = jd.buscarJugadorXId(rs.getInt("id_jugador"));
                p.setJugador(j);
                Sponsor s = sd.buscarSponsorXId(rs.getInt("id_sponsor"));
                p.setSponsor(s);
                p.setActivo(true);
                patrociniosXJugador.add(p);
            }      
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return patrociniosXJugador;
    }*/
    
    public List<Sponsor> obtenerSponsorXJugador(int id){
        Patrocinio p = null;
        ArrayList<Sponsor> patrociniosXJugador = new ArrayList<>();

        String query = "SELECT * FROM patrocinio WHERE id_jugador = ? AND activo = true";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id); 
            ResultSet rs = ps.executeQuery();            
            
            while(rs.next()){
                p = new Patrocinio();
                p.setId_patrocinio(rs.getInt("id_patrocinio"));
                Jugador j = jd.buscarJugadorXId(rs.getInt("id_jugador"));
                p.setJugador(j);
                Sponsor s = sd.buscarSponsorXId(rs.getInt("id_sponsor"));
                p.setSponsor(s);
                p.setActivo(true);
                patrociniosXJugador.add(s);
            }      
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return patrociniosXJugador;
    }
}
