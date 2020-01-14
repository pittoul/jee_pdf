
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
public class FileDownloadView implements IChemin {

    private StreamedContent file;

    public StreamedContent getDownloadValue() throws Exception {
        StreamedContent download = new DefaultStreamedContent();
        File file = new File(destination+"/Fichier a telecharcher ici.pdf");
        InputStream input = new FileInputStream(file);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        download = new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName());
    System.out.println("PREP = " + download.getName());
        return download;
    }

    public StreamedContent getFile() {
        return file;
    }
}
