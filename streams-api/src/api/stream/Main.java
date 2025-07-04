package api.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Empregado> empregados = new ArrayList<Empregado>();
        empregados.add(new Empregado(1, "Joao", 2000, "Producao"));
        empregados.add(new Empregado(1, "Marcelo", 5000, "Producao"));
        empregados.add(new Empregado(2, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));

        System.out.println("*** Funcionários que começam com J ***");
        empregados.stream()
                .filter( n -> n.getNome().startsWith("J"))
                .forEach(n -> System.out.println(n.getNome()));
        System.out.println("\n");

        // Stream ainda verboso:
        System.out.println("*** Stream ainda verboso: ***");
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
        DoubleSummaryStatistics sumary = empregados.stream()
                .collect(Collectors.summarizingDouble(Empregado::getSalario));
        System.out.println("Estatísticas do salário:");
        System.out.println("Maior salário: R$ " + String.format("%.2f", sumary.getMax()));
        System.out.println("Menor salário: R$ " + String.format("%.2f", sumary.getMin()));
        System.out.println("Salãrio médio: R$ " + String.format("%.2f", sumary.getAverage()));
        System.out.println("Folha salarial total: R$ " + String.format("%.2f", sumary.getSum()));
        System.out.println("\n");

        List<String> nomeEmpregados = empregados
                .stream()
                        .map(emp -> emp.getNome())
                                .collect(Collectors.toList());
        System.out.println("** Nomes dos empregados: **");
        nomeEmpregados.forEach(System.out::println);
        System.out.println("\n");

        String nomesSeparadosPorVirgula = empregados
                .stream()
                        .map(Empregado::getNome)
                        .reduce("Nomes dos empregados: ", (n1, n2) -> n1 + n2 + ", ");
        System.out.println(nomesSeparadosPorVirgula);
        System.out.println("\n");

        Map<String, List<Empregado>> dadosDepartamento = empregados
                .stream()                               //Empregado::getDepartamento()
                .collect(Collectors.groupingBy(emp -> emp.getDepartamento()));
        System.out.println(" ** Empregados por departamento: ** ");
        dadosDepartamento.forEach((dep, emps) -> {
            System.out.println(" - " + dep + ", " + emps.size() + " funcionários.");
            emps.forEach(emp -> {
                System.out.println("    * " + emp.getNome());
            });
        });
        System.out.println("\n");

        // Stream pipelines
        System.out.println("*** Stream pipelines: ***");
        List<Empregado> empregadoComJ = empregados
                .stream()
                .filter((emp) -> emp.getNome().startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("\n");

        // Exemplo prático LAZYYING LOADING
        System.out.println("### *** ### *** ###");
        System.out.println("** Funcionários que começam com: **");
        Stream<Empregado> stream = empregados
                .stream()
                .filter(emp -> {
                    System.out.println("*** Invocando o filter: ***");
                    return emp.getNome().startsWith("J");
                });
        System.out.println("** A conversão para lista será invocada: **");
        List<Empregado> empregadosLazyingLoading = stream
                .collect(Collectors.toList());
        System.out.println(empregadosLazyingLoading);
    }
}
