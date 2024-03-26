import java.util.SortedMap;
import java.util.TreeMap;

public class Fibonacci {
    private final SortedMap<Integer, Long> storedFibonacci;
    private int recursion_counter;

    public Fibonacci() {
        recursion_counter = 0;
        storedFibonacci = new TreeMap<>();
        storedFibonacci.put(0, 0L);
    }

    public Long getFibonacci(int num) {
        recursion_counter = 0;
        if (!storedFibonacci.containsKey(num)) {
            int last;
            for (last = storedFibonacci.lastKey() + 1; last <= num; last++) {
                storedFibonacci.put(last, calcFibonacci(last));
            }
        }
        return storedFibonacci.get(num);
    }


    private long calcFibonacci(int num) {
        recursion_counter++;
        if (num <= 1) return 1;
        Long num1 = storedFibonacci.containsKey(num -  2) ? storedFibonacci.get(num - 2) : calcFibonacci(num - 2);
        Long num2 = storedFibonacci.containsKey(num -  1) ? storedFibonacci.get(num - 1) : calcFibonacci(num - 1);
        return num1 + num2;
    }

    public void printSequence(int num) {
        for (int i = 0; i <= num; i++) {
            System.out.printf("%dº = %d\n", i, storedFibonacci.get(i));
        }
        System.out.printf("Numero que o metodo calcFibonacci foi chamado: %d\n", recursion_counter);
    }

    public void printMemoizedSequence() {
        for (Integer key : storedFibonacci.keySet()) {
            System.out.printf("%dº = %d\n", key, storedFibonacci.get(key));
        }
    }


}
