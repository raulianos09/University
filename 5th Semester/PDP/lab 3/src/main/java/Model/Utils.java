package Model;

import java.util.List;

public class Utils {
    public static Matrix computeSequentially(Matrix matrix1, Matrix matrix2)
    {
        Matrix result = new Matrix(matrix1.getNumberOfRows(),matrix2.getNumberOfCols());
        for(int i = 0;i<result.getNumberOfRows(); i++)
        {
            for(int j = 0 ;j<result.getNumberOfCols();j++)
            {
                result.setElemet(i,j,dotProduct(matrix1.getRow(i),matrix2.getColumn(j)));
            }
        }
        return result;
    }

    public static int dotProduct(List<Integer> vector1, List<Integer> vector2)
    {
        int result = 0;
        for(int i = 0; i < vector1.size(); i++)
        {
            result += vector1.get(i) * vector2.get(i);
        }
        return result;
    }

}
