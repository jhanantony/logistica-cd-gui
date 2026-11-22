
package logistica;

public class Producto {

    private int codigo;
    private String nombre;
    private int stock;

    // Constructor
    public Producto(int codigo, String nombre, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
    }

    // Obtener codigo
    public int getCodigo() {
        return codigo;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener stock
    public int getStock() {
        return stock;
    }

    // Modificar stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Mostrar informacion del producto
    @Override
    public String toString() {
        return "Codigo: " + codigo
                + " | Nombre: " + nombre
                + " | Stock: " + stock;
    }
}
