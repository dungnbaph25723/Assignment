package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.NSX;
import com.example.Ass_java44.repository.NSXRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {"/nha-san-xuat",
        "/detailNSX",
        "/addNSX",
        "/deleteNSX",
        "/updateNSX"})


public class NSXServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NSXRepository nsxRepository=new NSXRepository();
        String uri = request.getRequestURI();
        if (uri.equals("/nha-san-xuat")) {

            List<NSX> list = nsxRepository.getAll();
            request.setAttribute("listNSX", list);
            request.getRequestDispatcher("nha-san-xuat.jsp").forward(request, response);
        }else if(uri.contains("/detailNSX")){
            String id=request.getParameter("id");
            NSX nsx=nsxRepository.getById(UUID.fromString(id));
            request.setAttribute("nhaSanXuat",nsx);
            request.getRequestDispatcher("detailNSX.jsp").forward(request,response);

        }else if(uri.contains("/deleteNSX")){
            String id=request.getParameter("id");
            NSX nsx=nsxRepository.getById(UUID.fromString(id));
            nsxRepository.delete(nsx);
            response.sendRedirect("nha-san-xuat");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NSXRepository nsxRepository=new NSXRepository();
        String uri=req.getRequestURI();

        String ma=req.getParameter("ma");
        String ten=req.getParameter("ten");


        if(uri.contains("/addNSX")){
            NSX nsx=new NSX();

            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepository.add(nsx);
            resp.sendRedirect("nha-san-xuat");
        }else if (uri.contains("/updateNSX")){

            NSX nsx=new NSX();
            String id=req.getParameter("id");
            nsx.setMa(ma);
            nsx.setId(UUID.fromString(id));
            nsx.setTen(ten);
            nsxRepository.update(nsx);
            resp.sendRedirect("nha-san-xuat");
        }
    }
}
