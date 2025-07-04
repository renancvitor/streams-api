package api.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Empregado> empregados = new ArrayList<Empregado>();
        empregados.add(new Empregado(1, "Joao", 2000, "Producao"));
        empregados.add(new Empregado(2, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));

        System.out.println("*** Funcionários que começam com J ***");
        empregados.stream()
                .filter( n -> n.getNome().startsWith("J"))
                .forEach(n -> System.out.println(n.getNome()));

        List<Empregado> empregadosComJ = empregados
                .stream()
                .collect(Collectors.toList());
        empregadosComJ
                .stream()
                .forEach((emp) ->
                        System.out.println(emp.getNome()));
        OptionalDouble menorSalario = empregadosComJ
                .stream()
                .mapToDouble((emp) ->
                        emp.getSalario()).min();
        if (menorSalario.isPresent()) {
            System.out.println("Menor salãrio: R$ " + String.format("%.2f" ,
                    menorSalario.getAsDouble()));
        }
    }
}
