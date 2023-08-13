/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.Vendas;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmbvi
 */
public class Vendas_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {//veio de Vendas
        Vendas vendas = (Vendas) object;//o Vendas se converte em object
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {//clique na lampada do lado/ circundar instrucao com try catch
            String sql = "insert into vendas values(?,?,?,?,?)";
            System.out.println("as interrogacoes");
            PreparedStatement pstm = cnt.prepareStatement(sql);
            //pstm.setDate(5, (Date) Vendas.getDataNascimento());
            pstm.setInt(1, vendas.getIdVendas());
            //pstm.setDate(2, new Date(2001,1,1));
            pstm.setDate(2, new java.sql.Date(vendas.getData().getTime()));//tudo as conversoes
            pstm.setInt(3, vendas.getCliente());
            pstm.setInt(4, vendas.getVendedor());
            pstm.setDouble(5, vendas.getValor_total());
            //cnt = DriverManager.getConnection(url,user,password);

            System.out.println("passou");
            pstm.executeUpdate();
            System.out.println("executou");

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
        Vendas vendas = (Vendas) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {//clique na lampada do lado/ circundar instrucao com try catch
            String sql = "UPDATE vendas SET data = ?,cliente = ?,vendedor = ?,valortotal = ? where(idVendas = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            //pstm.setDate(1, new Date(2001,1,1));
            pstm.setDate(1, new java.sql.Date(vendas.getData().getTime()));//tudo as conversoes
            pstm.setInt(2, vendas.getCliente());
            pstm.setInt(3, vendas.getVendedor());
            pstm.setDouble(4, vendas.getValor_total());
            pstm.setInt(5, vendas.getIdVendas());

            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        //catch (ClassNotFoundException ex) {//bloco protegido, se der erro vai cair aqui
        //Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);//essa linha e a que mostra a mensagem
        //} catch (SQLException ex) {
        //   Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    @Override
    public void delete(Object object) {
        Vendas vendas = (Vendas) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {//clique na lampada do lado/ circundar instrucao com try catch

            String sql = "delete from vendas where(idVendas = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas.getIdVendas());
            //pstm.setDate(5, (Date) Vendas.getDataNascimento());
            pstm.executeUpdate();

            //cnt = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Vendas vendas = new Vendas();//ele não transforma o objeto em usuario, ele cria um novo usuario (no bean eu acho)
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //select
        try {

            String sql = "SELECT * from vendas where idVendas=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);//pq ele passa o id la em cima e nao o bean

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {//se rs
                //rs.next();
                vendas.setIdVendas(rs.getInt("idVendas"));//joga o valor do banco pro bean
                vendas.setData(rs.getDate("data"));//aqui funciona
                vendas.setCliente(rs.getInt("cliente"));
                vendas.setVendedor(rs.getInt("vendedor"));
                vendas.setValor_total(rs.getDouble("valortotal"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return vendas;//retorna o bean

    }

    @Override
    public List listAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List lista = new ArrayList();
        try {
            String sql = "SELECT * from vendas";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {//se rs
                Vendas vendas = new Vendas();//pra colocar todos diferentes na tabela
                //rs.next();
                vendas.setIdVendas(rs.getInt("idvendas"));//joga o valor do banco pro bean
                vendas.setData(rs.getDate("data"));//aqui funciona
                vendas.setCliente(rs.getInt("cliente"));
                vendas.setVendedor(rs.getInt("vendedor"));
                vendas.setValor_total(rs.getDouble("valortotal"));
                lista.add(vendas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return lista;//retorna o bean
    }

    public static void main(String[] args) {//main pra executar um teste

        //TESTE DE INSERT
        System.out.println("teste");//"sout"//*tab*
        Vendas vendas = new Vendas();//bean
        //coloca os valores no bean
        vendas.setIdVendas(1);
        //a data
        vendas.setCliente(1);
        vendas.setVendedor(2);
        vendas.setValor_total(460.10);
        Vendas_DAO vendas_DAO = new Vendas_DAO();//dao
        vendas_DAO.insert(vendas);//usa o metodo insert usando o bean Vendas
        System.out.println("deu certo!!!");
//*/

        /*/TESTE DE UPDATE
        System.out.println("teste");//"sout"//*tab*
        Vendas vendas = new Vendas();//bean
        //coloca os valores no bean
        //a data
        vendas.setCliente(1);
        vendas.setVendedor(2);
        vendas.setValor_total(123.45);
        vendas.setIdVendas(4);
        
        
        Vendas_DAO vendas_DAO = new Vendas_DAO();//dao
        vendas_DAO.update(vendas);//usa o metodo update usando o bean Vendas
        System.out.println("deu certo!!!");
//*/
 /*/TESTE DE DELETE
        System.out.println("teste");//"sout"//*tab*
        Vendas vendas = new Vendas();//bean
        //coloca os valores no bean
        vendas.setIdVendas(2);
        Vendas_DAO vendas_DAO = new Vendas_DAO();//dao
        vendas_DAO.delete(vendas);//usa o metodo insert usando o bean vendas
        System.out.println("deu certo!!!");
//*/
    }
}
