package 每日一题.链表20210714;

/**
 * @author hao.yang
 * @date 2021/7/14
 */

import java.util.Stack;

/**
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *  * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *  * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *  * 实例1：
 *  * 输入：l1 = [2,4,3], l2 = [5,6,4]
 *  * 输出：[7,0,8]
 *  * 解释：342 + 465 = 807.
 *  *
 *  * 示例 2：
 *  * 输入：l1 = [0], l2 = [0]
 *  * 输出：[0]
 *  *
 *  * 示例 3：
 *  * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *  * 输出：[8,9,9,9,0,0,0,1]
 *  *
 *  * 提示：
 *  * 每个链表中的节点数在范围 [1, 100] 内
 *  * 0 <= Node.val <= 9
 *  * 题目数据保证列表表示的数字不含前导零
 */
public class SumlinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public static  ListNode sumlinkedList(ListNode l1, ListNode l2) {
//        if(l1 == null || l2 == null) return null;
//        Stack stack1 = convertLinkedList2Stack(l1);
//        Stack stack2 = convertLinkedList2Stack(l2);
//        ListNode first = convertString2LinkedList(new Integer(getIntValueByStack(stack1)+getIntValueByStack(stack2)).toString());
//        return first;
//    }
//    private static Stack convertLinkedList2Stack(ListNode l){
//        Stack stack = new Stack();
//        ListNode node = l;
//        while (true){
//            stack.push(node.val);
//            node = node.next;
//            if( node == null) break;
//        }
//        return stack;
//    }
//    private static int getIntValueByStack(Stack stack){
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//        return Integer.parseInt(sb.toString());
//    }
//
//    private static ListNode convertString2LinkedList(String str){
//        char[] chars = str.toCharArray();
//        ListNode first = new ListNode(Integer.parseInt(String.valueOf(chars[chars.length - 1])));
//        ListNode node = first;
//        for (int i = chars.length - 2 ; i >= 0  ; i--) {
//            node.next = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
//            node = node.next;
//        }
//        return first;
//    }

    public static  ListNode sumlinkedList(ListNode l1, ListNode l2){

        return null;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(9);
        first.next = new ListNode(9);
        first.next.next = new ListNode(9);
        first.next.next.next = new ListNode(9);
        first.next.next.next.next = new ListNode(9);
        first.next.next.next.next.next = new ListNode(9);
        first.next.next.next.next.next.next = new ListNode(9);

        ListNode first1 = new ListNode(9);
        first1.next = new ListNode(9);
        first1.next.next = new ListNode(9);
        first1.next.next.next = new ListNode(9);
        ListNode node = SumlinkedList.sumlinkedList(first,first1);
        System.out.println("得到的结果:[");
        while (true){
            System.out.print(node.val+" ");
            node = node.next;
            if(node == null){
                break;
            }
        } System.out.println("]");



    }
}
