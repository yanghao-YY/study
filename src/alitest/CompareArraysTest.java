package alitest;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class CompareArraysTest {
    public static void main(String[] args) {
//        Integer[] a = {1,2,3,4,5,6};
//        Integer[] b = {6,5,4,3,2,1};
        Student[] a = {
                  new Student(12L,"YangHao",12),
                  new Student(13L,"BOb",13),
                  new Student(14L,"Tim",14),
                  new Student(15L,"Tom",15),
                  new Student(16L,"June",16),
          };
        Student[] b = {
                new Student(16L,"June",16),
                new Student(12L,"YangHao",12),
                new Student(13L,"BOb",13),
                new Student(14L,"Tim",14),
                new Student(15L,"Tom",15),
        };
        Student[] c = {
                new Student(14L,"YangHao",12),
                new Student(13L,"BOb",13),
                new Student(16L,"Tim",14),
                new Student(15L,"Tom",15),
                new Student(19L,"June",16),
        };
        System.out.println(a == b);
        System.out.println(CompareArrays.compareTo(a,b));
    }
}
