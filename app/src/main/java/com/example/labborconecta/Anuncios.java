package com.example.labborconecta;

public class Anuncios {
    private long id;
    private String nome;
    private String telefone;
    private String ramo;
    private String corpo;

    public Anuncios(String nome, String telefone, String ramo, String corpo) {
        this.nome = nome;
        this.telefone = telefone;
        this.ramo = ramo;
        this.corpo = corpo;
    }
    public Anuncios(){

    }

    public Anuncios(long id, String nome, String telefone, String corpo) {
    }

    public Anuncios(long id, String nome, String telefone, String ramo, String corpo) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
