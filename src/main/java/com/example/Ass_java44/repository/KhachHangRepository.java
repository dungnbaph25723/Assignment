package com.example.Ass_java44.repository;


import com.example.Ass_java44.entity.KhachHang;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

    public List<KhachHang> getAll(){
        List<KhachHang> list=new ArrayList<>();

        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            list=session.createQuery("from KhachHang ").list();

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public KhachHang getById(UUID id){
        KhachHang khachHang=new KhachHang();

        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            khachHang=session.get(KhachHang.class,id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }

    public Boolean delete(KhachHang kh){
        Transaction transaction=null;

        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return false;
    }

    public void add(KhachHang kh){
        Transaction transaction=null;

        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(kh);
            transaction.commit();

        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }

    }
}

