public class ListaTareas {

    private Nodo cabeza;

    public ListaTareas() {
        cabeza = null;
    }

    // INSERT: agregar una tarea al final de la lista
    public void insert(Tarea tarea) {

        Nodo nuevo = new Nodo(tarea);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // FIND: buscar una tarea por su ID
    public Tarea find(int id) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.tarea.getId() == id) {
                return actual.tarea;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // DELETE: eliminar una tarea por su ID
    public boolean delete(int id) {

        if (cabeza == null) {
            return false;
        }

        if (cabeza.tarea.getId() == id) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {

            if (actual.siguiente.tarea.getId() == id) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Mostrar todas las tareas
    public void mostrar() {

        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("\n--- TAREAS EN LISTA ---");

        Nodo actual = cabeza;

        while (actual != null) {
            System.out.println(actual.tarea);
            actual = actual.siguiente;
        }

    }

    public Tarea[] obtenerTareas() {

        int cantidad = 0;
        Nodo actual = cabeza;

        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }

        Tarea[] resultado = new Tarea[cantidad];

        actual = cabeza;
        int posicion = 0;

        while (actual != null) {
            resultado[posicion] = actual.tarea;
            posicion++;
            actual = actual.siguiente;
        }

        return resultado;
    }
}