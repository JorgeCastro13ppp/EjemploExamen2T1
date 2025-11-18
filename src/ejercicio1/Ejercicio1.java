package ejercicio1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        // Creamos una lista donde almacenaremos todos los objetos RopaEj1
        List<RopaEj1> lista = new ArrayList<>();
        
        // Primer try-with-resources: lectura del fichero CSV
        try (FileReader fr = new FileReader("ropa.csv");
             BufferedReader br = new BufferedReader(fr)) {
            
            String linea;
            
            // Leemos el CSV línea a línea hasta llegar al final (null)
            while ((linea = br.readLine()) != null) {
                
                // Dividimos la línea en campos utilizando el carácter ';'
                String[] partes = linea.split(";");
                
                // Convertimos y extraemos cada campo necesario según el enunciado
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String talla = partes[3];            // Categoría y Material se ignoran
                String color = partes[4];
                int stock = Integer.parseInt(partes[6]);
                double precio = Double.parseDouble(partes[7]);
                double coste = Double.parseDouble(partes[8]);
                String estado = partes[9];
                int descuento = Integer.parseInt(partes[10]);
                
                // Creamos un nuevo objeto RopaEj1 con los datos extraídos
                RopaEj1 ropa = new RopaEj1(
                        id, nombre, talla, color, 
                        stock, precio, coste, estado, descuento
                );
                
                // Añadimos el objeto a la lista
                lista.add(ropa);
            }
            
        } catch (IOException e) {
            // Si ocurre un error durante la lectura del CSV, lo mostramos
            e.printStackTrace();
        }
        
        // Segundo try-with-resources: guardado de la lista en un fichero binario
        try (FileOutputStream fos = new FileOutputStream("ropaEj1.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            // Serializamos y escribimos la lista completa en el fichero binario
            oos.writeObject(lista);
            
            // Mensaje de confirmación
            System.out.println("Fichero binario creado correctamente");
            
        } catch (IOException i) {
            // Si ocurre un error al escribir el fichero binario
            i.printStackTrace();
        }
    }
}
