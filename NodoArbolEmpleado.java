public class NodoArbolEmpleado {
    Empleado empleado;
    NodoArbolEmpleado izquierdo;
    NodoArbolEmpleado derecho;

    public NodoArbolEmpleado(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = null;
        this.derecho = null;
    }
}