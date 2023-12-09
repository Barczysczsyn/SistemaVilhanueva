package dao;

import bean.VendasJmbv;
import bean.VendasProdutoJmbv;
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
public class VendasProduto_DAO extends DAO_Abstract {

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
        //session.close();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasProdutoJmbv.class);
        criteria.add(Restrictions.eq("idvendasProdutoJmbv", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasProdutoJmbv.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listRel() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasProdutoJmbv.class);
        //criteria.add(Restrictions.eq("idvendasProdutoJmbv", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listProdutos(VendasJmbv vendas) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasProdutoJmbv.class);
        criteria.add(Restrictions.eq("vendasJmbv", vendas));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        VendasProduto_DAO vendasProduto_DAO = new VendasProduto_DAO();
    }
    
}
