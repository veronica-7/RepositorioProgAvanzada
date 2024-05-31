/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana7pa;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Usuario
 */
public class TestSumRowTaskPool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        var pos=0;
        int a=5;
        int[][] mat = RandomMatrix.generateMatrix(12,12);
        int[]sums = new int [mat.length];
        
        System.out.println("longitud "+mat.length);
        
        var numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);
        
        CountDownLatch endController = new CountDownLatch(12);
        printMatrix(mat);
        
        System.out.println("Creando y ejecutando hilos");
        
        for(var row: mat){
            Thread thread = new Thread(new SumRowTask(row, pos++, sums, endController, a));
            executor.execute(thread);
            System.out.println(a);
        }
         
        try {
            endController.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
         
        System.out.println("Fin");
        executor.shutdown();
        var sumTotal = 0;
        printRow(sums);
        System.out.println("Calculando suma final");
        for(var sum : sums){
            sumTotal += sum; 
        }
        System.out.printf("Suma total: %d\n", sumTotal);
        printRow(sums);
        printMatrix(mat);
    }
    
    private static void printMatrix(int[][] mat){
        for(int i=0; i < mat.length; i++){
            for(int j=0; i < mat.length; j++){
                System.out.print(mat[i][j]+" , ");
                System.out.println();
            }
        }
    }
    
    private static void printRow(int[] sums){
        for(int i=0; i<sums.length;i++){
            
        }
    }
    
}
