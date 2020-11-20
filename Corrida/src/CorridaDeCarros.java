
public class CorridaDeCarros {
	final static int NUM_CARROS = 2;	// N�mero de carros na corrida
	final static int DISTANCIA = 1000; // Dist�ncia da corrida em mt
	public static void main (String[] args) {
		/* colocando carros na corrida */
		for (int i = 1; i <= NUM_CARROS; i++) {
			new CarroCorrendoThread("CARRO_" + i, DISTANCIA).start();
		}
	}
}
