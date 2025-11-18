package ejercicio3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Usamos un bucle para poder buscar varios IDs hasta que el usuario decida salir
        while (true) {

            // Pedimos el ID al usuario
            System.out.println("Introduce el ID del producto a buscar (o -1 para salir):");
            int idProductoBuscar = sc.nextInt();
            sc.nextLine();

            // Si introduce -1, salimos del programa
            if (idProductoBuscar == -1) {
                System.out.println("Saliendo del programa...");
                break;
            }

            // Abrimos de nuevo el fichero en cada iteración del bucle,
            // ya que el puntero se consume hasta el final en cada búsqueda
            try (RandomAccessFile raf = new RandomAccessFile("precioEj2.dat", "r")) {

                // Indicador para saber si encontramos el ID
                boolean encontrado = false;

                // Mientras queden bytes que leer en el fichero
                while (raf.getFilePointer() < raf.length()) {

                    // Leemos un registro completo (24 bytes)
                    int id = raf.readInt();          // 4 bytes
                    double precio = raf.readDouble(); // 8 bytes
                    double coste = raf.readDouble();  // 8 bytes
                    int descuento = raf.readInt();    // 4 bytes

                    // Comparamos el ID del registro con el ID buscado por el usuario
                    if (id == idProductoBuscar) {
                        
                        // Calculamos el beneficio según la fórmula
                        double beneficio = precio - (precio * descuento / 100) - coste;

                        // Mostramos la información del producto
                        System.out.println("--------------------------------------------------");
                        System.out.println("Producto encontrado:");
                        System.out.println("Precio: " + precio + " €");
                        System.out.println("Coste: " + coste + " €");
                        System.out.println("Descuento: " + descuento + " %");
                        System.out.println("Beneficio final: " + beneficio + " €");
                        System.out.println("--------------------------------------------------");

                        encontrado = true; // Marcamos que encontramos el producto
                        break;            // Salimos del while interno
                    }
                }

                // Si terminamos el fichero sin encontrar el ID:
                if (!encontrado) {
                    System.out.println("No se encontró ningún producto con el ID " + idProductoBuscar + ".");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(); // Línea en blanco para separar búsquedas
        }

        sc.close(); // Cerramos el scanner
    }
}
