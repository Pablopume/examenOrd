package org.example.dao;

import org.example.common.ValoracionException;
import org.example.domain.Casa_rural;
import org.example.domain.Coleccion;
import org.example.domain.Hotel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
public class DaoColeccion2Impl implements DaoColeccion{
   private Coleccion coleccion=new Coleccion();

    public DaoColeccion2Impl(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public Coleccion getColeccion() {
        return this.coleccion;
    }

    @Override
    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public boolean anyadirCasa(Casa_rural casa) {
        return coleccion.getCasas().add(casa);
    }

    @Override
    public boolean anyadirHotel(Hotel hotel) {
        return coleccion.getHoteles().add(hotel);
    }

    @Override
    public List<Casa_rural> devolverCasas(String provincia, int precio, int precio2) {
        return coleccion.getCasas().stream().filter(casa -> casa.getPrecioHabitacion()>=precio && casa.getPrecioHabitacion()<=precio2 && casa.getProvincia().equals(provincia)).toList();
    }

    @Override
    public List<Hotel> devolverHoteles(String provincia, int precio, int precio2) {
        return null;
    }

    @Override
    public List<Casa_rural> ordenarValoracionCasas() {
        List<Casa_rural> lista=coleccion.getCasas();
        lista.sort(Comparator.comparing(Casa_rural::getValoracion));
        return null;
    }

    @Override
    public List<Hotel> ordenarValoracionHotel() {
        return null;
    }

    @Override
    public void actualizarCategoriaHotel(int valoracion, String nombre) {
        coleccion.getHoteles().stream().filter(hotel -> hotel.getNombre().equals(nombre)).forEach(hotel -> {
            try {
                hotel.setCategoria(valoracion);
            } catch (ValoracionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void eliminarAlojamientoCasas(String provincia) {
        coleccion.getCasas().removeIf(casa_rural -> casa_rural.getProvincia().equals(provincia));
    }

    @Override
    public List<Hotel> listarOrdenado(boolean ascendente) {
        List<Hotel> lista=coleccion.getHoteles();
        lista.sort(Comparator.comparing(Hotel::getCategoria).thenComparing(Hotel::getNombre));
        if (!ascendente){
            Collections.reverse(lista);
        }
        return lista;
    }


    public Map<String, List<Hotel>> hotelPorProvincia(){
        return coleccion.getHoteles().stream().collect(groupingBy(Hotel::getProvincia));
    }

    public Map<String, Long> numeroHotelesPorProvincia(){
        return coleccion.getHoteles().stream().collect(groupingBy(Hotel::getProvincia, counting()));
    }
}
