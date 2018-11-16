package jobber.modelo;

public class Trabalho {

    private String nome;
    private String descricao;
    private int qntDeFeedback;
    private float somaNotaDeFeedback;
    private int contaId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQntDeFeedback() {
        return qntDeFeedback;
    }

    public void setQntDeFeedback(int qntDeFeedback) {
        this.qntDeFeedback = qntDeFeedback;
    }

    public float getSomaNotaDeFeedback() {
        return somaNotaDeFeedback;
    }

    public void setSomaNotaDeFeedback(float somoaNotaDeFeedback) {
        this.somaNotaDeFeedback = somoaNotaDeFeedback;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }


}
