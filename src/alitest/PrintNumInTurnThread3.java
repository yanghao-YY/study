package alitest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hao.yang
 * @date 2021/6/7
 */
public class PrintNumInTurnThread3 {
    private static volatile Thread odd = null;
    private static volatile Thread even = null;
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(1);
        odd = new Thread(()->{
           while (num.get() <= 999){
               //奇数线程通过取模判断当前num是否为奇数，是奇数就打印，然后直接num++
               if( num.get() < 1000 && (num.get() % 2 != 0)){
                   System.out.println(Thread.currentThread().getName()+":"+num.get());
                   num.incrementAndGet();
               }
           }
        });
        even = new Thread(()->{
            while (num.get() <= 1000){
                if( num.get() < 1001 && (num.get() % 2 == 0)){
                    System.out.println(Thread.currentThread().getName()+":"+num.get());
                    num.incrementAndGet();
                }
            }
        });
        odd.start();
        even.start();
    }
}
