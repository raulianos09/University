package ST;

public class SymbolTable {
    private HashMap<Integer> table;

    public  SymbolTable(){
        this.table = new HashMap<>();
    }

    public Pair<Integer, Integer> add(String token){
        Pair<Integer,Integer> tokenPosition = table.search(token);
        if(tokenPosition == null)
            tokenPosition = table.add(token,null);
        return tokenPosition;
    }
}
