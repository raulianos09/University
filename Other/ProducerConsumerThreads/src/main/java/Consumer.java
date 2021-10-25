import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
                    System.out.println("The dot product of the 2 arrays is : " + this.sum);
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
}
