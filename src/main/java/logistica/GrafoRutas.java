package logistica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class GrafoRutas {

    private HashMap<String, LinkedList<Ruta>> adyacencia;

    // Constructor
    public GrafoRutas() {
        adyacencia = new HashMap<>();
    }

    // Agregar una ciudad
    public void agregarCiudad(String ciudad) {

        if (!adyacencia.containsKey(ciudad)) {
            adyacencia.put(ciudad, new LinkedList<>());
        }
    }

    // Agregar una ruta entre dos ciudades
    public void agregarRuta(String origen, String destino, int km) {

        if (km <= 0) {
            return;
        }

        if (!adyacencia.containsKey(origen)
                || !adyacencia.containsKey(destino)) {
            return;
        }

        adyacencia.get(origen).add(new Ruta(destino, km));

        adyacencia.get(destino).add(new Ruta(origen, km));
    }

    // Mostrar todas las rutas
    public String mostrarRutas() {

        String resultado = "";

        for (String ciudad : adyacencia.keySet()) {

            resultado += "\nCiudad: " + ciudad + "\n";

            for (Ruta ruta : adyacencia.get(ciudad)) {
                resultado += "  -> " + ruta.toString() + "\n";
            }
        }

        return resultado;
    }

    // Recorrido BFS (Busqueda en anchura)
    public List<String> bfs(String inicio) {

        List<String> recorrido = new LinkedList<>();

        if (!adyacencia.containsKey(inicio)) {
            return recorrido;
        }

        Queue<String> cola = new LinkedList<>();
        Set<String> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {

            String actual = cola.poll();

            recorrido.add(actual);

            for (Ruta ruta : adyacencia.get(actual)) {

                String destino = ruta.getDestino();

                if (!visitados.contains(destino)) {

                    visitados.add(destino);
                    cola.add(destino);
                }
            }
        }

        return recorrido;
    }

    // Calcular la distancia total de un camino
    public int distanciaRuta(List<String> camino) {

        int distanciaTotal = 0;

        for (int i = 0; i < camino.size() - 1; i++) {

            String origen = camino.get(i);
            String destino = camino.get(i + 1);

            if (!adyacencia.containsKey(origen)) {
                return -1;
            }

            boolean encontrada = false;

            for (Ruta ruta : adyacencia.get(origen)) {

                if (ruta.getDestino().equals(destino)) {

                    distanciaTotal += ruta.getDistanciaKm();
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                return -1;
            }
        }

        return distanciaTotal;
    }
}
