package dao;

import bean.ClientesJmbv;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
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
public class Clientes_DAO extends DAO_Abstract {

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
        Criteria criteria = session.createCriteria(ClientesJmbv.class);
        criteria.add(Restrictions.eq("idclientesJmbv", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClientesJmbv.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNome(String nome){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClientesJmbv.class);
        criteria.add(Restrictions.like("nomeJmbv", nome, MatchMode.ANYWHERE));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listSexo(int sexo){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClientesJmbv.class);
        String sexoS;
        if(sexo == 0){
            sexoS = "M";
        }else{
            sexoS = "F";
        }
        criteria.add(Restrictions.like("sexoJmbv", sexoS));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNomeESexo(String nome,int sexo){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClientesJmbv.class);
        criteria.add(Restrictions.like("nomeJmbv", nome, MatchMode.ANYWHERE));
        String sexoS;
        if(sexo == 0){
            sexoS = "M";
        }else{
            sexoS = "F";
        }
        criteria.add(Restrictions.eq("sexoJmbv", sexoS));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        Clientes_DAO clientes_DAO = new Clientes_DAO();
    }
    
}
