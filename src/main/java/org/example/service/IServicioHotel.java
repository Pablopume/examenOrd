package org.example.service;

import org.example.domain.Casa_rural;
import org.example.domain.Coleccion;
import org.example.domain.Hotel;

import java.util.List;

public interface IServicioHotel {
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

     boolean escribirFicheroBinario(Coleccion coleccion);

    Coleccion cargarFicheroBinario();
}
