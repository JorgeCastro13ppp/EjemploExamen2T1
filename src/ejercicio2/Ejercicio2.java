package ejercicio2;

import ejercicio1.RopaEj1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    
    // Tamaño del registro fijo: int (4) + double (8) + double (8) + int (4) = 24 bytes
    public static final int TAM_REGISTRO = 24;

    public static void main(String[] args) {
        
        // Lista donde guardaremos los objetos leídos del fichero ropaEj1.dat
        List<RopaEj1> listaPrecio = new ArrayList<>();

        // Primer try: lectura del fichero binario que contiene objetos RopaEj1
        try (FileInputStream fis = new FileInputStream("ropaEj1.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            // Recuperamos la lista completa de objetos RopaEj1
            listaPrecio = (List<RopaEj1>) ois.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            // Si hay error al leer, mostramos la excepción
            e.printStackTrace();
        }
        
        // Segundo try: escritura en fichero de acceso aleatorio precioEj2.dat
        try (RandomAccessFile raf = new RandomAccessFile("precioEj2.dat", "rw")) {
            
            // Recorremos todos los objetos leídos anteriormente
            for (RopaEj1 r : listaPrecio) {
                
                // Escribimos el registro fijo:
                // ID (int), Precio (double), Coste (double), Descuento (int)
                raf.writeInt(r.getIdProducto());
                raf.writeDouble(r.getPrecio());
                raf.writeDouble(r.getCoste());
                raf.writeInt(r.getDescuento());
            }
            
            // MENSAJE DE ÉXITO → Se coloca AQUÍ, después del for,
            // para confirmar que se ha escrito todo correctamente
            System.out.println("Fichero precioEj2.dat creado correctamente con registros de " 
                                + TAM_REGISTRO + " bytes.");
            
        } catch (IOException i) {
            // Si ocurre un error al escribir, lo mostramos
            i.printStackTrace();
        }
    }

}
