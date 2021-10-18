package ST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<Val>{
    static private final int m = 13;
    private final List<LinkedList<Pair<String,Val>>> hashmap;

    public HashMap(){
        this.hashmap = new ArrayList<>(m);
        for(int i = 0; i<m;i++)
        {
            hashmap.add(new LinkedList<>());
        }
    }

    static private int hashFunction(String token)
    {
        return token.chars().sum() % m;
    }

    public Pair<Integer, Integer> add(String token, Val value)
    {
        int hashValue = hashFunction(token);
        Pair<String,Val> pair = new Pair<>(token,value);

        hashmap.get(hashValue).add(pair);
        int index = hashmap.get(hashValue).indexOf(pair);

        return new Pair<>(hashValue,index);
    }

    public Pair<Integer, Integer> search(String token)
    {
        int hashValue = hashFunction(token);
        boolean found = this.hashmap.get(hashValue).stream()
                .filter(p -> p.first.equals(token))
                .findAny()
                .isEmpty();

        if(found)
            return new Pair<>(hashValue, hashmap.get(hashValue).indexOf(token));
        else
            return null;
    }
}