package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hao.yang
 * @date 2021/5/7
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {88,1,5,2,4,22,11,56,77,99};
        //基于交换的实现法
//        for (int begin = 1; begin < array.length; begin++) {
//           int cur = begin;
//           while (cur > 0 && (array[cur - 1] > array[cur])){//将未排序的元素依次跟已排序的元素进行比较，交换位置，插入到合适的位置
//               int temp = array[cur - 1];
//               array[cur - 1] = array[cur];
//               array[cur] = temp;
//               cur--;
//           }
//            for (int i = 0; i <array.length ; i++) {
//                System.out.print(array[i]+" ");
//            }
//            System.out.println();
//        }
      //基于位移元素实现，避免频繁交换造成性能降低
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            int a = array[cur];
            while (cur > 0 && (a < array [cur - 1])){//拿着待排序元素一次与已排序元素比较，一次将元素往后挪动，寻找合适的插入位置。
                array [cur] = array [cur - 1];
                cur --;
            }
            array[cur] = a;
            for (int i = 0; i <array.length ; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
        }


}
