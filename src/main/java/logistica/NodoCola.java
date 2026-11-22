package logistica;

public class NodoCola {

    Camion camion;
    NodoCola siguiente;

    // Constructor
    public NodoCola(Camion camion) {
        this.camion = camion;
        this.siguiente = null;
    }
}
