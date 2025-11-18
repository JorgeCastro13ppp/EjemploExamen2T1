package ejercicio4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import ejercicio1.RopaEj1;

public class Ejercicio4 {

    public static void main(String[] args) {

        // Lista donde cargaremos los objetos RopaEj1 deserializados del fichero binario
        List<RopaEj1> listaOriginal = new ArrayList<>();

        // ------------------------------------------------------------
        // 1) Leer el fichero binario ropaEj1.dat (ejercicio 2)
        // ------------------------------------------------------------
        try (FileInputStream fis = new FileInputStream("ropaEj1.dat");
             ObjectInputStream oos = new ObjectInputStream(fis)) {

            // Recuperamos la lista completa de objetos RopaEj1
            listaOriginal = (List<RopaEj1>) oos.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------------
        // 2) Convertir los objetos RopaEj1 → RopaEj4 (solo los campos necesarios)
        // ------------------------------------------------------------
        List<RopaEj4> listaNueva = new ArrayList<>();

        for (RopaEj1 r : listaOriginal) {

            // Creamos un RopaEj4 SOLO con Nombre, Talla, Color, Precio y Estado
            listaNueva.add(new RopaEj4(
                    r.getNombre(),
                    r.getTalla(),
                    r.getColor(),
                    r.getPrecio(),
                    r.getEstado()
            ));
        }

        // ------------------------------------------------------------
        // 3) Crear el contenedor para JAXB y asignarle la lista
        // ------------------------------------------------------------
        // JAXB no puede serializar directamente una lista: necesita una clase raíz
        RopaContenedorEj4 contenedor = new RopaContenedorEj4();
        contenedor.setProductos(listaNueva);

        // ------------------------------------------------------------
        // 4) Crear el XML mediante JAXB
        // ------------------------------------------------------------
        try {

            // El contexto JAXB debe recibir la clase raíz (el contenedor)
            JAXBContext context = JAXBContext.newInstance(RopaContenedorEj4.class);

            // El Marshaller se encarga de convertir objetos Java → XML
            Marshaller marshaller = context.createMarshaller();

            // Esta propiedad formatea el XML con saltos y sangrado (más legible)
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Generar el XML en el fichero ropaEj4.xml
            marshaller.marshal(contenedor, new File("ropaEj4.xml"));

            System.out.println("XML generado correctamente.");

        } catch (Exception i) {
            i.printStackTrace();
        }
    }
}
