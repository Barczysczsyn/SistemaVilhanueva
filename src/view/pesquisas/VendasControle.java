/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pesquisas;

import bean.Vendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jmbvi
 */
public class VendasControle extends AbstractTableModel {
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    public Vendas getBean(int linha){
        return (Vendas) lista.get(linha);
    }
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. return
        Vendas vendas = (Vendas) lista.get(rowIndex);

        if (columnIndex == 0) {
            return vendas.getIdVendas();
        }
        if (columnIndex == 1) {
            return vendas.getData();
        }
        if (columnIndex == 2) {
            return vendas.getCliente();
        }
        if (columnIndex == 3) {
            return vendas.getVendedor();
        }
        if (columnIndex == 4) {
            return vendas.getValor_total();
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
            return "Data";
        }
        if (column == 2) {
            return "Cliente";
        }
        if (column == 3) {
            return "Vendedor";
        }
        if (column == 4) {
            return "Valor Total";
        }
        return "";
    }
}
