package br.org.base.model;

import java.io.Serializable;
import java.util.Date;



public class ItemCompra extends Item implements Serializable{

    private String localizacao;
    private String fornecedor;
    private Date validade;
    private float valor;
    private float valorPor;
    private int quantidade;
    private String lote;


    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValorPor() {
        return valorPor;
    }

    public void setValorPor(float valorPor) {
        this.valorPor = valorPor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
