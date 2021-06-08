package alitest;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class PrintNumInTurnThread2 {
    private static Thread odd = null;
    private static Thread even = null;
    public static void main(String[] args) {

       odd = new Thread(()->{
           for (int i = 1; i < 1000; i+=2) {
               System.out.println(Thread.currentThread()+":"+i);
               LockSupport.unpark(even);
               //执行到最后一步时，就不要阻塞线程了，让程序能正常结束
               if(i != 999){
                   LockSupport.park();
               }
           }
       });

        even = new Thread(()->{
                for (int i = 2; i < 1001; i+=2) {
                    if(i != 1001){
                        //偶数线程先park，能够保证奇数线程一定先打印；同时因为unpark可以在park之前,意味着奇数线程可以先生成许可，偶数线程必须先park去消费这个许可再打印，如果打印之后再消费可能出现偶数线程连续执行。
                        LockSupport.park();
                    }
                    System.out.println(Thread.currentThread()+":"+i);
                    LockSupport.unpark(odd);

            }
        });
        even.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        odd.start();

    }
}
