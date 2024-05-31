
package sumaindmat;

import java.util.Random;

public class RandomMatrix {
    private static Random random = new Random();
    
    public static int[][] generateMatrix(int rows, int cols){
        int[][] output = new int[rows][cols];
        for(var i=0; i < rows; i++){
            for(var j=0; j < cols; j++){
                output[i][j]= random.nextInt(21);
            }
        }
        return output;
    }
}
