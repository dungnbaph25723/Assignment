package com.example.Ass_java44.repository;

import com.example.Ass_java44.entity.ChiTietSanPham;
import com.example.Ass_java44.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {


    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            listCTSP = session.createQuery("from ChiTietSanPham ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }

    public ChiTietSanPham getByid(UUID id){
        ChiTietSanPham c=new ChiTietSanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            c = session.get(ChiTietSanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }



    public void addNew(ChiTietSanPham chiTietSanPham){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSanPham);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Boolean delete(ChiTietSanPham chiTietSanPham){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSanPham);
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

    public Boolean update(ChiTietSanPham chiTietSanPham){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(chiTietSanPham);
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



//    public static void main(String[] args) {
//        ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
//
//        List<ChiTietSanPham> list = new ArrayList<>();
//        list = chiTietSanPhamRepository.getAll();
//
//        for (ChiTietSanPham chiTietSanPham: list){
//
//            System.out.println(chiTietSanPham.getSanPham().getTen().toString());
//        }
//    }
}