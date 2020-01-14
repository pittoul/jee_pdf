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
 * @author nimen
 */
@Named
@RequestScoped
public class SupprPageFromPdf implements IChemin {
    private final String SRC = destination + "\\" + "original.pdf";
    private final String DEST = destination + "\\" + "changed.pdf";

    public void supprPages() throws IOException {
        PdfReader reader = new PdfReader(SRC);
        PdfWriter writer = new PdfWriter(DEST);
        try (PdfDocument document = new PdfDocument(reader, writer)) {
            document.removePage(1);
        }
    }
}