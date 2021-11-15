package com.m2.medivali.consulta;

public class Consulta implements java.io.Serializable {

private int id;
private String data_hora_inicio;
private String data_hora_fim;
private String observacao;

    public Consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_hora_inicio() {
        return data_hora_inicio;
    }

    public void setData_hora_inicio(String data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public String getData_hora_fim() {
        return data_hora_fim;
    }

    public void setData_hora_fim(String data_hora_fim) {
        this.data_hora_fim = data_hora_fim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
