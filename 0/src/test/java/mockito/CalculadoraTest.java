package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculadoraTest {

	@Mock
	Calculadora calculadora;

	@BeforeEach
	public void setUp() {
	}

	@Test
	void teste_somar_dois_digitos() {
		when(calculadora.somar(anyInt(), anyInt())).thenReturn(5);
		int resultado = calculadora.somar(2, 3);
		assertEquals(5, resultado);
	}

}
