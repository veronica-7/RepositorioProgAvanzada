/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana8pa;

/**
 *
 * @author Usuario
 */
public class DemoTask1 implements Runnable {
    private int number;
    
    public DemoTask1(int number){
        this.number = number;
    }
    
    @Override
    public void run(){
        System.out.printf("%d\n", number);
    }
    
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};
        for(var num: numbers){
            Thread run = new Thread(new DemoTask1(num));
            run.start();
        }
    }
}
