package var1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utility {
    public static List<Integer> generateRandomList(Integer sizeOfList)
    {
        Random r = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0 ; i<sizeOfList ; i++)
        {
            randomNumbers.add(r.nextInt(50));
        }
        return randomNumbers;
    }
}
