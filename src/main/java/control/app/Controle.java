/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.app;

import control.cdp.Aparelho;
import control.observ.ControleRemoto;
import control.state.AparelhoState;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20121bsi0040
 */
public class Controle {
    
    List<Aparelho> aparelhos;
    ControleRemoto controleRemotoUni;
    
    Controle(){
        this.controleRemotoUni = new ControleRemoto();
        
        this.aparelhos = new ArrayList();
        
        //criando os aparelho que vão receber o sinal
        Aparelho tv = new Aparelho(5); 
        Aparelho arCondicionado = new Aparelho(5); 
        Aparelho porta = new Aparelho(5); 
        Aparelho ventilador = new Aparelho(5); 
        
        //adicionando aprelhos criados a lista de aparelhos
        this.aparelhos.add(tv);
        this.aparelhos.add(arCondicionado);
        this.aparelhos.add(porta);
        this.aparelhos.add(ventilador);
        
        this.registraObserver();
        this.trocandoEstado();
        
    }
    
    public static void vai(){
        //seta para inicializaControle
        Controle cru = new Controle();
    }
    
    //registraObserver a cada aparelho
    private void registraObserver(){
        for(Aparelho a : this.aparelhos){
            a.registerObserver(this.controleRemotoUni);
        }
    }
    
    //solicita a troca de estado dos aparelhos
    private void trocandoEstado(){
        for(Aparelho a : this.aparelhos){
            a.solicitaTrocarEstado();
        }
    }
    
}
