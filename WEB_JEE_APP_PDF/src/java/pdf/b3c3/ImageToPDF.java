package pdf.b3c3;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.imageio.ImageIO;
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

    public void ImageToPDF(String nomFichier) throws IOException, DocumentException {

        String url = destination + "\\upload_" + nomFichier;
        Image img = Image.getInstance(url);
        BufferedImage bimg = ImageIO.read(new File(url));
        int width = bimg.getWidth();
        int height = bimg.getHeight();
        Rectangle pageSize = new Rectangle(width, height);
        Document document = new Document(pageSize);
        PdfWriter.getInstance(document, new FileOutputStream(destination + "/imgEnPdf_" + nomFichier));
        document.open();
        img.scaleAbsoluteHeight(height);
        img.scaleAbsoluteWidth(width);
        document.add(img);
        document.close();
    }
}
