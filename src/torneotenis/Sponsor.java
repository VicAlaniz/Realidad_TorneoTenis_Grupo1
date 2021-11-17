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
public class Sponsor {
    private int id_sponsor;
    private String marca;
    private String indumentaria;
    private boolean activo;

    public Sponsor(int id_sponsor, String marca, String indumentaria, boolean activo) {
        this.id_sponsor = id_sponsor;
        this.marca = marca;
        this.indumentaria = indumentaria;
        this.activo = activo;
    }

    public Sponsor(String marca, String indumentaria, boolean activo) {
        this.marca = marca;
        this.indumentaria = indumentaria;
        this.activo = activo;
    }

    public Sponsor() {
    }
    
    

    public int getId_sponsor() {
        return id_sponsor;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(String indumentaria) {
        this.indumentaria = indumentaria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return marca + ", " + indumentaria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_sponsor;
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
        final Sponsor other = (Sponsor) obj;
        if (this.id_sponsor != other.id_sponsor) {
            return false;
        }
        return true;
    }
    
    
    
}
