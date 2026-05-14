package br.com.aquavida.model;

import java.time.LocalDateTime;

public class ParametroAgua {

    private int id;

    private int tanqueId;

    private double temperatura;

    private double ph;

    private double amonia;

    private LocalDateTime dataMedicao;

    private String nomeTanque;

    private String statusGeral;

    private String classeCss;

    public ParametroAgua() {}

    public ParametroAgua(int tanqueId, double temperatura, double ph, double amonia) {
        this.tanqueId = tanqueId;
        this.temperatura = temperatura;
        this.ph = ph;
        this.amonia = amonia;
        this.dataMedicao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTanqueId() {
        return tanqueId;
    }

    public void setTanqueId(int tanqueId) {
        this.tanqueId = tanqueId;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAmonia() {
        return amonia;
    }

    public void setAmonia(double amonia) {
        this.amonia = amonia;
    }

    public LocalDateTime getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(LocalDateTime dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public String getStatusTemperatura(double ideal) {
        if (Math.abs(temperatura - ideal) <= 1.5) return "Normal";
        if (Math.abs(temperatura - ideal) <= 3) return "Atenção";
        return "Crítico";
    }

    public String getStatusPh(double ideal) {
        if (Math.abs(ph - ideal) <= 0.5) return "Normal";
        if (Math.abs(ph - ideal) <= 1.0) return "Atenção";
        return "Crítico";
    }

    public String getStatusAmonia() {
        if (amonia <= 0.5) return "Normal";
        if (amonia <= 1.0) return "Atenção";
        return "Crítico";
    }

    public String getNomeTanque() {
        return nomeTanque;
    }

    public void setNomeTanque(String nomeTanque) {
        this.nomeTanque = nomeTanque;
    }

    public String getStatusGeral() {
        return statusGeral;
    }

    public void setStatusGeral(String statusGeral) {
        this.statusGeral = statusGeral;
    }

    public String getClasseCss() {
        return classeCss;
    }

    public void setClasseCss(String classeCss) {
        this.classeCss = classeCss;
    }
}