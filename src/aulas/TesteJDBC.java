/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author jmbvi
 */
//Class.forName("com.mysql.jdbc.driver");
//Class.org("org.postgresql.Driver");

public class TesteJDBC {
    
    public static void main(String[] args) {//psvm + tab
        /*
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_joao_vilhanueva";//local, ip, nome da porta, nome do esquema
        //url = "jdbc:mysql://localhost:3306/vendas";//pra fazer interno
        user = "joao_vilhanueva";
        password = "joao_vilhanueva";
        try {//clique na lampada do lado/ circundar instrucao com try catch
            Class.forName("com.mysql.jdbc.Driver");  //fala que registrei no mysql   
            Connection cnt;
            cnt = DriverManager.getConnection("jdbc:mysql://10.7.0.51:33062/db_joao_vilhanueva","joao_vilhanueva","joao_vilhanueva");//so pra conectar no banco
            Statement stm;//criar na lampada uma importacao java.sql//o statement tem que tar na conexao// statement cria um  objeto para mandar coisas pro banco
            stm = cnt.createStatement();
            String sql = "UPDATE 'usuario' SET 'apelido' = 'orguinha' WHERE ('idusuario' = '2')";//coloca o comando que colocaria no mysql// tem que colocar aspas simples pra nao dar conflito
            stm.executeUpdate(sql);
            //cnt = DriverManager.getConnection(url,user,password);
        
            /*
            Statement stm = cnt.createStatement();
– ResultSet rS = stm.executeQuery(
"select codigo, descricao
from grupo");
    
    

*/
    
    //select
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_joao_vilhanueva";//local, ip, nome da porta, nome do esquema
        //url = "jdbc:mysql://localhost:3306/vendas";//pra fazer interno
        user = "joao_vilhanueva";
        password = "joao_vilhanueva";
        try {
            Class.forName("com.mysql.jdbc.Driver");  //fala que registrei no mysql   
            Connection cnt;
            cnt = DriverManager.getConnection("jdbc:mysql://10.7.0.51:33062/db_joao_vilhanueva","joao_vilhanueva","joao_vilhanueva");
            
            String sql = "SELECT * from usuarios";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next() == true){//enquando rs
            //rs.next();
            System.out.println("codigo:" + rs.getInt("idUsuarios"));
            System.out.println("nome:" + rs.getString("nome"));
            System.out.println("apelido:" + rs.getString("apelido"));
        }
    
    
    
    
        } catch (ClassNotFoundException ex) {//bloco protegido, se der erro vai cair aqui
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);//essa linha e a que mostra a mensagem
            
        System.out.println("erro na conexao");
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("conectou");
        //Statement stm;
    
    //}


            //cnt = DriverManager.getConnection(url,user,password);
        
            /*
            Statement stm = cnt.createStatement();
– ResultSet rS = stm.executeQuery(
"select codigo, descricao
from grupo");

*/
            /*
        } catch (ClassNotFoundException ex) {//bloco protegido, se der erro vai cair aqui
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);//essa linha e a que mostra a mensagem
            
        System.out.println("erro na conexao");
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("conectou");
        //Statement stm;
        */
    }
}
//1:carregar o driver(mysql)
//2:realizar a conexão
//3:criar um objeto no java pra mandar coisas pro banco de dados
//podem ser feitas 4 operacoes, o crud
//localhost transforma em ip 