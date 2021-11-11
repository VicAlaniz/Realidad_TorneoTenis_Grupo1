/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneotenis;

/**
 *
 * @author Administrador
 */
public class Resultado {
    private Jugador jugador;
    private Torneo torneo;
    private int total;

    public Resultado(Jugador jugador, Torneo torneo, int total) {
        this.jugador = jugador;
        this.torneo = torneo;
        this.total = total;
    }

    public Resultado() {
        
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
