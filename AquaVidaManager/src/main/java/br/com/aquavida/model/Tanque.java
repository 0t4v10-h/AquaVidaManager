package br.com.aquavida.model;

public class Tanque {

    private int id;

    private String nome;

    private int capacidade;

    private double temperaturaIdeal;

    private double phIdeal;

    public Tanque() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(double temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public double getPhIdeal() {
        return phIdeal;
    }

    public void setPhIdeal(double phIdeal) {
        this.phIdeal = phIdeal;
    }

}