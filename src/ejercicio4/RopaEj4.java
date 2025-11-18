package ejercicio4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

// Indicamos el orden en el que aparecerán los elementos dentro de <producto>
@XmlType(propOrder = {"nombre","talla","color","precio","estado"})
public class RopaEj4 {

    // Campos que queremos que aparezcan en el XML
    private String nombre;
    private String talla;
    private String color;
    private double precio;
    private String estado;

    // Constructor vacío (OBLIGATORIO para JAXB)
    public RopaEj4() {
    }

    // Constructor útil para convertir desde RopaEj1
    public RopaEj4(String nombre, String talla, String color, double precio, String estado) {
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.estado = estado;
    }

    // Cada getter debe estar anotado con @XmlElement para que JAXB lo incluya en el XML

    @XmlElement
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getTalla() {
        return talla;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }

    @XmlElement
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @XmlElement
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // toString opcional, útil para depuración, no afecta a JAXB
    @Override
    public String toString() {
        return "RopaEj4 [nombre=" + nombre + ", talla=" + talla + ", color=" + color
                + ", precio=" + precio + ", estado=" + estado + "]";
    }
}
