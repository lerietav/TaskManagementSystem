import java.util.List;

public class AlgoritmosGestion {

    // RECURSIVIDAD: Cálculo del tiempo total acumulado
    public static int calcularTiempoTotalRecursivo(List<Tarea> tareas, int indice) {
        if (indice >= tareas.size()) {
            return 0;
        }
        return tareas.get(indice).getTiempoEstimadoMinutos() + calcularTiempoTotalRecursivo(tareas, indice + 1);
    }

    // DIVIDE Y VENCERÁS: MergeSort para ordenar tareas por fecha de entrega
    public static void mergeSortPorFecha(List<Tarea> tareas, int inicio, int fin) {
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            mergeSortPorFecha(tareas, inicio, medio);
            mergeSortPorFecha(tareas, medio + 1, fin);
            merge(tareas, inicio, medio, fin);
        }
    }

    private static void merge(List<Tarea> tareas, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        Tarea[] izq = new Tarea[n1];
        Tarea[] der = new Tarea[n2];

        for (int i = 0; i < n1; i++)
            izq[i] = tareas.get(inicio + i);
        for (int j = 0; j < n2; j++)
            der[j] = tareas.get(medio + 1 + j);

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (izq[i].getFechaEntregaDias() <= der[j].getFechaEntregaDias()) {
                tareas.set(k, izq[i]);
                i++;
            } else {
                tareas.set(k, der[j]);
                j++;
            }
            k++;
        }
        while (i < n1) {
            tareas.set(k, izq[i]);
            i++;
            k++;
        }
        while (j < n2) {
            tareas.set(k, der[j]);
            j++;
            k++;
        }
    }
}