package logistica;

public class Ruta {

    private String destino;
    private int distanciaKm;

    // Constructor
    public Ruta(String destino, int distanciaKm) {
        this.destino = destino;
        this.distanciaKm = distanciaKm;
    }

    // Obtener destino
    public String getDestino() {
        return destino;
    }

    // Obtener distancia
    public int getDistanciaKm() {
        return distanciaKm;
    }

    // Mostrar informacion de la ruta
    @Override
    public String toString() {
        return "Destino: " + destino
                + " | Distancia: " + distanciaKm + " km";
    }
}
