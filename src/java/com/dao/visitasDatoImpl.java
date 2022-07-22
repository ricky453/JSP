/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.pojo.Visitasweb;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import com.dao.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author ricardo.barrientos
 */
public class visitasDatoImpl implements visitasDao {

    @Override
    public void saveVisita(Visitasweb visita) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(visita);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Visitasweb> showAllVisitas() {
        List<Visitasweb> lista = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Visitasweb");
        lista = query.list();
        return lista;
    }

    @Override
    public Visitasweb showVisita(BigInteger id) {
        Visitasweb lista;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Visitasweb where id="+id);
        lista = (Visitasweb)query.list().get(0);
        return lista;
    }

    @Override
    public void updateVisita(BigInteger id, String usuario, BigInteger idpantalla, Date fecha) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Visitasweb visitaMod = (Visitasweb) session.load(Visitasweb.class, id);
        visitaMod.setFecha(fecha);
        visitaMod.setIdpantalla(idpantalla);
        visitaMod.setUsuario(usuario);
        session.update(visitaMod);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteVisita(Visitasweb visita) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(visita);
        transaction.commit();
        session.close();
    }
}
