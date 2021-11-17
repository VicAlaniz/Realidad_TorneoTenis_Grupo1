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
public class Estadio {
    private int id_estadio;
    private String nombre;
    private String ciudad;
    private float ancho;
    private float largo;
    private String categoria;
    private boolean habilitado;
    private String direccion;
    private int capacidad;
    private boolean activo;

    public Estadio(String nombre, String ciudad, float ancho, float largo, String categoria, boolean habilitado, String direccion, int capacidad, boolean activo) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ancho = ancho;
        this.largo = largo;
        this.categoria = categoria;
        this.habilitado = habilitado;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.activo = activo;
    }

    public Estadio(int id_estadio, String nombre, String ciudad, float ancho, float largo, String categoria, boolean habilitado, String direccion, int capacidad, boolean activo) {
        this.id_estadio = id_estadio;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.ancho = ancho;
        this.largo = largo;
        this.categoria = categoria;
        this.habilitado = habilitado;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.activo = activo;
    }

    public Estadio() {
    }

    public int getId_estadio() {
        return id_estadio;
    }

    public void setId_estadio(int id_estadio) {
        this.id_estadio = id_estadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Estadio: " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id_estadio;
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
        final Estadio other = (Estadio) obj;
        if (this.id_estadio != other.id_estadio) {
            return false;
        }
        return true;
    }
    
    
    
}
