/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nimen
 */
public class ServletSupprPages extends HttpServlet implements IChemin {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws com.itextpdf.text.DocumentException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nomFichierOriginal");
//            String nomCourt = request.getParameter("nomCourtFichierOriginal");
//            String extension = request.getParameter("extensionFichierOriginal");
            String pageDepart = request.getParameter("pageDepart");
            String nbrePages = request.getParameter("nbrePages");
//            Enumeration<String> lesParametres = request.getParameterNames();
//            System.out.println("Les paramètres de la requete sont : ");
//            while (lesParametres.hasMoreElements()) {
//                String s = lesParametres.nextElement();
//                System.out.println(s);
//            }
//
            System.out.println("On est dans la servletSupprPages avant instanciation du bean SupprPageFromPdf");
            SupprPageFromPdf spr = new SupprPageFromPdf();
            System.out.println("Juste apres instanciation du bean SupprPageFromPdf");
            spr.supprPages(nom, Integer.parseInt(pageDepart), Integer.parseInt(nbrePages));
            System.out.println("SUPPRESSION DE PAGES TERMINEE !");
//            System.out.println("\ndans le Servlet RecupNom : " + nom + ",\nNom Court : " + nomCourt + ", \nExtension : " + extension);
//            System.out.println("\nnbre pages : " + nbrePages + ", \npageDepart : " + pageDepart);
//            System.out.println("\nAdresse du fichier : " + destination + "\\" + nom);
            RequestDispatcher disp = request.getRequestDispatcher("ServletDownloadFile");
            disp.forward(request, response); // comme un include. Permet d'envoyer vers le servlet2
            HttpSession maSession = request.getSession();

            maSession.setAttribute("nomFichier", nom);
            maSession.setAttribute("operation", "changedSuppr_");
//            /**
//             * Redirection:
//             */
//            response.sendRedirect(request.getHeader("referer"));
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(ServletSupprPages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(ServletSupprPages.class.getName()).log(Level.SEVERE, null, ex);
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
