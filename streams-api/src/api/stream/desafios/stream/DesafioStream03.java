package api.stream.desafios.stream;

import api.stream.desafios.foreach.PessoaX;

import java.util.*;
import java.util.stream.*;

public class DesafioStream03 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<PessoaX> pessoas = new ArrayList<PessoaX>();
        while(sc.hasNext()){
            pessoas.add(new PessoaX(sc.next(), sc.nextInt()));
        }

        System.out.println(transformacao(pessoas.stream()));
    }

    //Informe seu código aqui
    static List<String> transformacao(Stream<PessoaX> pessoas) {
        List<String> nomes = pessoas.map(PessoaX::getNome)
                .collect(Collectors.toList());

        nomes.forEach(nome -> System.out.print(nome + " "));
        System.out.println();

        return nomes;
    }
    //Informe seu código aqui

}

class PessoaX {
    private String nome;
    private int idade;

    public PessoaX(String nome, int idade)
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
