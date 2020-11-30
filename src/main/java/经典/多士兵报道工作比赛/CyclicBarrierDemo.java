package 经典.多士兵报道工作比赛;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 三种多线程并发控制工具（循环栅栏）
 * 它也可以线程间的计数等待，类似countdownlatch，但比countdownlatch更加复杂
 * cyclic.await():第一次等待所有线程到齐
 * cyclic.await():第二次等待所有线程完成任务
 *
 * CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
 * 当计数器达到指标时便会调用BarrierRun的方法（触发两次：当线程总数达到时，当最后一个线程结束执行时）
 */
public class CyclicBarrierDemo {

    /**
     * 模拟士兵
     * 同时到齐后执行任务
     */
    public static class Soldier implements Runnable {

        private String soldierName;

        private final CyclicBarrier cyclicBarrier;

        Soldier(CyclicBarrier cyclic, String soldierName) {
            this.cyclicBarrier = cyclic;
            this.soldierName = soldierName;
        }

        public void run() {
            try {
                // 等待所有士兵到齐
                cyclicBarrier.await();
                doWork();
                // 等待所有士兵完成工作
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldierName + ":任务完成");
        }
    }

    /**
     * CyclicBarrier的参数：当计数器一次完成后，会执行一次
     */
    public static class BarrierRun implements Runnable {

        boolean flag;

        int N;

        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        public void run() {
            if (flag) {
                System.out.println("司令:[士兵" + N + "个，任务完成！]");
            } else {
                System.out.println("司令:[士兵" + N + "个，集合完毕！]");
                flag = true;
            }
        }
    }

    public static void main(String args[]) {
        final int N = 10;
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));

        Thread[] allSoldier = new Thread[N];

        // 设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for (int i = 0; i < N; ++i) {
            System.out.println("士兵 " + i +" 报道！");
            allSoldier[i] = new Thread(new Soldier(cyclic, "士兵 " + i));
            allSoldier[i].start();
        }
    }

}
