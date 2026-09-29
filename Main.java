import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Estructuras de la Fase I
        PilaTareas pila = new PilaTareas(10);
        ColaTareas cola = new ColaTareas(10);
        ListaTareas lista = new ListaTareas();

        // Estructuras de la Fase Final
        ColaPrioridadTareas colaPrioridad = new ColaPrioridadTareas();
        ArbolEmpleadosBST arbolEmpleados = new ArbolEmpleadosBST();
        HashMap<Integer, Tarea> hashTareas = new HashMap<>();
        HashMap<Integer, Empleado> hashEmpleados = new HashMap<>();
        GrafoDependencias grafo = new GrafoDependencias();
        List<Tarea> listaGeneral = new ArrayList<>();

        // Datos de prueba iniciales
        cargarDatosIniciales(pila, cola, lista, colaPrioridad, arbolEmpleados, hashTareas, hashEmpleados, grafo,
                listaGeneral);

        int opcion = 0;
        do {
            System.out.println("\n====================================================================");
            System.out.println("     SISTEMA INTEGRAL DE GESTIÓN DE TAREAS - RESTAURANTE  ");
            System.out.println("====================================================================");
            System.out.println("--- FASE I: ESTRUCTURAS LINEALES ---");
            System.out.println(" 1. Agregar tarea urgente (PILA)");
            System.out.println(" 2. Ver tareas urgentes (PILA)");
            System.out.println(" 3. Consultar tarea urgente (PEEK PILA)");
            System.out.println(" 4. Eliminar tarea urgente (POP PILA)");
            System.out.println(" 5. Agregar tarea programada (COLA)");
            System.out.println(" 6. Ver tareas programadas (COLA)");
            System.out.println(" 7. Consultar siguiente tarea (FRONT COLA)");
            System.out.println(" 8. Eliminar tarea programada (DEQUEUE COLA)");
            System.out.println(" 9. Agregar tarea a lista enlazada");
            System.out.println("10. Buscar tarea en lista por ID");
            System.out.println("11. Eliminar tarea de lista por ID");
            System.out.println("12. Ver todas las tareas de la Fase I (Ordenadas)");
            System.out.println("--- FASE FINAL: ESTRUCTURAS AVANZADAS Y ALGORITMOS ---");
            System.out.println("13. Agregar tarea a Cola de Prioridades (Heap)");
            System.out.println("14. Atender tarea más prioritaria (POLL Heap)");
            System.out.println("15. Ver tareas en Cola de Prioridades");
            System.out.println("16. Registrar empleado en Árbol Binario (BST)");
            System.out.println("17. Buscar empleado en Árbol BST");
            System.out.println("18. Ver empleados ordenados por ID (In-Orden BST)");
            System.out.println("19. Asignar empleado a tarea (Vía HashMap O(1))");
            System.out.println("20. Consultar tarea directamente en HashMap (O(1))");
            System.out.println("21. Calcular tiempo total de tareas (Recursividad)");
            System.out.println("22. Ordenar tareas por fecha de entrega (Divide y Vencerás - MergeSort)");
            System.out.println("23. Registrar dependencia entre tareas (Grafo)");
            System.out.println("24. Mostrar mapa de dependencias (Grafo)");
            System.out.println("25. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                // ------------------ FASE I ------------------
                case 1:
                    System.out.println("\n--- AGREGAR TAREA URGENTE (PILA) ---");
                    System.out.print("ID: ");
                    int idU = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descU = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depU = scanner.nextLine();
                    System.out.print("Urgencia (Alta, Media, Baja): ");
                    String urgU = scanner.nextLine();
                    pila.push(new Tarea(idU, descU, depU, urgU, 1, 30));
                    System.out.println("¡Tarea urgente agregada correctamente!");
                    break;
                case 2:
                    System.out.println("\n--- TAREAS URGENTES (PILA) ---");
                    pila.mostrar();
                    break;
                case 3:
                    System.out.println("\nPEEK: " + pila.peek());
                    break;
                case 4:
                    System.out.println("\nPOP: " + pila.pop());
                    System.out.println("¡La tarea ha sido eliminada correctamente!");
                    break;
                case 5:
                    System.out.println("\n--- AGREGAR TAREA PROGRAMADA (COLA) ---");
                    System.out.print("ID: ");
                    int idC = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descC = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depC = scanner.nextLine();
                    System.out.print("Urgencia: ");
                    String urgC = scanner.nextLine();
                    cola.enqueue(new Tarea(idC, descC, depC, urgC, 3, 45));
                    System.out.println("¡Tarea programada agregada correctamente!");
                    break;
                case 6:
                    System.out.println("\n--- TAREAS PROGRAMADAS (COLA) ---");
                    cola.mostrar();
                    break;
                case 7:
                    System.out.println("\nFRONT: " + cola.front());
                    break;
                case 8:
                    System.out.println("\nDEQUEUE: " + cola.dequeue());
                    System.out.println("¡La tarea ha sido eliminada correctamente!");
                    break;
                case 9:
                    System.out.println("\n--- AGREGAR TAREA A LISTA ---");
                    System.out.print("ID: ");
                    int idL = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descL = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depL = scanner.nextLine();
                    System.out.print("Urgencia: ");
                    String urgL = scanner.nextLine();
                    lista.insert(new Tarea(idL, descL, depL, urgL, 5, 60));
                    System.out.println("¡Tarea agregada correctamente a la lista!");
                    break;
                case 10:
                    System.out.print("\nIngrese ID a buscar: ");
                    int idBL = scanner.nextInt();
                    scanner.nextLine();
                    Tarea tb = lista.find(idBL);
                    System.out.println(tb != null ? "Encontrada: " + tb : "No encontrada.");
                    break;
                case 11:
                    System.out.print("\nIngrese ID a eliminar: ");
                    int idEL = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(lista.delete(idEL) ? "Eliminada exitosamente." : "No encontrada.");
                    break;
                case 12:
                    Tarea[] tP = pila.obtenerTareas();
                    Tarea[] tC = cola.obtenerTareas();
                    Tarea[] tL = lista.obtenerTareas();
                    Tarea[] todas = new Tarea[tP.length + tC.length + tL.length];
                    System.arraycopy(tP, 0, todas, 0, tP.length);
                    System.arraycopy(tC, 0, todas, tP.length, tC.length);
                    System.arraycopy(tL, 0, todas, tP.length + tC.length, tL.length);
                    Arrays.sort(todas,
                            Comparator.comparingInt(Tarea::nivelUrgencia).thenComparing(Tarea::getDepartamento));
                    System.out.println("\n--- TODAS LAS TAREAS PENDIENTES (FASE I) ---");
                    for (Tarea t : todas)
                        System.out.println(t);
                    break;

                // ------------------ FASE FINAL ------------------
                case 13:
                    System.out.println("\n--- AGREGAR TAREA A COLA DE PRIORIDADES (HEAP) ---");
                    System.out.print("ID: ");
                    int idCP = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String dCP = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depCP = scanner.nextLine();
                    System.out.print("Urgencia (Alta, Media, Baja): ");
                    String uCP = scanner.nextLine();
                    System.out.print("Días para entrega: ");
                    int diasCP = scanner.nextInt();
                    System.out.print("Tiempo estimado (minutos): ");
                    int minCP = scanner.nextInt();
                    scanner.nextLine();

                    Tarea nuevaT = new Tarea(idCP, dCP, depCP, uCP, diasCP, minCP);
                    colaPrioridad.encolar(nuevaT);
                    hashTareas.put(idCP, nuevaT);
                    listaGeneral.add(nuevaT);
                    grafo.agregarTarea(idCP);
                    break;
                case 14:
                    Tarea atendida = colaPrioridad.atenderSiguiente();
                    if (atendida != null) {
                        System.out.println("\n-> Tarea despachada de mayor urgencia:\n" + atendida);
                    }
                    break;
                case 15:
                    colaPrioridad.mostrarColaOrdenada();
                    break;
                case 16:
                    System.out.println("\n--- REGISTRAR EMPLEADO EN BST ---");
                    System.out.print("ID Empleado: ");
                    int idEmp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nEmp = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String dEmp = scanner.nextLine();

                    Empleado emp = new Empleado(idEmp, nEmp, dEmp);
                    arbolEmpleados.insertar(emp);
                    hashEmpleados.put(idEmp, emp);
                    System.out.println("Empleado registrado en BST y tabla Hash.");
                    break;
                case 17:
                    System.out.print("\nIngrese ID del empleado a buscar en el BST: ");
                    int idBE = scanner.nextInt();
                    scanner.nextLine();
                    Empleado encontrado = arbolEmpleados.buscar(idBE);
                    System.out.println(encontrado != null ? "Localizado:\n" + encontrado : "Empleado no encontrado.");
                    break;
                case 18:
                    arbolEmpleados.mostrarInOrden();
                    break;
                case 19:
                    System.out.println("\n--- ASIGNAR EMPLEADO A TAREA (HASHMAP O(1)) ---");
                    System.out.print("ID de la Tarea: ");
                    int idTAsig = scanner.nextInt();
                    System.out.print("ID del Empleado: ");
                    int idEAsig = scanner.nextInt();
                    scanner.nextLine();

                    Tarea tarObj = hashTareas.get(idTAsig);
                    Empleado empObj = hashEmpleados.get(idEAsig);

                    if (tarObj == null) {
                        System.out.println("Error: No existe una tarea registrada con ID " + idTAsig);
                    } else if (empObj == null) {
                        System.out.println("Error: No existe un empleado registrado con ID " + idEAsig);
                    } else {
                        tarObj.setIdEmpleadoAsignado(idEAsig);
                        System.out.println("¡Asignación exitosa! [" + tarObj.getDescripcion() + "] asignada a ["
                                + empObj.getNombre() + "]");
                    }
                    break;
                case 20:
                    System.out.print("\nIngrese ID de la tarea a consultar en HashMap: ");
                    int idHash = scanner.nextInt();
                    scanner.nextLine();
                    long t1 = System.nanoTime();
                    Tarea tHash = hashTareas.get(idHash);
                    long t2 = System.nanoTime();

                    if (tHash != null) {
                        System.out.println("Encontrada en O(1):\n" + tHash);
                        System.out.println("Tiempo de respuesta: " + (t2 - t1) + " nanosegundos.");
                    } else {
                        System.out.println("La tarea con ID " + idHash + " no está en la tabla Hash.");
                    }
                    break;
                case 21:
                    int totalMin = AlgoritmosGestion.calcularTiempoTotalRecursivo(listaGeneral, 0);
                    System.out.println("\n--- TIEMPO ESTIMADO TOTAL (RECURSIVIDAD) ---");
                    System.out.println(
                            "Total de minutos estimados: " + totalMin + " min (" + (totalMin / 60.0) + " horas).");
                    break;
                case 22:
                    if (listaGeneral.isEmpty()) {
                        System.out.println("No hay tareas registradas para ordenar.");
                    } else {
                        AlgoritmosGestion.mergeSortPorFecha(listaGeneral, 0, listaGeneral.size() - 1);
                        System.out.println("\n--- TAREAS ORDENADAS POR FECHA DE ENTREGA (DIVIDE Y VENCERÁS) ---");
                        for (Tarea t : listaGeneral) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 23:
                    System.out.println("\n--- REGISTRAR DEPENDENCIA (GRAFO) ---");
                    System.out.print("ID Tarea Prerrequisito (Origen): ");
                    int idO = scanner.nextInt();
                    System.out.print("ID Tarea Dependiente (Destino): ");
                    int idD = scanner.nextInt();
                    scanner.nextLine();
                    grafo.agregarDependencia(idO, idD);
                    System.out.println(
                            "Dependencia registrada: La Tarea [" + idD + "] depende de la Tarea [" + idO + "].");
                    break;
                case 24:
                    System.out.println("\n--- MAPA DE DEPENDENCIAS DEL PROYECTO (GRAFOS) ---");
                    grafo.mostrarDependencias();
                    break;
                case 25:
                    System.out.println("\n¡Hasta luego! Sistema finalizado.");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        } while (opcion != 25);

        scanner.close();
    }

    private static void cargarDatosIniciales(PilaTareas pila, ColaTareas cola, ListaTareas lista,
            ColaPrioridadTareas cp, ArbolEmpleadosBST bst,
            HashMap<Integer, Tarea> ht, HashMap<Integer, Empleado> he,
            GrafoDependencias g, List<Tarea> lg) {
        // Precarga de empleados
        Empleado e1 = new Empleado(105, "Ana Martinez", "Cocina");
        Empleado e2 = new Empleado(102, "Carlos Gomez", "Almacen");
        Empleado e3 = new Empleado(108, "Lucia Fernandez", "Administracion");
        bst.insertar(e1);
        bst.insertar(e2);
        bst.insertar(e3);
        he.put(e1.getId(), e1);
        he.put(e2.getId(), e2);
        he.put(e3.getId(), e3);

        // Precarga de tareas avanzadas
        Tarea t1 = new Tarea(501, "Recepcion de insumos frescos", "Almacen", "Alta", 1, 60);
        Tarea t2 = new Tarea(502, "Preparacion de mise en place", "Cocina", "Alta", 2, 90);
        Tarea t3 = new Tarea(503, "Auditoria contable de inventario", "Administracion", "Media", 5, 180);

        cp.encolar(t1);
        cp.encolar(t2);
        cp.encolar(t3);
        ht.put(t1.getId(), t1);
        ht.put(t2.getId(), t2);
        ht.put(t3.getId(), t3);
        lg.add(t1);
        lg.add(t2);
        lg.add(t3);

        // Dependencia inicial en grafo (502 depende de 501)
        g.agregarDependencia(501, 502);
    }
}