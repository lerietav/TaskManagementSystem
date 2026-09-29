public class ArbolEmpleadosBST {
    private NodoArbolEmpleado raiz;

    public ArbolEmpleadosBST() {
        this.raiz = null;
    }

    // Inserción en el BST
    public void insertar(Empleado emp) {
        raiz = insertarRecursivo(raiz, emp);
    }

    private NodoArbolEmpleado insertarRecursivo(NodoArbolEmpleado actual, Empleado emp) {
        if (actual == null) {
            return new NodoArbolEmpleado(emp);
        }
        if (emp.getId() < actual.empleado.getId()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, emp);
        } else if (emp.getId() > actual.empleado.getId()) {
            actual.derecho = insertarRecursivo(actual.derecho, emp);
        } else {
            System.out.println("El empleado con ID " + emp.getId() + " ya existe en el árbol.");
        }
        return actual;
    }

    // Búsqueda en el BST
    public Empleado buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Empleado buscarRecursivo(NodoArbolEmpleado actual, int id) {
        if (actual == null) {
            return null;
        }
        if (actual.empleado.getId() == id) {
            return actual.empleado;
        }
        return id < actual.empleado.getId()
                ? buscarRecursivo(actual.izquierdo, id)
                : buscarRecursivo(actual.derecho, id);
    }

    // Recorrido In-Orden: muestra empleados ordenados por ID
    public void mostrarInOrden() {
        if (raiz == null) {
            System.out.println("No hay empleados registrados en el árbol.");
            return;
        }
        System.out.println("\n--- DIRECTORIO DE EMPLEADOS (ORDENADO POR ID) ---");
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(NodoArbolEmpleado actual) {
        if (actual != null) {
            inOrdenRecursivo(actual.izquierdo);
            System.out.println(actual.empleado);
            inOrdenRecursivo(actual.derecho);
        }
    }

    // Filtrar y mostrar empleados de un departamento específico
    public void mostrarPorDepartamento(String depto) {
        System.out.println("\n--- EMPLEADOS DEL DEPARTAMENTO: " + depto + " ---");
        mostrarPorDeptoRecursivo(raiz, depto);
    }

    private void mostrarPorDeptoRecursivo(NodoArbolEmpleado actual, String depto) {
        if (actual != null) {
            mostrarPorDeptoRecursivo(actual.izquierdo, depto);
            if (actual.empleado.getDepartamento().equalsIgnoreCase(depto)) {
                System.out.println(actual.empleado);
            }
            mostrarPorDeptoRecursivo(actual.derecho, depto);
        }
    }
}