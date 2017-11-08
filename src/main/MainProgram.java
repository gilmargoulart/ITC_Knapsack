package main;

import java.io.FileNotFoundException;
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
	Instru��es:
		Desenvolva uma estrat�gia gulosa para resolver o problema da mochila bin�ria.
		O algoritmo dever� ler um arquivo de entrada e gerar um arquivo com a solu��o encontrada.
		O arquivo de entrada ir� conter os nomes de cada item, lucro,  pesos e capacidade da mochila. Como por exemplo:
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
		 
		Crie um resumo extendido (m�ximo de 3 pags, formato SBC, PDF) explicando o problema da mochila, a estrat�gia empregada e os resultados obtidos.
		
		Apresenta��o dos resultados obtidos e entrega dia 28 de Novembro.
	*/
	
	
	public static void main(String[] args) {
		
		/*
		//Exibir o que veio por par�metro.
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
			
			// Primeira linha cont�m o nome de cada item, separados por espa�o
			String [] cabecalhos = txtVetor[0].trim().split(charSplit);
			
			// Segunda linha cont�m o lucro
			// TODO Ler linha do Lucro
			String [] lucros = txtVetor[1].trim().split(charSplit);
			
			// Terceira linha cont�m os Pesos
			// TODO Ler linha dos pesos
			String [] pesos = txtVetor[2].trim().split(charSplit);
			
			// Quarta, e �ltima, linha cont�m a capacidade total
			//TODO Ler linha da capacidade total
			int capacidade = Integer.valueOf(txtVetor[3]);
			
			Mochila m = new Mochila("Snapsack", capacidade);
			
			for (int i = 0; i < pesos.length; i++) {
				Item item = new Item(cabecalhos[i], Integer.parseInt(lucros[i]), Integer.parseInt(pesos[i]));
				try {
					m.addItem(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(m.toString());
			

			//TextWriter.writeTextToFile(ARQUIVO_SAIDA, resultado);
			
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
