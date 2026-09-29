public class PilaTareas {

    private Tarea[] tareas;
    private int cima;

    public PilaTareas(int capacidad) {
        tareas = new Tarea[capacidad];
        cima = -1;
    }

    // PUSH: agregar una tarea
    public void push(Tarea tarea) {
        if (cima == tareas.length - 1) {
            System.out.println("La pila está llena.");
            return;
        }

        cima++;
        tareas[cima] = tarea;
    }

    // POP: eliminar y devolver la tarea de arriba
    public Tarea pop() {
        if (cima == -1) {
            System.out.println("La pila está vacía.");
            return null;
        }

        Tarea tarea = tareas[cima];
        tareas[cima] = null;
        cima--;

        return tarea;
    }

    // PEEK: consultar la tarea de arriba sin eliminarla
    public Tarea peek() {
        if (cima == -1) {
            System.out.println("La pila está vacía.");
            return null;
        }

        return tareas[cima];
    }

    // Mostrar todas las tareas
    public void mostrar() {
        if (cima == -1) {
            System.out.println("La pila está vacía.");
            return;
        }

        System.out.println("\n--- TAREAS URGENTES ---");

        for (int i = cima; i >= 0; i--) {
            System.out.println(tareas[i]);
        }
    }

    public Tarea[] obtenerTareas() {

        Tarea[] resultado = new Tarea[cima + 1];

        for (int i = 0; i <= cima; i++) {
            resultado[i] = tareas[i];
        }

        return resultado;
    }
}
