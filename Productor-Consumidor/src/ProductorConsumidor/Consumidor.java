/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProductorConsumidor;

/**
 *
 * @author Chess
 */
public class Consumidor implements Runnable { 
    private Buffer bb ;
    int veces, numC ;
    Thread thr ;
    
    public Consumidor( Buffer pbb, int pveces, int pnumC ) { 
        bb    = pbb;
        veces = pveces;
        numC  = pnumC ;
        thr   = new Thread(this,"consumidor "+numC);
    }
  
    public void run() { 
      try { 
            for( int i=0 ; i<veces ; i++ ){ 
                double item = bb.extraer ();
                System.out.println(thr.getName()+", consumiendo "+item);
            } 
        }
        catch( Exception e ) { 
            System.err.println("Excepcion en main: " + e);
        }
    }
}