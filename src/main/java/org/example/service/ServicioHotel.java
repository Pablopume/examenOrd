package org.example.service;

import org.example.dao.DaoColeccion;
import org.example.dao.DaoColeccionImpl;
import org.example.dao.DaoFicherosImpl;
import org.example.domain.Casa_rural;
import org.example.domain.Coleccion;
import org.example.domain.Hotel;

import java.util.List;

public class ServicioHotel implements IServicioHotel{
    private final DaoColeccion daoColeccion;

    public ServicioHotel(Coleccion coleccion) {
        this.daoColeccion =new DaoColeccionImpl(coleccion);
    }

    @Override
    public Coleccion getColeccion() {
        return daoColeccion.getColeccion();
    }

    @Override
    public void setColeccion(Coleccion coleccion) {
        daoColeccion.setColeccion(coleccion);
    }

    @Override
    public boolean anyadirCasa(Casa_rural casa) {
      return daoColeccion.anyadirCasa(casa);
    }

    @Override
    public boolean anyadirHotel(Hotel hotel) {
        return daoColeccion.anyadirHotel(hotel);
    }

    @Override
    public List<Casa_rural> devolverCasas(String provincia, int precio, int precio2) {
        return daoColeccion.devolverCasas(provincia,precio,precio2);
    }

    @Override
    public List<Hotel> devolverHoteles(String provincia, int precio, int precio2) {
        return daoColeccion.devolverHoteles(provincia,precio,precio2);
    }

    @Override
    public List<Casa_rural> ordenarValoracionCasas() {
        return daoColeccion.ordenarValoracionCasas();
    }

    @Override
    public List<Hotel> ordenarValoracionHotel() {
        return daoColeccion.ordenarValoracionHotel();
    }

    @Override
    public void actualizarCategoriaHotel(int valoracion, String nombre) {
        daoColeccion.actualizarCategoriaHotel(valoracion,nombre);
    }

    @Override
    public void eliminarAlojamientoCasas(String provincia) {
        daoColeccion.eliminarAlojamientoCasas(provincia);
    }

    @Override
    public List<Hotel> listarOrdenado(boolean ascendente) {
        return daoColeccion.listarOrdenado(ascendente);
    }

    @Override
    public boolean escribirFicheroBinario(Coleccion coleccion) {
        DaoFicherosImpl.escribirFicheroBinario(coleccion);
        return true;
    }

    @Override
    public Coleccion cargarFicheroBinario() {
        return DaoFicherosImpl.cargarFicheroBinario();
    }


}
