/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import java.util.List;
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
    
    public void guardarSponsor() {
        
    }
    public void actualizarSponsor(int id_sponsor){
        
    }
    public void borrarSponsor(int id_sponsor) {
        
    }
    public Sponsor buscarSponsor(String nombreSponsor){
        
    }
    public List<Sponsor> listaDeSponsors() {
        
    }
}
