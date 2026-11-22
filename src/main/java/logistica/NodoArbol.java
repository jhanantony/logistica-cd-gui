package logistica;

public class NodoArbol {

    Producto producto;
    NodoArbol izquierdo;
    NodoArbol derecho;

    // Constructor
    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izquierdo = null;
        this.derecho = null;
    }
}
