package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.SanPham;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {

    public List<SanPham> getAll(){
        List<SanPham> list=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            list=session.createQuery("from SanPham ").list();

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public SanPham getById(UUID id){
        SanPham sanPham=new SanPham();
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            sanPham=session.get(SanPham.class,id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean delete(SanPham sp){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.delete(sp);
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

    public void add(SanPham sanPham){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.save(sanPham);
            transaction.commit();

        }catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    public Boolean update(SanPham sp){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.saveOrUpdate(sp);
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

}
