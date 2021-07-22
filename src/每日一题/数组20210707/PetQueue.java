package 每日一题.数组20210707;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hao.yang
 * @date 2021/7/7
 */

/**
 * 实现一种猫狗队列的结构，要求如下：
 *     1.用户可以调用add方法将cat类或dog类的实例放入队列中；
 *     2.用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 *     3.用户可以调用pollDog方法，将队列中Dog类的实例按照进队列的先后顺序依次弹出；
 *     4.用户可以调用pollCat方法，将队列中Cat类的实例按照进队列的先后顺序依次弹出；
 *     5.用户可以调用isEmpty方法，检查队列中是否还有Dog或Cat的实例；
 *     6.用户可以调用isDogEmpty方法，检查队列中是否还有Dog类的实例；
 *     7.用户可以调用isCatEmpty方法，检查队列中是否还有Cat类的实例；
 */
public class PetQueue {
    private static Queue<Pet> queue = new LinkedList<>();

    /**
     * 入队
     * @param pet
     * @return
     */
    public boolean add(Pet pet){
        return queue.add(pet);
    }

    /**
     * 全部出队
     */
    public void pollAll(){
        while (!queue.isEmpty()){
            queue.poll();
        }
    }

    /**
     * Dog全部出队
     */
    public void pollDog(){
        Queue<Pet> help = new LinkedList<>();
        int len = queue.size();
        for (int i = 0; i < len ; i++) {
            if(queue.peek() instanceof Dog){
                queue.poll();
            }else {
                help.add(queue.poll());
            }
        }
        while (!help.isEmpty()){
            queue.add(help.poll());
        }
    }
    /**
     * Cat全部出队
     */
    public void pollCat(){
        Queue<Pet> help = new LinkedList<>();
        int len = queue.size();
        for (int i = 0; i < len  ; i++) {
            if(queue.peek() instanceof Cat){
                queue.poll();
            }else {
                help.add(queue.poll());
            }
        }
        while (!help.isEmpty()){
            queue.add(help.poll());
        }
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * Dog是否为空
     * @return
     */
    public boolean isDogEmpty(){
      Queue<Pet> help = CopyQueue(queue);;
      while (!help.isEmpty()){
          if(help.poll() instanceof Dog){
              return false;
          }
      }
      return true;
    }

    /**
     * Cat是否为空
     * @return
     */
    public boolean isCatEmpty(){
        Queue<Pet> help = CopyQueue(queue);
        while (!help.isEmpty()){
            if(help.poll() instanceof Cat){
                return false;
            }
        }
        return true;
    }

    private Queue<Pet> CopyQueue(Queue<Pet> queue){
        Queue<Pet> copyQueue = new LinkedList<>();
        Queue<Pet> help = new LinkedList<>();
        while (!queue.isEmpty()){
            Pet pet = queue.poll();
            copyQueue.add(pet);
            help.add(pet);
        }
        while (!help.isEmpty()){
            queue.add(help.poll());
        }
        return copyQueue;
    }


    public static class Pet{
        private String type;
        public Pet(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
    }

    public static class Cat extends Pet{
        public Cat() {
            super("Cat");
        }
    }

    public static class Dog extends Pet{
        public Dog() {
            super("Dog");
        }
    }

    public static void main(String[] args) {
        PetQueue petQueue = new PetQueue();
        petQueue.add(new Cat());
        petQueue.add(new Cat());
        System.out.println("入队两个cat");
        System.out.println("队列是否无猫："+petQueue.isCatEmpty());
        System.out.println("队列是否无狗："+petQueue.isDogEmpty());
        System.out.println("入队一个dog");
        petQueue.add(new Dog());
        System.out.println("cat全部出队");
        petQueue.pollCat();
        System.out.println("队列是否无猫："+petQueue.isCatEmpty());
        System.out.println("队列是否无狗："+petQueue.isDogEmpty());
        System.out.println("dog全部出队");
        petQueue.pollDog();
        System.out.println("队列是否无猫："+petQueue.isCatEmpty());
        System.out.println("队列是否无狗："+petQueue.isDogEmpty());
        System.out.println("入队一个cat和一个狗");
        petQueue.add(new Cat());
        petQueue.add(new Dog());
        System.out.println("pet全部出队");
        petQueue.pollAll();
        System.out.println("队列是否无宠物："+petQueue.isEmpty());

    }
}

