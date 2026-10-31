package calculadora;

/**
 * Calculadora do aplicativo FinançApp.
 *
 * <p>Realiza as quatro operações matemáticas básicas (soma, subtração,
 * multiplicação e divisão) a partir de um operador informado.</p>
 *
 * <p>Erros como divisão por zero ou operador inválido não interrompem
 * o programa: uma mensagem é exibida e o resultado retornado é 0.</p>
 *
 * @author Caique Pereira da Silva
 * @version 2.0
 */
public class Calculadora {

    /** Mensagem exibida quando há tentativa de divisão por zero. */
    public static final String MENSAGEM_DIVISAO_POR_ZERO = "Erro: divisao por zero, operação irregular";

    /** Mensagem exibida quando o operador não é reconhecido. */
    public static final String MENSAGEM_OPERACAO_INVALIDA = "Operacao invalida";

    /** Resultado da última operação realizada (antigo atributo "r"). */
    private int resultado = 0;

    /**
     * Cria uma calculadora com resultado inicial igual a zero.
     */
    public Calculadora() {
    }

    /**
     * Executa a operação indicada pelo operador e exibe o resultado no console.
     *
     * <p>Operadores aceitos: "+", "-", "*" e "/".</p>
     *
     * @param a primeiro número
     * @param b segundo número
     * @param op operador da operação desejada
     * @return o resultado da operação, ou 0 em caso de erro
     */
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

    /**
     * Retorna o resultado da última operação realizada.
     *
     * @return o resultado da última operação
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * Soma dois números.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return a soma de a e b
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return o resultado de a - b
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return o resultado de a * b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número pelo segundo (divisão inteira).
     *
     * @param a dividendo
     * @param b divisor, que não pode ser zero
     * @return o resultado inteiro de a / b
     * @throws ArithmeticException se o divisor for zero
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException(MENSAGEM_DIVISAO_POR_ZERO);
        }
        return a / b;
    }

    /**
     * Escolhe e executa a operação de acordo com o operador.
     *
     * @param a primeiro número
     * @param b segundo número
     * @param op operador da operação
     * @return o resultado da operação
     * @throws IllegalArgumentException se o operador for nulo ou inválido
     */
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