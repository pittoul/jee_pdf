/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import com.itextpdf.text.DocumentException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
public class ServletFusionPdf extends HttpServlet implements IChemin {

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
            String nom1 = request.getParameter("nomFichierOriginal1");
            String nom2 = request.getParameter("nomFichierOriginal2");

            System.out.println("FICHIER 1: -->" + nom1);
            System.out.println("FICHIER 1: -->" + nom2);
//            List<String> files = new ArrayList<>();
//            files.add(destination + "\\upload_" + nom1);
//            files.add(destination + "\\upload2_" + nom2);
            
            FusionPDF fusion = new FusionPDF();
            
            try {
	    //Prepare input pdf file list as list of input stream.
	    List<InputStream> inputPdfList = new ArrayList<InputStream>();
	    inputPdfList.add(new FileInputStream(destination + "\\uploadFusion1"));
	    inputPdfList.add(new FileInputStream(destination + "\\uploadFusion2"));
 
	    //Prepare output stream for merged pdf file.
            OutputStream outputStream = 
            		new FileOutputStream(destination + "\\" + "pdfFusion.pdf");
 
            //call method to merge pdf files.
            fusion.mergePdfFiles(inputPdfList, outputStream);     
	   } catch (Exception e) {
		e.printStackTrace();
	  }
            
            RequestDispatcher disp = request.getRequestDispatcher("ServletDownloadFile");
            disp.forward(request, response); // comme un include. Permet d'envoyer vers le servlet2
            HttpSession maSession = request.getSession();

            maSession.setAttribute("nomFichier", "pdfFusion.pdf");
            maSession.setAttribute("operation", "");
            
            
            
            
            
            
            /**
             * Redirection:
             */
            response.sendRedirect(request.getHeader("referer"));
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
