package org.example.domain;

import org.example.common.Comprobacion;
import org.example.common.ValoracionException;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;

public class Hotel implements Serializable{
    private String nombre;
    private String provincia;
    private int valoracion;
    private double precioHabitacion;
    private int categoria;

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getValoracion() {
        return valoracion;
    }

    public int getCategoria() {
        return categoria;
    }

    public double getPrecioHabitacion() {
        Calendar c1 = Calendar.getInstance();
        int mesActual = c1.get(Calendar.MONTH) + 1;
        if (mesActual == 7) {
            precioHabitacion = precioHabitacion * 1.20;
        } else if (mesActual == 8) {
            precioHabitacion = precioHabitacion * 1.30;
        }
        return precioHabitacion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setCategoria(int categoria) throws ValoracionException {
        Comprobacion.valoracionOk(categoria);
        this.categoria = categoria;
    }

    public Hotel(String nombre, String provincia, int valoracion, double precioHabitacion, int categoria) throws ValoracionException {
        this.nombre = nombre;
        this.provincia = provincia;
        this.valoracion=valoracion;
        this.precioHabitacion = precioHabitacion;
        Comprobacion.valoracionOk(categoria);
        this.categoria = categoria;
    }



}
