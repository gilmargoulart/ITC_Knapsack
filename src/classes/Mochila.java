package classes;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
	
	private String nome;
	private int capacidade;
	private List<Item> itens = new ArrayList<>();
	
	public Mochila(String nome, int capacidade) {
		setNome(nome);
		setCapacidade(capacidade);
	}
	
	public Mochila(String nome, int capacidade, List<Item> itens) {
		setNome(nome);
		setCapacidade(capacidade);
		setItens(itens);
	}
	//
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	//
	public void addItem(Item item){
		itens.add(item);
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(getNome() + " (" + getCapacidade() + ")\n"); 
		for (Item item : itens) {
			sb.append("  " + item.toString() + "\n");
		}
		return sb.toString();
	}
}
