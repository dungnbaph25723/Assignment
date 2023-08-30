package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.CuaHang;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {

    public List<CuaHang> getAll() {
        List<CuaHang> listCuaHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            listCuaHang = session.createQuery("from CuaHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCuaHang;
    }

    public CuaHang getByid(UUID id){
        CuaHang cuaHang=new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            cuaHang = session.get(CuaHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cuaHang;
    }

    public void addNew(CuaHang cuaHang){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
        }catch(Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Boolean delete(CuaHang ch){
        Transaction transaction =null;
        try { Session session=HibernateUtil.getFACTORY().openSession();
            transaction =session.beginTransaction();
            session.delete(ch);
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


    public Boolean update(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(cuaHang);
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
