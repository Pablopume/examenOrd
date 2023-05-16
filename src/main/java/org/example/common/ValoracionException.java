package org.example.common;

public class ValoracionException extends Exception {
    public ValoracionException(int valoracion) {
        super("La valoración " + valoracion + " no está permitida, debe ser entre 1 y 5");
    }
}
