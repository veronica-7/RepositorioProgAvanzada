
/*2. Llenar una matriz de dimensión (n x m (par)) con valores de 
1 a n de forma aleatoria en la proporcion de veces cada numero 
(si la matriz es 3x4 se debe llenar con 1,2,3 4 veces cada 
numero de forma aleatoria)*/

// @Author: Verónica Luna

package Ejercicios2;

import java.util.Random;
import java.util.Scanner;

public class secuencial {
    static Scanner entrada = new Scanner(System.in);
    static int m; 
    static int n; 
    static int[][] matriz; 
    static int[] contNums; 
    static int repNums;
   
    public static void main(String[] args) {
        // n = 3;
        // m = 4;
        
        System.out.println("Ingrese el número de filas:");
        n = entrada.nextInt();
        
        System.out.println("Ingrese un número PAR de columnas:");
        m = entrada.nextInt();

        if (m % 2 == 0) {
            matriz = new int[n][m]; 
            contNums = new int[n]; 
            repNums = m; 

            completarMatriz();
          
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

    public static void completarMatriz() {
        Random random = new Random();
        int contCom = 0;

        while (contCom < n * m) { // 3*4=12
            int num = random.nextInt(n) + 1; // Genera un número aleatorio entre 1 y n
            if (contNums[num - 1] < repNums) { // Si no se han insertado todas las repeticiones de este número
                boolean insertar = false;
                while (!insertar) {
                    int i = random.nextInt(n); 
                    int j = random.nextInt(m);  
                    if (matriz[i][j] == 0) {
                        matriz[i][j] = num;
                        contNums[num - 1]++;
                        contCom++;
                        System.out.println("Se insertó " + n);
                        insertar = true;
                    }
                }
            }
        }
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
        System.out.println("Hay " + cont + " números " + numero + " en la matriz.");
    }
}
