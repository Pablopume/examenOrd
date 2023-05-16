package org.example.ui;

import org.example.dao.DaoFicherosImpl;
import org.example.domain.Casa_rural;
import org.example.service.IServicioHotel;
import org.example.service.ServicioHotel;

import java.util.Scanner;

public class GestionColeccion {
    private IServicioHotel servicioHotel;

    public GestionColeccion() {
        this.servicioHotel = new ServicioHotel(DaoFicherosImpl.cargarFicheroBinario());
    }

    public static void main() {
        int opcion;
        do {
            opcion = elegirOpcionMenu();
            switch (opcion) {
                case 1:
                    anyadirAlojamiento();
            }


        } while (opcion != 7);
    }


    public static int elegirOpcionMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe 1 para añadir alojamiento, 2 para consulta de alojamiento, 3 para obtener los alojamientos de una provincia específica ordenado," +
                " 4 para actualizar las estrellas de un hotel, 5 para eliminar alojamiento y 6 para para ordenar los hoteles por estrellas y 7 para salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static void anyadirAlojamiento() {
        Scanner sc = new Scanner(System.in);
        int alojamiento;
        do {


            System.out.println("Introduce 1 para añadir una casa rural y 2 para añadir un hotel");
            alojamiento = sc.nextInt();
            sc.nextLine();
        }
        while (alojamiento != 1 && alojamiento != 2);
        if (alojamiento == 1) {

        }
    }
    public void anyadirCasa(){
        Scanner sc=new Scanner(System.in);

        System.out.println("¿Qué nombre tiene la casa?");
        String nombre=sc.nextLine();
        System.out.println("A que provincia pertenece?");
        String provincia=sc.nextLine();
        System.out.println("Que valoración tiene?");
        int valoracion=sc.nextInt();
        sc.nextLine();
        System.out.println("¿Cuál es el precio de la habitación?");
        double habitacion=sc.nextDouble();
        int piscina;
        do {
            System.out.println("Escribe 1 si tiene piscina y 2 si no tiene pisicna");
            piscina=sc.nextInt();
        }
        while (piscina!=1 && piscina!=2);
        boolean piscina2;
        if (piscina!=1){
            piscina2=true;
        }
        else piscina2=false;
        Casa_rural casa=new Casa_rural(nombre, provincia,valoracion, habitacion, piscina2);
        servicioHotel.anyadirCasa(casa);
    }
}
