package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<Val>{
    static private final int m = 13;
    private final List<LinkedList<Pair<String,Val>>> hashmap = new ArrayList<>(m);

    @Override
    public String toString() {
        String values = "\n";
        for(LinkedList<Pair<String,Val>> l : hashmap)
        {
            for(Pair<String,Val> p : l)
                values += p.toString();
        }
        return values;
    }

    public HashMap(){
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
        LinkedList <Pair<String,Val>> values = this.hashmap.get(hashValue);
        boolean found = false;
        int posInLinkedList = 0;
        for(Pair<String,Val> p : values)
        {
            if(p.first.equals(token)){
                found = true;
                break;
            }
            posInLinkedList++;
        }

        if(found)
            return new Pair<>(hashValue,posInLinkedList);
        else
            return null;
    }
}