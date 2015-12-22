/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.util.state;

import control.cdp.Aparelho;

/**
 *
 * @author 20121bsi0040
 */
public class Ligado extends AparelhoState{

    public Ligado(Aparelho ap) {
        super(ap);
    }

    @Override
    public void solicitaTrocarEstado() {
        
        this._aparelho.setNovoEstado(new Desligado(this._aparelho));
        this._aparelho.estado = false;
        this._aparelho.solicitaTrocarEstado();
    }
    
    @Override
    public String toString(){
        return "Ligado --> Desligado";
    }
    
}
