package main;

import java.util.Observable;

public class Distribuidora extends Observable {
    private String descricao;
    private String genero;
    private String nome;

    public Distribuidora(String descricao, String genero, String nome) {
        this.descricao = descricao;
        this.genero = genero;
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void lancarFilme(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "{nome: '"+ nome +"'"+
                ", genero: '"+ genero +"'"+
                ", descricao: '"+ descricao +"'"+
                "}";
    }
}
