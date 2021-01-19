package arraylist;

import java.util.Arrays;

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
    /**
     * 通过索引查找元素
     * @param index
     * @return
     */
    public E get(int index){
        checkIndex(index);
        return elements[index];
    }

    /**
     * 通过索引直接设置值
     * @param index
     * @param newElement
     * @return
     */
    public E set(int index,E newElement){
        checkIndex(index);
       E oldElement = elements[index];
       elements[index] = newElement;
       return oldElement;
    }

    /**
     * 复用add函数实现在末尾添加
     * @param element
     */
    public void add(E element){
        add(size,element);
    }

    /**
     * 往指定索引处添加元素
     * @param index
     * @param element
     */
    public void add(int index,E element){
        if( index < 0 || index > size){
            throw new IndexOutOfBoundsException("size:"+size+","+"index:"+index);
        }
        //判断即使在末尾添加元素是否需要扩容
        ensureCapacity(size + 1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index){
        checkIndex(index);
        E oldElement = elements[index] ;
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return oldElement;
    }
    /**
     * 自动扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity){
         int oldCapacity = elements.length;
         if ( capacity <= oldCapacity) return;
         int newCapacity = oldCapacity + (oldCapacity >> 1);
         E[] newElments = (E[]) new Object[newCapacity];
         for (int i = 0; i < size; i++) {
            newElments[i] = elements[i];
        }
         elements = newElments;
    }
    /**
     * 检查查询时索引是否越界
     * @param index
     */
    private void checkIndex(int index){
        if ( index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("size:"+size+","+"index:"+index);
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}

