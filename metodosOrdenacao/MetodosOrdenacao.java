package metodosOrdenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MetodosOrdenacao {
	
	private int comparacao = 0; // Contador de comparações.
    private int trocas = 0; // Contador de trocas.

	public void bubbleSort(int array[]) {
		int temp = 0;
		for(int i=0;i<array.length;i++){
			for (int j=0;j<array.length-i-1;j++){
				// Comparações
				comparacao++;
				if (array[j] > array[j+1]){
					// Trocas
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					trocas++;
				}
			}
		}
	}

	public void selectionSort(int array[]) {
		int minIndex, aux;
		for (int i = 0; i < array.length-1; i++) {
			minIndex = i;
			for (int j = i+1; j < array.length; j++) {
				// Comparações
				comparacao++;
				if (array[j]<array[minIndex]){
					minIndex = j;
				}
			}
			// trocas
			aux = array[i];
			array[i] = array[minIndex];
			array[minIndex] = aux;
			trocas++;
		}
	}

	
	public void insertionSort(int vetor[]){
		int pivo;
		int j;
		for (int i = 0; i < vetor.length; i++) {
			pivo = vetor[i];
			j = i-1;
			while (j>=0){
				// Comparações
				comparacao++;
				if(vetor[j] > pivo){
					// Trocas
					vetor[j+1] = vetor[j];
					j--;
					trocas++;
				} else {
					break;
				}
			}
			vetor[j+1] = pivo;
		}
	}

	
	public void cocktailSort(int[] array) {
        boolean swapped;
        int start = 0;
        int end = array.length - 1;

        do {
            swapped = false;

            // Passo da esquerda para a direita, similar ao Bubble Sort
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            // Passo da direita para a esquerda, inverso do Bubble Sort
            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            start++;
        } while (swapped);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
	//Métodos recursivos
	
	//Merge sort
    public void mergeSort(int array[]) {
        int n = array.length;
        int tamanhoSublista = 1;
        
        while (tamanhoSublista < n) {
            int inicio = 0;
            
            while (inicio < n - tamanhoSublista) {
                int meio = inicio + tamanhoSublista - 1;
                int fim = Math.min(inicio + 2 * tamanhoSublista - 1, n - 1);
                
                merge(array, inicio, meio, fim);
                
                inicio += 2 * tamanhoSublista;
            }
            
            tamanhoSublista *= 2;
        }
    }


    private void merge(int array[], int inicio, int meio, int fim) {
        int aux[] = new int[array.length];
        for (int i = inicio; i <= meio; i++) {
            aux[i] = array[i];
        }
        for (int j = meio + 1; j <= fim; j++) {
            aux[fim + meio + 1 - j] = array[j];
        }
        int i = inicio;
        int j = fim;
        for (int k = inicio; k <= fim; k++) {
            comparacao++; // A comparação é feita aqui.
            if (aux[i] <= aux[j]) {
                trocas++; // A troca é feita aqui.
                array[k] = aux[i];
                i = i + 1;
            } else {
                trocas++; // A troca é feita aqui.
                array[k] = aux[j];
                j = j - 1;
            }
        }
    }


	
	//Quick sort
    public void quickSort(int X[], int inicio, int fim) {
        int q;
        if (inicio < fim) {
            q = particao(X, inicio, fim);
            quickSort(X, inicio, q - 1);
            quickSort(X, q + 1, fim);
        }
    }

    private int particao(int X[], int inicio, int fim) {
        int pivo, i, j, aux;
        pivo = X[(inicio + fim) / 2];
        i = inicio - 1;
        j = fim + 1;
        while (i < j) {
            do {
                j = j - 1;
                comparacao++; // A comparação é feita aqui.
            } while (X[j] > pivo);
            do {
                i = i + 1;
                comparacao++; // A comparação é feita aqui.
            } while (X[i] < pivo);

            if (i < j) {
                aux = X[i];
                X[i] = X[j];
                X[j] = aux;
                trocas++; // A troca é feita aqui.
            }
        }
        return j;
    }
	

    public  void bucketSort(int[] array) {
        int numBuckets = 50000; // Número de baldes

        // Crie os baldes
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // Coloque os elementos nos baldes
        for (int i = 0; i < array.length; i++) {
            int indiceBucket = array[i] / numBuckets;
            buckets[indiceBucket].add(array[i]);
            trocas++; // Incrementa o contador de trocas
        }

        // Ordene cada balde individualmente
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets[i]);
            trocas += buckets[i].size() - 1; // Incrementa o contador de trocas
            comparacao += buckets[i].size() - 1; // Incrementa o contador de comparações
        }

        // Coloque os elementos ordenados de volta no array
        int indiceArray = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[indiceArray] = buckets[i].get(j);
                indiceArray++;
                trocas++; // Incrementa o contador de trocas
            }
        }
    }
    
    public void blockSort(int[] array, int blockSize) {
        int numBlocks = (int) Math.ceil((double) array.length / blockSize);

        // Ordena cada bloco individualmente
        for (int i = 0; i < numBlocks; i++) {
            int start = i * blockSize;
            int end = Math.min(start + blockSize, array.length);
            Arrays.sort(array, start, end);
            comparacao += (end - start - 1); // Incrementa o contador de comparações
            trocas += (end - start - 1); // Incrementa o contador de trocas
        }

        // Junta os blocos ordenados
        for (int i = 1; i < numBlocks; i++) {
            int pivot = array[i * blockSize];
            int j = i;
            while (j > 0 && array[(j - 1) * blockSize] > pivot) {
                System.arraycopy(array, (j - 1) * blockSize, array, j * blockSize, blockSize);
                j--;
                comparacao++; // Incrementa o contador de comparações
                trocas++; // Incrementa o contador de trocas
            }
            array[j * blockSize] = pivot;
        }

    }



    
	public void setContador() {
		this.comparacao = 0;
		this.trocas = 0;
	}
	
    public void mostrarContadores() {
    	if(comparacao < 0) {
    		this.comparacao = comparacao * -1;
    	}
        System.out.println("Comparações: " + comparacao);
        if(trocas < 0) {
        	this.trocas = trocas * -1;
        }
        System.out.println("Trocas: " + trocas);
    }
	
}