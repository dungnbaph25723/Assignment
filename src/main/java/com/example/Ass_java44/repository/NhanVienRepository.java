package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.NhanVien;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        List<NhanVien> listNV = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            listNV = session.createQuery("from NhanVien ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public NhanVien getByid(UUID id){
        NhanVien nv=new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nv = session.get(NhanVien.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nv;
    }



    public void addNew(NhanVien nhanVien){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Boolean delete(NhanVien nhanVien){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();

        }
        return false;
    }

    public Boolean update(NhanVien nhanVien){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();

        }
        return false;
    }
}
