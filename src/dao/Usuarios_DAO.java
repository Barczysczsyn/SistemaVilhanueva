/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import bean.Usuarios;
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
 *
 */
public class Usuarios_DAO extends DAO_Abstract {
    //botao direito na conexao
    //edit connecttion
    //advanced
    //useSSL=0

    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;//o usuarios se converte em object
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            String sql = "insert into usuarios values(?,?,?,?,?,?,?,?)";
            System.out.println("as interrogacoes");//coloca o comando que colocaria no mysql// tem que colocar aspas simples pra nao dar conflito
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuarios());//posicao, o que vai colocar
            pstm.setString(2, usuarios.getNome());
            pstm.setString(3, usuarios.getApelido());
            pstm.setString(4, usuarios.getCpf());
            pstm.setDate(5, new java.sql.Date(usuarios.getDataNascimento().getTime()));//tudo as conversoes
            //pstm.setDate(5, new Date(2001,1,1));
            pstm.setString(6, usuarios.getSenha());
            pstm.setInt(7, usuarios.getNivel());
            pstm.setString(8, usuarios.getAtivo());
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
        Usuarios usuarios = (Usuarios) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            String sql = "UPDATE usuarios SET nome = ?,apelido = ?,cpf = ?,DataNascimento = ?,senha = ?,nivel = ?,ativo = ? where(idUsuarios = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, usuarios.getNome());
            pstm.setString(2, usuarios.getApelido());
            pstm.setString(3, usuarios.getCpf());
            pstm.setDate(4, new java.sql.Date(usuarios.getDataNascimento().getTime()));//tudo as conversoes

            //pstm.setDate(5, (Date) usuarios.getDataNascimento());//ve ai
            //pstm.setDate(4, new Date(2001,1,1));
            pstm.setString(5, usuarios.getSenha());
            pstm.setInt(6, usuarios.getNivel());
            pstm.setString(7, usuarios.getAtivo());
            pstm.setInt(8, usuarios.getIdUsuarios());
            //pstm.setDate(5, (Date) usuarios.getDataNascimento());
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
        Usuarios usuarios = (Usuarios) object;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {//clique na lampada do lado/ circundar instrucao com try catch

            String sql = "delete from usuarios where(idUsuarios = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuarios());
            //pstm.setDate(5, (Date) usuarios.getDataNascimento());
            pstm.executeUpdate();

            //cnt = DriverManager.getConnection(url,user,password);
            System.out.println("erro na conexao");
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Usuarios usuarios = new Usuarios();//ele não transforma o objeto em usuario, ele cria um novo usuario (no bean eu acho)
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //select
        try {

            String sql = "SELECT * from usuarios where idUsuarios=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);//pq ele passa o id la em cima e nao o bean

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {//se rs
                //rs.next();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));//joga o valor do banco pro bean
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return usuarios;//retorna o bean

    }

    @Override
    public List listAll() {
        // pstm.setInt(1, id );//pq ele passa o id la em cima e nao o bean
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //select
        List lista = new ArrayList();
        try {
            String sql = "SELECT * from usuarios";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next() == true) {//se rs
                Usuarios usuarios = new Usuarios();//pra colocar todos diferentes na tabela
                //rs.next();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));//joga o valor do banco pro bean
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));
                lista.add(usuarios);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return lista;//retorna o bean
    }
    
    public Usuarios listCadastro(String apelido,String senha) {
        Usuarios usuarios = new Usuarios();//ele não transforma o objeto em usuario, ele cria um novo usuario (no bean eu acho)
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("listapelido" + usuarios);

        //select
        try {

            String sql = "SELECT * from usuarios where(apelido = ?) and(senha = ?);";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, apelido);//pq ele passa o id la em cima e nao o bean
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {//se rs
                //rs.next();
                usuarios.setIdUsuarios(rs.getInt("idUsuarios"));//joga o valor do banco pro bean
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));//aqui funciona
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("conectou");
        //Statement stm;
        return usuarios;//retorna o bean

    }

    public static void main(String[] args) {//main pra executar um teste

        /*/TESTE DE INSERT
        System.out.println("teste");//"sout"//*tab*
        Usuarios usuarios = new Usuarios();//bean
        //coloca os valores no bean
        usuarios.setIdUsuarios(4);
        usuarios.setNome("marcos");
        usuarios.setApelido("marquinhos");
        usuarios.setCpf("12344254534");
        usuarios.setSenha("12345");
        //usuarios.setDataNascimento("");
        usuarios.setNivel(1);
        usuarios.setAtivo("S");
        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();//dao
        usuarios_DAO.insert(usuarios);//usa o metodo insert usando o bean usuarios
        System.out.println("deu certo!!!");
//*/
        //TESTE DE UPDATE
        System.out.println("teste");//"sout"//*tab*
        Usuarios usuarios = new Usuarios();//bean
        //coloca os valores no bean

        usuarios.setNome("janja");
        usuarios.setApelido("lula");
        usuarios.setCpf("123574");
        usuarios.setSenha("123124");
        //usuarios2.setDataNascimento("");
        usuarios.setNivel(4);
        usuarios.setAtivo("N");
        usuarios.setIdUsuarios(4);
        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();//dao
        usuarios_DAO.update(usuarios);//usa o metodo update usando o bean usuarios
        System.out.println("deu certo!!!");
//*/


        /*/TESTE DE DELETE
        System.out.println("teste");//"sout"//*tab*
        Usuarios usuarios = new Usuarios();//bean
        //coloca os valores no bean
        usuarios.setIdUsuarios(4);
        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();//dao
        usuarios_DAO.delete(usuarios);//usa o metodo insert usando o bean usuarios
        System.out.println("deu certo!!!");
//*/
    }
}
