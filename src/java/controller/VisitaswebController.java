/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.dao.visitasDao;
import com.dao.visitasDatoImpl;
import com.model.pojo.Visitasweb;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ricardo.barrientos
 */
public class VisitaswebController extends HttpServlet {

    Visitasweb visitasweb = new Visitasweb();
    visitasDatoImpl visitasDaoImpl = new visitasDatoImpl();
    visitasDao dao;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("addVisitas") != null) {
            BigInteger id = new BigInteger(request.getParameter("id"));
            String usuario = request.getParameter("usuario");
            BigInteger idpantalla = new BigInteger(request.getParameter("idpantalla"));
            //Date fecha = new Date(request.getParameter("fecha"));
            //visitasweb.setFecha(fecha);
            visitasweb.setUsuario(usuario);
            visitasweb.setIdpantalla(idpantalla);
            visitasDaoImpl.saveVisita(visitasweb);
            RequestDispatcher rd = request.getRequestDispatcher("crear.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("Nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("pages/crear.jsp");
            rd.forward(request, response);
        }
        if (accion.equals("Agregar")) {
            try {
                BigInteger id = new BigInteger(request.getParameter("id"));
                String usuario = request.getParameter("usuario");
                BigInteger idpantalla = new BigInteger(request.getParameter("idpantalla"));
                String startDateStr = request.getParameter("fecha");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(startDateStr);
                visitasweb.setId(id);
                visitasweb.setFecha(fecha);
                visitasweb.setUsuario(usuario);
                visitasweb.setIdpantalla(idpantalla);
                visitasDaoImpl.saveVisita(visitasweb);
                RequestDispatcher rd = request.getRequestDispatcher("pages/crear.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(VisitaswebController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (accion.equals("Listar")) {
            List<Visitasweb> visitasList = new ArrayList();
            visitasList = visitasDaoImpl.showAllVisitas();
            request.setAttribute("visitasList", visitasList);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        if (accion.equals("Editar")) {
            Visitasweb visita = visitasDaoImpl.showVisita(new BigInteger(request.getParameter("id")));
            request.setAttribute("visita", visita);
            RequestDispatcher rd = request.getRequestDispatcher("pages/editar.jsp");
            rd.forward(request, response);
        }
        if (accion.equals("Actualizar")) {
            try {
                BigInteger id = new BigInteger(request.getParameter("id"));
                String usuario = request.getParameter("usuario");
                BigInteger idpantalla = new BigInteger(request.getParameter("idpantalla"));
                String startDateStr = request.getParameter("fecha");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(startDateStr);
                //Date fecha = new Date(request.getParameter("fecha"));
                visitasDaoImpl.updateVisita(id, usuario, idpantalla, startDate);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(VisitaswebController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (accion.equals("Eliminar")) {
            System.out.println(request.getParameter("id"));
            BigInteger id = new BigInteger(request.getParameter("id"));
            visitasweb.setId(id);
            visitasDaoImpl.deleteVisita(visitasweb);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
