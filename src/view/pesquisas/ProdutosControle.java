/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pesquisas;

import bean.Produtos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jmbvi
 */
public class ProdutosControle extends AbstractTableModel {
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    public Produtos getBean(int linha){
        return (Produtos) lista.get(linha);
    }
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. return
        Produtos produtos = (Produtos) lista.get(rowIndex);

        if (columnIndex == 0) {
            return produtos.getIdProdutos();
        }
        if (columnIndex == 1) {
            return produtos.getNome();
        }
        if (columnIndex == 2) {
            return produtos.getPreco();
        }
        if (columnIndex == 3) {
            return produtos.getMarca();
        }

        return "conteudo";
    }

    @Override
    public String getColumnName(int column) {
        //colocar o nome nos campos
        if (column == 0) {
            return "Id";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Preço";
        }
        if (column == 3) {
            return "Marca";
        }
        return "";
    }
}
