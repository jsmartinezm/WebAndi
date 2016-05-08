/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andi.dao;

import com.andi.model.FocoInversionSocial;
import com.andi.model.Pregunta;
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
public class AutodiagnosticoDonacionDAO {
    public ArrayList<Pregunta> getPreguntas(){
        ArrayList<Pregunta> preguntas = null;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            String queryString = "from Pregunta pre where  pre.preguntaCuestionario = 1 order by pre.preguntaId asc)";
            Query query = session.createQuery(queryString);
            preguntas = (ArrayList<Pregunta>)query.list();
        }catch(RuntimeException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.flush();
            session.close();
        }
        return preguntas;
    }
}
