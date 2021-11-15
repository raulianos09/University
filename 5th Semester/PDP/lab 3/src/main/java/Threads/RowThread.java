package Threads;

import Model.Matrix;
import Model.Utils;

import java.util.List;

public class RowThread implements Runnable{
    Matrix matrix1;
    Matrix matrix2;
    Matrix result;
    int startingRow;
    int numberOfThreads;

    public RowThread(Matrix matrix1, Matrix matrix2, Matrix result, int startingRow, int numberOfThreads) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startingRow = startingRow;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run(){
        for(int i = startingRow ; i < result.getNumberOfRows(); i+=this.numberOfThreads)
        {
            computeRow(this.matrix1,this.matrix2,this.result,i);
        }
    }

    public static void computeRow(Matrix matrix1, Matrix matrix2, Matrix result, int rowIndex)
    {
        List<Integer> row = matrix1.getRow(rowIndex);
        for(int i = 0; i < result.getNumberOfCols(); i++)
        {
            result.setElemet(rowIndex, i , Utils.dotProduct(row , matrix2.getColumn(i)));
        }
    }


}
