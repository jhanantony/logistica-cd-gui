package logistica;

public class Camion {

    private String placa;
    private String conductor;
    private double capacidadTon;

    // Constructor
    public Camion(String placa, String conductor, double capacidadTon) {
        this.placa = placa;
        this.conductor = conductor;
        this.capacidadTon = capacidadTon;
    }

    // Obtener placa
    public String getPlaca() {
        return placa;
    }

    // Obtener conductor
    public String getConductor() {
        return conductor;
    }

    // Obtener capacidad
    public double getCapacidadTon() {
        return capacidadTon;
    }

    // Mostrar informacion del camion
    @Override
    public String toString() {
        return "Placa: " + placa
                + " | Conductor: " + conductor
                + " | Capacidad: " + capacidadTon + " toneladas";
    }
}
