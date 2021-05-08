package sort;

/**
 * @author hao.yang
 * @date 2021/5/7
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] array = {88,1,5,2,4,22,11,56,77,99};
        int[] array = {1,2,3,4,5,11,56,99};
//        boolean isSorted = true;//1、判断如果某次循环已经没有元素交换了，证明已经有序了，终止循环。
//          int sortedIndex = 1;
        for(int end = array.length - 1;end > 0;end--){
            int sortedIndex = 1;//得到已排序的索引，索引之后的元素代表已排序，不用再比较了
            for (int begin = 1; begin <=end ; begin++) {
                if(array[begin] < array[begin - 1]){
                    int temp = array[begin - 1];
                    array[begin - 1] = array[begin];
                    array[begin] = temp;
                    sortedIndex = begin -1;
//                    isSorted = false;
                }
            }
            end = sortedIndex;
            for (int i = 0; i <array.length ; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
//           if(isSorted) break;
        }
    }
}
