/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbax.hackerrank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcelo Lima Baxauli <mlb122@hotmail.com>
 */

@Entity
@Table(name="TB_ENDERECO")
public class Endereco {
    
    @Id
    private int id;
    
    @Column(name="RUA")
    private String rua;

    @Column(name="NUMERO")
    private int numero;

    @Column(name="CEP")
    private String cep;

    @Column(name="CIDADE")    
    private String cidade;

    @Column(name="ESTADO")
    private String estado;

    @Column(name="BAIRRO")
    private String bairro;

    @Column(name="COMPLEMENTO")
    private String complemento;

    public Endereco() {
    }

    public Endereco(int id, String rua, int numero, String cep, String cidade, String estado, String bairro, String complemento) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + ", bairro=" + bairro + ", complemento=" + complemento + '}';
    }
    
    
}
