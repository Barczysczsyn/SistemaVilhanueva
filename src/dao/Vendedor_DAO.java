/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.Vendedor;
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
public class Vendedor_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {//veio de vendedor
        Vendedor vendedor = (Vendedor) object;//o vendedor se converte em object
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            String sql = "insert into vendedor values(?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println("as interrogacoes");
            PreparedStatement pstm = cnt.prepareStatement(sql);
            //pstm.setDate(5, (Date) vendedor.getDataNascimento());
            pstm.setInt(1, vendedor.getIdVendedor());
            pstm.setString(2, vendedor.getNome());
            pstm.setString(3, vendedor.getCpf());
            pstm.setDate(4, new java.sql.Date(vendedor.getDataNascimento().getTime()));//tudo as conversoes
            pstm.setString(5, vendedor.getCep());
            pstm.setString(6, vendedor.getEndereco());
            pstm.setString(7, vendedor.getCelular());
            pstm.setString(8, vendedor.getBairro());
            pstm.setString(9, vendedor.getComplemento());
            pstm.setString(10, vendedor.getEmail());
            pstm.setString(11, vendedor.getRg());
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
        Vendedor vendedor = (Vendedor) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            String sql = "UPDATE vendedor SET nome = ?,cpf = ?,dataNascimento = ?,cep = ?,endereco = ?,celular = ?,bairro = ?,complemento = ?,email = ?,rg = ? where(idVendedor = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setDate(3, new java.sql.Date(vendedor.getDataNascimento().getTime()));//tudo as conversoes
            pstm.setString(4, vendedor.getCep());
            pstm.setString(5, vendedor.getEndereco());
            pstm.setString(6, vendedor.getCelular());
            pstm.setString(7, vendedor.getBairro());
            pstm.setString(8, vendedor.getComplemento());
            pstm.setString(9, vendedor.getEmail());
            pstm.setString(10, vendedor.getRg());
            pstm.setInt(11, vendedor.getIdVendedor());
            //cnt = DriverManager.getConnection(url,user,pas

            pstm.executeUpdate();

            System.out.println("erro na conexao");
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
        Vendedor vendedor = (Vendedor) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            String sql = "delete from vendedor where(idVendedor = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendedor.getIdVendedor());
            //pstm.setDate(5, (Date) vendedor.getDataNascimento());
            pstm.executeUpdate();

            //cnt = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Vendedor vendedor = new Vendedor();//ele não transforma o objeto em usuario, ele cria um novo usuario (no bean eu acho)
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //select
        try {

            String sql = "SELECT * from vendedor where idVendedor=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);//pq ele passa o id la em cima e nao o bean

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {//se rs
                //rs.next();
                vendedor.setIdVendedor(rs.getInt("idVendedor"));//joga o valor do banco pro bean
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
                vendedor.setCep(rs.getString("cep"));
                vendedor.setEndereco(rs.getString("endereco"));
                vendedor.setCelular(rs.getString("celular"));
                vendedor.setBairro(rs.getString("bairro"));
                vendedor.setComplemento(rs.getString("complemento"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setRg(rs.getString("rg"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return vendedor;//retorna o bean

    }

    @Override
    public List listAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List lista = new ArrayList();
        try {
            String sql = "SELECT * from vendedor";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {//se rs
                Vendedor vendedor = new Vendedor();//pra colocar todos diferentes na tabela
                //rs.next();
                vendedor.setIdVendedor(rs.getInt("idVendedor"));//joga o valor do banco pro bean
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
                vendedor.setCep(rs.getString("cep"));
                vendedor.setEndereco(rs.getString("endereco"));
                vendedor.setCelular(rs.getString("celular"));
                vendedor.setBairro(rs.getString("bairro"));
                vendedor.setComplemento(rs.getString("complemento"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setRg(rs.getString("rg"));
                lista.add(vendedor);
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
        Vendedor vendedor = new Vendedor();//bean
        //coloca os valores no bean
        vendedor.setIdVendedor(3);
        //a data
        vendedor.setNome("carinha");
        vendedor.setCpf("1235162");
        //data
        vendedor.setCep("1873543");
        vendedor.setEndereco("nacassa");
        vendedor.setCelular("(11)1234-1234");
        vendedor.setBairro("saidhaos");
        vendedor.setComplemento("ali");
        vendedor.setEmail("carinha@gmail.com");
        vendedor.setRg("carinha");

        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();//dao
        vendedor_DAO.insert(vendedor);//usa o metodo insert usando o bean vendedor
        System.out.println("deu certo!!!");
//*/

        /*/TESTE DE UPDATE
        System.out.println("teste");//"sout"//*tab*
        Vendedor vendedor = new Vendedor();//bean
        //coloca os valores no bean
        
        //a data
        vendedor.setNome("samira");
        vendedor.setCpf("654332");
        //data
        vendedor.setCep("765462");
        vendedor.setEndereco("assentamento itamarati");
        vendedor.setCelular("12-6355-3567");
        vendedor.setBairro("no meio da terra");
        vendedor.setComplemento("brinquedos na frente");
        vendedor.setEmail("samiramendes@gmail.com");
        vendedor.setRg("21874129652");
        vendedor.setIdVendedor(2);
        
        
        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();//dao
        vendedor_DAO.update(vendedor);//usa o metodo insert usando o bean vendedor
        System.out.println("deu certo!!!");
//*/
 /*/TESTE DE DELETE
        System.out.println("teste");//"sout"//*tab*
        Vendedor vendedor = new Vendedor();//bean
        //coloca os valores no bean
        vendedor.setIdVendedor(3);
        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();//dao
        vendedor_DAO.delete(vendedor);//usa o metodo insert usando o bean vendas
        System.out.println("deu certo!!!");
//*/
    }
}
