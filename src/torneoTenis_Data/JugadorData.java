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
 * @author rataq
 */
public class JugadorData {
    private Connection conn = null;
    
    public JugadorData(Conectar conexionJugador){
        this.conn = (Connection) conexionJugador.getConexion();
    }
    
}
