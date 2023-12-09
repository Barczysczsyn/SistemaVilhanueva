/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pesquisas;

import bean.VendasProdutoJmbv;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jmbvi
 */
public class VendasProdutoControle extends AbstractTableModel {
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    public VendasProdutoJmbv getBean(int linha){
        return (VendasProdutoJmbv) lista.get(linha);
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
        VendasProdutoJmbv vendasproduto = (VendasProdutoJmbv) lista.get(rowIndex);

        
        if (columnIndex == 0) {
            return vendasproduto.getProdutosJmbv();
        }
        if (columnIndex == 1) {
            return vendasproduto.getValorUnitarioJmbv();
        }
        if (columnIndex == 2) {
            return vendasproduto.getQuantidadeJmbv();
        }
        if (columnIndex == 3) {
            double total = vendasproduto.getQuantidadeJmbv() * vendasproduto.getValorUnitarioJmbv();
            return total;
        }

        return "conteudo";
    }
    public void addBean(VendasProdutoJmbv vendasprod){
        lista.add(vendasprod);
        this.fireTableDataChanged();
    }
    public void updateBean(int index,VendasProdutoJmbv vendasprod){
        lista.set(index, vendasprod);
        this.fireTableDataChanged();
    }
    public void removeBean(int index){
        lista.remove(index);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        //colocar o nome nos campos
        if (column == 0) {
            return "Produto";
        }
        if (column == 1) {
            return "Valor Unitário";
        }
        if (column == 2) {
            return "Quantidade";
        }
        if (column == 3) {
            return "Total";
        }
        return "";
    }
}
