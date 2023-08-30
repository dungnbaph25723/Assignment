package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.ChucVu;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {

    public List<ChucVu> getAll() {
        List<ChucVu> listChucVu = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            listChucVu = session.createQuery("from ChucVu ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChucVu;
    }

    public ChucVu getByid(UUID id) {
        ChucVu chucVu = new ChucVu();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            chucVu = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }

    public void addNew(ChucVu chucVu) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Boolean delete(ChucVu c){
        Transaction transaction=null;
        try {Session session=HibernateUtil.getFACTORY().openSession();

            transaction=session.beginTransaction();
            session.delete(c);
            transaction.commit();
            return  true;
        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ChucVu c){
        Transaction transaction=null;
        try {Session session=HibernateUtil.getFACTORY().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(c);
            transaction.commit();
            return  true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();

            }
            e.printStackTrace();
            return false;
        }

    }


}
