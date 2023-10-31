package dao;

import bean.VendasJmbv;
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
        criteria.add(Restrictions.eq("idusuariosJmbv", id));
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
    public List listClientes(String cliente) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.eq("vendedorJmbv", cliente));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listVendedor(String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.eq("clientesJmbv", vendedor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listClientesEVendedor(String cliente, String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasJmbv.class);
        criteria.add(Restrictions.eq("clientesJmbv", vendedor));
        criteria.add(Restrictions.eq("vendedormbv", cliente));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        Vendas_DAO vendas_DAO = new Vendas_DAO();
    }
    
}
