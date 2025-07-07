package api.stream.desafios.stream;

import java.util.*;
import java.util.stream.*;

public class DesafioStream01 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        List<Produto01> produtos = new ArrayList<Produto01>();
        while(sc.hasNext()){
            produtos.add(new Produto01(sc.next(), sc.nextDouble(), sc.nextInt()));
        }

        Stream<Produto01> stream = produtos.stream();

        filtro(stream).stream().forEach(p -> System.out.println(p.getNome()));;
    }

//Informe seu código aqui
    static List<Produto01> filtro(Stream<Produto01> produtos) {
        return produtos
                .filter(prod -> prod.getQuantidade() <= 0)
                .toList();
    }

}

class Produto01 {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto01(String nome, double preco, int quantidade)
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
