package api.stream.desafios.foreach;

import java.util.*;
import java.util.stream.Collectors;

public class DesafioForEach {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        while(sc.hasNext()){
            pessoas.add(new Pessoa(sc.next(), sc.nextInt()));
        }

        List<Pessoa> maioresDeIdade = pessoas.stream()
                .filter(p -> p.getIdade() >= 18)
                .toList();

        maioresDeIdade.forEach(pessoa ->
                System.out.println(pessoa.getNome()));


    }
}

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade)
    {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome()
    {
        return nome;
    }

    public int getIdade()
    {
        return idade;
    }
}
