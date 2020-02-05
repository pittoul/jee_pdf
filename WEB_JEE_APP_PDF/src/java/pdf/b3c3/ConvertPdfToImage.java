/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import com.itextpdf.text.DocumentException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;
import static pdf.b3c3.IChemin.destination;



public class ConvertPdfToImage {
    public void ConvertPdfToImage() throws IOException, DocumentException {
        
        String pdfFileName = destination +"\\upload.pdf";
        
        PDDocument document = PDDocument.loadNonSeq(new File(pdfFileName), null);
        List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
        int page = 0;
        for (PDPage pdPage : pdPages)
        { 
            ++page;
            BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
            ImageIOUtil.writeImage(bim, pdfFileName + "-" + page + ".png", 300);
        }                  
    document.close();
    }
}
