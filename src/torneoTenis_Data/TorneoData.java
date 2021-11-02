/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import java.util.List;
import torneotenis.Conectar;
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
       
   }
   
   public void actualizarTorneo(int id_torneo){
       
   }
   
   public List<Torneo> listarTorneos(int id_torneo) {
       
   }
   public void borrarTorneo(int id_torneo) {
       
   } 
   public Torneo buscarTorneo(String nombreTorneo) {
       
   }
}
