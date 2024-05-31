/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana7pa;

import java.util.concurrent.CountDownLatch;

public class SumRowTask implements Runnable{
    private int[] row;
    private final int pos;
    private int[] sums;
    private CountDownLatch endController;
    private int a;

    public SumRowTask(int[] row, int pos, int[] sums, CountDownLatch endController, int a) {
        this.row = row;
        this.pos = pos;
        this.sums = sums;
        this.endController = endController;
        this.a = a;
    }
    
    @Override
    public void run(){
        var sum = 0;
        for(var num :row){
            sum += num;
        }
        sums[pos]= sum;
        a = 99999;
        System.out.println("hilo -->"+Thread.currentThread().getId());
        endController.countDown();
    }
}
