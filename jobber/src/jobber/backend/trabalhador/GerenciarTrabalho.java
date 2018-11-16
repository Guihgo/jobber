package jobber.backend.trabalhador;

import jobber.backend.Conexao;

public class GerenciarTrabalho extends Conexao{

    private Conexao conexao;

    public GerenciarTrabalho(Conexao conexao) {
        this.conexao = conexao;
    }

}
