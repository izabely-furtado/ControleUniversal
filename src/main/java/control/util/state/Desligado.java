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
public class Desligado extends AparelhoState{

    public Desligado(Aparelho ap) {
        super(ap);
    }

    @Override
    public void solicitaTrocarEstado() {
        this._aparelho.setNovoEstado(new Ligado(this._aparelho));
        this._aparelho.estado = true;
        this._aparelho.solicitaTrocarEstado();
    }

    @Override
    public String toString(){
        return "Desligado --> Ligado";
    }
    
}
