package jobber.modelo;

import java.sql.Timestamp;

public class Mensagem {

	private String msg;
	private int idAutor;
        private String autor;
        private Timestamp data;

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return this.msg;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public int getIdAutor() {
		return this.idAutor;
	}

        public String getAutor() {
           return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public Timestamp getData() {
            return data;
        }

        public void setData(Timestamp data) {
            this.data = data;
        }
        
        
}
