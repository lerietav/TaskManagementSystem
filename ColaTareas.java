public class ColaTareas {

    private Tarea[] tareas;
    private int frente;
    private int finalCola;
    private int cantidad;

    public ColaTareas(int capacidad) {
        tareas = new Tarea[capacidad];
        frente = 0;
        finalCola = -1;
        cantidad = 0;
    }

    // ENQUEUE: agregar una tarea al final
    public void enqueue(Tarea tarea) {

        if (cantidad == tareas.length) {
            System.out.println("La cola está llena.");
            return;
        }

        finalCola = (finalCola + 1) % tareas.length;
        tareas[finalCola] = tarea;
        cantidad++;
    }

    // DEQUEUE: eliminar la primera tarea
    public Tarea dequeue() {

        if (cantidad == 0) {
            System.out.println("La cola está vacía.");
            return null;
        }

        Tarea tarea = tareas[frente];

        tareas[frente] = null;
        frente = (frente + 1) % tareas.length;
        cantidad--;

        return tarea;
    }

    // FRONT: consultar la primera tarea sin eliminarla
    public Tarea front() {

        if (cantidad == 0) {
            System.out.println("La cola está vacía.");
            return null;
        }

        return tareas[frente];
    }

    // Mostrar todas las tareas
    public void mostrar() {

        if (cantidad == 0) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("\n--- TAREAS PROGRAMADAS ---");

        for (int i = 0; i < cantidad; i++) {
            int posicion = (frente + i) % tareas.length;
            System.out.println(tareas[posicion]);
        }
    }

    public Tarea[] obtenerTareas() {

        Tarea[] resultado = new Tarea[cantidad];

        for (int i = 0; i < cantidad; i++) {
            int posicion = (frente + i) % tareas.length;
            resultado[i] = tareas[posicion];
        }

        return resultado;
    }
}