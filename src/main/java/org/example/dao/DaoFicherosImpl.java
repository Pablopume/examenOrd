package org.example.dao;

import org.example.domain.Casa_rural;
import org.example.domain.Coleccion;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DaoFicherosImpl {
    public static final String FICHEROB = "FicheroBinario";
    public static final String FICHERONONB="Fichero de texto";


    public static Coleccion cargarFicheroBinario() {
        Coleccion auxiliar = null;
        File file = new File(FICHEROB);
        if (file.exists()) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
                auxiliar = (Coleccion) is.readObject();

            } catch (IOException | ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(DaoFicherosImpl.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
           auxiliar=new Coleccion();
        }
        return auxiliar;
    }

    public static boolean escribirFicheroBinario(Coleccion coleccion) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(coleccion);
            escrito = true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoFicherosImpl.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }

    public static List<Casa_rural> cargarFichero() {
        List<Casa_rural> listaE = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(new File(FICHERONONB).toPath(), StandardCharsets.UTF_8);
            lines.forEach(line -> {
                String[] article = line.split(";");
                listaE.add(new Casa_rural((article[0]), (article[1]), Integer.parseInt(article[2]),Double.parseDouble( article[3]),Boolean.parseBoolean(article[4]) ));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaE;
    }

    public static boolean escribirFichero(Casa_rural casa, int i) {
        boolean resultado = false;
         File fi=new File(FICHERONONB);
        try {
            if (!new File(FICHERONONB).exists()) {

                Files.createFile(fi.toPath());
            }

            FileWriter fileWriter = new FileWriter(FICHERONONB, true);
            BufferedWriter bufferedWriter;
            if (i==0){
                 bufferedWriter = Files.newBufferedWriter(fi.toPath(), StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
            }
             bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(casa.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();

            resultado = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }



}



