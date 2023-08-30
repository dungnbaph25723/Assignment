package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.DongSP;
import com.example.Ass_java44.repository.DongSPRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {"/dong-sp","/detailDSP","/addDSP","/deleteDSP","/updateDSP"})
public class DongSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSPRepository dongSPRepository = new DongSPRepository();
        String uri = request.getRequestURI();
        if (uri.equals("/dong-sp")) {

            List<DongSP> list = dongSPRepository.getAll();
            request.setAttribute("listDongSP", list);
            request.getRequestDispatcher("dong-sp.jsp").forward(request, response);
        }else if(uri.contains("/detailDSP")){
            String id=request.getParameter("id");
            DongSP d=dongSPRepository.getByid(UUID.fromString(id));
            request.setAttribute("dongSP",d);
            request.getRequestDispatcher("detailDSP.jsp").forward(request,response);


        }else if(uri.contains("/deleteDSP")){

            String id=request.getParameter("id");
            DongSP d=dongSPRepository.getByid(UUID.fromString(id));

            dongSPRepository.delete(d);
            response.sendRedirect("dong-sp");

        }
//

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DongSPRepository dongSPRepository= new DongSPRepository();
        String uri= req.getRequestURI();
        if(uri.contains("/addDSP")){
            String ma=req.getParameter("ma");
            String ten=req.getParameter("ten");

            DongSP d=new DongSP();
            d.setMa(ma);
            d.setTen(ten);

            dongSPRepository.addNew(d);
            resp.sendRedirect("/dong-sp");

        }else if(uri.contains("/updateDSP")){
            String id=req.getParameter("id");
            String ma=req.getParameter("ma");
            String ten=req.getParameter("ten");

            DongSP d=new DongSP();
            d.setId(UUID.fromString(id));
            d.setMa(ma);
            d.setTen(ten);

            dongSPRepository.update(d);
            resp.sendRedirect("dong-sp");
        }
    }
}
