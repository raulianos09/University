package PIF;

import HashMap.Pair;

import java.util.ArrayList;
import java.util.List;

public class PIF {
    private List<Pair<String, Pair<Integer,Integer>>> pif;

    public PIF() {
        this.pif = new ArrayList<>();
    }

    public void add(String token , Pair<Integer,Integer> positionInSt){
        pif.add(new Pair<>(token, positionInSt));
    }

    @Override
    public String toString() {
        String values = "" ;
        for(Pair<String,Pair<Integer,Integer>> o : pif){
            values = values + o.first + " " + o.second.first + " " + o.second.second + "\n";
        }
        return values;
    }
}
