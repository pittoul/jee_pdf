/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.List;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author nimen
 */
public class ServletRecupNomFichier extends HttpServlet implements IChemin {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nomFichierOriginal");
            String nomCourt = request.getParameter("nomCourtFichierOriginal");
            String extension = request.getParameter("extensionFichierOriginal");
            String pageDepart = request.getParameter("pageDepart");
            String nbrePages = request.getParameter("nbrePages");
            Enumeration<String> lesParametres = request.getParameterNames();
            System.out.println("Les paramètres de la requete sont : ");
            while (lesParametres.hasMoreElements()) {
                String s = lesParametres.nextElement();
                System.out.println(s);
            }
            
            SupprPageFromPdf spr = new SupprPageFromPdf();
            spr.supprPages(Integer.parseInt(pageDepart), Integer.parseInt(nbrePages));
            
            
            
            
            System.out.println("\ndans le Servlet RecupNom : " + nom + ",\nNom Court : " + nomCourt + ", \nExtension : " + extension);
            System.out.println("\nnbre pages : " + nbrePages + ", \npageDepart : " + pageDepart);
            response.sendRedirect(request.getHeader("referer"));
//            PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
//            PdfDocument ppp = new PdfDocument(IChemin.destination + "\\" + nom);
//            int n = pdfDoc.getNumberOfPages();
//            System.out.println("nbre de pages : " + n);
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletRecupNomFichier</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ServletRecupNomFichier at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
