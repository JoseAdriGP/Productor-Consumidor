/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProductorConsumidor;

import monitor.AbstractMonitor;
import monitor.Condition;

/**
 *
 * @author Chess
 */
public class Buffer extends AbstractMonitor{
    private int numSlots = 0, cont = 0;   
    private double[] buffer = null;
    private Condition cp, cc;
    public Buffer( int p_numSlots ) {
        numSlots = p_numSlots ; 
        buffer = new double[numSlots] ;
        cp = makeCondition();
        cc = makeCondition();
    }
  
    public void depositar( double valor ) throws InterruptedException { 
        enter();
        while( cont == numSlots ) 
            cp.await();              
        buffer[cont] = valor; 
        cont++;      
        cc.signal();
        leave();
    }
  
    public double extraer() throws InterruptedException {
        enter();
        double valor;
        while( cont == 0 ) 
            cc.await();
        cont--;
        valor = buffer[cont] ;
        cp.signal();
        leave();
        return valor;
        
    }
}
