/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.dao;

import com.andi.model.Oportunidad;
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
public class OportunidadesDAO {
    
    public ArrayList<Oportunidad> getAllOportunidadesBySubSector(Subsector subSectorId){
        ArrayList<Oportunidad> oportunidades = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            String queryString = "from Oportunidad opo where  opo.oportunidadId in (select oportunidad from SubsectorOportunidad as subopo where subopo.subsector = :idToFind)";
            Query query = session.createQuery(queryString);
            query.setEntity("idToFind", subSectorId);
            oportunidades = (ArrayList<Oportunidad>)query.list();
        }catch(RuntimeException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.flush();
            session.close();
        }
        return oportunidades;
    }
    
}
