package pdf.b3c3;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
@Named
@RequestScoped
public class SupprPageFromPdf implements IChemin {

    File f = new File(destination);
    private String[] pathnames;
    private String SRC = destination + "\\";
    private String DEST = destination + "\\";

    public void supprPages(String nomFichier, int pageDeDepart, int nbreDePages) throws IOException {

    
        SRC = SRC + "upload_" + nomFichier;
        DEST = DEST + "changedSuppr_" + nomFichier;

        PdfReader reader = new PdfReader(SRC);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
        int n = pdfDoc.getNumberOfPages();
        System.out.println("nbre de pages : " + n);
        boolean validation1 = (pageDeDepart <= n);
        boolean validation2 = (nbreDePages <= (n - pageDeDepart));
        try (PdfDocument document = new PdfDocument(reader, writer)) {
            if (validation1 && validation2) {
                for (int i = 0; i < nbreDePages; i++) {
                    document.removePage(pageDeDepart);
                }
            }
        }
        
        System.out.println("Dans bean Suppr " );
        reader.close();
        writer.close();
    }
}
