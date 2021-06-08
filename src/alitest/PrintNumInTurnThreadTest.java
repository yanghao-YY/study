package alitest;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class PrintNumInTurnThreadTest {
    public static void main(String[] args) {
        for (int i = 0 ; i < 2 ; i++) {
            new Thread(new PrintNumInTurnThread()
            ).start();
        }
    }
}
