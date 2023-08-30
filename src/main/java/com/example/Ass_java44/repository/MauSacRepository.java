package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.MauSac;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {

    public List<MauSac> getAll() {
        List<MauSac> listMauSac = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            listMauSac = session.createQuery("from MauSac ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMauSac;
    }

    public MauSac getByid(UUID id){
        MauSac mauSac=new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            mauSac = session.get(MauSac.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }

    public void addNew(MauSac mauSac){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
        }catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Boolean delete(MauSac mauSac){
        Transaction transaction= null;
        try {Session session=HibernateUtil.getFACTORY().openSession();
            transaction=session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(MauSac mauSac){
        Transaction transaction=null;
        try {Session session=HibernateUtil.getFACTORY().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
