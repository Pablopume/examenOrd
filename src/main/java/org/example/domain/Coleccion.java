package org.example.domain;

import org.example.common.ValoracionException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Coleccion implements Serializable {
    private List<Casa_rural> casas;
    private List <Hotel> hoteles;

    public void setCasas(List<Casa_rural> casas) {
        this.casas = casas;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public List<Casa_rural> getCasas() {
        return casas;
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public Coleccion() {
        this.casas = new ArrayList<>();
        this.hoteles = new ArrayList<>();
        casas.add(new Casa_rural("Casa de pareja","Guadalajara",1,283.27,true));
        casas.add(new Casa_rural("Mina pirata","Madrid",3,583.27,true));
        casas.add(new Casa_rural("Grieta del Thumb","Valladolid",4,483.27,false));
        casas.add(new Casa_rural("Parcela Ilanova","Alicante",2,133.27,false));
        try {
            hoteles.add(new Hotel("Nh Hoteles","Madrid",2,273.48,1));
            hoteles.add(new Hotel("Ph Hoteles","Málaga",1,17.48,5));
            hoteles.add(new Hotel("Dh Hoteles","Zaragoza",4,67.48,5));
            hoteles.add(new Hotel("Zh Hoteles","Barcelona",5,47.48,2));

        } catch (ValoracionException e) {
            throw new RuntimeException(e);
        }
    }

}
