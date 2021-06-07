package alitest;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class PrintNumInTurnThread implements Runnable{
    private static Object lock = new Object();
    private static volatile Integer num = 1;
    @Override
    public void run() {
        for (int i = 0; i < 500 ; i++) {
             synchronized (lock){
                 lock.notify();
                 System.out.println(Thread.currentThread()+":"+num);
                 num++;
                 try {
                     if(i != 499){
                         lock.wait();
                     }
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        }
    }

}
