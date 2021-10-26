package ST;

import HashMap.HashMap;
import HashMap.Pair;

public class SymbolTable {
    private HashMap<Integer> table;

    public  SymbolTable(){
        this.table = new HashMap<Integer>();
    }

    public Pair<Integer, Integer> add(String token){
        Pair<Integer,Integer> tokenPosition = table.search(token);
        if(tokenPosition == null)
            tokenPosition = table.add(token,null);
        return tokenPosition;
    }

    @Override
    public String toString() {
        return "SymbolTable\n" +
                "token             value" +
                table.toString();

    }
}
