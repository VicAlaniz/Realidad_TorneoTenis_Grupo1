/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import torneotenis.Conectar;
import torneotenis.Estadio;

/**
 *
 * @author Familia
 */
public class EstadioData {
    private Connection conn = null;
    
    public EstadioData(Conectar conexionEstadio){
        this.conn = (Connection) conexionEstadio.getConexion();
    }
    
    public void registrarEstadio(Estadio est){
        
    }
    
    public Estadio consultarEstadio(int id_estadio){
        
        Estadio est = null;
        
        return est;
    }
    
    public void modificarEstadio(Estadio est){
        
    }
}
