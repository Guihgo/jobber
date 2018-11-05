package jobber;

public class Conta {

	private String nome;
	private String email;
	private String senha;
	private int idConta;
	
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
	
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getIdConta() {
		return this.idConta;
	}
	
}
