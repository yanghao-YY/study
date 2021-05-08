package sort;

/**
 * @author hao.yang
 * @date 2021/5/8
 */
public class selectionSort {
    public static void main(String[] args) {
        int[] array = {88,1,5,2,4,22,11,56,77,99};
        for (int end = array.length - 1; end > 0 ; end--) {
            int max = 0;//默认0位置的数字是最大的
            for (int begin = 1; begin <=end ; begin++) {
               if(array[begin] > array[max]){
                   max = begin;
               }
            }
            int temp = array[end];
            array[end] = array[max];
            array[max] = temp;
            for (int i = 0; i <array.length ; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
}
