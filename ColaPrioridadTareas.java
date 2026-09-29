import java.util.PriorityQueue;

public class ColaPrioridadTareas {
    private PriorityQueue<Tarea> cola;

    public ColaPrioridadTareas() {
        this.cola = new PriorityQueue<>();
    }

    public void encolar(Tarea tarea) {
        cola.offer(tarea);
        System.out.println("-> Tarea [" + tarea.getId() + "] encolada con éxito en la cola de prioridades.");
    }

    public Tarea consultarFrente() {
        if (cola.isEmpty()) {
            System.out.println("La cola de prioridades está vacía.");
            return null;
        }
        return cola.peek();
    }

    public Tarea atenderSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("No hay tareas pendientes en la cola de prioridades.");
            return null;
        }
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int cantidadTareas() {
        return cola.size();
    }

    public void mostrarColaOrdenada() {
        if (cola.isEmpty()) {
            System.out.println("La cola de prioridades está vacía.");
            return;
        }
        PriorityQueue<Tarea> copia = new PriorityQueue<>(cola);
        System.out.println("\n--- TAREAS EN COLA DE PRIORIDAD (ORDEN DE ATENCIÓN) ---");
        int pos = 1;
        while (!copia.isEmpty()) {
            System.out.println(pos + ". " + copia.poll());
            pos++;
        }
    }
}