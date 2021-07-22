package 每日一题.链表20210709;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hao.yang
 * @date 2021/7/9
 */

/**
 * ## 2021/07/09 打印两个有序链表的公共部分
 *
 * ```JAVA
 * 题目：给定2个有序链表的头指针head1和head2，打印2个链表的公共部分
 */
public class FindLinkedListsInCommon {

    private static void findLinkedListsInCommon(Node n1,Node n2) {
        System.out.print("共有的部分为："+"[");
        if(n1 ==null || n2 == null) return;
        List<Integer> list = new ArrayList<>();
        //将链表1的值存到list中
       Node node1 = n1;
       while (true){
           list.add(node1.value);
            node1 = node1.next;
           if (node1 == null) break;

       }
       Node node2 = n2;
        while (true){
            if(list.contains(node2.value)){
                System.out.print(node2.value+" ");
            }
            node2 = node2.next;
            if(node2 == null) break;

        }

        System.out.println("]");

    }

    private static  void findLinkedListsInCommon2(Node n1,Node n2){
        System.out.print("共有的部分为："+"[");
        if(n1 == null || n2 == null) return;
        Node node1 = n1;
        Node node2 = n2;
        while (node1 != null && node2 != null){
            if(node1.value == node2.value){
                System.out.print(node1.value+ " ");
                node1 = node1.next;
                node2 = node2.next;
            }else if( node1.value < node2.value){
                node1 = node1.next;
            }else {
                node2 = node2.next;
            }
        }
        System.out.println("]");
    }

    public class Node {
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static void main(String[] args) {
      Node n1 = new FindLinkedListsInCommon(). new Node(1);
      n1.next  = new FindLinkedListsInCommon(). new Node(2);
      n1.next.next  = new FindLinkedListsInCommon(). new Node(3);
      n1.next.next.next  = new FindLinkedListsInCommon(). new Node(4);
      n1.next.next.next.next  = new FindLinkedListsInCommon(). new Node(6);


        Node n2 = new FindLinkedListsInCommon(). new Node(1);
        n2.next  = new FindLinkedListsInCommon(). new Node(4);
        n2.next.next  = new FindLinkedListsInCommon(). new Node(6);
        n2.next.next.next  = new FindLinkedListsInCommon(). new Node(7);
        n2.next.next.next.next  = new FindLinkedListsInCommon(). new Node(8);

//        FindLinkedListsInCommon.findLinkedListsInCommon(n1,n2);
        FindLinkedListsInCommon.findLinkedListsInCommon2(n1,n2);


    }
}
