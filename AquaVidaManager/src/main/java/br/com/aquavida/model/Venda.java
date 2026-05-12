package br.com.aquavida.model;

import java.sql.Timestamp;

public class Venda {

    private int id;
    private int peixeId;
    private int quantidade;
    private double valorTotal;
    private Timestamp dataVenda;
    private String nomePeixe;

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeixeId() {
        return peixeId;
    }

    public void setPeixeId(int peixeId) {
        this.peixeId = peixeId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Timestamp dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomePeixe() {
        return nomePeixe;
    }

    public void setNomePeixe(String nomePeixe) {
        this.nomePeixe = nomePeixe;
    }
}