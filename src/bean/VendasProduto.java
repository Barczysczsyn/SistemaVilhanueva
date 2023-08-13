/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jmbvi
 */
public class VendasProduto {

    private int idVendasProduto;
    private int fkVendas;
    private int fkProduto;
    private double valor_Unitario;
    private int quantidade;
    /**
     * @return the idVendasProduto
     */
    public int getIdVendasProduto() {
        return idVendasProduto;
    }

    /**
     * @param idVendasProduto the idVendasProduto to set
     */
    public void setIdVendasProduto(int idVendasProduto) {
        this.idVendasProduto = idVendasProduto;
    }

    /**
     * @return the fkVendas
     */
    public int getFkVendas() {
        return fkVendas;
    }

    /**
     * @param fkVendas the fkVendas to set
     */
    public void setFkVendas(int fkVendas) {
        this.fkVendas = fkVendas;
    }

    /**
     * @return the fkProduto
     */
    public int getFkProduto() {
        return fkProduto;
    }

    /**
     * @param fkProduto the fkProduto to set
     */
    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    /**
     * @return the valor_Unitario
     */
    public double getValor_Unitario() {
        return valor_Unitario;
    }

    /**
     * @param valor_Unitario the valor_Unitario to set
     */
    public void setValor_Unitario(double valor_Unitario) {
        this.valor_Unitario = valor_Unitario;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
