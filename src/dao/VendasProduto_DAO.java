/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.VendasProduto;
import java.sql.Connection;
//o date que nao usa
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
public class VendasProduto_DAO extends DAO_Abstract {
    
    

    @Override
    public void insert(Object object) {//veio de vendasProduto
        VendasProduto vendasProduto = (VendasProduto) object;//o vendasProduto se converte em object
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        try {
            String sql = "insert into vendasproduto values(?,?,?,?,?)"; System.out.println("as interrogacoes");
            PreparedStatement pstm = cnt.prepareStatement(sql);
            //pstm.setDate(5, (Date) vendasProduto.getDataNascimento());
            pstm.setInt(1, vendasProduto.getIdVendasProduto() );
            pstm.setInt(2, vendasProduto.getFkVendas() );
            pstm.setInt(3, vendasProduto.getFkProduto() );
            pstm.setDouble(4, vendasProduto.getValor_Unitario() );
            pstm.setInt(5, vendasProduto.getQuantidade() );
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
        VendasProduto vendasProduto = (VendasProduto) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        try {
            String sql = "UPDATE vendasproduto SET fkVendas = ?,fkProduto = ?,valor_Unitario = ?,quantidade = ? where(idVendasProduto = ?);"; 
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendasProduto.getFkVendas() );
            pstm.setInt(2, vendasProduto.getFkProduto() );
            pstm.setDouble(3, vendasProduto.getValor_Unitario() );
            pstm.setInt(4, vendasProduto.getQuantidade() );
            pstm.setInt(5, vendasProduto.getIdVendasProduto() );
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
        VendasProduto vendasProduto = (VendasProduto) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {//clique na lampada do lado/ circundar instrucao com try catch


            String sql = "delete from vendasproduto where(idVendasProduto = ?);"; 
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendasProduto.getIdVendasProduto() );
            //pstm.setDate(5, (Date) vendasProduto.getDataNascimento());
            pstm.executeUpdate();

            //cnt = DriverManager.getConnection(url,user,password);
        
            
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        VendasProduto vendasProduto = new VendasProduto();//ele não transforma o objeto em usuario, ele cria um novo usuario (no bean eu acho)
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    //select
        try {
            
            String sql = "SELECT * from vendasProduto where idUsuarios=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id );//pq ele passa o id la em cima e nao o bean
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next() == true){//se rs
            //rs.next();
            vendasProduto.setIdVendasProduto(rs.getInt("idVendasProduto"));//joga o valor do banco pro bean
            vendasProduto.setFkVendas(rs.getInt("fkVendas"));
            vendasProduto.setFkProduto(rs.getInt("fkProduto"));
            vendasProduto.setValor_Unitario(rs.getDouble("valor_Unitario"));
            vendasProduto.setQuantidade(rs.getInt("quantidade"));
            }
    
    
    
    
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("conectou");
        //Statement stm;
        return vendasProduto;//retorna o bean
    
    }

    @Override
    public List listAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        List lista = new ArrayList();
        try {
            String sql = "SELECT * from vendasproduto";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {//se rs
                VendasProduto vendasProduto = new VendasProduto();//pra colocar todos diferentes na tabela
                //rs.next();
            vendasProduto.setIdVendasProduto(rs.getInt("idVendasProduto"));//joga o valor do banco pro bean
            vendasProduto.setFkVendas(rs.getInt("fkVendas"));
            vendasProduto.setFkProduto(rs.getInt("fkProduto"));
            vendasProduto.setValor_Unitario(rs.getDouble("valor_Unitario"));
            vendasProduto.setQuantidade(rs.getInt("quantidade"));
                lista.add(vendasProduto);
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
        VendasProduto vendasProduto = new VendasProduto();//bean
        //coloca os valores no bean
        vendasProduto.setIdVendasProduto(1);
        vendasProduto.setFkVendas(2);
        vendasProduto.setFkProduto(2);
        vendasProduto.setValor_Unitario(643.64);
        vendasProduto.setQuantidade(10);
        VendasProduto_DAO vendasProduto_DAO = new VendasProduto_DAO();//dao
        vendasProduto_DAO.insert(vendasProduto);//usa o metodo insert usando o bean vendasProduto
        System.out.println("deu certo!!!");
//*/

 
        /*/TESTE DE UPDATE
        System.out.println("teste");//"sout"//*tab*
        VendasProduto vendasProduto = new VendasProduto();//bean
        //coloca os valores no bean
        
        vendasProduto.setFkVendas(2);
        vendasProduto.setFkProduto(2);
        vendasProduto.setValor_Unitario(643.64);
        vendasProduto.setQuantidade(10);
        vendasProduto.setIdVendasProduto(2);

        
        
        VendasProduto_DAO vendasProduto_DAO = new VendasProduto_DAO();//dao
        vendasProduto_DAO.update(vendasProduto);//usa o metodo insert usando o bean vendasProduto
        System.out.println("deu certo!!!");
//*/


        /*/TESTE DE DELETE
        System.out.println("teste");//"sout"//*tab*
        VendasProduto vendasProduto = new VendasProduto();//beans
        //coloca os valores no bean
        
        vendasProduto.setIdVendasProduto(3);
        
        VendasProduto_DAO vendasProduto_DAO = new VendasProduto_DAO();//dao
        vendasProduto_DAO.delete(vendasProduto);//usa o metodo insert usando o bean vendasProduto
        System.out.println("deu certo!!!");
//*/
    }
}
