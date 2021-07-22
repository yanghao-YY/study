package 每日一题.数组20210707;

/**
 * @author hao.yang
 * @date 2021/7/7
 */

/**
 * ## 2021/07/07 数的最小和
 *
 * ```java
 * 题目：在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 */
public class GetSmallSum {

    public static int getSmallSum(int[] arr){
        int sum = 0;
        if(arr.length == 0) return 0;
        for (int begin = 1; begin < arr.length ; begin++) {
            int cur = begin - 1;
            while (cur >= 0){
                if(arr[cur] < arr[begin]){
                    sum = sum + arr[cur];
                }
                cur--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(GetSmallSum.getSmallSum(arr));
    }

}
