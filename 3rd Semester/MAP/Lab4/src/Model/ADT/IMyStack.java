package Model.ADT;

import Exception.MyException;

public interface IMyStack<T> {
    public T pop() throws MyException;
    public void push(T value);

    boolean isEmpty();
}