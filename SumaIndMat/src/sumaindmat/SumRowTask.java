
package sumaindmat;

public class SumRowTask implements Runnable{
    private static int[] row;
    private static int indF;
    private static int[] rowSums;

    public SumRowTask(int[] row, int rowIndex) {
        this.row = row;
        this.indF = rowIndex;
    }

    public void run() {
        int sum = 0;
        for (int num : row) {
            sum += num;
        }
        rowSums[indF] = sum;
        System.out.printf("%s trabajando. Suma de la fila %d: %d\n", Thread.currentThread().getName(), indF, sum);
    }

    public static void main(String[] args) {
        int[][] mat = RandomMatrix.generateMatrix(10, 8);
        rowSums = new int[mat.length];
        Thread[] threads = new Thread[mat.length];

        presnetarMatriz(mat);
        System.out.println("");
        
        // Crear y empezar los hilos
        for (int i = 0; i < mat.length; i++) {
            threads[i] = new Thread(new SumRowTask(mat[i], i));
            threads[i].start();
        }

        // Unir los hilos para asegurarse de que todos terminen antes de continuar
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Sumar todas las sumas parciales
        int sumaTotal = 0;
        for (int sum : rowSums) {
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
}