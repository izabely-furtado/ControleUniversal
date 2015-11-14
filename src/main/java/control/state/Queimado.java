/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.state;

import control.cdp.Aparelho;

/**
 *
 * @author IzabelyFurtado
 */
public class Queimado extends AparelhoState{

    public Queimado(Aparelho ap) {
        super(ap);
    }

    @Override
    public void solicitaTrocarEstado() {
        throw new UnsupportedOperationException("O aparelho queimou - troca");
    }
    
    @Override
    public String toString(){
        return " :'( Já era";
    }
}
