package 每日一题.栈20210706;

import java.util.Stack;

/**
 * @author hao.yang
 * @date 2021/7/6
 */
public class SortedStack {

    public static void sort(Stack<Integer> stack){
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()){
            helpStack.push(stack.pop());
        }
        while (!helpStack.isEmpty()){
                Integer temp = helpStack.pop();
                while (!stack.isEmpty() && temp < stack.peek()){
                    helpStack.push(stack.pop());
                }
                stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(5);
        stack.add(4);
        stack.add(3);
        stack.add(1);
        SortedStack.sort(stack);
        System.out.println(stack);

    }
}
