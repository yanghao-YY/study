package 每日一题.栈20210706;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author hao.yang
 * @date 2021/7/6
 */

/**
 * ## **2021/07/06** 实现可以获取最小值的栈
 *
 * ```java
 * /**
 *  * @Auther: licl
 *  * @Date: 2021/07/06
 *  * @Description: 问题：实现一个特殊的栈，在实现栈的基本功能的同时，再实现返回栈中最小元素的操作
 *  *                 要求：1.pop push getMin操作的时间复杂度都是O(1)
 *  *                     2.设计的栈类型可以使用现成的栈结构。
 */
public class MySpecialStack {

    private static ArrayList<Integer> itemList = new ArrayList<>();

    private static Stack<Integer> minItemIndexStack = new Stack<>();

    public Integer push(Integer item){
          itemList.add(item);
          if(minItemIndexStack.isEmpty() || item < itemList.get(minItemIndexStack.peek())){
             minItemIndexStack.push(itemList.size() - 1);
          }
          return item;
    }

    public Integer peek(){
        if(itemList.isEmpty()){
            throw new RuntimeException("栈数据为空！");
        }
        return itemList.get(itemList.size() - 1);
    }

    public Integer pop(){
        Integer item = peek();
        int len = itemList.size();
        itemList.remove(len - 1 );
        if((len - 1) == minItemIndexStack.peek()){
            minItemIndexStack.pop();
        }
        return item;
    }

    public Integer getMinItem(){
        return itemList.get(minItemIndexStack.peek());
    }

    public static void main(String[] args) {
        MySpecialStack mySpecialStack = new MySpecialStack();
        mySpecialStack.push(2);
        mySpecialStack.push(3);
        mySpecialStack.push(4);
        mySpecialStack.push(5);
        System.out.println(mySpecialStack.getMinItem());
        System.out.println(mySpecialStack.peek());
        System.out.println(mySpecialStack.pop());
        mySpecialStack.push(1);
        System.out.println(mySpecialStack.getMinItem());
        System.out.println(mySpecialStack.pop());
        System.out.println(mySpecialStack.getMinItem());
    }
}
