
/* 1. Llenar un vector de dimensión = 80 con valores (1,2,3,4) 
de forma aleatoria en la misma proporción, 20 veces cada numero.*/

// @Author: Verónica Luna

package Ejercicios1;

import java.util.Random;

public class secuencial {
    static int dim = 80;
    static int rep = 20;
    static int[] vector = new int[dim]; 
    static int[] vectorNums = new int[4];

    public static void main(String[] args) {
        completarVector();

        // Imprimir el vector para verificar
        System.out.println("\nVector final:");
        for (int i = 0; i < dim; i++) {
            System.out.print(vector[i] +" ");
        }
        System.out.println("");
        contar(1);
        contar(2);
        contar(3);
        contar(4);
        
    }

    public static void completarVector() {
        Random random = new Random();
        int indice = 0;
        while (!verificar()) { 
            int num = random.nextInt(4) + 1; 
            if (vectorNums[num - 1] < rep) { 
                vector[indice] = num; 
                vectorNums[num - 1]++; 
                System.out.println("Se insertó " + num);
                indice++; // Avanzar al siguiente índice
            }
        }
    }

    public static boolean verificar() {
        for (int i = 0; i < vectorNums.length; i++) {
            if (vectorNums[i] < rep) { 
                return false; 
            }
        }
        return true;
    }
    
    public static void contar(int n){
        int cont = 0;
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] == n){
                cont++;
            }
        }
        System.out.println("Hay " +cont+ " números " +n);
    }
}
