/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.Clientes;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jmbvi
 */
public class Clientes_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Clientes clientes = (Clientes) object;


        try {
            String sql = "insert into clientes values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, clientes.getIdClientes());//posicao, o que vai colocar

            pstm.setString(2, clientes.getNome());
            pstm.setString(3, clientes.getSexo());
            pstm.setDate(4, new java.sql.Date(clientes.getDataNascimento().getTime()));//tudo as conversoes
            pstm.setString(5, clientes.getContato());
            pstm.setString(6, clientes.getCpf());
            pstm.setString(7, clientes.getCep());
            pstm.setString(8, clientes.getEndereco());
            pstm.setString(9, clientes.getCelular());
            pstm.setString(10, clientes.getCidade());
            pstm.setString(11, clientes.getBairro());
            pstm.setString(12, clientes.getComplemento());
            pstm.setString(13, clientes.getEstado());
            pstm.setString(14, clientes.getEmail());
            pstm.setString(15, clientes.getRg());
            //cnt = DriverManager.getConnection(url,user,password);

            pstm.executeUpdate();

        } catch (SQLException ex) {//tem que ser esse e não o not found
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
        Clientes clientes = (Clientes) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            String sql = "update clientes set nome = ?, sexo = ?, dataNascimento = ?, contato = ?, cpf = ?, cep = ?, endereco = ?, celular = ?, cidade = ?, bairro = ?, complemento = ?, estado = ?, email = ?, rg = ? where(idClientes = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setString(1, clientes.getNome());
            pstm.setString(2, clientes.getSexo());
            pstm.setDate(3, new java.sql.Date(clientes.getDataNascimento().getTime()));//tudo as conversoes
            pstm.setString(4, clientes.getContato());
            pstm.setString(5, clientes.getCpf());
            pstm.setString(6, clientes.getCep());
            pstm.setString(7, clientes.getEndereco());
            pstm.setString(8, clientes.getCelular());
            pstm.setString(9, clientes.getCidade());
            pstm.setString(10, clientes.getBairro());
            pstm.setString(11, clientes.getComplemento());
            pstm.setString(12, clientes.getEstado());
            pstm.setString(13, clientes.getEmail());
            pstm.setString(14, clientes.getRg());
            pstm.setInt(15, clientes.getIdClientes());
            pstm.executeUpdate();
            //cnt = DriverManager.getConnection(url,user,password);

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Object object) {
        Clientes clientes = (Clientes) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {//clique na lampada do lado/ circundar instrucao com try catch
            String sql = "delete from clientes where(idClientes = ?);";//coloca o comando que colocaria no mysql// tem que colocar aspas simples pra nao dar conflito
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setInt(1, clientes.getIdClientes());

            pstm.executeUpdate();
            //cnt = DriverManager.getConnection(url,user,password);

            System.out.println("erro na conexao");
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Clientes clientes = new Clientes();//ele não transforma o objeto em usuario, ele cria um novo usuario (no bean eu acho)
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    //select
        try {
            
            String sql = "SELECT * from clientes where idClientes=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id );//pq ele passa o id la em cima e nao o bean
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next() == true){//se rs
            //rs.next();
            clientes.setIdClientes(rs.getInt("idClientes"));//joga o valor do banco pro bean
            clientes.setNome(rs.getString("nome"));
            clientes.setSexo(rs.getString("sexo"));
            clientes.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
            clientes.setContato(rs.getString("contato"));
            clientes.setCpf(rs.getString("cpf"));
            clientes.setCep(rs.getString("cep"));
            clientes.setEndereco(rs.getString("endereco"));
            clientes.setCelular(rs.getString("celular"));
            clientes.setCidade(rs.getString("cidade"));
            clientes.setBairro(rs.getString("bairro"));
            clientes.setComplemento(rs.getString("complemento"));
            clientes.setEstado(rs.getString("estado"));
            clientes.setEmail(rs.getString("email"));
            clientes.setRg(rs.getString("rg"));
            
        }
    
    
    
    
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("conectou");
        //Statement stm;
        return clientes;//retorna o bean
    
    }

    @Override
    public List listAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        List lista = new ArrayList();
        try {
            String sql = "SELECT * from clientes";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {//se rs
                Clientes clientes = new Clientes();//pra colocar todos diferentes na tabela
                //rs.next();
            clientes.setIdClientes(rs.getInt("idClientes"));//joga o valor do banco pro bean
            clientes.setNome(rs.getString("nome"));
            clientes.setSexo(rs.getString("sexo"));
            clientes.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
            clientes.setContato(rs.getString("contato"));
            clientes.setCpf(rs.getString("cpf"));
            clientes.setCep(rs.getString("cep"));
            clientes.setEndereco(rs.getString("endereco"));
            clientes.setCelular(rs.getString("celular"));
            clientes.setCidade(rs.getString("cidade"));
            clientes.setBairro(rs.getString("bairro"));
            clientes.setComplemento(rs.getString("complemento"));
            clientes.setEstado(rs.getString("estado"));
            clientes.setEmail(rs.getString("email"));
            clientes.setRg(rs.getString("rg"));
                lista.add(clientes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return lista;//retorna o bean
    }

    //TESTE DE INSERT
    public static void main(String[] args) {//main pra executar um teste
        System.out.println("teste");//"sout"//*tab*
        Clientes clientes = new Clientes();//bean
        //coloca os valores no bean
        clientes.setIdClientes(5);
        clientes.setNome("chapam");
        clientes.setSexo("M");
        //clientes.setDataNascimento("");//ver
        clientes.setContato("oimeuchapa");//ver
        clientes.setCpf("1265462");
        clientes.setCep("568543522");//ver
        clientes.setEndereco("casa do pica pau");
        clientes.setCelular("67-2451-6543");
        clientes.setCidade("sei la");
        clientes.setBairro("picapau");
        clientes.setComplemento("ele e do pica pau");
        clientes.setEstado("barreado canaveral");
        clientes.setEmail("@oimeuchapa");
        clientes.setRg("6541262");
        Clientes_DAO clientes_DAO = new Clientes_DAO();//dao
        clientes_DAO.insert(clientes);//usa o metodo insert usando o bean clientes
        System.out.println("deu certo!!!");
    }
    //*/

    /*/TESTE DE UPDATE
    public static void main(String[] args) {//main pra executar um teste
        System.out.println("teste");//"sout"//*tab*
        Clientes clientes = new Clientes();//bean
        //coloca os valores no bean
        
        clientes.setNome("pica pau");
        clientes.setSexo("M");
        //clientes.setDataNascimento("");//ver
        clientes.setContato("hehehehehehe");//ver
        clientes.setCpf("65442141");
        clientes.setCep("4872633");//ver
        clientes.setEndereco("sei la e no eua");
        clientes.setCelular("67-6363-6363");
        clientes.setCidade("illinois");
        clientes.setBairro("inilandia");
        clientes.setComplemento("escocia");
        clientes.setEstado("texas");
        clientes.setEmail("@woodypecker");
        clientes.setRg("542134");
        clientes.setIdClientes(3);


        Clientes_DAO clientes_DAO = new Clientes_DAO();//dao
        clientes_DAO.update(clientes);//usa o metodo insert usando o bean clientes
        System.out.println("deu certo!!!");
    }
    //*/
 /*/TESTE DE DELETE
    public static void main(String[] args) {//main pra executar um teste
        System.out.println("teste");//"sout"//*tab*
        Clientes clientes = new Clientes();//bean
        //coloca os valores no bean
        clientes.setIdClientes(4);
        Clientes_DAO clientes_DAO = new Clientes_DAO();//dao
        clientes_DAO.delete(clientes);//usa o metodo insert usando o bean clientes
        System.out.println("deu certo!!!");
    }
    //*/
}
