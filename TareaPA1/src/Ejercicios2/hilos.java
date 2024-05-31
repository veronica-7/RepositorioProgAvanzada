
/*2. Llenar una matriz de dimensión (n x m (par)) con valores de 
1 a n de forma aleatoria en la proporcion de veces cada numero 
(si la matriz es 3x4 se debe llenar con 1,2,3 4 veces cada 
numero de forma aleatoria)*/

// @Author: Verónica Luna

package Ejercicios2;

import java.util.Random;
import java.util.Scanner;

public class hilos extends Thread {
    static Scanner entrada = new Scanner(System.in);
    static int n;
    static int m;
    static int[][] matriz;
    static int[] contNums;
    static int repNums;
    int num;

    public hilos(int num) {
        this.num = num;
    }
    
    public static void contar(int numero) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == numero) {
                    cont++;
                }
            }
        }
        System.out.println("Hay "+ cont +" números "+ numero +" en la matriz.");
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < repNums; i++) {
            boolean insertar = false;
            while (!insertar) {
                int indi = random.nextInt(n);
                int indj = random.nextInt(m);
                if (matriz[indi][indj] == 0) {
                    matriz[indi][indj] = num;
                    System.out.println(this.getName() + " | inserta " + num);
                    insertar = true;
                } 
            }
        }
    }
    
    public static void main(String[] args) {

        System.out.println("Ingrese el número de filas:");
        n = entrada.nextInt();
        
        System.out.println("Ingrese un número PAR de columnas:");
        m = entrada.nextInt();

        if (m % 2 == 0) {
            matriz = new int[n][m];
            contNums = new int[n];
            repNums = m; 

            Thread[] threads = new Thread[n];
            for (int i = 0; i < n; i++) {
                threads[i] = new hilos(i + 1);
                threads[i].start();
            }

            for (int i = 0; i < n; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Imprimir la matriz final
            System.out.println("\nMatriz final:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("");
            for (int i = 1; i <= n; i++) {
                contar(i);
            }

        } else {
            System.out.println("El número de columnas debe ser par");
        }
    }
}