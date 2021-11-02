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
public class PatrocinioData {
    private Connection conn = null;
    
    public PatrocinioData(Conectar conexionPatrocinio){
        this.conn = (Connection) conexionPatrocinio.getConexion();
    }
    
    public void guardarPatrocinio(){
        jugador 
                id_sponsor
                patrocinio(ju, )
    }
}
