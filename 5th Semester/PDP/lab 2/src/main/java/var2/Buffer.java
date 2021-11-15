package var2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private static final int BUFFER_CAPACITY = 1;
    private Queue<Integer> buffer = new LinkedList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void put(int value) throws InterruptedException {
        lock.lock();

        try {
            while (buffer.size() == BUFFER_CAPACITY)
            {
                condition.await();
            }
            buffer.add(value);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == 0)
            {
                condition.await();
            }
            Integer value = buffer.poll();
            if(value != null)
            {
                condition.signalAll();
            }
            return value;
        }finally {
            lock.unlock();
        }
    }
}
