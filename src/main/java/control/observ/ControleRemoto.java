/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.observ;

import control.cdp.Aparelho;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 20121bsi0040
 */
public class ControleRemoto implements Observer{

    @Override
    public void update(Observable controle, Object arg) {
        if(controle instanceof Aparelho){
            Aparelho arCond = (Aparelho) ar;
            
            if(nTemp > 25 ){
                int dif = nTemp - 25;
                System.out.println("Temperatura aumentou" + dif + "graus");
            }
            else if (nTemp < 25){
                int dif = 25 - nTemp;
                System.out.println("Temperatura diminuiu" + dif + "graus");
            }
        }
        
        else{
            throw new UnsupportedOperationException
                      ("Indicação de quantidade não suportada, "
                              + "sete a cada entrada (1*novaTemperatura) "
                              + "ou saída(-1*novaTemperatura)");
        }
    }
    
}
