package jobber.modelo;

import jobber.modelo.Mensagem;

public class Processo {

	private int status;
	private Mensagem msg[];
	private int id;
	private int idTrab;
	
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return this.status;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public void setIdTrab(int idTrab) {
		this.idTrab = idTrab;
	}
	public int getidTrab() {
		return this.idTrab;
	}
	
	//fazer construtor mensagem
	
}
