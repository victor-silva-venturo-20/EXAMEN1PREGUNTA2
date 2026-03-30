public interface AsistenciaRepository {
    boolean existeEmpleado(String empleadoId);
    boolean tieneRegistroActivo(String empleadoId);
    void guardarEntrada(String empleadoId);
}
