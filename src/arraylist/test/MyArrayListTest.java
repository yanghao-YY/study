package arraylist.test;

import arraylist.MyArrayList;

/**
 * @Author: yanghao
 * @Date: 2021/1/19 18:59
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(new Integer("10"));
        myArrayList.add(new Integer("11"));
        myArrayList.add(new Integer("12"));
        myArrayList.remove(1);
        myArrayList.add(1,new Integer("13"));
        myArrayList.set(1,new Integer("333"));
        System.out.println(myArrayList.toString());
    }

}
