package api.stream.desafios.lambda;

import java.io.*;
import java.util.*;
import java.util.function.*;

public class DesafioLambdaPredicate {

    public static void main(String[] args) throws IOException {
        Matematica mt = new Matematica();
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String resposta = "";
        Function<Integer, Boolean> funcao;
        boolean ret;
        for(int i = 0; i < T; i++){
            int ch = sc.nextInt();
            int num = sc.nextInt();
            if (ch == 1) {
                funcao = mt.isImpar();
                ret = mt.checker(funcao, num);
                resposta = (ret) ? "Ímpar" : "Par";
            } else if (ch == 2) {
                funcao = mt.isPrimo();
                ret = mt.checker(funcao, num);
                resposta = (ret) ? "Primo" : "Composto";
            } else if (ch == 3) {
                funcao = mt.isPalindromo();
                ret = mt.checker(funcao, num);
                resposta = (ret) ? "Palíndromo" : "Não é palíndromo";
            }
            System.out.println(resposta);
        }
    }
}

class Matematica {

    public boolean checker(Function<Integer, Boolean> p, int num) {
        return p.apply(num);
    }

    public Function<Integer, Boolean> isImpar() {
        return (num) -> num % 2 != 0;
    }

    public Function<Integer, Boolean> isPrimo() {
        return (num) -> {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        };
    }

    public Function<Integer, Boolean> isPalindromo() {
        return (num) -> {
            String texto = num.toString();
            String reverso = new StringBuilder(texto).reverse().toString();
            return texto.equals(reverso);
        };
    }
}
