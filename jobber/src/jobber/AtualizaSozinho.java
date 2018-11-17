/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobber;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author rfutenma
 */
public class AtualizaSozinho {    
    static long TEMPO = (1000 * 10);
    
    public static void main(String args[]){
        System.out.println("inicio");
        Timer timer = null;
		if (timer == null) {
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				public void run() {
					try {
						System.out.println("Teste agendador");
						//chamar metodo
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
		}
        
    }
}
