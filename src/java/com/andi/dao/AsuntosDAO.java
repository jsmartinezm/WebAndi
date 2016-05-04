/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.dao;

import com.andi.model.AsuntoRelevante;
import com.andi.model.Subsector;
import com.andi.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juanse0529
 */
public class AsuntosDAO {
    public ArrayList<AsuntoRelevante> getAllAsuntosBySubSector(Subsector subSectorId){
        ArrayList<AsuntoRelevante> asuntos = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            String queryString = "from AsuntoRelevante asu where  asu.asuntoId in (select asuntoRelevante from SubsectorAsunto as subasun where subasun.subsector = :idToFind)";
            Query query = session.createQuery(queryString);
            query.setEntity("idToFind", subSectorId);
            asuntos = (ArrayList<AsuntoRelevante>)query.list();
        }catch(RuntimeException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.flush();
            session.close();
        }
        return asuntos;
    }
}
