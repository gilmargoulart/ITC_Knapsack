package classes;

public class Item implements Comparable<Item> {
	
	private String nome;
	private int lucro;
	private int peso;
	private float lucro_peso;
	
	public Item() {
		
	}

	public Item(String nome, int lucro, int peso){
		setNome(nome);
		setLucro(lucro);
		setPeso(peso);
		setLucro_Peso();
	}
	//
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//
	public int getLucro() {
		return lucro;
	}
	public void setLucro(int lucro) {
		this.lucro = lucro;
	}
	//
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public void setLucro_Peso() {
		this.lucro_peso = (float) getLucro() / (float) getPeso();
	}
	
	public float getLucro_Peso() {
		return this.lucro_peso;
	}
	
	@Override
	public String toString(){
		return getNome() + ", Lucro: " + getLucro() + ", Peso: " + getPeso() + ", Lucro/Peso: " + getLucro_Peso();
	}

	@Override
	public int compareTo(Item i) {
		// Decrescente (Invertido)
		return Float.compare(i.getLucro_Peso(), getLucro_Peso());

		// Decrescente (* -1)
		//return Float.compare(getLucro_Peso(), i.getLucro_Peso()) * -1;
		
		//Decrescente (Manual)
		/*
		if (getLucro_Peso() > i.getLucro_Peso()) {
			return -1;
		} else if (getLucro_Peso() < i.getLucro_Peso()) {
			return 1;
		}
		return 0;
		*/
	}

}