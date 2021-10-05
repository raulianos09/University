package Model.ADT;

import Exception.MyException;

import java.util.Map;

public interface IMyDictionary<K, V> {
    public V lookup(K key);
    public void update(K key, V value);
    public void remove(K key) throws MyException;

    boolean isDefined(K id);

    void add(K name, V intValue) throws MyException;
    public Map<K, V> getContent();
}
