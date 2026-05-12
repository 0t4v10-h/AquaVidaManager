package br.com.aquavida.model;

public class Peixe {

    private int id;

    private String nome;

    private String especie;

    private int quantidade;

    private int tanqueId;

    private String nomeTanque;

    private double pesoMedio;

    private double precoKg;

    public Peixe() {
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTanqueId() {
        return tanqueId;
    }

    public void setTanqueId(int tanqueId) {
        this.tanqueId = tanqueId;
    }

    public String getNomeTanque() {
        return nomeTanque;
    }

    public void setNomeTanque(String nomeTanque) {
        this.nomeTanque = nomeTanque;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void setPrecoKg(double precoKg) {
        this.precoKg = precoKg;
    }

    public double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

}