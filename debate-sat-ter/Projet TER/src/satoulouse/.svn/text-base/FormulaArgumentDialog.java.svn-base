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

import debate.game.Player;
import debate.game.Referee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author Propriétaire
 */
public class FormulaArgumentDialog extends javax.swing.JDialog {

    ArrayList<FormulaBox> formulaBoxes;
    private int formulaBoxIndiceCourant = 0;
    private final PaletteForFormulas paletteForFormulas;
    SATSolverSAT4J solver;

    /** Creates new form FormulaArgumentDialog */
    public FormulaArgumentDialog(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulaBoxes = new ArrayList<FormulaBox>();
        paletteForFormulas = new PaletteForFormulas();
        jScrollPane2.setViewportView(paletteForFormulas);

        reset();
    }

    public void addFormulaFromReferee(Referee referee) {
        paletteForFormulas.addFormulaPanel(referee.getFormulaList(), "Common Formulas :");
    }

    public void addFormulaFromPlayer(Player player) {
        paletteForFormulas.addFormulaPanel(player.getFormulaList(), "Player Formulas :");
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
            Logger.getLogger(FormulaArgumentDialog.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    private void lireFichier(String chemin) {
        ArrayList<String> s;
        try {
            s = TextFile.lire_dans_un_fichier_lignes(chemin); // TODO add your handling code here:
            reset();
            for (int i = 0; i < s.size(); i++) {
                addFormula(s.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichier " + chemin + "introuvable");
        } catch (IOException ex) {
            System.out.println("Fichier " + chemin + "introuvable");
        }

    }

    private void lireFichierCNF(String chemin) {
        ArrayList<String> s;
        try {
            s = TextFile.lire_dans_un_fichier_lignes(chemin); // TODO add your handling code here:
            reset();
            for (String clause : Formula.createListFormulaFromCNFFile(s)) {
                addFormula(clause);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichier " + chemin + "introuvable");
        } catch (IOException ex) {
            System.out.println("Fichier " + chemin + "introuvable");
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

        formulaBoxes.clear();
        jPanelFormulas.removeAll();


        for (int i = 0; i < 2; i++) {
            formulaBoxes.add(new FormulaBox());
        }

        for (FormulaBox formulaBox : formulaBoxes) {
            formulaBox.doLayout();
            jPanelFormulas.add(formulaBox);
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPaneFormulas = new javax.swing.JScrollPane();
        jPanelFormulas = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(240, 32767));
        jScrollPane2.setName("jScrollPane2"); // NOI18N
        mainPanel.add(jScrollPane2);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setText("Valider");
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

        jPanel2.add(jPanel3);

        jScrollPaneFormulas.setName("jScrollPaneFormulas"); // NOI18N

        jPanelFormulas.setName("jPanelFormulas"); // NOI18N
        jPanelFormulas.setLayout(new javax.swing.BoxLayout(jPanelFormulas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPaneFormulas.setViewportView(jPanelFormulas);

        jPanel2.add(jScrollPaneFormulas);

        mainPanel.add(jPanel2);

        menuBar.setFocusable(false);
        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText("Fichier");
        fileMenu.setFocusable(false);
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem9.setText("Reset");
        jMenuItem9.setName("jMenuItem9"); // NOI18N
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem9);

        jMenuItem15.setText("Importer une liste de formules...");
        jMenuItem15.setName("jMenuItem15"); // NOI18N
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem15);

        jMenuItem16.setText("Sauvegarder ma liste de formules dans un fichier...");
        jMenuItem16.setName("jMenuItem16"); // NOI18N
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem16);

        menuBar.add(fileMenu);

        jMenu2.setText("Insérer");
        jMenu2.setFocusable(false);
        jMenu2.setName("jMenu2"); // NOI18N

        jMenuItem7.setText("Insérer une conjonction qui décrit une grille...");
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        reset();
}//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setDialogTitle("Ouvrir une liste de formules d'un fichier...");
        fc.setFileFilter((javax.swing.filechooser.FileFilter) getFileFilterLoad());
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String fichierNomAOuvrir = fc.getSelectedFile().getAbsolutePath();

            if (fichierNomAOuvrir.endsWith(".cnf")) {
                lireFichierCNF(fichierNomAOuvrir);
            } else {
                lireFichier(fichierNomAOuvrir);
            }
        }
}//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        String fichierNom = demanderFichierNomPourSauvegarder();
        if (fichierNom != null) {
            sauvegarderFichier(fichierNom);
        }
}//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        FormulaBox f = getFocusFormulaBox();

        if (f == null) {
            JOptionPane.showMessageDialog(this, "Sélectionne un endroit où écrire une formule");
            return;
        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
}//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        FormulaArgumentDialog dialog = new FormulaArgumentDialog(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
        System.exit(0);
        }
        });
        dialog.setVisible(true);*/
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setBounds(0, 0, 100, 100);
        new FormulaArgumentDialog(f, true).setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFormulas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneFormulas;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    public JButton getValidateButton() {
        return jButton1;
    }

    // Listener sur le bouton d'envoi de formule
    public void setSendFormulaListener(final Runnable listener) {
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
                solver = new SATSolverSAT4J();
                for (FormulaBox f : formulaBoxes) {
                    if (!f.isEmpty()) {
                        solver.addFormula(f.getFormulaForSAT4J());
                        s.add(f.getText());
                    }
                }
                loadFileCNF("temp.txt", solver);

                try {
                    ArrayList<String> result = solver.isSATFormulaInSchemeVar();
                    if (result != null) {
                        JOptionPane.showMessageDialog(null, "Formula accepted");
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
