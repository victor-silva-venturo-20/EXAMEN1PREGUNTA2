public class SistemaAsistencia {

    private AsistenciaRepository repositorio;

    public SistemaAsistencia(AsistenciaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public String registrarEntrada(String empleadoId) {
        if (!repositorio.existeEmpleado(empleadoId)) {
            return "Empleado no encontrado";
        }
        if (repositorio.tieneRegistroActivo(empleadoId)) {
            return "No se permite doble marcación consecutiva";
        }
        repositorio.guardarEntrada(empleadoId);
        return "Entrada registrada correctamente";
    }
}
