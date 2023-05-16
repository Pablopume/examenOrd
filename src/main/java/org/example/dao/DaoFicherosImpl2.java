package org.example.dao;

import org.example.domain.Coleccion;

import java.io.*;

public class DaoFicherosImpl2 {
    private static String ficherob = "fichero binario";

    public static Coleccion leerFichero() {
        File file = new File(ficherob);
        Coleccion auxiliar = null;
        if (file.exists()) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
                auxiliar = (Coleccion) is.readObject();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            auxiliar = new Coleccion();
        }
        return auxiliar;
    }

    public static void escribirFichero(Coleccion coleccion){
        try(ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(ficherob))){
            os.writeObject(coleccion);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
