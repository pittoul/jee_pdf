/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Bruno
 */
@Named
@RequestScoped
public class FileDownloadView implements IChemin{
 
    private StreamedContent file;
 
    public FileDownloadView() {
//        file = DefaultStreamedContent.builder()
//                .name("downloaded_boromir.jpg")
//                .contentType("image/jpg")
//                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg"))
//                .build();
    }
 
    public StreamedContent getFile() {
        return file;
    }
}