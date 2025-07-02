package api.stream.desafios.foreach;

import java.util.*;
import java.util.stream.*;

public class DesafioStreamSort {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        while(sc.hasNext()){
            pessoas.add(new Pessoa(sc.next(), sc.nextInt()));
        }

        OptionalInt idade =  filtro(pessoas.stream());
        if(idade.isPresent())
            System.out.println(idade.getAsInt());
    }

    static OptionalInt filtro(Stream<Pessoa> stream) {
        return stream
                .sorted(Comparator.comparingInt(Pessoa::getIdade).reversed())
                .mapToInt(Pessoa::getIdade)
                .findFirst();
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
