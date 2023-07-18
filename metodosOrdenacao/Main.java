package metodosOrdenacao;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Tamanhos de entrada a serem testados

		int[] tamanhosEntrada = { 100000, 1000000 };

		// Executa algoritmo para cada tamanho de entrada
		for (int tamanho : tamanhosEntrada) {
//			int[] entrada = gerarEntrada_aleatoria(tamanho);
//			int[] entrada = gerarEntrada_ordenada(tamanho);
			int[] entrada = gerarEntrada_inverso(tamanho);
			
			// Marca o tempo de início
			long inicio = System.nanoTime();

			// Chama o algoritmo a ser testado
			meuAlgoritmo(entrada);

			// Marca o tempo de fim
			long fim = System.nanoTime();

			// Calcula o tempo de execução em milissegundos
			double tempoExecucao = Math.round((fim - inicio) / 1000000.0);

			System.out.println("Tempo de execucao para tamanho " + tamanho + ": " + tempoExecucao + "ms");
		}

	}

	public static void meuAlgoritmo(int[] arr) {
		MetodosOrdenacao ordenar = new MetodosOrdenacao();
		
		ordenar.blockSort(arr,500);
	}

	// Gera uma entrada aleatória para testes
	public static int[] gerarEntrada_aleatoria(int tamanho) {
	    int[] arr = new int[tamanho];
	    Random random = new Random();

	    for (int i = 0; i < tamanho; i++) {
	        arr[i] = random.nextInt(Integer.MAX_VALUE);
	    }

	    return arr;
	}

	
	// Gera uma entrada ordenada para testes.
	public static int[] gerarEntrada_ordenada(int tamanho) {
		int[] arr = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			arr[i] = i; 
		}
		return arr;
	}
	
	// Gera uma entrada inversa para testes.
	public static int[] gerarEntrada_inverso(int tamanho) {
	    int[] arr = new int[tamanho];
	    for (int i = 0; i < tamanho; i++) {
	        arr[tamanho - 1 - i] = i;
	    }
	    return arr;
	}

}
