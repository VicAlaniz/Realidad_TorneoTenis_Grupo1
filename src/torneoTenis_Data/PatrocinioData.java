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
     String query = "INSERT INTO patrocinio (id_sponsor, id_jugador, activo) VALUES (?, ?, ?)";
    
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
      ArrayList<Patrocinio> listaPatrocinio = new ArrayList<>();
         String query = "SELECT * FROM patrocinio WHERE patrocinio.id_patrocinio = ? activo = true";

        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patrocinio p = new Patrocinio();

                p.setId_patrocinio(rs.getInt("id_patrocinio"));
                Jugador j = buscarJugador(rs.getInt("dni"));
                p.setJugador(j);
                Sponsor s = buscarSponsor(rs.getInt("id_sponsor"));
                p.setSponsor(s);
                p.setActivo(rs.getBoolean("activo"));

                listaPatrocinio.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return listaPatrocinio;  
    }
   
    public List<Patrocinio> obtenerPatrocinioXJugador(int id){
        Patrocinio p = null;
        ArrayList<Patrocinio> patrociniosXJugador = new ArrayList<>();

        String query = "SELECT * FROM patrocinio WHERE patrocinio.id_jugador = ? AND activo = true";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id); 
            ResultSet rs = ps.executeQuery();            
            //Cursada cursada;
            while(rs.next()){
                p = new Patrocinio();
                p.setId_patrocinio(rs.getInt(1));
                
                Jugador j = buscarJugador(rs.getInt("id_jugador"));
                p.setJugador(j);
                Sponsor s = buscarSponsor(rs.getInt("id_sponsor"));
                p.setSponsor(s);
                
                patrociniosXJugador.add(p);
            }      
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return patrociniosXJugador;
    }
    public Sponsor buscarSponsor(int id_sponsor){
        Sponsor s = new Sponsor(); 
        String query = "SELECT s.id_sponsor, s.marca, s.indumentaria, s.activo FROM patrocinio AS p, sponsor AS s WHERE p.id_sponsor = s.id_sponsor AND p.id_sponsor = ?";
        try {
            PreparedStatement ps= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_sponsor);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                s.setMarca(rs.getString("marca"));
                s.setIndumentaria(rs.getString("indumentaria"));
                s.setActivo(rs.getBoolean("activo"));
                s.setId_sponsor(rs.getInt("id_sponsor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion metodo buscar Sponsor");
        }
        return s;
    }
     public Jugador buscarJugador(int id_jugador){
        Jugador j = new Jugador(); 
        String query = "SELECT j.id_jugador, j.nombreApellido, j.dni, j.fechaNac, j.altura, j.peso, j.estilo, j.manoHabil, j.activo FROM patrocinio AS p, jugador AS j WHERE p.id_jugador = j.id_jugador AND p.id_jugador = ?";
        try {
            PreparedStatement ps= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_jugador);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                j.setNombreApellido(rs.getString("nombreApellido"));
                j.setDni(rs.getInt("dni"));
                j.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                j.setAltura(rs.getFloat("altura"));
                j.setPeso(rs.getFloat("peso"));
                j.setEstilo(rs.getString("estilo"));
                j.setManoHabil(rs.getString("manoHabil"));
                j.setActivo(rs.getBoolean("activo"));
                j.setId_jugador(rs.getInt("id_jugador"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion metodo buscar Jugador");
        }
        return j;
    }
}
