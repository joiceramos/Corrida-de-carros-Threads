
public class CarroCorrendoThread extends Thread {

	String nome;					// nome do carro
	int distanciaCorrida = 0;		// dist�ncia total j� corrida pelo carro
	int distanciaTotalCorrida;	// dist�ncia a ser corrida pelo carro
	int metro = 0;					// distancia percorrida pelo carro em mt
	static int colocacao = 0;		// coloca��o do carro ao final da corrida
	final static int DISTANCIA_MAXIMA = 100; // movimento m�ximo em mt que um carro pode andar

	/** Construtor da classe. Par�mtros : Nome do carro e Dist�ncia da Corrida */
	public CarroCorrendoThread (String nome, int distanciaTotalCorrida) {
		/* chamando o construtor de Thread passando o nome do carro como par�metro */
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
	/** Imprime o �ltimo movimento do carro e a dist�ncia percorrida */
	public void carroImprimindoSituacao () {
		System.out.println("O " + nome +  " andou " + metro + "mt \t e j� percorreu " +
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
		/* M�todo que passa vez a outras threads */
		Thread.yield();
	}
	/** Imprime a coloca��o do carro ao final da corrida */
	public void colocacaoCarro () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + "� colocado!");
	}
	/** M�todo run da thread Corrida de carros */
	public void run () {
		while (distanciaCorrida < distanciaTotalCorrida) {
			movimentoCarro();
			carroImprimindoSituacao();
			carroParado();
		}
		colocacaoCarro();
	}
}
