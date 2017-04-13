/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormulaArgumentDialog.java
 *
 * Created on 17 avr. 2012, 19:32:16
 */
package satoulouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Propriétaire
 */
public class ArgumentDialog extends javax.swing.JDialog {

    ArrayList<FormulaBox> formulaBoxes;
    private int formulaBoxIndiceCourant = 0;
    private final PaletteForFormulas paletteForFormulas;
    private boolean success;
    private SATSolverSAT4J playersolver;

    /** Creates new form FormulaArgumentDialog */
    public ArgumentDialog(javax.swing.JFrame parent, SATSolverSAT4J playersolver, boolean modal) {
        super(parent, modal);
        initComponents();
        formulaBoxes = new ArrayList<FormulaBox>();
        paletteForFormulas = new PaletteForFormulas();
        jScrollPane2.setViewportView(paletteForFormulas);
        this.playersolver = playersolver;
        reset();
    }

    public boolean getSuccess() {
        return success;
    }

    private FormulaBox getFocusFormulaBox() {

        for (FormulaBox fb : formulaBoxes) {
            if (fb.isFocusOwner()) {
                return fb;
            }
        }

        return FormulaBox.getFocusOwnerFormulaBox();
    }

    public ArrayList<String> getArrayListFormulas() {
        ArrayList<String> s = new ArrayList<String>();
        for (FormulaBox f : formulaBoxes) {
            if (!f.isEmpty()) {
                s.add(f.getText());
            }

        }
        return s;
    }

    public static void loadFileCNF(String chemin, SATSolverSAT4J solver) {
        try {
            ArrayList<String> s = TextFile.lire_dans_un_fichier_lignes(chemin);
            for (int i = 0; i < s.size(); i++) {
                solver.addFormula(new FormulaForSAT4J(new Formula(s.get(i))));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Fichier " + chemin + "introuvable");
        } catch (IOException ex) {
            Logger.getLogger(ArgumentDialog.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    private void sauvegarderFichier(String chemin) {
        ArrayList<String> s = getArrayListFormulas();
        try {
            TextFile.string_ecrire_dans_fichier_lignes(s, chemin);
        } catch (IOException ex) {
            System.out.println("Fichier " + chemin + "introuvable");
        }
    }

    private FileFilter getFileFilterSave() {
        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".txt");
                }
            }

            public String getDescription() {
                return "Fichier texte SAToulouse (*.txt)";
            }
        };
    }

    private FileFilter getFileFilterLoad() {
        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".txt") || f.getName().endsWith(".cnf");
                }
            }

            public String getDescription() {
                return "Fichier texte SAToulouse (*.txt) | Fichier DIMACS cnf (*.cnf)";
            }
        };
    }

    private String demanderFichierNomPourSauvegarder() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Sauvegarder une liste de formules dans un fichier...");
        fc.setFileFilter((javax.swing.filechooser.FileFilter) getFileFilterSave());
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (fc.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                return fc.getSelectedFile().getAbsolutePath();
            } else {
                return fc.getSelectedFile().getAbsolutePath() + ".txt";
            }

        } else {
            return null;
        }


    }

    private boolean isOK() {
        for (FormulaBox f : formulaBoxes) {
            if (!f.isOK()) {
                return false;
            }
        }
        return true;
    }

    private void reset() {
        int indice = formulaBoxes.size();
        if (indice == 0) {
            indice++;
        } else {
            formulaBoxes.get(formulaBoxes.size() - 1).setVisible(false);
            formulaBoxes.get(formulaBoxes.size() - 1).getjLblError().setVisible(false);
        }
        formulaBoxes.clear();
        System.out.println(formulaBoxes.size());
        jPanelFormulas.removeAll();

        for (int i = 0; i < indice; i++) {
            FormulaBox f = new FormulaBox();
            f.doLayout();
            formulaBoxes.add(f);
            jPanelFormulas.add(f);
        }

        jScrollPaneFormulas.revalidate();
        jPanelFormulas.doLayout();
        jScrollPaneFormulas.doLayout();

        formulaBoxIndiceCourant = 0;

        for (FormulaBox f : formulaBoxes) {
            paletteForFormulas.addFormulaBoxToTreat(f);
        }

    }

    private void addFormula(String formula) {
        if (formulaBoxIndiceCourant >= formulaBoxes.size()) {
            FormulaBox formulaBox = new FormulaBox();
            formulaBoxes.add(formulaBox);
            jPanelFormulas.add(formulaBox);

        }

        formulaBoxes.get(formulaBoxIndiceCourant).setText(formula);
        formulaBoxIndiceCourant++;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPaneFormulas = new javax.swing.JScrollPane();
        jPanelFormulas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formulaBox1 = new satoulouse.FormulaBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Argument writer");

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(240, 32767));
        jScrollPane2.setName("jScrollPane2"); // NOI18N
        mainPanel.add(jScrollPane2, java.awt.BorderLayout.WEST);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setName("jPanel3"); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        jButton2.setToolTipText("Add a field for a new formula");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        jButton1.setToolTipText("Submit your argument");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/less.png"))); // NOI18N
        jButton4.setToolTipText("Clear all");
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jScrollPaneFormulas.setName("jScrollPaneFormulas"); // NOI18N

        jPanelFormulas.setName("jPanelFormulas"); // NOI18N
        jPanelFormulas.setLayout(new javax.swing.BoxLayout(jPanelFormulas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPaneFormulas.setViewportView(jPanelFormulas);

        jPanel2.add(jScrollPaneFormulas, java.awt.BorderLayout.CENTER);

        jPanel1.setName("jPanel1");
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("                                                                  Enter your conclusion here");
        jLabel1.setName("jLabel1");
        jPanel1.add(jLabel1);

        formulaBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        formulaBox1.setName("formulaBox1"); // NOI18N
        jPanel1.add(formulaBox1);

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        mainPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkSelfConsistency(SATSolverSAT4J solver) {
        success = false;
        checkConsistency(solver, "Self consistency");
        return success;
    }

    private boolean checkGloballyConsistency(SATSolverSAT4J solver) {
        loadFileCNF("src/formulas/temp.txt", solver);
        success = false;
        checkConsistency(solver, "Globally consistency");
        // Si ce qui a été entré est consistent avec les connaissances communes,
        //success sera repassé à true;
        return success;
    }

    public SATSolverSAT4J getPlayersolver() {
        return playersolver;
    }

    private void checkConsistency(SATSolverSAT4J solver, String title) {
        try {
            if (solver.isSATFormulaInSchemeVar() != null) {
                success = true;
            } else {
                JOptionPane.showMessageDialog(this, "Formula refused",
                        title, JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            SchemeWithKawa.restart();
            JOptionPane.showMessageDialog(this, ex,
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!isOK()) {
            JOptionPane.showMessageDialog(this, "Tatata ! Tu as des erreurs dans les formules que tu as entré. D'abord, tu me vérifies ça !!",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (formulaBox1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You have not entered a conclusion for your argument",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        playersolver.addFormula(formulaBox1.getFormulaForSAT4J());

        for (FormulaBox f : formulaBoxes) {
            if (!f.isEmpty()) {
                playersolver.addFormula(f.getFormulaForSAT4J());
            }
        }

        if (checkSelfConsistency(playersolver)) {
            checkGloballyConsistency(playersolver);
        }

        this.dispose();
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FormulaBox formulaBox = new FormulaBox();
        formulaBoxes.add(formulaBox);
        jPanelFormulas.add(formulaBox);
        paletteForFormulas.addFormulaBoxToTreat(formulaBox);
        jScrollPaneFormulas.revalidate();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    public String getConclusion() {
        return formulaBox1.getText();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setBounds(0, 0, 100, 100);
        new ArgumentDialog(f, new SATSolverSAT4J(), true).setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private satoulouse.FormulaBox formulaBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFormulas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneFormulas;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    // Listener sur le bouton d'envoi de formule
    public void setSendArgueListener(final Runnable listener) {
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!isOK()) {
                    JOptionPane.showMessageDialog(null, "Tatata ! Tu as des erreurs dans les formules que tu as entré. D'abord, tu me vérifies ça !!",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }
                ArrayList<String> s = new ArrayList<String>();
                playersolver = new SATSolverSAT4J();
                for (FormulaBox f : formulaBoxes) {
                    if (!f.isEmpty()) {
                        playersolver.addFormula(f.getFormulaForSAT4J());
                        s.add(f.getText());
                    }
                }
                loadFileCNF("temp.txt", playersolver);

                try {
                    ArrayList<String> result = playersolver.isSATFormulaInSchemeVar();
                    if (result != null) {
                        JOptionPane.showMessageDialog(null, "Formula accepted");
                        //Tout est correct on peut valider l'argument
                        listener.run();
                    } else {
                        JOptionPane.showMessageDialog(null, "Formula refused",
                                "Unsatisfiability", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    

                } catch (Exception ex) {
                    SchemeWithKawa.restart();
                    JOptionPane.showMessageDialog(null, ex,
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                

            }
        });
    }


}
