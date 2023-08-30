package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.MauSac;
import com.example.Ass_java44.repository.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {"/mau-sac","/detailMS","/addMS","/updateMS","/deleteMS"})
public class MauSacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSacRepository mauSacRepository=new MauSacRepository();
        String uri = request.getRequestURI();
        if (uri.equals("/mau-sac")) {

            List<MauSac> list = mauSacRepository.getAll();
            request.setAttribute("listMS", list);
            request.getRequestDispatcher("mau-sac.jsp").forward(request, response);
        } else if (uri.contains("/detailMS")) {
            String id = request.getParameter("id");
            MauSac sp=mauSacRepository.getByid(UUID.fromString(id));
            request.setAttribute("mauSac",sp);
            request.getRequestDispatcher("detailMS.jsp").forward(request,response);

        }else if(uri.contains("/deleteMS")){
            String id=request.getParameter("id");
            MauSac ms=mauSacRepository.getByid(UUID.fromString(id));
            mauSacRepository.delete(ms);
            response.sendRedirect("mau-sac");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSacRepository mauSacRepository=new MauSacRepository();
        String uri=request.getRequestURI();
        if(uri.contains("/addMS")){
            String ma=request.getParameter("ma");
            String ten=request.getParameter("ten");

            MauSac sp=new MauSac();
            sp.setMa(ma);
            sp.setTen(ten);
            mauSacRepository.addNew(sp);
            response.sendRedirect("/mau-sac");

        }else if(uri.contains("/updateMS")){
            String id=request.getParameter("id");
            String ma=request.getParameter("ma");
            String ten=request.getParameter("ten");
            MauSac m=new MauSac();
            m.setId(UUID.fromString(id));
            m.setMa(ma);
            m.setTen(ten);

            mauSacRepository.update(m);

            response.sendRedirect("/mau-sac");

        }
    }
}
