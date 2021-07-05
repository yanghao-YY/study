package 每日一题.栈队列20210705;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hao.yang
 * @date 2021/7/5
 */
public class TwoQueueIntoStack {
    private static Queue<Integer> queue01 = new LinkedList<>();
    private static Queue<Integer> queue02 = new LinkedList<>();

    public boolean add(Integer item){
        if(queue01.isEmpty()){
            if(!queue02.isEmpty()){
                return queue02.add(item);
            }
        }
        return queue01.add(item);
    }

    public Integer poll(){
        Queue<Integer> hasItemsQueue = findItemsInWhichQueue();
        int len = hasItemsQueue.size();
        Queue<Integer> emptyQueue = hasItemsQueue == queue01 ? queue02 :queue01;
        for (int i = 0; i < len - 1; i++) {
            emptyQueue.add(hasItemsQueue.poll());
        }
        return hasItemsQueue.poll();
    }

    public Integer peek(){
        Queue<Integer> hasItemsQueue = findItemsInWhichQueue();
        int len = hasItemsQueue.size();
        Queue<Integer> emptyQueue = hasItemsQueue == queue01 ? queue02 :queue01;
        Integer peekItem = null;
        //为了不改变存储顺序，peek后都把元素放一个队列里，保证同一个时刻只能有一个队列中有数据
        for (int i = 0; i < len ; i++) {
            if( i == len - 1 ){
                peekItem = hasItemsQueue.peek();
            }
            emptyQueue.add(hasItemsQueue.poll());
        }

        return peekItem;
    }

    private static Queue<Integer>  findItemsInWhichQueue(){
        if(!(queue01.isEmpty() && queue02.isEmpty())){
            return queue01.isEmpty() ? queue02 :queue01;
        }else {
            throw new RuntimeException("容器中无元素!");
        }
    }

    public static void main(String[] args) {
        TwoQueueIntoStack twoQueueIntoStack = new TwoQueueIntoStack();
        twoQueueIntoStack.add(1);
        twoQueueIntoStack.add(2);
        twoQueueIntoStack.add(3);
        System.out.println(twoQueueIntoStack.peek());
        System.out.println(twoQueueIntoStack.poll());
        twoQueueIntoStack.add(4);
        System.out.println(twoQueueIntoStack.peek());
    }

}
