package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.NSX;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {

    public List<NSX> getAll(){
        List<NSX> list=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            list=session.createQuery("from NSX").list();

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public NSX getById(UUID id){
        NSX nsx=new NSX();
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            nsx=session.get(NSX.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean delete(NSX nsx){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return false;
    }

    public Boolean update(NSX nsx){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.saveOrUpdate(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return false;
    }

    public void add(NSX nsx){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(nsx);
            transaction.commit();

        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }

    }
}
