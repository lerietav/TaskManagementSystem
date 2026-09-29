public class Tarea implements Comparable<Tarea> {
    // Atributos de la Fase I
    private int id;
    private String descripcion;
    private String departamento;
    private String urgencia;

    // NUEVOS ATRIBUTOS para la Fase Final
    private int fechaEntregaDias; // Días restantes (ej: 1 = entrega más próxima)
    private int tiempoEstimadoMinutos;// Minutos que toma realizarla
    private int idEmpleadoAsignado; // ID del empleado responsable (-1 si no está asignado)

    // Constructor completo actualizado
    public Tarea(int id, String descripcion, String departamento, String urgencia, int fechaEntregaDias,
            int tiempoEstimadoMinutos) {
        this.id = id;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.urgencia = urgencia;
        this.fechaEntregaDias = fechaEntregaDias;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.idEmpleadoAsignado = -1; // Comienza sin asignar
    }

    // Métodos Getters y Setters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public int getFechaEntregaDias() {
        return fechaEntregaDias;
    }

    public int getTiempoEstimadoMinutos() {
        return tiempoEstimadoMinutos;
    }

    public int getIdEmpleadoAsignado() {
        return idEmpleadoAsignado;
    }

    public void setIdEmpleadoAsignado(int idEmpleadoAsignado) {
        this.idEmpleadoAsignado = idEmpleadoAsignado;
    }

    // Método de la Fase I para convertir texto a valor numérico
    public int nivelUrgencia() {
        if (urgencia.equalsIgnoreCase("Alta")) {
            return 1;
        }
        if (urgencia.equalsIgnoreCase("Media")) {
            return 2;
        }
        return 3; // Baja
    }

    @Override
    public int compareTo(Tarea otra) {
        // Criterio 1: Mayor urgencia primero (1 es más urgente que 2 y 3)
        int comparacionUrgencia = Integer.compare(this.nivelUrgencia(), otra.nivelUrgencia());
        if (comparacionUrgencia != 0) {
            return comparacionUrgencia;
        }
        // Criterio 2: Si tienen la misma urgencia, la que venza más pronto (menor días)
        // va primero
        return Integer.compare(this.fechaEntregaDias, otra.fechaEntregaDias);
    }

    // Representación en texto actualizada
    @Override
    public String toString() {
        return "ID: " + id +
                " | Tarea: " + descripcion +
                " | Departamento: " + departamento +
                " | Urgencia: " + urgencia +
                " | Vence en: " + fechaEntregaDias + " días" +
                " | Tiempo estimado: " + tiempoEstimadoMinutos + " min" +
                (idEmpleadoAsignado != -1 ? " | Asignado a Emp ID: " + idEmpleadoAsignado : " | [Sin asignar]");
    }
}