package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.*;
import com.example.Ass_java44.repository.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSanPhamServlet", value = {
        "/hien-thi",
        "/detailCTSP",
        "/deleteCTSP",
        "/updateCTSP",
        "/addCTSP",

})
public class ChiTietSanPhamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();

        SanPhamRepository sanPhamRepository = new SanPhamRepository();
        List<SanPham> listSP = sanPhamRepository.getAll();
        req.setAttribute("listSP", listSP);

        NSXRepository nsxRepository=new NSXRepository();
        List<NSX> listNSX=nsxRepository.getAll();
        req.setAttribute("listNSX",listNSX);

        MauSacRepository mauSacRepository=new MauSacRepository();
        List<MauSac>listMS=mauSacRepository.getAll();
        req.setAttribute("listMauSac",listMS);

        DongSPRepository dongSPRepository=new DongSPRepository();
        List<DongSP> listDSP=dongSPRepository.getAll();
        req.setAttribute("listDongSP",listDSP);

        ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

        if(uri.contains("/hien-thi")) {

            List<ChiTietSanPham> listCTSP = chiTietSanPhamRepository.getAll();
            req.setAttribute("listCTSP", listCTSP);
            req.getRequestDispatcher("ctsp.jsp").forward(req, resp);
        }else if(uri.contains("/detailCTSP")){
            String id=req.getParameter("id");
            ChiTietSanPham chiTietSanPham=chiTietSanPhamRepository.getByid(UUID.fromString(id));
            req.setAttribute("detail",chiTietSanPham);
            req.getRequestDispatcher("detailCTSP.jsp").forward(req,resp);
        }else if(uri.contains("/deleteCTSP")){
            String id=req.getParameter("id");
            ChiTietSanPham chiTietSanPham=chiTietSanPhamRepository.getByid(UUID.fromString(id));
            chiTietSanPhamRepository.delete(chiTietSanPham);
            resp.sendRedirect("hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
        String uri=req.getRequestURI();
        String id=req.getParameter("id");

        String idSp = req.getParameter("idSP");
        String idNSX = req.getParameter("idNSX");
        String idMauSac = req.getParameter("idMS");
        String idDSP = req.getParameter("idDSP");
        String namBh = req.getParameter("namBH");
        String moTa = req.getParameter("moTa");
        String soLuongTon = req.getParameter("soLuongTon");
        String giaNhap = req.getParameter("giaNhap");
        String giaBan = req.getParameter("giaBan");

        SanPham sanPham = new SanPham();
        sanPham.setId(UUID.fromString(idSp));

        NSX nsx = new NSX();
        nsx.setId(UUID.fromString(idNSX));

        MauSac mauSac = new MauSac();
        mauSac.setId(UUID.fromString(idMauSac));

        DongSP d = new DongSP();
        d.setId(UUID.fromString(idDSP));
        if(uri.contains("/addCTSP")) {

            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.setSanPham(sanPham);
            chiTietSanPham.setNsx(nsx);
            chiTietSanPham.setMauSac(mauSac);
            chiTietSanPham.setDongSP(d);
            chiTietSanPham.setGiaBan(Integer.parseInt(giaBan));
            chiTietSanPham.setGiaNhap(Integer.parseInt(giaNhap));
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setSoLuongTon(Integer.parseInt(soLuongTon));
            chiTietSanPham.setNamBH(Integer.parseInt(namBh));

            // new ChiTietSanPhamRepository().addNew(chiTietSanPham);

            chiTietSanPhamRepository.addNew(chiTietSanPham);
            resp.sendRedirect("/hien-thi");

        }else if(uri.contains("/updateCTSP")){
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham(
                    UUID.fromString(id),
                    sanPham,
                    nsx,
                    mauSac,
                    d,
                    Integer.parseInt(namBh),
                    moTa,
                    Integer.parseInt(soLuongTon),
                    Float.parseFloat(giaNhap),
                    Float.parseFloat(giaBan));


            chiTietSanPhamRepository.update(chiTietSanPham);
            resp.sendRedirect("hien-thi");
        }
    }

}

