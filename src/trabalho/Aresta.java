package trabalho;

public class Aresta {

	private Vertice verticeOrigem;

	private Vertice verticeDestino;
	
	private int valor;
	
	
	public Aresta(Vertice verticeOrigem, Vertice verticeDestino, int valor) {
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.valor = valor;
	}
	
	

	public Vertice getVertice1() {
		return verticeOrigem;
	}

	public void setVertice1(Vertice vertice1) {
		this.verticeOrigem = vertice1;
	}

	public Vertice getVertice2() {
		return verticeDestino;
	}

	public void setVertice2(Vertice vertice2) {
		this.verticeDestino = vertice2;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
