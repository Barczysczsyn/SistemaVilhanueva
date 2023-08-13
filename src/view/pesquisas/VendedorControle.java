/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pesquisas;

import bean.Vendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jmbvi
 */
public class VendedorControle extends AbstractTableModel {
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    public Vendedor getBean(int linha){
        return (Vendedor) lista.get(linha);
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
        Vendedor vendedor = (Vendedor) lista.get(rowIndex);

        if (columnIndex == 0) {
            return vendedor.getIdVendedor();
        }
        if (columnIndex == 1) {
            return vendedor.getNome();
        }
        if (columnIndex == 2) {
            return vendedor.getCpf();
        }
        if (columnIndex == 3) {
            return vendedor.getCelular();
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
            return "CPF";
        }
        if (column == 3) {
            return "Celular";
        }
        return "";
    }
}
