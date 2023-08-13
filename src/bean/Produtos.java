/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
/**
 *
 * @author jmbvi
 */
public class Produtos {
    private int idProdutos;
    private String nome;
    private double preco;
    private String marca;
    private Date validade;

    /**
     * @return the idProduto
     */
    public int getIdProdutos() {
        return idProdutos;
    }

    /**
     * @param idProdutos the idProduto to set
     */
    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }
    
    //combobox
    @Override
    public String toString(){
        return getNome() + " - " + getPreco();
    }
}
