package api.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class MainAntigoVerboso {

    public static void main(String[] args) {

        List<Empregado> empregados = new ArrayList<Empregado>();
        empregados.add(new Empregado(1, "Joao", 2000, "Producao"));
        empregados.add(new Empregado(2, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));

        System.out.println("For comum");
        System.out.println(" ** LISTA DE EMPREGADOS: ** ");
        for (Empregado emp : empregados) {
            System.out.println(emp.getNome());
        }

        double salarioTotal = 0;
        for (Empregado emp : empregados) {
            salarioTotal = salarioTotal + emp.getSalario();
        }
        System.out.println("Salário total: R$ " + salarioTotal);

        System.out.println("\nFor stream");
        System.out.println(" ** LISTA DE EMPREGADOS: ** ");
        empregados.stream().forEach(emp -> {
            System.out.println(emp.getNome());
        });
        double salarioTotal2 = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();
        System.out.println("Salário total: R$ " + salarioTotal2);

        // Consumer
        System.out.println("Consumer - entra parâmetro e não retorna nada:");
        Consumer<Empregado> consumer = (emp) -> {
            System.out.println(emp.getNome() + ", R$ " + String.format("%.2f",emp.getSalario()));
        };
        consumer.accept(new Empregado(10, "TreinaWeb", 1000, "Educação"));

        // Function
        System.out.println("Function:");
        Function<Empregado, Double> function = (emp) -> emp.getSalario() * 10;
        double novoSalario = function.apply(new Empregado(100, "TreinaWeb10", 2000, "Educação"));
        System.out.println(novoSalario);

        // BinaryOperator
        System.out.println("BinaryOperator:");
        BinaryOperator<Empregado> binaryOperator = (emp1, emp2) -> new Empregado(
                -1, emp1.getNome() + emp2.getNome(),
                emp1.getSalario() + emp2.getSalario(),
                emp1.getDepartamento() + emp2. getDepartamento());
        Empregado novoEmpregado = binaryOperator.apply(new Empregado(
                0, "Treima",
                1000,
                "Depa"), new Empregado(
                        0,
                        "Web",
                        500,
                        "rtamento"
        ));
        System.out.println(novoEmpregado.getNome() + ", R$ " + novoEmpregado.getSalario()
                + ", Departamento: " + novoEmpregado.getDepartamento());

        // Predicate
        System.out.println("Predicate:");
        Predicate<Empregado> predicate = (emp) -> emp.getNome().endsWith("Web");
        boolean ternaComWeb = predicate.test(new Empregado(0, "TreinaWeb", 0, ""));
        System.out.println(ternaComWeb);

        // Supplier
        System.out.println("Supplier: ");
        Supplier<Empregado> supplier = () -> new Empregado(
                new Random().nextInt(),
                "TreinaWeb",
                0,
                "Departamnto");
        Empregado emp1 = supplier.get();
        System.out.println(emp1.getId());
        Empregado emp2 = supplier.get();
        System.out.println(emp2.getId());
    }
}
