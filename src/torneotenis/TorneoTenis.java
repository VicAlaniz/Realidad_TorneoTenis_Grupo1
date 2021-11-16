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
        
        
        Jugador v = new Jugador(24, "Vicky Alaniz", 34951362, LocalDate.of(1985, 10, 11), 179, 67, "voleadora", "diestra", true);
        Jugador p = new Jugador(25, "Pato Baigorria", 27632541, LocalDate.of(1985, 10, 11), 179, 67, "jugadora de toda la cancha", "zurda", true);
        
        //jd.registrarJugador(v);
        //jd.registrarJugador(p);
        //jd.eliminarJugador(34951362);
        //jd.buscarJugador(v);
        //System.out.println(jd.buscarJugador(34951362));
        
        //p.setActivo(true);
        //v.setPeso((float) 63.7);
        //v.setAltura((float) 1.75);
        //jd.actualizarJugador(v);
       
        //jd.listaDeJugadores();
        //System.out.println("lista: "+jd.listaDeJugadores());
        
        //jd.buscarJugador("Pato Baigorria");
        //System.out.println(p.getNombreApellido()+"\n"+p.getDni()+"\n"+p.getManoHabil());
        //System.out.println("jugadoras Guardadas");
        
        //GUARDAR ESTADIO
        
        //Estadio co = new Estadio ("Cordoba Open", "Córdoba", 1546, 12698, "Cesped", true, "La Ribera", 15000, true);
        Estadio co2 = new Estadio (5, "Cordoba Open", "Córdoba", 1546, 12698, "Cesped", true, "La Ribera", 15000, true);
        
        //esd.guardarEstadio(co2);
        
        //BUSCAR ESTADIO
        //esd.buscarEstadio("Cordoba Open");
        //System.out.println(esd.buscarEstadio("Cordoba Open"));
        
        //ACTUALIZAR ESTADIO
        
        //co.setDireccion("Maipu");
        //co.setCategoria("Ladrillo");
        //co.setAncho((float) 9.60);
        //co.setLargo((float) 23.77);
        //esd.actualizarEstadio(co);
        
        //BORRAR ESTADIO
        //esd.borrarEstadio(6);
        
        //LISTAR ESTADIOS
        //esd.listaDeEstadios();
        //System.out.println("Lista de Estadios: "+esd.listaDeEstadios());
        
        Torneo us = new Torneo (4, "US Open", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 1), true );
        //GUARDAR TORNEO
        //td.guardarTorneo(us);
        //BUSCAR
        //td.buscarTorneo("Torneo US Open");
        //System.out.println(td.buscarTorneo("Torneo US Open"));
        //ACTUALIZAR
        //us.setFecha_ini(LocalDate.of(2021, 11, 1));
        //us.setNombre("US Open");
        //us.setActivo(false);
        //td.actualizarTorneo(us);
        //LISTAR TORNEOS
       //td.listaDeTorneos();
        //System.out.println("Lista de Torneos: "+td.listaDeTorneos());
        //BORRAR TORNEOS
        //td.borrarTorneo(4);
        
        Sponsor va = new Sponsor("Nike", "Remeras", true);
        //Sponsor pb = new Sponsor(7, "Adidas", "Zapatillas", true);
        //sd.guardarSponsor(pb);
       //System.out.println(sd.buscarSponsor("Nike"));
       //pb.setIndumentaria("Ropa");
       //sd.actualizarSponsor(pb);
        //System.out.println("Sponsor: " + sd.listaDeSponsors());
        //sd.borrarSponsor(7);
        
        Encuentros enc = new Encuentros(17, LocalDate.of(2021, 11, 11), 2, v, v, p, co2, us, true);
        //Encuentros encu = new Encuentros(18, LocalDate.of(2021, 11, 26), 2, null, v, p, co2, us, true);
        //ed.guardarEncuentros(encu);
        //enc.setGanador(v);
        //enc.setFechaEnc(LocalDate.of(2021, 11, 1));
        //ed.ganadorEncuentro(enc);
        //ed.actualizarEncuentro(enc);
        //Jugador vic = jd.buscarJugadorXId(24);
        //Sponsor va1 = sd.buscarSponsorXId(7);
        //System.out.println(ed.listaDeEncuentros());
        
        //Patrocinio pat = new Patrocinio(va1, vic, true);
        //pd.guardarPatrocinio(pat);
        //pd.borrarPatrocinio(7, 24);
        
        //System.out.println("Patrocinio: " + pd.obtenerPatrocinioXJugador(24));
        //System.out.println("Encuentros: " + ed.listaEncuentrosXJugador(25));
        //System.out.println(ed.buscarEncuentro(18));
        //System.out.println("Jugadores: " + td.listaJugadoresXTorneo(3));
        //System.out.println("Jugadores: " + td.listaTorneosXJugador(25));
        //System.out.println(ed.listaEncuentrosXJugador(25));
        //for(Resultado r : td.calcularRanking(4)) {
            //System.out.println(r.getJugador().getNombreApellido());
            //System.out.println(r.getTorneo().getNombre());
            //System.out.println(r.getTotal());
            
        System.out.println(ed.listaPosibleGanador(17));
            
        
    }
    
    
    
}
