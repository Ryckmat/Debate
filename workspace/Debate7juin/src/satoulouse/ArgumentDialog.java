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
import debate.logical.Argument;
import debate.tools.ErrorEnum;
import debate.tools.MessageDialog;
import java.awt.Window;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
    private Referee r;

    /** Creates new form FormulaArgumentDialog */
    public ArgumentDialog(javax.swing.JFrame parent, SATSolverSAT4J playersolver, Referee r, boolean modal) {
        super(parent, modal);
        initComponents();
        formulaBoxes = new ArrayList<>();
        paletteForFormulas = new PaletteForFormulas(r.getTopics());
        jScrollPane2.setViewportView(paletteForFormulas);
        this.playersolver = (SATSolverSAT4J) playersolver.clone();
        this.r = r;
        reset();
    }

    public boolean getSuccess() {
        return success;
    }

    private FormulaBox getFocusFormulaBox() {

        for (FormulaBox fb : formulaBoxes) 
            if (fb.isFocusOwner()) 
                return fb;
        
        return FormulaBox.getFocusOwnerFormulaBox();
    }

    public ArrayList<String> getArrayListFormulas() {
        ArrayList<String> s = new ArrayList<>();
        for (FormulaBox f : formulaBoxes) 
            if (!f.isEmpty()) 
                s.add(f.getText());
        return s;
    }

    private void saveClausesinTextFile(String filepath) throws FileNotFoundException, IOException {
        ArrayList<String> clauses = TextFile.lire_dans_un_fichier_lignes(filepath);
        ArrayList<String> s = getArrayListFormulas();
        ArrayList<String> res = new ArrayList<>();
        for (String ch : s) 
            if (!clauses.contains(ch)) 
                res.add(ch);

        try {
            TextFile.string_ecrire_dans_fichier_lignes(res, filepath);
        } catch (IOException ex) {
            System.out.println("Fichier " + filepath + "introuvable");
        }
    }

    private boolean isOK() {
        for (FormulaBox f : formulaBoxes) 
            if (!f.isOK()) 
                return false;

        return true;
    }

    private void reset() {
        int indice = formulaBoxes.size();
        if (indice == 0) 
            indice++;
         else {
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

    public void addFormula(String formula) {
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

    private boolean checkSelfConsistency() {
        success = false;
        checkConsistency(playersolver, ErrorEnum.SelfConsistencyArgument);
        return success;
    }

    private boolean checkGloballyConsistency(SATSolverSAT4J so) {
        success = false;
        checkConsistency(so, ErrorEnum.GlobalConsistencyArgument);
        // Si ce qui a été entré est consistent avec les connaissances communes, 
        // success sera repassé à true;
        return success;
    }

    public SATSolverSAT4J getPlayersolver() {
        return playersolver;
    }

    private void checkConsistency(SATSolverSAT4J solver, ErrorEnum err) {
        try {
            if (solver.isSATFormulaInSchemeVar() != null) {
                success = true;
            } else 
                MessageDialog.displayErrorMessage((Window)this, err);

        } catch (Exception ex) {
            SchemeWithKawa.restart();
            MessageDialog.displayErrorMessage((Window)this, ErrorEnum.Solver);
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!isOK()) {
            MessageDialog.displayErrorMessage((Window)this, ErrorEnum.MistakenFormula);                
            return;
        }

        if (formulaBox1.isEmpty()) {
            MessageDialog.displayErrorMessage((Window)this, ErrorEnum.ForgottenConclusion);
            return;
        }
        playersolver.addFormula(formulaBox1.getFormulaForSAT4J());
        SATSolverSAT4J refereesolver = new SATSolverSAT4J();
        refereesolver.addFormula(formulaBox1.getFormulaForSAT4J());
        loadClausesFromFormulaList(refereesolver);

        for (FormulaBox f : formulaBoxes) {
            if (!f.isEmpty()){
                refereesolver.addFormula(f.getFormulaForSAT4J());
                playersolver.addFormula(f.getFormulaForSAT4J());
            }
        }
        
        if (checkSelfConsistency()) 
            checkGloballyConsistency(refereesolver);
        
        this.setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

    public void addFormulaBoxField(){
                // TODO add your handling code here:
        FormulaBox formulaBox = new FormulaBox();
        formulaBoxes.add(formulaBox);
        jPanelFormulas.add(formulaBox);
        paletteForFormulas.addFormulaBoxToTreat(formulaBox);
        jScrollPaneFormulas.revalidate();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addFormulaBoxField();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    public String getConclusion() {
        return formulaBox1.getText();
    }

    public void setConclusion(Formula formula) {
        formulaBox1.setText(formula.toString());
    }
    
        public void loadClausesFromFormulaList(SATSolverSAT4J sol) {
        for (String f : r.getFormulaList()) {
            sol.addFormula(new FormulaForSAT4J(new Formula(f)));
        }
        for (Argument arg : r.getArgumentList()) {
            for (Formula f : arg.getSupport()) {
                if (!r.getFormulaList().contains(f.toString())) {
                    sol.addFormula(new FormulaForSAT4J(f));
                }
            }
        }

    }
        
    public void lockSupport(){
        for(int i=0; i<formulaBoxes.size(); i++)
            formulaBoxes.get(i).lockFormula();
        
    }

    public void lockConclusion() {
        formulaBox1.lockFormula();
    }

    public void addFormulaFromReferee(Referee referee) {
        paletteForFormulas.addFormulaPanel(referee.getFormulaList(), "Common Formulas :");
    }

    public void addFormulaFromPlayer(Player player) {
        paletteForFormulas.addFormulaPanel(player.getFormulaList(), "Player Formulas :");
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


}
