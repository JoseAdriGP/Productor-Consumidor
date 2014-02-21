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
public class Productor implements Runnable { 
    private Buffer bb ;
    int veces, numP ;
    Thread thr ;
    
    public Productor( Buffer pbb, int pveces, int pnumP ) { 
        bb    = pbb;
        veces = pveces;
        numP  = pnumP ;
        thr   = new Thread(this,"productor "+numP);
    }
  
    public void run() { 
        try{ 
            double item = 100*numP ;
            for( int i=0 ; i<veces ; i++ ){ 
                System.out.println(thr.getName()+", produciendo " + item);
                bb.depositar( item++ );
            }
        }
        catch( Exception e ) {
            System.err.println("Excepcion en main: " + e);
        }
    }
}
