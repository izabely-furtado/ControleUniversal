/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.state;

import control.cdp.Aparelho;

/**
 *
 * @author 20121bsi0040
 */
public abstract class AparelhoState implements IAparelhoState{

     protected Aparelho _aparelho;
    
    public AparelhoState(Aparelho ap){
        this._aparelho = ap;
    }
    
    @Override
    public abstract void solicitaTrocarEstado();
    
}
