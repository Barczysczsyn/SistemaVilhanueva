package dao;

import bean.UsuariosJmbv;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmbvi
 */
public class Usuarios_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();//para limpar o cache do hibernate
        session.clear();//para que ele nao grave coisas erradas
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosJmbv.class);
        criteria.add(Restrictions.eq("idusuariosJmbv", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosJmbv.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public boolean listCadastro(String apelido, String senha){
        //UsuariosJmbv usuariosJmbv = new UsuariosJmbv();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosJmbv.class);
        criteria.add(Restrictions.eq("apelidoJmbv", apelido));
        criteria.add(Restrictions.eq("senhaJmbv", senha));
        List lista = criteria.list();
        session.getTransaction().commit();
        System.out.println("lista:" + lista);
        if(lista.isEmpty()){
           
        return false; 
        }else{
            
        return true; 
        }
    }
    public static void main(String[] args) {
        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();
    }
    
}
