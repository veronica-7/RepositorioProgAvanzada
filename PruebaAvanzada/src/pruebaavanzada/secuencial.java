
package pruebaavanzada;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Usuario | Verónica Sofía Luna Eras
 */
public class secuencial {
    static Scanner entrada = new Scanner(System.in);
    static Random r1 = new Random(10);
    static int [] nums = new int[80];
    static int [] listap = new int[20];
    String nombre;
    int r;
    
    public secuencial(String nombre, int r){
        this.nombre = nombre;
        this.r = r;
    }
    
    public void presentar(){
        for(int i=0; i<r;i++){
            // nums[i] = entrada.nextInt((int) Math.random());
            listap[i] = r1.nextInt(10);
        }
        System.out.println(listap);
    }
    
    public static void main(String[] args) {
        
        // int random = entrada.nextInt((int) Math.random());
        
        /*for(int i=0; i<=nums.length; i++){
            nums[i] = entrada.nextInt((int) Math.random());
            System.out.println(nums);
        }*/
        
        
        secuencial s1 = new secuencial("a", 20);
        secuencial s2 = new secuencial("b", 20);
        secuencial s3 = new secuencial("c", 20);
        secuencial s4 = new secuencial("d", 20);
        
        s1.presentar();
        s2.presentar();
        s3.presentar();
        s4.presentar();
        
    }
}
