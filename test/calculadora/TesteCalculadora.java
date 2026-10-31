package calculadora;

public class TesteCalculadora {

    static int total = 0;
    static int aprovados = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("===== TESTES DA CALCULADORA =====");

        testar(calc, "Soma", 2, 3, "+", 5);
        testar(calc, "Subtração", 10, 4, "-", 6);
        testar(calc, "Multiplicação", 3, 5, "*", 15);
        testar(calc, "Divisão", 8, 2, "/", 4);
        testar(calc, "Divisão por zero", 8, 0, "/", 0);
        testar(calc, "Operação inválida", 5, 5, "x", 0);

        System.out.println();
        System.out.println("Resultado final: " + aprovados + " de " + total + " testes aprovados");
    }

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