package 经典;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 阻塞队列支持两个附加操作：
 * 在队列为空时，获取元素的线程会等待队列变为非空。当队列满时，存储元素的线程会等待队列可用
 * Created by liuzhiyang on 2020/4/9 下午7:09
 */
public class BlockingQueue {

    private List<Object> queue = new LinkedList<>();

    private int limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }

        this.queue.add(item);
    }


    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(3);

        Thread t1 = new Thread(() -> {
            try {
                blockingQueue.enqueue(1);
                blockingQueue.enqueue(2);
                blockingQueue.enqueue(3);
                blockingQueue.enqueue(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                blockingQueue.dequeue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(Arrays.toString(blockingQueue.queue.toArray()));
    }

}
