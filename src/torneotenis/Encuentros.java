/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneotenis;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Encuentros {
    private int id_encuentro;
    private LocalDate fechaEnc;
    private int estadoEnCurso;
    private int ganador;
    private Jugador jugador1;
    private Jugador jugador2;
    private Estadio estadio;
    private Torneo torneo;
    private boolean activo;

    public Encuentros(int id_encuentro, LocalDate fechaEnc, int estadoEnCurso, int ganador, Jugador jugador1, Jugador jugador2, Estadio estadio, Torneo torneo, boolean activo) {
        this.id_encuentro = id_encuentro;
        this.fechaEnc = fechaEnc;
        this.estadoEnCurso = estadoEnCurso;
        this.ganador = ganador;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.estadio = estadio;
        this.torneo = torneo;
        this.activo = activo;
    }

    public Encuentros(LocalDate fechaEnc, int estadoEnCurso, int ganador, Jugador jugador1, Jugador jugador2, Estadio estadio, Torneo torneo, boolean activo) {
        this.fechaEnc = fechaEnc;
        this.estadoEnCurso = estadoEnCurso;
        this.ganador = ganador;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.estadio = estadio;
        this.torneo = torneo;
        this.activo = activo;
    }

    public Encuentros() {
    }

    public int getId_encuentro() {
        return id_encuentro;
    }

    public void setId_encuentro(int id_encuentro) {
        this.id_encuentro = id_encuentro;
    }

    public LocalDate getFechaEnc() {
        return fechaEnc;
    }

    public void setFechaEnc(LocalDate fechaEnc) {
        this.fechaEnc = fechaEnc;
    }

    public int getEstadoEnCurso() {
        return estadoEnCurso;
    }

    public void setEstadoEnCurso(int estadoEnCurso) {
        this.estadoEnCurso = estadoEnCurso;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Encuentro en fecha: " + fechaEnc;
    }
    
    
    
}
