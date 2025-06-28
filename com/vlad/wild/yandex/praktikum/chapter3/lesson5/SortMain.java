package vlad.wild.yandex.praktikum.chapter3.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * №  Сортировка         Время работы в среднем/худшем     Затраты по памяти в среднем/худшем
 * 1. Быстрая	          O(nlogn)/O(n2)	                O(logn)/O(n)
 * 2. Слиянием	          O(nlogn)/O(nlogn)	                O(n)/O(n)
 * 3. Вставками           O(n2)/O(n2)	                    O(1)/O(1)
 * 4. Пирамидальная       O(nlogn)/O(nlogn)	                O(1)/O(1)
 */
public class SortMain {

    public static void main(String[] args) {
        int[] ints = {4, 1, 5, 9, 1, 0, -1};
        Arrays.sort(ints); // для примитивных типов быстрая сортировка
        System.out.println(Arrays.toString(ints));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(20, "Igor"));
        persons.add(new Person(34, "Kate"));
        persons.add(new Person(18, "Sam"));
        persons.add(new Person(44, "Ira"));
        List<Person> list = persons.stream().sorted().toList(); // для объектов сортировка слиянием
        System.out.println(list);
    }

    public static class Person implements Comparable<Person> {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return age - o.age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
