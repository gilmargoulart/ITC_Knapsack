package classes;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
	
	private String nome;
	private int capacidade;
	private int peso;
	private int lucro;
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
	public int getPeso() {
		return peso;
	}
	//
	public int getLucro() {
		return lucro;
	}

	//
	public void addItem(Item item) throws Exception {
		if (item.getPeso()+getPeso() > getCapacidade()) {
			throw new Exception("Capacidade excedida.");
		} else {
			itens.add(item);
			lucro += item.getLucro();
			peso += item.getPeso();
		}
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		for (Item it : itens) {
			try {
				addItem(it);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean hasItem(Item i) {
		return getItens().indexOf(i) >= 0;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(getNome() + " (Cap: " + getCapacidade() + ", Peso: " + getPeso() + ")\n"); 
		for (Item item : itens) {
			sb.append("  " + item.toString() + "\n");
		}
		return sb.toString();
	}
}
