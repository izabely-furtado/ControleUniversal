package tddUniversal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.cdp.Aparelho;
import control.util.observ.ControleRemoto;
import control.util.state.AparelhoState;
import control.util.state.Desligado;
import control.util.state.Ligado;
import control.util.state.Queimado;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author IzabelyFurtado
 */
public class testControle {
    
    public testControle() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    @Test
    public void aparelhoQueimado(){
        Aparelho ap = new Aparelho(0);
        assertEquals(ap.getMeuEstado().toString(), new Queimado(ap).toString());
    }
    
    @Test
    public void aparelhoInicializado(){
        Aparelho ap = new Aparelho(1);
        assertEquals(ap.getMeuEstado().toString() + false, new Desligado(ap).toString() + ap.estado);
    }
    
    @Test
    public  void setNovoEstadoVish(){
        Aparelho ap = new Aparelho(0);
        AparelhoState as = new Ligado(ap);
        ap.setNovoEstado(as);
        assertEquals(new Queimado(ap).toString(), ap.getMeuEstado().toString());
    }
            
    @Test
    public  void setEstadoLigado(){
        Aparelho ap = new Aparelho(1);
        AparelhoState as = new Ligado(ap);
        ap.setNovoEstado(as);
        assertEquals(new Ligado(ap).toString(), ap.getMeuEstado().toString());
    }
         
    @Test
    public  void setEstadoDesligado(){
        Aparelho ap = new Aparelho(1);
        AparelhoState as = new Desligado(ap);
        ap.setNovoEstado(as);
        assertEquals(new Desligado(ap).toString(), ap.getMeuEstado().toString());
    }
            
    @Test
    public  void setEstadoQuantMudanca(){
        Aparelho ap = new Aparelho(1);
        AparelhoState as = new Desligado(ap);
        ap.setNovoEstado(as);
        assertEquals(new Desligado(ap).toString() + 0, ap.getMeuEstado().toString() + ap.getMudanca());
    }
    
    @Test 
    public void updateEstado(){
        ControleRemoto cr = new ControleRemoto();
        cr.update(new Aparelho(1), cr);
        assertEquals(true, cr.getEstado());
    }
    
    @Test 
    public void updateEstado1(){
        ControleRemoto cr = new ControleRemoto();
        Aparelho ap = new Aparelho(2);
        cr.update(ap, cr);
        cr.update(ap, cr);
        assertEquals(false, cr.getEstado());
    }
    
    
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
