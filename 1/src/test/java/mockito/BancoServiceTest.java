package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

	@Test
	public void testConsultarSaldo() {
		// Criando mock do repositório
		ContaRepository mockRepository = mock(ContaRepository.class);

		// Criando conta simulada
		Conta conta = new Conta("12345", 20.000);

		// Definindo comportamento do mock
		when(mockRepository.buscarConta(anyString())).thenReturn(conta);

		// Criando serviço com o mock
		BancoService mockService = new BancoService(mockRepository);

		// Testando consulta de saldo
		double saldo = mockService.consultarSaldo(anyString());

		// Verificando se o saldo está correto
		assertEquals(saldo, conta.getSaldo());

		// Verificando se o método buscarConta foi chamado
		verify(mockRepository, atLeastOnce()).buscarConta(anyString());
	}

	@Test
	public void testDepositar() {
		// Criando mock do repositório
		ContaRepository mockRepository = mock(ContaRepository.class);

		// Criando conta simulada
		Conta conta = new Conta("12345", 20.000);

		// Definindo comportamento do mock
		when(mockRepository.buscarConta(anyString())).thenReturn(conta);

		// Criando serviço com o mock
		BancoService mockService = new BancoService(mockRepository);

		// Executando depósito
		mockService.depositar("12345", 20.000);

		// Verificando se o saldo foi atualizado
		assertEquals(40.0, conta.getSaldo());

		// Verificando se os métodos
		verify(mockRepository, atLeastOnce()).buscarConta(anyString());
		verify(mockRepository, atLeastOnce()).salvar(any(Conta.class));
	}
}
