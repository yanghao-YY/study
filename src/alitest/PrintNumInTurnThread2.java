package alitest;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class PrintNumInTurnThread2 {
    private static Thread odd = null;
    private static Thread even = null;
    private static volatile boolean oddHasRunFlag = false;
    public static void main(String[] args) {

       odd = new Thread(()->{
          oddHasRunFlag = true;
           for (int i = 1; i < 1000; i+=2) {
               System.out.println(Thread.currentThread()+":"+i);
               LockSupport.unpark(even);
               if(i != 999){
                   LockSupport.park();
               }
           }
       });

        even = new Thread(()->{
            while (oddHasRunFlag){
                for (int i = 2; i < 1001; i+=2) {
                    System.out.println(Thread.currentThread()+":"+i);
                    LockSupport.unpark(odd);
                    if(i != 1000){
                        LockSupport.park();
                    }
                }
                break;
            }
        });
        odd.start();
        even.start();
    }
}
