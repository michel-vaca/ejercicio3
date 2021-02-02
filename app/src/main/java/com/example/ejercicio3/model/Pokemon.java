package com.example.ejercicio3.model;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private long id;
    private String name;
    private String url;
    private String numero;
    private String experiencia_base;
    private String altura;
    private String peso;
    private String tipo;

    public Pokemon(long id, String name, String url, String numero) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.numero = numero;
    }

    public Pokemon(long id, String name, String url, String numero, String experiencia_base, String altura, String peso, String tipo) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.numero = numero;
        this.experiencia_base = experiencia_base;
        this.altura = altura;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = name;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExperiencia_base() {
        return experiencia_base;
    }

    public void setExperiencia_base(String experiencia_base) {
        this.experiencia_base = experiencia_base;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
