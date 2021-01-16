package arraylist;

/**
 * @Author hao.yang
 * @Date 2021/1/16
 **/
public class MyArrayList<E> {
    /**
     * 容量
     */
    private int size;
    /**
     * 元素
     */
    private  E[] elements;
    /**
     * 默认容量
     */
    private static final int DEFAUT_CAPACITY = 10;

    public MyArrayList(int capacity){
        capacity = capacity <= 0 ? DEFAUT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public MyArrayList(){
        this(DEFAUT_CAPACITY);
    }

    /**
     * 清除元素的数量
     */
     public void clear(){
         //将数组中的元素都设为null,释放内存资源
         for (int i = 0; i < size; i++) {
             elements[i] = null;
         }
      size = 0;
    }

    /**
     * 获取元素的数量
     * @return
     */
    public int size(){
         return size;
    }

    /**
     * 判断是否为空数组
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 判断数组中是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) == -1;
    }

    /**
     * 通过元素查找索引
     * @param element
     * @return
     */
    public int indexOf(E element){
            if (element == null){
                for (int i = 0; i < size; i++) {
                    if (elements[i] == null) return i;
                }
            }else {
                for (int i = 0; i < size; i++) {
                    if (element.equals(elements[i])) return i;
                }
            }
        return -1;
    }
}

