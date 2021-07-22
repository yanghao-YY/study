package 每日一题.华为20210712;

import java.util.Arrays;

/**
 * @author hao.yang
 * @date 2021/7/12
 */

/**
 * 题目：输入一个由数字组成的字符串逗号分隔，返回这些数字可以组成的最大值
 *
 * 例：输入："123,9,44,631"
 *
 * ​		返回：963144123
 *
 * 字符串由逗号分隔，不考虑数字无效的情况
 */
public class FindBigNum {
    public static StringBuilder findBigNum(String str) {
        String[] items = str.split(",");
        for (int end = items.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                String num1 = items[begin - 1] + items[begin];
                String num2 = items[begin] + items[begin - 1];
                if( Integer.parseInt(num1) < Integer.parseInt(num2)){
                     String temp = items[begin];
                    items[begin] = items[begin - 1];
                    items[begin - 1] = temp;
                }

            }
        }
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < items.length; i++) {
                sb.append(items[i]);
            }
            return sb;


    }
    public static void main (String[]args){
//        String str = "123,9,44,631,256,28";
//        String str = "282,256";
//          String str = "59,594";
//        String str = "29,256";
        String str = "9163,909";
//        String str = "801,8018";
//        String str = "891,8918";

        System.out.println(FindBigNum.findBigNum(str));
    }
}
