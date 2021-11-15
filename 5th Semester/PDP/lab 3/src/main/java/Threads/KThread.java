package Threads;

import Model.Matrix;
import Model.Utils;
import jdk.jshell.execution.Util;

import java.util.List;

public class KThread implements Runnable {
    Matrix matrix1;
    Matrix matrix2;
    Matrix result;
    int startingElem;
    int numberOfThreads;

    public KThread(Matrix matrix1, Matrix matrix2, Matrix result, int startingElem, int numberOfThreads) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startingElem = startingElem;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run() {
        for (int i = startingElem; i < result.getNumberOfCols() * result.getNumberOfRows(); i += this.numberOfThreads) {
            int elemCol = i % result.getNumberOfCols();
            int elemRow = i / result.getNumberOfCols();
            this.result.setElemet(elemRow, elemCol, Utils.dotProduct(matrix1.getRow(elemRow), matrix2.getColumn(elemCol)));
        }
    }
}
