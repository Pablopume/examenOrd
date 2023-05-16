package org.example.dao;

import org.example.common.ValoracionException;
import org.example.domain.Casa_rural;
import org.example.domain.Coleccion;
import org.example.domain.Hotel;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface DaoColeccion {
    Coleccion getColeccion();

    void setColeccion(Coleccion coleccion);

    boolean anyadirCasa(Casa_rural casa);

    boolean anyadirHotel(Hotel hotel);

    List<Casa_rural> devolverCasas(String provincia, int precio, int precio2);

    List<Hotel> devolverHoteles(String provincia, int precio, int precio2);

    List<Casa_rural> ordenarValoracionCasas();

    List<Hotel> ordenarValoracionHotel();

    void actualizarCategoriaHotel(int valoracion, String nombre);

    void eliminarAlojamientoCasas(String provincia);

    List<Hotel> listarOrdenado(boolean ascendente);

}
