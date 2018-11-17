package jobber.modelo;

public class Feedback {
    private int id;
    private float nota;
    private String comentario;
    private int conta_id;
    private int trabalho_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getConta_id() {
        return conta_id;
    }

    public void setConta_id(int conta_id) {
        this.conta_id = conta_id;
    }

    public int getTrabalho_id() {
        return trabalho_id;
    }

    public void setTrabalho_id(int trabalho_id) {
        this.trabalho_id = trabalho_id;
    }


}
