/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneotenis;

import java.time.LocalDate;
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
        
        
        Jugador v = new Jugador(26, "Vicky Alaniz", 34951362, LocalDate.of(1985, 10, 11), 179, 67, "voleadora", "diestra", true);
        Jugador p = new Jugador(28, "Pato Baigorria", 27632541, LocalDate.of(1985, 10, 11), 179, 67, "jugadora de toda la cancha", "zurda", true);
        
        //jd.registrarJugador(v);
        //jd.registrarJugador(p);
        //jd.eliminarJugador(34951362);
        //jd.buscarJugador("Vicky Alaniz");
        //p.setActivo(true);
        //jd.actualizarJugador(p);
       
        jd.listaDeJugadores();
        System.out.println("lista: "+jd.listaDeJugadores());
        
        //jd.buscarJugador("Pato Baigorria");
        //System.out.println(p.getNombreApellido()+"\n"+p.getDni()+"\n"+p.getManoHabil());
        //System.out.println("jugadoras Guardadas");
        
    }
    
    
    
}
