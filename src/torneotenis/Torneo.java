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
public class Torneo {
    private int id_torneo;
    private String nombre;
    private LocalDate fecha_ini;
    private LocalDate fecha_fin;
    private boolean activo;

    public Torneo(String nombre, LocalDate fecha_ini, LocalDate fecha_fin, boolean activo) {
        this.nombre = nombre;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.activo = activo;
    }

    public Torneo(int id_torneo, String nombre, LocalDate fecha_ini, LocalDate fecha_fin, boolean activo) {
        this.id_torneo = id_torneo;
        this.nombre = nombre;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.activo = activo;
    }

    public Torneo() {
    }

    public int getId_torneo() {
        return id_torneo;
    }

    public void setId_torneo(int id_torneo) {
        this.id_torneo = id_torneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(LocalDate fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Torneo: " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_torneo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Torneo other = (Torneo) obj;
        if (this.id_torneo != other.id_torneo) {
            return false;
        }
        return true;
    }
    
    
}
