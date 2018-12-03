package sort;

import pojo.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Comparator
 * @Created by zgw
 * @Date 2018-11-27 21:16
 * @Description 比较器
 */
public class MyComparator {

    /**
     * 比较器
     * 升序，从小到大
     */
    public static class IdAscendingComparator implements Comparator<Student> {

        /**
         *
         * @param o1
         * @param o2
         * @return
         *
         * 如果o1.id - o2.id 小于0 ,o1放前边
         * 如果o1.id - o2.id 大于0 ,o2放前边
         * 如果o1.id - o2.id 等于0 ,保持不变
         */
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    /**
     * 比较器
     * 降序，从大到小
     */
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }

    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

        //IdAscendingComparator以id小的放前边，即最小堆
        PriorityQueue<Student> heap=new PriorityQueue<>(new IdAscendingComparator());
        heap.add(student1);
        heap.add(student2);
        heap.add(student3);
        while (!heap.isEmpty()){
            //堆顶
            Student student=heap.poll();
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }
}
