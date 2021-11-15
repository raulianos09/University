package Threads;

import Model.Matrix;
import Model.Utils;

import java.util.List;

public class ColThread implements Runnable{
    Matrix matrix1;
    Matrix matrix2;
    Matrix result;
    int startingCol;
    int numberOfThreads;

    public ColThread(Matrix matrix1, Matrix matrix2, Matrix result, int startingCol, int numberOfThreads) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startingCol = startingCol;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run(){
        for(int i = startingCol ; i < result.getNumberOfCols(); i+=this.numberOfThreads)
        {
            computeCol(this.matrix1,this.matrix2,this.result,i);
        }
    }

    public static void computeCol(Matrix matrix1, Matrix matrix2, Matrix result, int colIndex)
    {
        List<Integer> col = matrix2.getColumn(colIndex);
        for(int i = 0; i < result.getNumberOfRows(); i++)
        {
            result.setElemet(i, colIndex, Utils.dotProduct(matrix1.getRow(i) , col));
        }
    }


}
