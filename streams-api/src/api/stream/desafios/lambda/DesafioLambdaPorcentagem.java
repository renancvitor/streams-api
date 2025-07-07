package api.stream.desafios.lambda;

import java.util.*;
import java.util.function.Function;

class DesafioLambdaProcentagem {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<Produto>();
        while(sc.hasNext()){
            produtos.add(new Produto(sc.next(), sc.nextDouble()));
        }

        ControleEstoque controle = new ControleEstoque();

        for(Produto p : produtos)
        {
            Estoque infracao = controle.inflacao();
            Estoque promocao = controle.promocao();
            System.out.println(controle.correcao(infracao, p));
            System.out.println(controle.correcao(promocao, p));
        }
    }
}

interface Estoque {
    Produto operacao(Produto p);
}

class ControleEstoque
{
    public Produto correcao(Estoque e, Produto p)
    {
        return e.operacao(p);
    }

    public Estoque inflacao() {
        return (prod) -> {
            double novoPreco = prod.getPreco() + prod.getPreco() * 0.1;
            Produto novoProduto = new Produto(prod.getNome(), novoPreco);
            return novoProduto;
        };
    }

    public Estoque promocao() {
        return (prod) -> {
            Produto produtoInflacionado = inflacao().operacao(prod);
            double novoPreco = produtoInflacionado.getPreco() - produtoInflacionado.getPreco() * 0.23;
            return new Produto(prod.getNome(), novoPreco);
        };
    }
}

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome()
    {
        return nome;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public double getPreco()
    {
        return preco;
    }

    public String toString()
    {
        return String.format("%s - R$ %5.2f", nome, preco);
    }
}
