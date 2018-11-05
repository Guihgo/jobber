/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber;

import jobber.gui.Frm_Login;




/**
 *
 * @author rfutenma
 */

public class Main {
    public static void main(String args[]) {
        System.out.println("Estamos rodando !!!");
        Frm_Login l = new Frm_Login();
        l.setLocationRelativeTo(null);
        l.setVisible(true);
    }
}
