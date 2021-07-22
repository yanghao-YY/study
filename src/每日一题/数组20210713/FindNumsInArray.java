package 每日一题.数组20210713;

/**
 * @author hao.yang
 * @date 2021/7/13
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ## 2021/07/13 两数之和 （简单）
 *
 * ```java
 * /**
 * *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class FindNumsInArray {
    public static int[] findNumsInArray(int[] ints,Integer sum){
        for (int begin = 0; begin < ints.length ; begin++) {
            for (int cur = begin + 1; cur < ints.length ; cur++) {
                 if(ints[begin] + ints[cur] == sum){
                     return new int[]{begin,cur};
                 }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = {7,2,3,4,5,6};
        System.out.println(Arrays.toString(FindNumsInArray.findNumsInArray(ints,7)));
    }

}
