
package pruebaavanzada;

import java.util.Scanner;

/**
 *
 * @author Usuario | Verónica Sofía Luna Eras
 */
public class hilos extends Thread{
    static Scanner entrada = new Scanner(System.in);
    // static int[] nums1 = new int[];
    int [] nums = new int[80];
    int rep; 
    
    
    public hilos(String nombre, int rep){
        super(nombre);
        this.rep = rep;
    }

    public hilos(String nombre, int rep,int[] nums) {
        super(nombre);
        this.nums = nums;
    }
    
    /*@Override
    public void run(){
        for(int i=0; i<=rep;i++){
            //int random = entrada.nextInt((int) Math.random());
            System.out.println("Hilo " +this.getName()+ " - repeticion #"+ i);
        }
    }*/
    
    @Override
    public void run(){
        for(int i=0; i<=rep;i++){
            System.out.println("Hilo " +this.getName()+ " - repeticion #"+ i);
        }
    }
    
    public static void main(String[] args) {
        int [] nums = new int[80];
        
        Thread h1 = new Thread(new hilos("a", 20));
        Thread h2 = new Thread(new hilos("b", 20));
        Thread h3 = new Thread(new hilos("c", 20));
        Thread h4 = new Thread(new hilos("d", 20));
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }
    
}
