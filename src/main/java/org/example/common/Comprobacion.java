package org.example.common;

public class Comprobacion {
public static void valoracionOk(int valoracion) throws ValoracionException{
    if (valoracion<1 || valoracion>5){
        throw new ValoracionException(valoracion);
    }
}
}
