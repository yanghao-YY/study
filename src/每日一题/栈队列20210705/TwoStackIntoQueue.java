package 每日一题.栈队列20210705;

import java.util.Stack;

/**
 * @author hao.yang
 * @date 2021/7/5
 */
public class TwoStackIntoQueue {
    private static Stack<Integer> stackInput = new Stack<>();
    private static Stack<Integer> stackOutput = new Stack<>();

    public Integer add(Integer item){
        stackInput.push(item);
        return  item;
    }

    public Integer poll(){
        pushStackInputItemsToStackOutput();
        return stackOutput.pop();
    }

    public Integer peek(){
        pushStackInputItemsToStackOutput();
        return stackOutput.peek();
    }

    private static  void pushStackInputItemsToStackOutput(){
        if(stackOutput.isEmpty()){
            if(!stackInput.isEmpty()){
                int len = stackInput.size();
                for (int i = 0; i <len ; i++) {
                    stackOutput.push(stackInput.pop());
                }
            }else {
                throw  new  RuntimeException("队列中无元素!");
            }
        }
    }


    public static void main(String[] args) {
        TwoStackIntoQueue twoStackIntoQueue = new TwoStackIntoQueue();
//        for (int i = 0; i < 10 ; i++) {
//            System.out.println("本次入队元素："+twoStackIntoQueue.add(i));
//        }
//        for (int i = 0; i < 10 ; i++) {
//            System.out.println("本次查看下队头元素："+twoStackIntoQueue.peek());
//            System.out.println("本次出队元素："+twoStackIntoQueue.poll());
//        }
        twoStackIntoQueue.add(1);
        twoStackIntoQueue.add(2);
        twoStackIntoQueue.add(3);
        twoStackIntoQueue.poll();
        twoStackIntoQueue.add(4);
        System.out.println(twoStackIntoQueue.peek());
    }
}
