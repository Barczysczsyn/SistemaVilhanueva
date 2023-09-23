/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pesquisas;

import bean.ProdutosJmbv;
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
        //System.out.println("setlist");
        //atualizar
        this.fireTableDataChanged();
    }
    public ProdutosJmbv getBean(int linha){
        //System.out.println("getbean");
        return (ProdutosJmbv) lista.get(linha);
    }
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("rowcount");
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("columncount");
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. return
        ProdutosJmbv produtos = (ProdutosJmbv) lista.get(rowIndex);
        //System.out.println("getvalueat" + rowIndex + "e" + columnIndex);

        if (columnIndex == 0) {
            return produtos.getIdprodutosJmbv();
        }
        if (columnIndex == 1) {
            return produtos.getNomeJmbv();
        }
        if (columnIndex == 2) {
            return produtos.getPrecoJmbv();
        }
        if (columnIndex == 3) {
            return produtos.getMarcaJmbv();
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
