import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SistemaAsistenciaTest {

    @Mock
    AsistenciaRepository repositorio;

    @InjectMocks
    SistemaAsistencia sistema;

    @Test
    @DisplayName("Test 1 - Registro de entrada exitoso")
    public void testRegistroEntradaExitoso() {
        Mockito.when(repositorio.existeEmpleado("EMP001")).thenReturn(true);
        Mockito.when(repositorio.tieneRegistroActivo("EMP001")).thenReturn(false);

        String resultado = sistema.registrarEntrada("EMP001");

        assertEquals("Entrada registrada correctamente", resultado);
        Mockito.verify(repositorio, Mockito.times(1)).guardarEntrada("EMP001");
    }

    @Test
    @DisplayName("Test 2 - No permite doble marcación consecutiva")
    public void testNoPermiteDobleEntrada() {
        Mockito.when(repositorio.existeEmpleado("EMP001")).thenReturn(true);
        Mockito.when(repositorio.tieneRegistroActivo("EMP001")).thenReturn(true);

        String resultado = sistema.registrarEntrada("EMP001");

        assertEquals("No se permite doble marcación consecutiva", resultado);
    }


}