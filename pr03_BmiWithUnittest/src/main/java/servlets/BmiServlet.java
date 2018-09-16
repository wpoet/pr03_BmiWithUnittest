/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wp
 */
@WebServlet(name = "BmiServlet", urlPatterns = "/calculateServlet")
public class BmiServlet extends HttpServlet {
 
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
 
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
 
        try {
            double bmi = calculateBMI(
              Double.parseDouble(weight), 
              Double.parseDouble(height));
             
            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));
 
            RequestDispatcher dispatcher 
              = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }
 
    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest ( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        response.setContentType ( "text/html;charset=UTF-8" );
        try (PrintWriter out = response.getWriter ()) {
            /* TODO output your page here. You may use following sample code. */
            out.println ( "<!DOCTYPE html>" );
            out.println ( "<html>" );
            out.println ( "<head>" );
            out.println ( "<title>Servlet NewServlet</title>" );            
            out.println ( "</head>" );
            out.println ( "<body>" );
            out.println ( "<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>" );
            out.println ( "</body>" );
            out.println ( "</html>" );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet ( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest ( request, response );
    }

    
}
