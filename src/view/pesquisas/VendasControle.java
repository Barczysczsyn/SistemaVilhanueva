/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pesquisas;

import bean.VendasJmbv;
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
    public VendasJmbv getBean(int linha){
        return (VendasJmbv) lista.get(linha);
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
        VendasJmbv vendas = (VendasJmbv) lista.get(rowIndex);

        if (columnIndex == 0) {
            return vendas.getIdvendasJmbv();
        }
        if (columnIndex == 1) {
            return vendas.getDataJmbv();
        }
        if (columnIndex == 2) {
            return vendas.getClientesJmbv();
        }
        if (columnIndex == 3) {
            return vendas.getVendedorJmbv();
        }
        if (columnIndex == 4) {
            return vendas.getValorTotalJmbv();
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
