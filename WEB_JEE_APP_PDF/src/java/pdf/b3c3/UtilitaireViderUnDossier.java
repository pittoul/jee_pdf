/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import java.io.File;

/**
 *
 * @author Bruno
 */
public class UtilitaireViderUnDossier {

    public void emptyDirectory(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                emptyDirectory(file);
            }
            file.delete();
        }
    }
}
