package ejercicio4;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Representa la etiqueta raíz <productos> del XML
@XmlRootElement(name="productos")
public class RopaContenedorEj4 {

    // Lista de elementos <producto> dentro de <productos>
    private List<RopaEj4> productos;

    // Constructor VACÍO (OBLIGATORIO para JAXB)
    public RopaContenedorEj4() {
    }

    // Este getter define que cada elemento de la lista aparecerá como <producto>
    @XmlElement(name="producto")
    public List<RopaEj4> getProductos() {
        return productos;
    }

    public void setProductos(List<RopaEj4> productos) {
        this.productos = productos;
    }
}
