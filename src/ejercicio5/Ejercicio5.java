package ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ejercicio1.RopaEj1;

public class Ejercicio5 {

    public static void main(String[] args) {
        
        // Lista donde cargaremos los objetos RopaEj1 leídos del fichero binario
        List<RopaEj1> listaOriginal = new ArrayList<>();

        // ------------------------------------------------------------
        // 1) Leer el fichero binario ropaEj1.dat (serializado en ej1)
        // ------------------------------------------------------------
        try (FileInputStream fis = new FileInputStream("ropaEj1.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Recuperamos la lista completa de objetos RopaEj1
            listaOriginal = (List<RopaEj1>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un error durante la lectura o deserialización
            e.printStackTrace();
        }

        // ------------------------------------------------------------
        // 2) Convertir la lista original → lista mínima para JSON
        // Solo conservamos idProducto y precio (según el enunciado)
        // ------------------------------------------------------------
        List<RopaEj5> listaNueva = new ArrayList<>();

        for (RopaEj1 r : listaOriginal) {
            // Creamos un nuevo objeto RopaEj5 con solo los campos necesarios
            listaNueva.add(new RopaEj5(
                    r.getIdProducto(),
                    r.getPrecio()
            ));
        }

        // ------------------------------------------------------------
        // 3) Generar el fichero JSON utilizando Jackson
        // ------------------------------------------------------------
        try {
            // ObjectMapper es la clase principal de Jackson
            ObjectMapper mapper = new ObjectMapper();

            // writeValue() → escribe listaNueva en JSON
            // writerWithDefaultPrettyPrinter() → JSON con formato bonito
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File("ropaEj5.json"), listaNueva);

            System.out.println("JSON generado correctamente.");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
