import java.util.*;

public class GrafoDependencias {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void agregarTarea(int idTarea) {
        adjList.putIfAbsent(idTarea, new ArrayList<>());
    }

    public void agregarDependencia(int idTareaOrigen, int idTareaDestino) {
        adjList.putIfAbsent(idTareaOrigen, new ArrayList<>());
        adjList.putIfAbsent(idTareaDestino, new ArrayList<>());
        adjList.get(idTareaOrigen).add(idTareaDestino);
    }

    public void mostrarDependencias() {
        if (adjList.isEmpty()) {
            System.out.println("No hay dependencias registradas.");
            return;
        }
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print("Tarea [" + entry.getKey() + "] desbloquea a -> ");
            if (entry.getValue().isEmpty()) {
                System.out.println("(Ninguna tarea dependiente)");
            } else {
                System.out.println(entry.getValue());
            }
        }
    }
}