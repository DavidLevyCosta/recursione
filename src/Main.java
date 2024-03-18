import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();

        while (true) {
            System.out.print("Digite um número inteiro (digite '0' para sair): ");
            int num;
            try {num = input.nextInt();}
            catch (Exception e) {
                System.out.println("Digite um número válido!");
                input.nextLine();
                continue;
            }
            if (num == 0) break;
            if (num < 0) fibonacci.printMemoizedSequence();
            else {
                System.out.printf("o %dº numero na sequencia de fibonacci e: %d\n", num, fibonacci.getFibonacci(num));
                fibonacci.printSequence(num);
            }


        }
    }

}
