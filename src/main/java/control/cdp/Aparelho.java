/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.cdp;

import control.observ.ControleRemoto;
import control.state.AparelhoState;
import control.state.Desligado;
import control.state.Ligado;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 20121bsi0040
 */
public class Aparelho extends Observable{
    List<ControleRemoto> controles;
    AparelhoState meuEstado;
    
    private  void liga(){
        this.meuEstado = new Ligado();
    }
    
    private void desliga(){
        this.meuEstado = new Desligado();
    }
    
    public void setNovoEstado(){
        if (meuEstado instanceof Desligado){
            this.liga();
        }
        else{
            this.desliga();
        }
        setChanged();
        this.notifyObservers();
    }
    
    public void registerObserver(ControleRemoto observer) { 
        this.controles.add(observer);
    } 
    
    public void removeObserver(ControleRemoto observer) { 
        this.controles.remove(observer);
    } 
    
    @Override
    public void notifyObservers(){
        // Chama o método de atualização de todos os observers disponíveis. 
        for (Observer ob : this.controles) { 
            System.out.println("Notificando observers!"); 
            ob.update(this, this.controles);
        } 
    }
    
    
    
}
