package jobber.modelo;

import java.sql.Date;
import java.sql.Timestamp;
import jobber.modelo.Mensagem;

public class Processo1 {

	private int status;
	private Timestamp data;
        private int idConta;
	private int id;
	private int idTrab;
	
	
	
	//fazer construtor mensagem

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrab() {
        return idTrab;
    }

    public void setIdTrab(int idTrab) {
        this.idTrab = idTrab;
    }
	
}
