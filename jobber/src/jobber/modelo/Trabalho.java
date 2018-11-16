package jobber.modelo;

public class Trabalho {

    private String nome;
    private String descricao;
    private int qntDeFeedback;
    private int somoaNotaDeFeedback;
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

    public int getSomoaNotaDeFeedback() {
        return somoaNotaDeFeedback;
    }

    public void setSomoaNotaDeFeedback(int somoaNotaDeFeedback) {
        this.somoaNotaDeFeedback = somoaNotaDeFeedback;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }


}
