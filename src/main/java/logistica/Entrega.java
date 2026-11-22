package logistica;

public class Entrega {

    private int id;
    private String producto;
    private String camion;
    private String destino;
    private int cantidad;

    // Constructor
    public Entrega(int id, String producto, String camion,
                   String destino, int cantidad) {

        this.id = id;
        this.producto = producto;
        this.camion = camion;
        this.destino = destino;
        this.cantidad = cantidad;
    }

    // Obtener ID
    public int getId() {
        return id;
    }

    // Obtener producto
    public String getProducto() {
        return producto;
    }

    // Obtener camion
    public String getCamion() {
        return camion;
    }

    // Obtener destino
    public String getDestino() {
        return destino;
    }

    // Obtener cantidad
    public int getCantidad() {
        return cantidad;
    }

    // Mostrar informacion de la entrega
    @Override
    public String toString() {
        return "ID: " + id
                + " | Producto: " + producto
                + " | Camion: " + camion
                + " | Destino: " + destino
                + " | Cantidad: " + cantidad;
    }
}
