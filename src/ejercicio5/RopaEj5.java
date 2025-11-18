package ejercicio5;

// Clase modelo mínima para exportar a JSON (solo idProducto y precio)
public class RopaEj5 {

    private int idProducto;
    private double precio;

    // Constructor vacío (Jackson lo necesita para deserializar si fuera necesario)
    public RopaEj5() {
    }

    // Constructor útil para convertir desde RopaEj1
    public RopaEj5(int idProducto, double precio) {
        this.idProducto = idProducto;
        this.precio = precio;
    }

    // Getters y setters → Jackson los usa para generar el JSON

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // toString opcional, útil para depuración
    @Override
    public String toString() {
        return "RopaEj5 [idProducto=" + idProducto + ", precio=" + precio + "]";
    }
}
