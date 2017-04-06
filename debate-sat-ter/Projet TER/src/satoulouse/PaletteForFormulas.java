/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PaletteForFormulas.java
 *
 * Created on 25 sept. 2010, 19:08:52
 */
package satoulouse;

import debate.game.Referee;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * représente la palette avec les boutons où on peut insérer des "(<phi> and <psi>)" etc.
 * @author François Schwarzentruber
 */
public class PaletteForFormulas extends javax.swing.JPanel {

    private ArrayList<FormulaBox> fbs = new ArrayList<FormulaBox>();

    private void displayPropositions() {
        try {
            SATSolverSAT4J solver = new SATSolverSAT4J();
            FormulaArgumentDialog.loadFileCNF("temp.txt", solver);
            ArrayList<String> s = solver.returnPropositions();
            Collections.sort(s);//Tri par ordre alphabétique
            for (String p : s) {
                jToolBar1.add(new InsertionButton(fbs, p));
            }
        } catch (Exception ex) {
            Logger.getLogger(PaletteForFormulas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /** Creates new form PaletteForFormulas */
    public PaletteForFormulas() {
        initComponents();
        //ajout proposisions de la connaissance commune
        jToolBar1.add(new PaletteSeperationLabel("Propositions :"));
        try {
            displayPropositions();
        } catch (Exception ex) {
            Logger.getLogger(PaletteForFormulas.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ajout formules connaissances communes
        jToolBar1.add(new PaletteSeperationLabel("Formules :"));
        try {

            ArrayList<String> s = TextFile.lire_dans_un_fichier_lignes("temp.txt");
            for (String line : s) {
                jToolBar1.add(new InsertionButton(fbs, line));
            }
        } catch (IOException ex) {
            Logger.getLogger(PaletteForFormulas.class.getName()).log(Level.SEVERE, null, ex);
        }

        jToolBar1.add(new PaletteSeperationLabel("connecteurs :"));
        jToolBar1.add(new InsertionButton(fbs, "(<phi> and <psi>)", "insérer une conjonction (et)"));
        jToolBar1.add(new InsertionButton(fbs, "(not <phi>)", "insérer la négation de ..."));
        jToolBar1.add(new InsertionButton(fbs, "(<phi> or <psi>)", "insérer une disjonction (ou)"));
        jToolBar1.add(new InsertionButton(fbs, "(<phi> imply <psi>)", "insérer une implication"));
        jToolBar1.add(new InsertionButton(fbs, "(<phi> equiv <psi>)", "insérer une équivalence"));


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(1);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(satoulouse.SatoulouseApp.class).getContext().getResourceMap(PaletteForFormulas.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jToolBar1.add(jLabel1);

        add(jToolBar1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void addFormulaBoxToTreat(FormulaBox fb) {
        fbs.add(fb);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    void addFormulaFromReferee(Referee referee) {
    }

    void addFormulaPanel(List<String> formulaList, String string) {
        if (!formulaList.isEmpty()) {
            //ajout formules connaissances communes
            jToolBar1.add(new PaletteSeperationLabel(string));
            for (String s : formulaList) {
                jToolBar1.add(new InsertionButton(fbs, "" + s, "Insert Formula :" + s));
            }
        }
    }
}
