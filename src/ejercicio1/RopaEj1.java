package ejercicio1;

import java.io.Serializable;

// Implementamos Serializable para permitir guardar objetos en binario
public class RopaEj1 implements Serializable {
    
    /*
     * serialVersionUID:
     * ------------------
     * Cuando una clase implementa Serializable, Java necesita identificar su versión
     * para asegurar que los objetos guardados en un fichero binario coinciden con la
     * versión actual de la clase.
     *
     * Si NO definimos un serialVersionUID manualmente, Java genera uno automático
     * basado en la estructura de la clase (atributos, métodos, etc.).
     *
     * Esto significa que SI LA CLASE CAMBIA (añades un atributo, cambias un nombre,
     * recompilas con otra versión, etc.), el serialVersionUID generado será diferente,
     * y al intentar leer objetos antiguos dará un error:
     *
     *    InvalidClassException: local class incompatible
     *
     * Para evitar este problema, definimos un serialVersionUID fijo. De este modo,
     * aunque la clase cambie mínimamente, Java seguirá considerando compatibles los
     * objetos guardados en el fichero binario.
     */
    private static final long serialVersionUID = 1L;

    // Atributos del objeto según el enunciado
    private int idProducto;
    private String nombre;
    private String talla;
    private String color;
    private int Stock;        // Nota: por convención debería ser "stock" en minúscula
    private double precio;
    private double coste;
    private String estado;
    private int descuento;

    // Constructor vacío (puede ser útil para lectura/escritura)
    public RopaEj1() {

    }

    // Constructor con parámetros para inicializar todos los atributos
    public RopaEj1(int idProducto, String nombre, String talla, String color,
                   int stock, double precio, double coste,
                   String estado, int descuento) {
        super();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        Stock = stock;
        this.precio = precio;
        this.coste = coste;
        this.estado = estado;
        this.descuento = descuento;
    }

    // Getters y setters para acceder y modificar cada atributo

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
