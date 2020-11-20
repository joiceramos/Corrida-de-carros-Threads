
public class CarroCorrendoThread extends Thread {

	String nome;					// nome do carro
	int distanciaCorrida = 0;		// distância total já corrida pelo carro
	int distanciaTotalCorrida;	// distância a ser corrida pelo carro
	int metro = 0;					// distancia percorrida pelo carro em mt
	static int colocacao = 0;		// colocação do carro ao final da corrida
	final static int DISTANCIA_MAXIMA = 100; // movimento máximo em mt que um carro pode andar

	/** Construtor da classe. Parâmtros : Nome do carro e Distância da Corrida */
	public CarroCorrendoThread (String nome, int distanciaTotalCorrida) {
		/* chamando o construtor de Thread passando o nome do carro como parâmetro */
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
	/** Imprime o último movimento do carro e a distância percorrida */
	public void carroImprimindoSituacao () {
		System.out.println("O " + nome +  " andou " + metro + "mt \t e já percorreu " +
							distanciaCorrida + "mt");
	}
	/** Faz o carro movimentar */
	public void movimentoCarro() {
		metro = (int) (Math.random() * DISTANCIA_MAXIMA);
		distanciaCorrida += metro;
		if (distanciaCorrida > distanciaTotalCorrida) {
			distanciaCorrida = distanciaTotalCorrida;
		}
	}
	/** Representando a pausa do carro */
	public void carroParado () {
		/* Método que passa vez a outras threads */
		Thread.yield();
	}
	/** Imprime a colocação do carro ao final da corrida */
	public void colocacaoCarro () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + "º colocado!");
	}
	/** Método run da thread Corrida de carros */
	public void run () {
		while (distanciaCorrida < distanciaTotalCorrida) {
			movimentoCarro();
			carroImprimindoSituacao();
			carroParado();
		}
		colocacaoCarro();
	}
}
