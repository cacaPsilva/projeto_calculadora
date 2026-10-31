package calculadora;

public class Calculadora {

    public static final String MENSAGEM_DIVISAO_POR_ZERO = "Erro: divisao por zero, operação irregular";

    public static final String MENSAGEM_OPERACAO_INVALIDA = "Operacao invalida";

    private int resultado = 0;

    public int calc(int a, int b, String op) {
        try {
            resultado = executarOperacao(a, b, op);
        } catch (ArithmeticException | IllegalArgumentException erro) {
            // O erro é tratado aqui para o programa continuar executando
            System.out.println(erro.getMessage());
            resultado = 0;
        }

        System.out.println("Resultado = " + resultado);
        return resultado;
    }

    public int getResultado() {
        return resultado;
    }

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException(MENSAGEM_DIVISAO_POR_ZERO);
        }
        return a / b;
    }

    private int executarOperacao(int a, int b, String op) {
        // Operador nulo também é considerado inválido
        if (op == null) {
            throw new IllegalArgumentException(MENSAGEM_OPERACAO_INVALIDA);
        }

        return switch (op) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException(MENSAGEM_OPERACAO_INVALIDA);
        };
    }
}