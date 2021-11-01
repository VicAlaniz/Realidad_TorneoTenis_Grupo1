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
public class Jugador {
    private int id_jugador;
    private String nombreApellido;
    private int dni;
    private LocalDate fechaNac;
    private float altura;
    private float peso;
    private String estilo;
    private String manoHabil;
    private boolean activo;

    public Jugador(String nombre, int dni, LocalDate fechaNac, float altura, float peso, String estilo, String manoHabil, boolean activo) {
        this.nombreApellido = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.manoHabil = manoHabil;
        this.activo = activo;
    }

    public Jugador(int id_jugador, String nombre, int dni, LocalDate fechaNac, float altura, float peso, String estilo, String manoHabil, boolean activo) {
        this.id_jugador = id_jugador;
        this.nombreApellido = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.manoHabil = manoHabil;
        this.activo = activo;
    }

    public Jugador() {
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombre) {
        this.nombreApellido = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getManoHabil() {
        return manoHabil;
    }

    public void setManoHabil(String manoHabil) {
        this.manoHabil = manoHabil;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombreApellido;
    }
    
    
    
}
