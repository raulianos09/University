package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Matrix {
    private List<List<Integer>> matrix;
    private int rows, cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                l.add(0);
            }
            this.matrix.add(l);
        }
    }

    public int getElement(int elemRow, int elemCol){
        return this.matrix.get(elemRow).get(elemCol);
    }

    public void setElemet(int elemRow, int elemCol, int newValue)
    {
        this.matrix.get(elemRow).set(elemCol,newValue);
    }

    public List<Integer> getRow(int rowNumber)
    {
        return this.matrix.get(rowNumber);
    }

    public List<Integer> getColumn(int colNumber)
    {
        return this.matrix.stream().map( r -> r.get(colNumber)).collect(Collectors.toList());
    }
    public int getNumberOfRows(){
        return this.rows;
    }

    public int getNumberOfCols(){
        return this.cols;
    }

    public void randomizeMatrix(int maxValue) {
        Random r = new Random();
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++) {
                this.matrix.get(i).set(j, r.nextInt(maxValue));
            }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return rows == matrix1.rows && cols == matrix1.cols && Objects.equals(matrix, matrix1.matrix);
    }

    public void setAllElementsToOne() {
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++) {
                this.matrix.get(i).set(j, 1);
            }
    }

    @Override
    public String toString() {
        StringBuilder stringToPrint = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stringToPrint.append(matrix.get(i).get(j)).append(" ");
            }
            stringToPrint.append("\n");
        }
        return stringToPrint.toString();
    }
}
