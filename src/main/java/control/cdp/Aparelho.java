/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.cdp;

import control.util.observ.ControleRemoto;
import control.util.state.AparelhoState;
import control.util.state.Desligado;
import control.util.state.Queimado;
import java.util.ArrayList;
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
    private int muda;
    public boolean estado;
        
    public Aparelho(int quantMudanças){
        this.controles = new ArrayList();
        this.muda = quantMudanças;
        if(this.muda <= 0){
            this.meuEstado = new Queimado(this);
        }
        //setando estado padrao como desligado
        else{
            this.meuEstado = new Desligado(this);
        }
        this.estado = false;
    }
    
    public AparelhoState getMeuEstado(){
        return this.meuEstado;
    }
    
    public int getMudanca(){
        return this.muda;
    }
    
    public  void setNovoEstado(AparelhoState estado){
        if (this.muda <= 0){
            this.meuEstado = new Queimado(this);
        }
        else{
            this.meuEstado = estado;
        }
        this.muda -=1;
    }
    
    public void solicitaTrocarEstado(){
        setChanged();
        this.notifyObservers();
        System.out.println(this.meuEstado);
        this.meuEstado.solicitaTrocarEstado();
        
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
