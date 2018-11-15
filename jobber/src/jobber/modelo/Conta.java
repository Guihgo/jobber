package jobber.modelo;

public class Conta {

	private boolean logado = false;
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

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean getLogado() {
		return this.logado;
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
