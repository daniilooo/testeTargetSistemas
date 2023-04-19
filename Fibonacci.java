import javax.swing.JOptionPane;

public class Fibonacci {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo:"));
        int fib1 = 0, fib2 = 1, fib3 = 0;
        boolean pertence = false;

        while (fib3 < num) {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }

        if (fib3 == num) {
            pertence = true;
        }

        String mensagem = pertence ? "O número " + num + " pertence à sequência de Fibonacci." :
                                      "O número " + num + " não pertence à sequência de Fibonacci.";
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
