package var2;

public class Consumer implements Runnable{
    private Buffer buffer;
    private Long sum = 0L;
    private Integer size;

    public Consumer(Buffer buffer, Integer size) {
        this.buffer = buffer;
        this.size = size;
    }

    @Override
    public void run() {
        for(int i = 0 ; i<size;i++)
        {
            try {
               sum += buffer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Long getSum() {
        return sum;
    }
}
