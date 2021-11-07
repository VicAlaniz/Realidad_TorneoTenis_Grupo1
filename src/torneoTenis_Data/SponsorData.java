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
import torneotenis.Sponsor;

/**
 *
 * @author Familia
 */
public class SponsorData {
    private Connection conn = null;
    
    public SponsorData(Conectar conexionSponsor){
        this.conn = (Connection) conexionSponsor.getConexion();
    }

    SponsorData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void guardarSponsor(Sponsor s) {
        String query = "INSERT INTO sponsor(marca, indumentaria, activo)VALUES (?,?,?)";

        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, s.getMarca());
                ps.setString(2, s.getIndumentaria());
                ps.setBoolean(3, s.isActivo());

                ps.executeUpdate();
                ResultSet rst = ps.getGeneratedKeys();

                if(rst.next()){
                    s.setId_sponsor(rst.getInt(1));
                    JOptionPane.showMessageDialog(null, "Sponsor cargado correctamente");
                }
                ps.close();
        } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nSponsor no guardado");
          }
    }
    public void actualizarSponsor(Sponsor s){
        //Sponsor s = new Sponsor();
            String query = "UPDATE sponsor SET marca = ?, indumentaria = ?, activo = ?  WHERE id_sponsor = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            
                ps.setString(1, s.getMarca());
                ps.setString(2, s.getIndumentaria());
                ps.setBoolean(3, s.isActivo());
                ps.setInt(4, s.getId_sponsor());
                
                ps.executeUpdate();

            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Sponsor Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al intentar actualizar Sponsor");
             }
            ps.close();
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR \nSponsor no encontrado");
         }
    }
    public void borrarSponsor(int id_sponsor) {
         String query = "UPDATE sponsor SET activo = false WHERE id_sponsor = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, id_sponsor);
            ps.setInt(1, id_sponsor);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Sponsor borrado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar Sponsor");
             }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nSponsor No Encontrado");
         }
    }
    public Sponsor buscarSponsor(String marca){
                Sponsor s = new Sponsor();
        
        String query = "SELECT * FROM sponsor WHERE marca = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, marca);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){

                s.setId_sponsor(rs.getInt("id_sponsor"));
                s.setMarca(rs.getString("marca"));
                s.setIndumentaria(rs.getString("indumentaria"));
                s.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nSponsor no encontrado");
         }
        return s;
    }
    public Sponsor buscarSponsorXId(int id){
                Sponsor s = new Sponsor();
        
        String query = "SELECT * FROM sponsor WHERE id_sponsor = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){

                s.setId_sponsor(rs.getInt("id_sponsor"));
                s.setMarca(rs.getString("marca"));
                s.setIndumentaria(rs.getString("indumentaria"));
                s.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nSponsor no encontrado");
         }
        return s;
    }
    public List<Sponsor> listaDeSponsors() {
         ArrayList<Sponsor> listaDeSponsor = new ArrayList<>();
        
        String query = "SELECT * FROM sponsor WHERE activo = true";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Sponsor s = new Sponsor();
                s.setId_sponsor(rs.getInt("id_sponsor"));
                s.setMarca(rs.getString("marca"));
                s.setIndumentaria(rs.getString("indumentaria"));
                s.setActivo(rs.getBoolean("activo"));
                
                listaDeSponsor.add(s);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nSponsor no encontrado");
         }
        return listaDeSponsor;
    
    }
}
