/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.kernel.geom.AffineTransform;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import static pdf.b3c3.MergeAndAddFont.FONT;

/**
 *
 * @author Bruno
 */
public class FusionPDF implements IChemin {
    
    
    
    protected void manipulatePdf(String[] files, String dest) throws Exception {
//        for (int i = 0; i < files.length; i++) {
//
//            // Create pdf files with font, which will be embedded into the target document,
//            // and only the used glyphs will be included in the font.
//            createPdf(files[i], CONTENT[i], true, true);
//        }
//
//        mergeFiles(files, dest + DEST_NAMES.get("A1"), false);
//        mergeFiles(files, dest + DEST_NAMES.get("A2"), true);
//
//        for (int i = 0; i < FILE_B.length; i++) {
//
//            // Create pdf files with font, which will embedded into the target document.
//            // Full font will be included and all subset ranges will be removed
//            createPdf(FILE_B[i], CONTENT[i], true, false);
//        }
//
//        mergeFiles(FILE_B, dest + DEST_NAMES.get("B1"), false);
//        mergeFiles(FILE_B, dest + DEST_NAMES.get("B2"), true);
//
//        for (int i = 0; i < FILE_C.length; i++) {
//
//            // Create pdf files with font, which won't be embedded into the target document.
//            // Full font will be included and all subset ranges will be removed
//            createPdf(FILE_C[i], CONTENT[i], false, false);
//        }
//
//        mergeFiles(FILE_C, dest + DEST_NAMES.get("C1"), true);
//
//        // Embed the font manually
//        embedFont(dest + DEST_NAMES.get("C1"), FONT, dest + DEST_NAMES.get("C2"));
    }
    

    /**
     * 
     * @param files
     * @param result // le nom du pdf resultant de la fusion
     * @param isSmartModeOn
     * @throws IOException 
     */
    public void mergeFiles(String[] files, String result, boolean isSmartModeOn) throws IOException {
        com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(result);

        // In smart mode when resources (such as fonts, images,...) are encountered,
        // a reference to these resources is saved in a cache and can be reused.
        // This mode reduces the file size of the resulting PDF document.
        writer.setSmartMode(isSmartModeOn);
        PdfDocument pdfDoc = new PdfDocument(writer);

        // This method initializes an outline tree of the document and sets outline mode to true.
        pdfDoc.initializeOutlines();

        for (int i = 0; i < files.length; i++) {
            PdfDocument addedDoc = new PdfDocument(new PdfReader(files[i]));
            addedDoc.copyPagesTo(1, addedDoc.getNumberOfPages(), pdfDoc);
            addedDoc.close();
        }

        pdfDoc.close();
    }

    public void createPdf(String filename, String text, boolean embedded, boolean subset) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new com.itextpdf.kernel.pdf.PdfWriter(filename));
        com.itextpdf.layout.Document doc = new com.itextpdf.layout.Document(pdfDoc);

        // The 3rd parameter indicates whether the font is to be embedded into the target document.
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.WINANSI, embedded);

        // When set to true, only the used glyphs will be included in the font.
        // When set to false, the full font will be included and all subset ranges will be removed.
        font.setSubset(subset);
        doc.add(new Paragraph(text).setFont(font));

        doc.close();
    }
}
