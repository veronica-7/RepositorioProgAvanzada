
/*package sumaindmat;

public class SumaMat {
    
    public static void main(String[] args) {
        int[][] matriz = RandomMatrix.generateMatrix(3, 6);
        int[] sumFila = new int[matriz.length];

        presnetarMatriz(matriz);
        System.out.println("");
        
        // Sumar por filas y guardar en rowSums
        for (int i = 0; i < matriz.length; i++) {
            int sum = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sum += matriz[i][j];
            }
            sumFila[i] = sum;
            System.out.printf("Suma de la fila %d: %d\n", (i+1), sum);
        }
        
        System.out.println("");
        
        // Calcular la suma total
        int sumaTotal = 0;
        for (int sum : sumFila) {
            sumaTotal += sum;
        }

        System.out.printf("La suma total es: %d\n", sumaTotal);
    }
    
    public static void presnetarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}*/