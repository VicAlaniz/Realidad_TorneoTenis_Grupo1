/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import torneotenis.Conectar;

/**
 *
 * @author Familia
 */
public class TorneoData {
    private Connection conn = null;
    
    public TorneoData(Conectar conexionTorneo){
        this.conn = (Connection) conexionTorneo.getConexion();
    }
    
    public void calcularRanking(int partGanados){
        
    }
    
    
}
