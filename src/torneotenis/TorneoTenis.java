/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneotenis;

import torneoTenis_Data.EncuentrosData;
import torneoTenis_Data.EstadioData;
import torneoTenis_Data.JugadorData;
import torneoTenis_Data.PatrocinioData;
import torneoTenis_Data.SponsorData;
import torneoTenis_Data.TorneoData;


/**
 *
 * @author Administrador
 */
public class TorneoTenis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Conectar conexion = new Conectar();
        EncuentrosData ed = new EncuentrosData(conexion);
        EstadioData esd = new EstadioData(conexion);
        JugadorData jd = new JugadorData(conexion);
        PatrocinioData pd= new PatrocinioData(conexion);
        SponsorData sd = new SponsorData(conexion);
        TorneoData td = new TorneoData(conexion);
    }
    
    
    
}
