
package semana09;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ResolCarrera extends Thread{
    static boolean seguir = true; // static variable global
    Random random = new Random();
    int con; // en java las variables no inicializadas inician en 0
    int inc;
    int rep;
    
    public ResolCarrera(String nombre, int rep){
        nombre = nombre;
        rep = rep;
    }
    
    @Override
    public void run(){
        
        for(int i=0; i <= rep; i++){
            while(con < 100 && seguir){
            inc = random.nextInt(1,10); // genera numeros randoms del 1 - 10
            con = con + inc; 
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ResolCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(con >= 100 && seguir){
                do{
                    System.out.println(this.getName()+" "+ "gana");
                
                } while(i<rep);
                
            }
            }
            System.out.println(this.getName() + " rep# "+ (i+1));
            
        }
    }
    // si tu matas al hilo 1 no muere el resto
    
    public static void main(String[] args) {
        ResolCarrera t1 = new ResolCarrera("1", 4);
        ResolCarrera t2 = new ResolCarrera("2", 4);
        ResolCarrera t3 = new ResolCarrera("3", 4);
        ResolCarrera t4 = new ResolCarrera("4", 4);
        // ResolCarrera t5 = new ResolCarrera("5", 4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        // t5.start();
    }
    
}
/* crear un programa que simule una carrera de relevos de 400 metros, 4 hilos (equipos) deben ser 
   ejecutados para comparar cuál es el que llega primero a completar los 400 metros, 
   estos hilos (equipos) tendran 4 relevos (se repetiran 4 veces) cada uno (equipo), 
   estos relevos deben completar 100 metros para que el siguienterelevo pueda correr (para que el hilo se repita de nuevo), 
   y así hasta que cada equipo complete los 400 metros en total, una vez completos los 400 metros, */

// usar la tabla de valores en programaci[on
        
        /*while(con < 100 && seguir){
            inc = random.nextInt(1,10); // genera numeros randoms del 1 - 10
            con = con + inc;
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ResolCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(con >= 100 && seguir){
                seguir = false;
                System.out.println(this.getName()+" "+ "gana");
            } else {
                System.out.println(this.getName()+" "+ con);

            }*/