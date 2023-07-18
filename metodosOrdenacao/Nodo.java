package metodosOrdenacao;

public class Nodo {

	private int dados;
	private Nodo prox;

	public Nodo(int dados) {
		this.dados = dados;
		this.prox = null;
	}

	public int getDados() {
		return dados;
	}

	public void setDados(int dados) {
		this.dados = dados;
	}

	public Nodo getProx() {
		return prox;
	}

	public void setProx(Nodo prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nodo [dados=");
		builder.append(dados);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}

}
