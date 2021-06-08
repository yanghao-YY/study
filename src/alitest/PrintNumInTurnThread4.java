package alitest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hao.yang
 * @date 2021/6/7
 */
public class PrintNumInTurnThread4 {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();
    private static volatile int num = 1;

    public static void main(String[] args) {
        for (int threadNum = 0; threadNum < 2 ; threadNum++) {
            new Thread(()->{
                for (int i = 0; i < 500; i++) {
                    try {
                        reentrantLock.lock();
                        System.out.println(Thread.currentThread().getName()+":"+num);
                        condition.signal();
                        num++;
                        if (i != 499){
                            condition.await();
                        }
                    }catch ( Exception e){
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }).start();
        }
    }
}
