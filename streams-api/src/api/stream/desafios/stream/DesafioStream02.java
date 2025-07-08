package api.stream.desafios.stream;

import java.util.*;
import java.util.stream.*;

public class DesafioStream02 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        List<Animal> animais = new ArrayList<Animal>();
        while(sc.hasNext()){
            animais.add(new Animal(sc.next(), sc.next()));
        }

        Stream<Animal> stream = animais.stream();

        filtro(stream).forEach(System.out::println);
    }

    //Informe seu código aqui
    static List<String> filtro(Stream<Animal> animais) {
        return animais
                .filter(a -> a.getEspecie().equals("Gato"))
                .map(a -> a.getNome())
                .toList();
}

class Animal {
    private String nome;
    private String especie;

    public Animal(String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }
}
