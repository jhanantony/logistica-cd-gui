package logistica;

import java.util.List;

public class ArbolInventario {

    private NodoArbol raiz;

    // Insertar un producto en el arbol
    public void insertar(Producto producto) {
        raiz = insertarRecursivo(raiz, producto);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, Producto producto) {

        if (actual == null) {
            return new NodoArbol(producto);
        }

        if (producto.getCodigo() < actual.producto.getCodigo()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, producto);

        } else if (producto.getCodigo() > actual.producto.getCodigo()) {
            actual.derecho = insertarRecursivo(actual.derecho, producto);
        }

        return actual;
    }

    // Buscar un producto por su codigo
    public Producto buscar(int codigo) {

        NodoArbol actual = raiz;

        while (actual != null) {

            if (codigo == actual.producto.getCodigo()) {
                return actual.producto;
            }

            if (codigo < actual.producto.getCodigo()) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }

        return null;
    }

    // Mostrar productos ordenados de menor a mayor
    public void inOrden(List<Producto> lista) {
        inOrdenRecursivo(raiz, lista);
    }

    private void inOrdenRecursivo(NodoArbol actual, List<Producto> lista) {

        if (actual != null) {

            inOrdenRecursivo(actual.izquierdo, lista);

            lista.add(actual.producto);

            inOrdenRecursivo(actual.derecho, lista);
        }
    }

    // Calcular la altura del arbol
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(NodoArbol actual) {

        if (actual == null) {
            return 0;
        }

        int izquierda = alturaRecursiva(actual.izquierdo);
        int derecha = alturaRecursiva(actual.derecho);

        return 1 + Math.max(izquierda, derecha);
    }

    // Descontar stock de un producto
    public boolean descontarStock(int codigo, int cantidad) {

        Producto producto = buscar(codigo);

        if (producto == null || cantidad <= 0) {
            return false;
        }

        if (producto.getStock() < cantidad) {
            return false;
        }

        producto.setStock(producto.getStock() - cantidad);

        return true;
    }
}
