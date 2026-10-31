package calculadora;

/**
 * Testes unitários da classe {@link Calculadora}.
 *
 * <p>Para cada teste são exibidos a entrada, o resultado esperado,
 * o resultado obtido e se o teste passou ou falhou.</p>
 *
 * @author Caique Pereira da Silva
 * @version 2.0
 */
public class TesteCalculadora {

    /** Quantidade de testes executados. */
    static int total = 0;

    /** Quantidade de testes aprovados. */
    static int aprovados = 0;

    /**
     * Construtor padrão (a classe é usada apenas pelo método main).
     */
    public TesteCalculadora() {
    }

    /**
     * Executa todos os testes da calculadora.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("===== TESTES DA CALCULADORA =====");

        testar(calc, "Soma", 2, 3, "+", 5);
        testar(calc, "Subtração", 10, 4, "-", 6);
        testar(calc, "Multiplicação", 3, 5, "*", 15);
        testar(calc, "Divisão", 8, 2, "/", 4);
        testar(calc, "Divisão por zero", 8, 0, "/", 0);
        testar(calc, "Operação inválida", 5, 5, "x", 0);
        testar(calc, "Operação nula", 5, 5, null, 0);

        System.out.println();
        System.out.println("Resultado final: " + aprovados + " de " + total + " testes aprovados");
    }

    /**
     * Executa um teste e compara o resultado obtido com o esperado.
     *
     * @param calc calculadora que será testada
     * @param nome nome do teste
     * @param a primeiro número
     * @param b segundo número
     * @param op operador da operação
     * @param esperado resultado esperado
     */
    static void testar(Calculadora calc, String nome, int a, int b, String op, int esperado) {
        total++;
        System.out.println();
        System.out.println("Teste " + total + ": " + nome);
        System.out.println("Entrada: a = " + a + ", b = " + b + ", operação = " + op);

        int obtido = calc.calc(a, b, op);

        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido: " + obtido);

        if (obtido == esperado) {
            aprovados++;
            System.out.println("Situação: PASSOU");
        } else {
            System.out.println("Situação: FALHOU");
        }
    }
}