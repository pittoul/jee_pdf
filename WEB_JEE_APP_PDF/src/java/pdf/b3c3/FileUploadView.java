package pdf.b3c3;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.primefaces.shaded.commons.io.IOUtils;

/**
 *
 * Bean managé dont le nom sera le nom exac de la classe.
 *
 * @author Bruno
 */
@Named
@RequestScoped
public class FileUploadView implements IChemin {

    private UploadedFile file;
    private String nomFichier;
    private String nomFichier2;
    private String extensionFichier;
    private String nomCourt;
//    private int nbrePages = 0;
    private String cheminFichier = "";
    private String cheminFichier2 = "";
//    private String afficheImg = "";

    public String getCheminFichier2() {
        return cheminFichier2;
    }

    public void setCheminFichier2(String cheminFichier2) {
        this.cheminFichier2 = cheminFichier2;
    }


    public String getExtensionFichier() {
        return extensionFichier;
    }

    public String getNomFichier2() {
        return nomFichier2;
    }

    public void setNomFichier2(String nomFichier2) {
        this.nomFichier2 = nomFichier2;
    }

    public String getCheminFichier() {
        return cheminFichier;
    }

    public void setCheminFichier(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    public void setExtensionFichier(String extensionFichier) {
        this.extensionFichier = extensionFichier;
    }

//    public int getNbrePages() {
//        return nbrePages;
//    }
//
//    public void setNbrePages(int nbrePages) {
//        this.nbrePages = nbrePages;
//    }

    public String getNomCourt() {
        return nomCourt;
    }

    public void setNomCourt(String nomCourt) {
        this.nomCourt = nomCourt;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

//    public String getAfficheImg() {
//        return afficheImg;
//    }
    public UploadedFile getFile() {
        return file;
    }

//    public String getCheminImg() {
//        return cheminImg;
//    }
//    public void setTexteTest(String texteTest) {
//        this.cheminImg = texteTest;
//    }
    public void setFile(UploadedFile file) {
        System.out.println("- - - - - SET FILE - - - - - ");
        this.file = file;
    }

    public static String getDestination() {
        return destination;
    }

    public void upload() throws IOException {
        if (file != null) {
            String cheminDoc = destination + "\\" + file.getFileName();
            this.cheminFichier = destination + "\\upload_" + file.getFileName();

            FacesMessage message = new FacesMessage("Votre fichier", file.getFileName() + " a bien été envoyé");
            FacesContext.getCurrentInstance().addMessage(null, message);
            String filename = FilenameUtils.getName(file.getFileName());
            String filenameShort = FilenameUtils.removeExtension(file.getFileName());
            String extension = FilenameUtils.getExtension(file.getFileName());
//            Si c'est un pdf, on obtient le nombre de pages
//            try {
//                PdfDocument pdfDoc = new PdfDocument(new PdfReader(cheminDoc), new PdfWriter(destination + "\\" + "testXXXX"));
//                int n = pdfDoc.getNumberOfPages();
//                this.nbrePages = n;
//            } catch (Exception e) {
//                System.out.println("erreur ! " + e);
//            }
            this.nomFichier = filename;
            this.nomCourt = filenameShort;
            this.extensionFichier = extension;
            InputStream input = file.getInputstream();
//            OutputStream output = new FileOutputStream(new File(destination, (filenameShort + "_original.pdf")));
            OutputStream output = new FileOutputStream(new File(destination, ("upload_" + filename)));
            System.out.println("chemin : " + cheminDoc);
            // Copy the contents of the file to the output stream
            try {
                IOUtils.copy(input, output);
            } finally {
                IOUtils.closeQuietly(input);
                IOUtils.closeQuietly(output);
            }
        }
    }

    public void upload2() throws IOException {
        if (file != null) {
            String cheminDoc = destination + "\\" + file.getFileName();
            this.cheminFichier2 = destination + "\\upload2_" + file.getFileName();

            FacesMessage message = new FacesMessage("Votre fichier", file.getFileName() + " a bien été envoyé");
            FacesContext.getCurrentInstance().addMessage(null, message);
            String filename = FilenameUtils.getName(file.getFileName());
            String filenameShort = FilenameUtils.removeExtension(file.getFileName());
            String extension = FilenameUtils.getExtension(file.getFileName());
//            Si c'est un pdf, on obtient le nombre de pages
//            try {
//                PdfDocument pdfDoc = new PdfDocument(new PdfReader(cheminDoc), new PdfWriter(destination + "\\" + "testXXXX"));
//                int n = pdfDoc.getNumberOfPages();
//                this.nbrePages = n;
//            } catch (Exception e) {
//                System.out.println("erreur ! " + e);
//            }
            this.nomFichier2 = filename;
//            this.nomCourt = filenameShort;
//            this.extensionFichier = extension;
            InputStream input = file.getInputstream();
//            OutputStream output = new FileOutputStream(new File(destination, (filenameShort + "_original.pdf")));
            OutputStream output = new FileOutputStream(new File(destination, ("upload2_" + filename)));
            System.out.println("chemin : " + cheminDoc);
            // Copy the contents of the file to the output stream
            try {
                IOUtils.copy(input, output);
            } finally {
                IOUtils.closeQuietly(input);
                IOUtils.closeQuietly(output);
            }
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
