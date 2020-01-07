package site.negocio.carlosmachado.core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Write {

    public static void writeStringOnTxtFile(String str, String path) {
        String extension = ".txt";
        if(path.contains(extension)){
            extension = "";
        }
        try {
            FileWriter fw = new FileWriter(path + extension);
            PrintWriter pw = new PrintWriter(fw);
            pw.printf(str);
        } catch (IOException ex) {
            Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo.");
        }
    }

}
