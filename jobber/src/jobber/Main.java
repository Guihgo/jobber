/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber;

import jobber.backend.Conexao;
import jobber.gui.Frm_Login;

/**
 * teste
 * omneiasdiasjdi
 * @author rfutenma
 */

public class Main {
    public static void main(String args[]) {
        System.out.println("Estamos rodando !");
        Conexao conexao = new Conexao();

        if(conexao.carregaDriver()) {
            System.out.println("Driver carregado");
            if(conexao.conecta()) {
                Frm_Login l = new Frm_Login(conexao);
            }
        }
    }
}
