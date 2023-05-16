package org.example.dao;

import org.example.common.ValoracionException;
import org.example.domain.Casa_rural;
import org.example.domain.Coleccion;
import org.example.domain.Hotel;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class DaoColeccionImpl implements DaoColeccion{
    public DaoColeccionImpl(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    protected Coleccion coleccion;

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public DaoColeccionImpl() {
        this.coleccion = new Coleccion();
    }
    public boolean anyadirCasa(Casa_rural casa){
        return coleccion.getCasas().add(casa);
    }
    public boolean anyadirHotel(Hotel hotel){
        return coleccion.getHoteles().add(hotel);
    }
    public List<Casa_rural> devolverCasas(String provincia, int precio, int precio2){
    /*    List<Casa_rural> casas=new ArrayList<>();
        for (int i = 0; i <coleccion.getCasas().size() ; i++) {
            if(coleccion.getCasas().get(i).getPrecioHabitacion()>=precio && coleccion.getCasas().get(i).getPrecioHabitacion() <=precio2 && coleccion.getCasas().get(i).getProvincia().equals(provincia));
            casas.add(coleccion.getCasas().get(i));
        }
        return casas;
      */
        return coleccion.getCasas().stream()
                .filter(casa -> casa.getPrecioHabitacion() >= precio &&
                        casa.getPrecioHabitacion() <= precio2 &&
                        casa.getProvincia().equals(provincia))
                .toList();
    }

    public List<Hotel> devolverHoteles(String provincia, int precio, int precio2){
    /*    List<Casa_rural> casas=new ArrayList<>();
        for (int i = 0; i <coleccion.getCasas().size() ; i++) {
            if(coleccion.getCasas().get(i).getPrecioHabitacion()>=precio && coleccion.getCasas().get(i).getPrecioHabitacion() <=precio2 && coleccion.getCasas().get(i).getProvincia().equals(provincia));
            casas.add(coleccion.getCasas().get(i));
        }
        return casas;
      */
        return coleccion.getHoteles().stream().filter(hotel -> hotel.getProvincia().equals(provincia) && hotel.getPrecioHabitacion()>=precio && hotel.getPrecioHabitacion()<=precio2).toList();
    }

    public List<Casa_rural> ordenarValoracionCasas(){
        List<Casa_rural> casasOrdenadas=this.coleccion.getCasas();
        casasOrdenadas.sort(Comparator.comparing(Casa_rural::getValoracion));
        return casasOrdenadas;
    }
    public List<Hotel> ordenarValoracionHotel(){
        List<Hotel> casasOrdenadas=this.coleccion.getHoteles();
        casasOrdenadas.sort(Comparator.comparing(Hotel::getValoracion));
        return casasOrdenadas;
    }
    public void actualizarCategoriaHotel(int valoracion, String nombre){
        coleccion.getHoteles().stream().filter(hotel -> nombre.equals(hotel.getNombre())).forEach(hotel -> {
            try {
                hotel.setCategoria(valoracion);
            } catch (ValoracionException e) {
                throw new RuntimeException(e);
            }
        });

        }


    public void eliminarAlojamientoCasas(String provincia) {
        coleccion.getCasas().removeIf(casa_rural -> provincia.equals(casa_rural.getProvincia()));
    }

    public List<Hotel> listarOrdenado(boolean ascendente){
        List<Hotel> lista=coleccion.getHoteles();
        lista.sort(Comparator.comparing(Hotel::getCategoria).thenComparing(Hotel::getNombre));
        if (!ascendente){
            Collections.reverse(lista);
        }
        return lista;
    }


    public Map<String, List<Hotel>> hotelesporProvincia(){
        return coleccion.getHoteles().stream().collect(groupingBy(Hotel::getProvincia));
    }

    public Map<String, Long> contarHotelesProvincia(){
        return coleccion.getHoteles().stream().collect(groupingBy(Hotel::getProvincia,counting()));

    }
}
