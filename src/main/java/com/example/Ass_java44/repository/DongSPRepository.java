package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.DongSP;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {

    public List<DongSP> getAll(){
        List<DongSP> list=new ArrayList<>();
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            list=session.createQuery("from DongSP").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public DongSP getByid(UUID id){
        DongSP dongSP=new DongSP();
        try(Session session=HibernateUtil.getFACTORY().openSession()) {

            dongSP=session.get(DongSP.class,id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return  dongSP;
    }

    public void addNew(DongSP dongSP){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
        }catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Boolean delete(DongSP d){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.delete(d);
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }


    public Boolean update(DongSP dongSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(dongSP);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
            return false;
        }
    }
}
