package trabalho;

import java.util.ArrayList;

public class Vertice {

	private String nome;
	
	ArrayList<Vertice> adjacentes = new ArrayList<Vertice>();
	
	public Vertice (String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
