package mockito;

public class Calculadora {
	ServicoMatematicoImpl servicoMatematico = new ServicoMatematicoImpl();

	public int somar(int a, int b) {
		return servicoMatematico.somar(a, b);
	}

}
