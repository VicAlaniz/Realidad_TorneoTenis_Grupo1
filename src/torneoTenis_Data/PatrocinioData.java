/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import java.util.List;
import torneotenis.Conectar;
import torneotenis.Patrocinio;


/**
 *
 * @author Familia
 */
public class PatrocinioData {
    private Connection conn = null;
    
    public PatrocinioData(Conectar conexionPatrocinio){
        this.conn = (Connection) conexionPatrocinio.getConexion();
    }
    
    public void guardarPatrocinio(Patrocinio p){
        jugador 
                id_sponsor
                patrocinio(ju, )
    }
    
    public Patrocinio buscarPatrocinio(int id_patrocinio) {
        
    }
    public void actualizarPatrocinio(Patrocinio p) {
        
    }
    public void borrarPatrocinio(int id_patrocinio) {
        
    }
      public List<Patrocinio> listaDePatrocinios() {
        
    }
}
