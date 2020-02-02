    package pdf.b3c3;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;
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
public class ImageToPDF implements IChemin {

    public void ImageToPDF() throws IOException, DocumentException {
        FileUploadView fileUpload = new FileUploadView();
        System.out.println(fileUpload.toString());
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(destination + "/newPDF.pdf"));
        document.open();
        Image img = Image.getInstance(fileUpload.getNomFichier());
        img.scaleAbsoluteHeight(PageSize.A4.getHeight());
        img.scaleAbsoluteWidth(PageSize.A4.getWidth());
        document.add(img);
        document.close();
    }
}
