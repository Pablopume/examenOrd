package org.example.domain;

import java.io.Serializable;
import java.util.Calendar;

public class Casa_rural implements Serializable {
    private String nombre;
    private String provincia;
    private int valoracion;
    private double precioHabitacion;
    boolean piscina;

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getValoracion() {
        return valoracion;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public Casa_rural(String nombre, String provincia, int valoracion, double precioHabitacion, boolean piscina) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.valoracion = valoracion;
        this.precioHabitacion = precioHabitacion;
        this.piscina = piscina;
    }

    public double getPrecioHabitacion() {
        Calendar c1=Calendar.getInstance();
        int mesActual=c1.get(Calendar.MONTH)+1;
        if (mesActual==7){
            precioHabitacion=precioHabitacion*1.20;
        } else if (mesActual==8) {
            precioHabitacion=precioHabitacion*1.30;
        }
        return precioHabitacion;
    }

    @Override
    public String toString() {
        return   nombre + ';' + provincia + ';' + valoracion + ';' + precioHabitacion + ';' + piscina;

    }
}
