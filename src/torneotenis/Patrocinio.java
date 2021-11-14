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
public class Patrocinio {
    private int id_patrocinio;
    private Sponsor sponsor;
    private Jugador jugador;
    private boolean activo;

    public Patrocinio(Sponsor sponsor, Jugador jugador, boolean activo) {
        this.sponsor = sponsor;
        this.jugador = jugador;
        this.activo = activo;
    }

    public Patrocinio(int id_patrocinio, Sponsor sponsor, Jugador jugador, boolean activo) {
        this.id_patrocinio = id_patrocinio;
        this.sponsor = sponsor;
        this.jugador = jugador;
        this.activo = activo;
    }

    public Patrocinio(int id_patrocinio, Sponsor sponsor, Jugador jugador) {
        this.id_patrocinio = id_patrocinio;
        this.sponsor = sponsor;
        this.jugador = jugador;
    }

    public Patrocinio() {
    }

    public int getId_patrocinio() {
        return id_patrocinio;
    }

    public void setId_patrocinio(int id_patrocinio) {
        this.id_patrocinio = id_patrocinio;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Patrocinio: " + id_patrocinio + ", Sponsor: " + sponsor + ", Jugador: " + jugador;
    }
    
    
    
}
