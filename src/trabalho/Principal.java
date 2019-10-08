package trabalho;

import trabalho.Vertice;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	
	/*
	====================================
	|		   UNISUL - Grafos	       |
	|			 Trabalho 2		       |
	|								   |
	|	    Algoritmo feito por		   |
	|		  Lucas de Abreu,		   |
	|		 Gustavo Zancheta &		   |
	|	     Julia Luiz Cardoso		   |
	====================================
	*/
	public static void main(String[] args) {
		boolean orientado = false;
		boolean valorado = false;
		
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		ArrayList<Aresta> arestas = new ArrayList<Aresta>();

		int i = 0;
		do {
			i = Integer.parseInt(JOptionPane.showInputDialog("O grafo é orientado?\n 1 - Sim\n 2 - Nao"));
			if (i == 1) {
				orientado = true;
			} else if (i == 2) {
				orientado = false;
			}
		} while (i < 1 || i > 2);
		
		i = 0;
		do {
			i = Integer.parseInt(JOptionPane.showInputDialog("O grafo é valorado?\n 1 - Sim\n 2 - Nao"));
			if (i == 1) {
				valorado = true;
			} else if (i == 2) {
				valorado = false;
			}
		} while (i < 1 || i > 2);
		
		i = 0;
		
		String menu ="~ Grafos - Trabalho II~\n\n"
				+ "Selecione uma opção:\n"
				+ "1 - Adicionar Vértice\n"
				+ "2 - Adicionar Aresta\n"
				+ "3 - Listar Vértices\n"
				+ "4 - Lista de Arestas\n"
				+ "5 - Lista de Adjacencia\n"
				+ "6 - Matriz de Adjacencia\n"
				+ "7 - Matriz de Incidencia\n"
				+ "8 - Algoritmo de Dijkstra\n\n"
				+ "0 - Sair";	
		
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			if (op == 1) {
				// Adicionar Vértices
				String nome;
				nome = JOptionPane.showInputDialog("Digite o nome do vértice.");
				boolean existe = false;	
				for (Vertice v: vertices) {
					if (v.getNome().equalsIgnoreCase(nome)) {
						existe = true;
					}
				}
				if (existe) {
					JOptionPane.showMessageDialog(null, "Esse vértice já existe.");
				} else {
					Vertice novoVertice = new Vertice(nome);
					vertices.add(novoVertice);
					JOptionPane.showMessageDialog(null, "Vértice cadastrado.");
				}
			}
			
			
			if (op == 2) {
				// Adicionar Arestas
					Vertice verticeOrigem = null;
					Vertice verticeDestino = null;
					int valor = 0;
					String nomeOrigem = null, nomeDestino = null;
						nomeOrigem = JOptionPane.showInputDialog("Digite o nome do Vértice de Origem.");
						for (Vertice v : vertices) {
							if (v.getNome().equals(nomeOrigem)){
								verticeOrigem = v;
							}
						}
						if (verticeOrigem == null) {
							JOptionPane.showMessageDialog(null, "Vértice nao encontrado.");
						} else {
							nomeDestino = JOptionPane.showInputDialog("Digite o nome do Vértice de Destino.");
							for (Vertice v : vertices) {
								if (v.getNome().equals(nomeDestino)){
									verticeDestino = v;
									if (!orientado) {
										if (!arestas.isEmpty()) {
											boolean existe = false;
											for (Aresta a : arestas) {
												if ((a.getVertice2().getNome().equals(verticeOrigem.getNome()) && a.getVertice1().getNome().equals(verticeDestino.getNome())
														|| a.getVertice2().getNome().equals(verticeDestino.getNome()) &&  a.getVertice1().getNome().equals(verticeOrigem.getNome()))) {
													existe = true;
												}
											}
											boolean laco = false;
											if (verticeDestino.getNome().equals(verticeOrigem.getNome())) {
												laco = true;
											}
											
											if (!laco){
												if (existe) {
													JOptionPane.showMessageDialog(null, "Essa aresta já existe.");
												} else {
													if (valorado) {
														valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da aresta."));
														Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
														arestas.add(novaAresta);
														JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
														if (verticeDestino.equals(verticeOrigem)) {
															for (Vertice adj : vertices) {
																if (adj.equals(verticeOrigem)) {
																	adj.adjacentes.add(verticeDestino);
																}
															}
														} else {
															for (Vertice adj : vertices) {
																if (adj.equals(verticeOrigem)) {
																	adj.adjacentes.add(verticeDestino);
																}
															}
															for (Vertice adj : vertices) {
																if (adj.equals(verticeDestino)) {
																	adj.adjacentes.add(verticeOrigem);
																}
															}
														}
													} else {
														Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
														arestas.add(novaAresta);
														JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
														if (verticeDestino.equals(verticeOrigem)) {
															for (Vertice adj : vertices) {
																if (adj.equals(verticeOrigem)) {
																	adj.adjacentes.add(verticeDestino);
																}
															}
														} else {
															for (Vertice adj : vertices) {
																if (adj.equals(verticeOrigem)) {
																	adj.adjacentes.add(verticeDestino);
																}
															}
															for (Vertice adj : vertices) {
																if (adj.equals(verticeDestino)) {
																	adj.adjacentes.add(verticeOrigem);
																}
															}
														}
													} 
												}
											} else {
												JOptionPane.showMessageDialog(null, "Laço nao é possivel.");
											}
										} else {
											if (valorado) {
												valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da aresta."));
												Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
												arestas.add(novaAresta);
												JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
												if (verticeDestino.equals(verticeOrigem)) {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
												} else {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
													for (Vertice adj : vertices) {
														if (adj.equals(verticeDestino)) {
															adj.adjacentes.add(verticeOrigem);
														}
													}
												}
											} else {
												Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
												arestas.add(novaAresta);
												JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
												if (verticeDestino.equals(verticeOrigem)) {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
												} else {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
													for (Vertice adj : vertices) {
														if (adj.equals(verticeDestino)) {
															adj.adjacentes.add(verticeOrigem);
														}
													}
												}
											}
										}
									}
									if (orientado) {
										if (!arestas.isEmpty()) {
											boolean existe = false;
											for (Aresta a : arestas) {
												if (a.getVertice1().getNome().equals(verticeOrigem.getNome()) &&  a.getVertice2().getNome().equals(verticeDestino.getNome())) {
													existe = true;
												}
											}	
											if (existe) {
												JOptionPane.showMessageDialog(null, "Essa aresta já existe.");
											} else {
												if (valorado) {
													valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da aresta."));
													Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
													arestas.add(novaAresta);
													JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
													if (verticeDestino.equals(verticeOrigem)) {
														for (Vertice adj : vertices) {
															if (adj.equals(verticeOrigem)) {
																adj.adjacentes.add(verticeDestino);
															}
														}
													} else {
														for (Vertice adj : vertices) {
															if (adj.equals(verticeOrigem)) {
																adj.adjacentes.add(verticeDestino);
															}
														}
													}
												} else {
													Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
													arestas.add(novaAresta);
													JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
													if (verticeDestino.equals(verticeOrigem)) {
														for (Vertice adj : vertices) {
															if (adj.equals(verticeOrigem)) {
																adj.adjacentes.add(verticeDestino);
															}
														}
													} else {
														for (Vertice adj : vertices) {
															if (adj.equals(verticeOrigem)) {
																adj.adjacentes.add(verticeDestino);
															}
														}
													}
												}
											}
										} else {
											if (valorado) {
												valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da aresta."));
												Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
												arestas.add(novaAresta);
												JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
												if (verticeDestino.equals(verticeOrigem)) {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
												} else {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
												}
											} else {
												Aresta novaAresta = new Aresta(verticeOrigem, verticeDestino, valor);
												arestas.add(novaAresta);
												JOptionPane.showMessageDialog(null, "Aresta Cadastrada.");
												if (verticeDestino.equals(verticeOrigem)) {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
												} else {
													for (Vertice adj : vertices) {
														if (adj.equals(verticeOrigem)) {
															adj.adjacentes.add(verticeDestino);
														}
													}
												}
											}
										}	
									}
									
								}
							}
						}
			}
			
			
			if (op == 3) {
				// -- Lista de Vértices --
				
				String[] listaVertices = new String[vertices.size()];
				
				// Preenche lista de arestas.
				int cont = 0;
				for (Vertice v : vertices) {
					listaVertices[cont] = "[" + v.getNome() + "]";
					cont++;
				}
				
				// Imprime Lista de Arestas
				String result = "[";
				for (int loop = 0; loop < listaVertices.length; loop ++) {
					result += listaVertices[loop];
				}
				result += "]";
				JOptionPane.showMessageDialog(null, "-- Lista de Vértices --\n\n" + result);
			}
			
			
			if (op == 4) {
				// -- Lista de Arestas --
				
				String[] listaArestas = new String[arestas.size()];
				
				String resultadoArestas = "";
				
				
				// Preenche lista de arestas.
				int cont = 0;
				for (Aresta a : arestas) {
					resultadoArestas = "[" + a.getVertice1().getNome() + "," + a.getVertice2().getNome();
					if (valorado) {
						resultadoArestas += "," + a.getValor();
					}
					resultadoArestas += "]";
					listaArestas[cont] = resultadoArestas;
					cont++;
				}
				
				// Imprime Lista de Arestas
				String result = "[";
				for (int loop = 0; loop < listaArestas.length; loop ++) {
					result += listaArestas[loop];
				}
				result += "]";
				JOptionPane.showMessageDialog(null, "-- Lista de Arestas --\n\n" + result);
			}
			
			if (op == 5) {
				// -- Lista de Adjacencia --
				
				String listaDeAdjacencia = "-- Lista de Adjacencia -- \n\n"; 
				listaDeAdjacencia += "[";
				for (Vertice v : vertices) {
					listaDeAdjacencia += "[";
					for (Vertice adj : v.adjacentes) {
						listaDeAdjacencia += adj.getNome() + ",";
					}
					if (listaDeAdjacencia.substring(listaDeAdjacencia.length()-2, listaDeAdjacencia.length()).contains(",")){
						listaDeAdjacencia = listaDeAdjacencia.substring(0, listaDeAdjacencia.length()-1);
					}
					listaDeAdjacencia += "]";
				}
				if (orientado) {
				} else {
					listaDeAdjacencia += "]";
				}
				
				JOptionPane.showMessageDialog(null, listaDeAdjacencia);				
			}
			
			if (op == 6) {
				// -- Matriz de Adjacencia --
				
				String resultadoAdjacencia = " -- Matriz de Adjacencia -- \n\n"; 
				
				// Preenche os campos de cabecalho.
				String[][] matriz = new String[vertices.size()+1][vertices.size()+1];
				int a = 0, b = 1;
				matriz[0][0] = " "; 
				for (Vertice v : vertices) {
					matriz[a][b] = v.getNome();
					b ++;
				}
				
				a = 1;
				b = 0;
				for (Vertice v : vertices) {
					matriz[a][b] = v.getNome();
					a ++;
				}
				
				// Verifica a Matriz por Adjacencias.
				if (orientado) {
					for (int linha = 0; linha < vertices.size() + 1; linha ++) {
						for (int coluna = 0; coluna < vertices.size() + 1; coluna ++) {
							if (linha == 0 || coluna == 0) {
								
							} else {
								Vertice v = vertices.get(linha - 1);
								int novoValor = 0;	
								for (Vertice adj : v.adjacentes) {
									
									if (adj.getNome().equals(vertices.get(coluna - 1).getNome())) {
										if (valorado) {	
											for (Aresta valor : arestas) {
												if (v.getNome().equals(valor.getVertice1().getNome()) && adj.getNome().equals(valor.getVertice2().getNome())) {
													matriz[linha][coluna] = ""  + valor.getValor();
												}
											}			
										} else {
											novoValor += 1;
									 		matriz[linha][coluna] = "" + novoValor;
										}
									
									}
								}
							}
						}
					}
				} else {
					for (int linha = 0; linha < vertices.size() + 1; linha ++) {
						for (int coluna = 0; coluna < vertices.size() + 1; coluna ++) {
							if (linha == 0 || coluna == 0) {
								
							} else {
								Vertice v = vertices.get(linha - 1);
								for (Vertice adj : v.adjacentes) {
									if (adj.getNome().equals(vertices.get(coluna - 1).getNome())) {
										if (valorado){
											for (Aresta valor : arestas) {
												if (v.getNome().equals(valor.getVertice1().getNome()) && adj.getNome().equals(valor.getVertice2().getNome())
														|| v.getNome().equals(valor.getVertice2().getNome()) && adj.getNome().equals(valor.getVertice1().getNome())) {
													matriz[linha][coluna] = ""  + valor.getValor();
													matriz[coluna][linha] = ""  + valor.getValor();
												}
											}
										} else {
											matriz[linha][coluna] = "1";
											matriz[coluna][linha] = "1";
										}
									}
								}
							}
						}
					}
				}
				
				// Preenche matriz com zeros.
				for (int linha = 0; linha < vertices.size() + 1; linha ++) {
					for (int coluna = 0; coluna < vertices.size() + 1; coluna ++) {
						if (matriz[linha][coluna] == null) {
							if (linha == 0 && coluna == 0) {	
							} else {
								matriz[linha][coluna] = "0";
							}
						}
					}
				}
				
				// Lista a matriz de adjacencia.
				for (int linha = 0; linha < vertices.size() + 1; linha ++) {
					for (int coluna = 0; coluna < vertices.size() + 1; coluna ++) {
						resultadoAdjacencia += matriz[linha][coluna] + "\t";
					}
					resultadoAdjacencia += "\n";
				}
				
				System.out.println(resultadoAdjacencia + "\nO Resutlado está saindo na console pois o JOptionPane não salvou identação.");
			}
			
			
			if (op == 7) {
				// -- Matriz de Incidencia --
				
				String resultadoIncidencia = "\n\n -- Matriz de Incidencia -- \n\n"; 
				
				// Preenche os campos de cabecalho.
				String[][] matrizIncidencia = new String[vertices.size()+1][arestas.size()+1];
				int linhaIncidencia = 0, colunaIncidencia = 1;
				matrizIncidencia[0][0] = " "; 
				do {
					matrizIncidencia[linhaIncidencia][colunaIncidencia] = "E" + colunaIncidencia;
					colunaIncidencia ++;
				} while (colunaIncidencia <= arestas.size());
				
				linhaIncidencia = 1;
				colunaIncidencia = 0;
				for (Vertice v : vertices) {
					matrizIncidencia[linhaIncidencia][colunaIncidencia] = v.getNome();
					linhaIncidencia ++;
				}

				// Preenche a matriz com zeros.
				for (int linha = 0; linha < vertices.size() + 1; linha ++) {
					for (int coluna = 0; coluna < arestas.size() + 1; coluna ++) {
						if (matrizIncidencia[linha][coluna] == null) {
							if (linha == 0 && coluna == 0) {	
							} else {
								matrizIncidencia[linha][coluna] = "0";
							}
						}
					}
				}
				
				// Preenche Matriz.
				if (orientado) {
					for (int linha = 0; linha < vertices.size() + 1; linha ++) {
						for (int coluna = 0; coluna < arestas.size() + 1; coluna ++) {	
							if (linha == 0 || coluna == 0) {
								
							} else {
								Vertice v = vertices.get(linha - 1);
								
								if (arestas.get(coluna - 1).getVertice2().getNome().equals(v.getNome())) {
									matrizIncidencia[linha][coluna] = "-1";
									if (valorado) {
										matrizIncidencia[linha][coluna] = "-" + arestas.get(coluna-1).getValor();
									}
								}
								
								if (arestas.get(coluna - 1).getVertice1().getNome().equals(v.getNome())) {
									matrizIncidencia[linha][coluna] = "1";
									if (valorado) {
										matrizIncidencia[linha][coluna] = "" + arestas.get(coluna-1).getValor();
									}
								}
							}
						}	
					}
				} else {
					for (int linha = 0; linha < vertices.size() + 1; linha ++) {
						for (int coluna = 0; coluna < arestas.size() + 1; coluna ++) {			
							if (linha == 0 || coluna == 0) {
								
							} else {
								Vertice v = vertices.get(linha - 1);
								if (arestas.get(coluna - 1).getVertice1().getNome().equals(v.getNome()) || arestas.get(coluna - 1).getVertice2().getNome().equals(v.getNome())) {
								matrizIncidencia[linha][coluna] = "1";
								matrizIncidencia[linha][coluna] = "" + arestas.get(coluna-1).getValor();
								}
							}
						}
					}
				}
				
				// Lista a matriz de incidencia.
				for (int linha = 0; linha < vertices.size() + 1; linha ++) {
					for (int coluna = 0; coluna < arestas.size() + 1; coluna ++) {
						resultadoIncidencia += matrizIncidencia[linha][coluna] + "\t";
					}
					resultadoIncidencia += "\n";
				}
			
				System.out.println(resultadoIncidencia + "\nO Resutlado está saindo na console pois o JOptionPane não salvou identação.");	
			}
			
			
			// TRABALHO II - DIJKSTRA
			if (op == 8) {
				
				Integer[] dist = new Integer[vertices.size()];
				String[] anterior = new String[vertices.size()];
				boolean[] perm = new boolean[vertices.size()];
				
				
				String[] listaVertices = new String[vertices.size()];
				
				int cont = 0;
				for (Vertice v : vertices) {
					listaVertices[cont] = "[" + v.getNome() + "]";
					cont++;
				}
				
				String result = "[";
				for (int contador = 0; contador < listaVertices.length; contador ++) {
					result += listaVertices[contador];
				}
				result += "]";
				
				String selecao = JOptionPane.showInputDialog("Selecione o Vértice de Origem: (Digite apenas o nome do vértice)\n\n" + result);
				int s = 0;
				
				int loop = 0;
				for (Vertice v: vertices) {
					dist[loop] = 99999999;
					anterior[loop] = null;
					perm[loop] = false;
					if (selecao.equalsIgnoreCase(v.getNome())) {
						s = loop;
					}
					loop ++;
				}
				
				dist[s] = 0;

				boolean aindaTem = true;
				int origem = s;
				
				while (aindaTem) {
					Vertice u = vertices.get(origem);
					
					for (Vertice v : u.adjacentes) {
						int peso = 0;
						int destino = 0;
						
						for (Vertice d : vertices) {
							if (d.getNome().equalsIgnoreCase(v.getNome())) {
								destino = peso;
							}
							peso ++;
						}		
						
						peso = 0;
						if (perm[destino] == false) {
							for (Aresta a : arestas) {
								if ((a.getVertice1().getNome().equalsIgnoreCase(u.getNome()) && a.getVertice2().getNome().equalsIgnoreCase(v.getNome())) ||
										(a.getVertice1().getNome().equalsIgnoreCase(v.getNome()) && a.getVertice2().getNome().equalsIgnoreCase(u.getNome()))) {
									peso = a.getValor();
								}
							}
							int alt = dist[origem] + peso;
							if (alt < dist[destino]) {
								dist[destino] = alt;
								anterior[destino] = u.getNome();
							}
						}
					}
					
					int menorDist = 999999999;
					for (int d = 0; d < vertices.size(); d++) {
						if (dist[d] < menorDist && perm[d]==false) {
							menorDist = dist[d];
							origem = d;
						}
					}
					perm[origem] = true;
					
					aindaTem = false;
					for (int a = 0; a < perm.length; a++) {
						if (perm[a] == false) {
							aindaTem = true;
						}
					}
				}
				System.out.println("-- Algoritmo de Dijkstra --\n\nVértice\tPerm\tDist\tPath");
				for (int a = 0; a < vertices.size(); a ++) {
					System.out.println(vertices.get(a).getNome() + "\t" + perm[a] + "\t" + dist[a] + "\t" + anterior[a]);
				}
			}
		} while (op != 0);
		
	
		
	}

}