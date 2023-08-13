/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aulas.TesteJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u06437985100
 */
public abstract class DAO_Abstract {
    //void significa sem retorno
    //ele da o esqueleto pras outras classes
    
    
    Connection cnt;
    
   public void conexao(){
        try {//clique na lampada do lado/ circundar instrucao com try catch
            Class.forName("com.mysql.jdbc.Driver");  //registrei no mysql   

            //cnt = DriverManager.getConnection("jdbc:mysql://10.7.0.51:33062/db_joao_vilhanueva","joao_vilhanueva","joao_vilhanueva");//if
            cnt = DriverManager.getConnection("jdbc:mysql://localhost/db_joao_vilhanueva", "root", "");//local
            //funcao();
            System.out.println("conectou no if né");

        } catch (ClassNotFoundException ex) {//bloco protegido, se der erro vai cair aqui
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);//essa linha e a que mostra a mensagem

            System.out.println("erro na conexao");
        } catch (SQLException ex) {
            Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DAO_Abstract() {
        conexao();
    }

    
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int id);
    public abstract List listAll(); 
    /*
    public void mensagem(String texto){
        System.out.println(texto);
       
    }
    */
}
