package jobber.modelo;

public class Conta {

	private String nome;
	private String email;
	private String senha;
	private int id;
	private int tipo;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return this.senha;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}

	public void setTipo(int tipo) { this.tipo = tipo; }
	public int getTipo() { return this.tipo; }
}
