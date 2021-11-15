package var1;

import java.util.List;

public class Consumer implements Runnable{
    private List<Integer> buffer;
    private Long sum = 0L;

    public Consumer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true)
        {
            synchronized (buffer)
            {
                if(buffer.isEmpty()){
                    continue;}
                if(buffer.get(0) == null)
                {
                    break;
                }
                else
                {
                    sum+=buffer.get(0);
                    buffer.remove(0);
                }
            }
        }
    }

    public Long getSum() {
        return sum;
    }
}
