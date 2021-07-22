package 每日一题.栈20210706;

import java.util.Stack;

/**
 * @author hao.yang
 * @date 2021/7/6
 */

/**
 * 题目：一个栈中的元素为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构，如何完成排序？
 *     -----------------------------------------------
 * 解答：
 *     /**
 *  * @Auther: licl
 *  * @Date: 2021/07/06
 *  * @Description:  用一个栈实现另一个栈的排序
 *  *                一个栈中元素为整型，现在需要从顶到底安照从大到小排序，只可以申请一个栈，可以申请新的变量，但是不能申请额外的数据结构 完成排序
 *  *                思想：stack  help  stack弹出元素记做cur
 *  *                      1.如果cur小于等于help栈顶元素  则放入help
 *  *                      2.如果cur大于help栈顶元素 则弹出help元素放入stack 直到cur小于等于help栈顶元素  放入cur到help 继续从stack重复操作
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
