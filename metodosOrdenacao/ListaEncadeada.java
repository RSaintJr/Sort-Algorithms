package metodosOrdenacao;

public class ListaEncadeada {

	private Nodo inicio;
	private int comparacao = 0; // Contador de comparações.
    private int trocas = 0; // Contador de trocas.


	// construtor
	public ListaEncadeada() {
		inicio = null;
	}

	public boolean estaVazia() {
		return inicio == null;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public void inserirOrdenada(int dado) {
		Nodo novoNodo = new Nodo(dado);
		trocas++;  // Incrementa o contador de trocas

		if (estaVazia()) {
			inicio = novoNodo;
			return;
		}
		if (dado < inicio.getDados()) {
			comparacao++;  // Incrementa o contador de comparações
			novoNodo.setProx(inicio);
			inicio = novoNodo;
			return;
		}

		Nodo atual = inicio;
		Nodo anterior = null;

		while (atual != null && dado > atual.getDados()) {
			comparacao++;  // Incrementa o contador de comparações
			anterior = atual;
			atual = atual.getProx();
		}
		novoNodo.setProx(atual);
		anterior.setProx(novoNodo);
	}

	public int getComparacao() {
		return comparacao;
	}

	public int getTrocas() {
		return trocas;
	}
	
	
	
	
	
}
