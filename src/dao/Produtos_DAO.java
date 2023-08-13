/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.Produtos;
import java.sql.Connection;
import java.sql.Date;//util
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;//util
import java.util.logging.Level;//util
import java.util.logging.Logger;//util

/**
 *
 * @author jmbvi
 */
public class Produtos_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Produtos produtos = (Produtos) object;
        try {//clique na lampada do lado/ circundar instrucao com try catch
            String sql = "insert into produtos values(?,?,?,?,?)";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produtos.getIdProdutos());//posicao, o que vai colocar
            pstm.setString(2, produtos.getNome());
            pstm.setDouble(3, produtos.getPreco());
            pstm.setString(4, produtos.getMarca());
            pstm.setDate(5, new java.sql.Date(produtos.getValidade().getTime()));//tudo as conversoes

            //cnt = DriverManager.getConnection(url,user,password);
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Produtos produtos = (Produtos) object;
        try {//clique na lampada do lado/ circundar instrucao com try catch
            String sql = "update produtos set nome = ?, preco = ?, marca = ?, validade = ? where(idProdutos = ?);";//coloca o comando que colocaria no mysql// tem que colocar aspas simples pra nao dar conflito
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setString(1, produtos.getNome());
            pstm.setDouble(2, produtos.getPreco());
            pstm.setString(3, produtos.getMarca());
            pstm.setDate(4, new java.sql.Date(produtos.getValidade().getTime()));//tudo as conversoes
            pstm.setInt(5, produtos.getIdProdutos());

            pstm.executeUpdate();
            //cnt = DriverManager.getConnection(url,user,password);
} catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Produtos produtos = (Produtos) object;

        try {//clique na lampada do lado/ circundar instrucao com try catch
            String sql = "delete from produtos where(idProdutos = ?);";//coloca o comando que colocaria no mysql// tem que colocar aspas simples pra nao dar conflito
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produtos.getIdProdutos());
            pstm.executeUpdate();
            //cnt = DriverManager.getConnection(url,user,password);

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Produtos produtos = new Produtos();
        //select
        try {
            String sql = "SELECT * from produtos where idProdutos=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);//pq ele passa o id la em cima e nao o bean

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {//se rs
                //rs.next();
                produtos.setIdProdutos(rs.getInt("idProdutos"));//joga o valor do banco pro bean
                produtos.setNome(rs.getString("nome"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setMarca(rs.getString("marca"));
                produtos.setValidade(rs.getDate("validade"));//aqui funciona
            }

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return produtos;//retorna o bean

    }

    @Override
    public List listAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //select
        List lista = new ArrayList();
        try {
            String sql = "SELECT * from produtos";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {//se rs
                Produtos produtos = new Produtos();//pra colocar todos diferentes na tabela
                //rs.next();
                produtos.setIdProdutos(rs.getInt("idprodutos"));//joga o valor do banco pro bean
                produtos.setNome(rs.getString("nome"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setMarca(rs.getString("marca"));
                produtos.setValidade(rs.getDate("validade"));//aqui funciona
                lista.add(produtos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return lista;//retorna o bean
    }

    //TESTE INSERT
    public static void main(String[] args) {//main pra executar um teste
        System.out.println("teste");//"sout"//*tab*
        Produtos produtos = new Produtos();//bean
        //coloca os valores no bean
        produtos.setIdProdutos(3);
        produtos.setNome("coleira");
        produtos.setPreco(12.20);
        produtos.setMarca("pedigree");
        //clientes.setDataNascimento("");//ver

        Produtos_DAO produtos_DAO = new Produtos_DAO();//dao
        produtos_DAO.insert(produtos);//usa o metodo insert usando o bean produtos
        System.out.println("deu certo!!!");
    }
    //*/

    /*/TESTE UPDATE
    public static void main(String[] args) {//main pra executar um teste
        System.out.println("teste");//"sout"//*tab*
        Produtos produtos = new Produtos();//bean
        //coloca os valores no bean
        produtos.setNome("racao");
        produtos.setPreco(6.15);
        produtos.setMarca("whiskas");
        //clientes.setDataNascimento("");//ver
        produtos.setIdProdutos(2);
        
        Produtos_DAO produtos_DAO = new Produtos_DAO();//dao
        produtos_DAO.update(produtos);//usa o metodo insert usando o bean produtos
        System.out.println("deu certo!!!");
    }
    //*/
 /*/TESTE DELETE
    public static void main(String[] args) {//main pra executar um teste
        System.out.println("teste");//"sout"//*tab*
        Produtos produtos = new Produtos();//bean
        //coloca os valores no bean
        //clientes.setDataNascimento("");//ver
        produtos.setIdProdutos(3);
        
        Produtos_DAO produtos_DAO = new Produtos_DAO();//dao
        produtos_DAO.delete(produtos);//usa o metodo insert usando o bean produtos
        System.out.println("deu certo!!!");
    }
    //*/
}
