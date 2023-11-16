package dao;

import bean.VendasJmbv;
import java.util.ArrayList;
import java.util.Date;
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
public class Vendas_DAO extends DAO_Abstract {

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
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.eq("idvendasJmbv", id));
        //ne = not equals
        //Restrictions.isNull("nome")//pega se  campo nome e vazio
        //Restrictions.like("nome","mar%")//ve se o nome comeca com mar
        //Restrictions.gt("preco",new Double(30.0));//ve se o campo preco e maior que 30
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listData(Date data,Date data2){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.gt("dataJmbv", data));
        criteria.add(Restrictions.lt("dataJmbv", data2));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listValorTotal(double total){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.eq("valorTotalJmbv", total));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listDataETotal( double total,Date data, Date data2){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.eq("valorTotalJmbv", total));
        criteria.add(Restrictions.gt("dataJmbv", data));
        criteria.add(Restrictions.lt("dataJmbv", data2));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        Vendas_DAO vendas_DAO = new Vendas_DAO();
    }
    
}
