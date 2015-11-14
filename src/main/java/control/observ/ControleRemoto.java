/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.observ;

import control.cdp.Aparelho;
import control.state.AparelhoState;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 20121bsi0040
 */
public class ControleRemoto implements Observer{
    boolean estado;
    
    public ControleRemoto(){
        this.estado = false;
    }
    
    @Override
    public void update(Observable aparelho, Object arg) {
        if(aparelho instanceof Aparelho){
            Aparelho ap = (Aparelho) aparelho;
            if (estado){
                System.out.println("Está Ligado");
                this.estado = false;
            }
            else{
                System.out.println("Está Desligado");
                this.estado = true;
            }
        }
        else{
            throw new UnsupportedOperationException("Aparelho não suportado");
        }
    }
    
}
