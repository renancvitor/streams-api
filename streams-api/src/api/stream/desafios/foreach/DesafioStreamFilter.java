package api.stream.desafios.foreach;

import java.util.*;

public class DesafioStreamFilter {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<Pessoa1> pessoas = new ArrayList<Pessoa1>();
        while(sc.hasNext()){
            pessoas.add(new Pessoa1(sc.next(), sc.nextInt()));
        }

        List<Pessoa1> maioresDeIdade = pessoas.stream()
                .filter(p -> p.getIdade() >= 18)
                .toList();

        maioresDeIdade.forEach(pessoa ->
                System.out.println(pessoa.getNome()));


    }
}

class Pessoa1 {
    private String nome;
    private int idade;

    public Pessoa1(String nome, int idade)
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
