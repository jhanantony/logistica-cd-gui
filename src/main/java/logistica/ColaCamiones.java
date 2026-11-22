package logistica;

public class ColaCamiones {

    private NodoCola frente;
    private NodoCola fin;

    // Constructor
    public ColaCamiones() {
        frente = null;
        fin = null;
    }

    // Verificar si la cola esta vacia
    public boolean estaVacia() {
        return frente == null;
    }

    // Agregar un camion al final
    public void encolar(Camion camion) {

        NodoCola nuevo = new NodoCola(camion);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Retirar el primer camion
    public Camion desencolar() {

        if (estaVacia()) {
            return null;
        }

        Camion camion = frente.camion;

        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return camion;
    }

    // Mostrar todos los camiones
    public String mostrar() {

        if (estaVacia()) {
            return "La cola de camiones esta vacia.";
        }

        String resultado = "";
        NodoCola actual = frente;

        while (actual != null) {

            resultado += actual.camion.toString() + "\n";

            actual = actual.siguiente;
        }

        return resultado;
    }
}
