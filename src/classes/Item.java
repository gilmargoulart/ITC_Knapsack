package classes;

public class Item {
	
	private String nome;
	private int lucro;
	private int peso;
	
	public Item() {
		
	}

	public Item(String nome, int lucro, int peso){
		setNome(nome);
		setLucro(lucro);
		setPeso(peso);
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
	
	@Override
	public String toString(){
		return getNome() + ", Lucro: " + getLucro() + ", Peso: " + getPeso();
	}
}