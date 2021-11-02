/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoTenis_Data;

import java.sql.Connection;
import java.util.List;
import torneotenis.Conectar;
import torneotenis.Estadio;
import torneotenis.Sponsor;

/**
 *
 * @author Familia
 */
public class EstadioData {
    private Connection conn = null;
    
    public EstadioData(Conectar conexionEstadio){
        this.conn = (Connection) conexionEstadio.getConexion();
    }
    
    public void guardarEstadio(Estadio est){
        
    }
    
    public Estadio buscarEstadio(String nombreEstadio){
        
        Estadio est = null;
        
        return est;
    }
    
    public void actualizarEstadio(Estadio est){
        
    }
      public List<Estadio> listaDeEstadios() {
        
    }
    public void borrarEstadio(int id_estadio){
        
    }  
}
