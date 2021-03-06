package Model.ADT;

import Exception.MyException;

public interface IMyList<T> {
    void add(T item);
    void remove(T item) throws MyException;
    int size();
    T get(int index) throws MyException;

}