package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import classes.Item;
import classes.Mochila;
import utilitarios.TextReader;
import utilitarios.TextWriter;

/**
 * 
 * @author Gilmar J. A. Goulart
 * @author Jayson Costa
 * @author Sean Pablo Eschenbach
 * @category Trabalho ITC - Snapsack
 *
 */
public class MainProgram {
	
	public static String ARQUIVO_ENTRADA = "itens_capacidade.txt";
	public static String ARQUIVO_SAIDA = "itens_selecionados.txt";
	
	
	/*
	Instruções:
		Desenvolva uma estratégia gulosa para resolver o problema da mochila binária.
		O algoritmo deverá ler um arquivo de entrada e gerar um arquivo com a solução encontrada.
		O arquivo de entrada irá conter os nomes de cada item, lucro,  pesos e capacidade da mochila. Como por exemplo:
		---------------------------------------------------------------------------------------------------------
		| ARQUIVO DE ENTRADA
		---------------------------------------------------------------------------------------------------------
		Londres Paris Dublin Amsterdam Lisboa Madrid Barcelona Ibiza // Nome dos itens
		40 25 17 35 38 34 54 48                                      // Lucro
		49 35 15 43 38 37 21 37                                      // Pesos
		137                                                          // Capacidade
		
		 
		---------------------------------------------------------------------------------------------------------
		| ARQUIVO DE SAIDA
		---------------------------------------------------------------------------------------------------------
		0 1 1 0 1 1 0 1                       // 1 indica os itens selecionados
		127                                   // Soma dos lucros dos itens selecionados
		107                                   // Peso total da mochila
		 
		Crie um resumo extendido (máximo de 3 pags, formato SBC, PDF) explicando o problema da mochila, a estratégia empregada e os resultados obtidos.
		
		Apresentação dos resultados obtidos e entrega dia 28 de Novembro.
	*/
	
	
	public static void main(String[] args) {
		
		/*
		//Exibir o que veio por parâmetro.
		int i = 0;
		for (String s : args) {
			System.out.println("args[" + i + "] = " + s);
			i++;
		}
		*/
		
		String charSplit = " ";
		try {
			// Ler arquivo de texto, contendo o nome de cada item, lucro, peso e capacidade.
			String txtJson = TextReader.readTextFile(ARQUIVO_ENTRADA);
			
			// Quebra cada linha em um vetor
			String [] txtVetor = txtJson.split("\n");
			
			// Primeira linha contém o nome de cada item, separados por espaço
			String [] cabecalhos = txtVetor[0].trim().split(charSplit);
			
			// Segunda linha contém o lucro
			// TODO Ler linha do Lucro
			String [] lucros = txtVetor[1].trim().split(charSplit);
			
			// Terceira linha contém os Pesos
			// TODO Ler linha dos pesos
			String [] pesos = txtVetor[2].trim().split(charSplit);
			
			// Quarta, e última, linha contém a capacidade total
			//TODO Ler linha da capacidade total
			int capacidade = Integer.valueOf(txtVetor[3]);
			
			// Popular uma coleção com os itens
			List<Item> itensEntrada = new ArrayList<>();
			List<Item> itensOrderDesc = new ArrayList<>();
			
			// Carrega lista de itens
			for (int i = 0; i < pesos.length; i++) {
				Item item = new Item(cabecalhos[i], Integer.parseInt(lucros[i]), Integer.parseInt(pesos[i]));
				itensEntrada.add(item);
				itensOrderDesc.add(item);
			}
			
			// Ordena uma das listas de forma decrescente por Valor/Peso
			itensOrderDesc.sort(null);
			
			// Inicializa Mochila
			Mochila m = new Mochila("Snapsack ITC", capacidade);
			
			// Adiciona os itens na mochila
			System.out.println("Adicionando itens...");
			for (Item item : itensOrderDesc) {
				try {
					System.out.println(item.toString());
					m.addItem(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			itensOrderDesc = null;
			System.out.println("");
			
			// Exibir no Console os dados da Mochila
			System.out.println(m.toString());
			
			boolean isPrimeiraIteracao = true;
			StringBuilder resultado = new StringBuilder(itensEntrada.size()*2);
			// Criar texto para arquivo de saída
			for (Item item : itensEntrada) {
				System.out.println(m.hasItem(item) + ": " + item.toString());
				
				if (!isPrimeiraIteracao) {
					resultado.append(" ");
				}
				
				if (m.hasItem(item)) {
					resultado.append("1");
				} else {
					resultado.append("0");
				}
				
				if (isPrimeiraIteracao) {
					isPrimeiraIteracao = false;
				}
			}
			
			// Adicionar lucro total da Mochila ao arquivo de saída.
			resultado.append("\n");
			resultado.append(m.getLucro());
			// Adicionar peso total da Mochila ao arquivo de saída.
			resultado.append("\n");
			resultado.append(m.getPeso());
			
			System.out.println(resultado.toString());
			TextWriter.writeTextToFile(ARQUIVO_SAIDA, resultado.toString());
			
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
