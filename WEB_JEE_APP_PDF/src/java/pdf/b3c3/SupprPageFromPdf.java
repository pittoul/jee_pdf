package pdf.b3c3;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.IOException;
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

    private String nomFichierOriginal;
    private final String SRC = destination + "\\" + "upload.pdf";
    private final String DEST = destination + "\\" + "changed.pdf";

    public void supprPages(int pageDeDepart, int nbreDePages) throws IOException {
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
        reader.close();
        writer.close();
    }
}
