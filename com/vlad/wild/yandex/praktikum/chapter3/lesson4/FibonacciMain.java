package vlad.wild.yandex.praktikum.chapter3.lesson4;

public class FibonacciMain {

    public static void main(String[] args) {
        //рекурсия
        int function = function(9);
        System.out.println(function);

        //итеративное решение
        int fibonacci = fibonacci(9);
        System.out.println(fibonacci);
    }

    public static int function(int n) {
        if (n <= 1) {
            return n;
        }

        return function(n - 1) + function(n - 2);
    }

    /**
     *
     *      0     |     1     |     1     |
     *   previous |  current  |   next    |
     *
     *   Сначала надо вычислить 3-е число -> next
     *   И только потом пересчитать previous и current
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }
}
