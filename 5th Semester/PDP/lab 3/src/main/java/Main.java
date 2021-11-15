import Model.Matrix;
import Model.Utils;
import Threads.ColThread;
import Threads.KThread;
import Threads.RowThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfRowsMatrix1 = 5;
        int numberOfColsMatrix1 = 4;
        int numberOfRowsMatrix2 = 4;
        int numberOfColsMatrix2 = 5;

        Matrix matrix1 = new Matrix(numberOfRowsMatrix1, numberOfColsMatrix1);
        Matrix matrix2 = new Matrix(numberOfRowsMatrix2, numberOfColsMatrix2);

        matrix1.randomizeMatrix(10);
        matrix2.randomizeMatrix(10);
        System.out.println("Matrix 1:\n" + matrix1);
        System.out.println("Matrix 2:\n" + matrix2);


        Long startTimeSeq = System.nanoTime();
        Matrix resultSeq = Utils.computeSequentially(matrix1, matrix2);
        Long endTimeSeq = System.nanoTime();
        System.out.println("Sequentially computed result:\n" + resultSeq);


        Matrix resultThread = new Matrix(numberOfRowsMatrix1, numberOfColsMatrix2);

        List<Runnable> runnables = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        int NUMBER_OF_THREADS = 3;
        Long startTimeT = System.nanoTime(), endTimeT = System.nanoTime();


        String threadType = "k"; //can be row, col or k
        switch (threadType) {
            case "row":
                for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                    RowThread rowThread = new RowThread(matrix1, matrix2, resultThread, i, NUMBER_OF_THREADS);
                    runnables.add(rowThread);
                }
                break;

            case "col":
                for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                    ColThread colThread = new ColThread(matrix1, matrix2, resultThread, i, NUMBER_OF_THREADS);
                    runnables.add(colThread);
                }
                break;

            case "k":
                for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                    KThread kThread = new KThread(matrix1, matrix2, resultThread, i, NUMBER_OF_THREADS);
                    runnables.add(kThread);
                }
                break;

        }


        String executionType = "threadPool"; // can be threads or threadPool
        switch (executionType) {
            case "threads":
                for (Runnable r : runnables) {
                    threadList.add(new Thread(r));
                }
                for (Thread t : threadList)
                    t.start();
                for (Thread t : threadList)
                    t.join();
                endTimeT = System.nanoTime();
                break;

            case "threadPool":
                ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
                for (Runnable r : runnables) {
                    threadPoolExecutor.submit(r);
                }
                threadPoolExecutor.shutdown();
                while (!threadPoolExecutor.isTerminated()) {

                }
                endTimeT = System.nanoTime();
                break;
        }

        System.out.println("Result computed with " + executionType + " and splitting the matrix by " + threadType + " is:\n" + resultThread);

        if (resultSeq.equals(resultThread)) {
            System.out.println("The two computed matrices are the same");
        } else
            System.out.println("SOMETHING WENT WRONG! The two computed matrices are different");

        System.out.println("Computation using threads took: " + (double) (endTimeT - startTimeT) / 1000000 + " milliseconds");
        System.out.println("Sequential computation took: " + (double) (endTimeSeq - startTimeSeq) / 1000000 + " milliseconds");
    }

}
