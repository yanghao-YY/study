package alitest;

import java.util.Arrays;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class CompareArrays {
    public static boolean compareTo(Object[] arr1,Object[] arr2){
        if(arr1 == null || arr2 == null)
            return false;
        if( arr1 == arr2)
            return true;
        if(arr1.length != arr2.length)
            return false;
            Arrays.sort(arr1);
            Arrays.sort(arr2);
        if(Arrays.equals(arr1,arr2)) return true;
           return false;
    }
}
