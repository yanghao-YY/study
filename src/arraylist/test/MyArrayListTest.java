package arraylist.test;

import arraylist.MyArrayList;

/**
 * @Author: yanghao
 * @Date: 2021/1/19 18:59
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 21 ; i++) {
            myArrayList.add(new Integer("10"));
        }


        System.out.println(myArrayList.toString());
    }

}
