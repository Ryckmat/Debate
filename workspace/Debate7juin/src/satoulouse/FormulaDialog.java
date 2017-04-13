/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ArgumentDialog.java
 *
 * Created on 23 avr. 2012, 20:17:27
 */
package satoulouse;

import debate.game.Player;
import debate.game.Referee;
import debate.logical.Argument;
import debate.tools.ErrorEnum;
import debate.tools.MessageDialog;
import java.awt.Window;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class FormulaDialog extends javax.swing.JDialog {

    ArrayList<FormulaBox> formulaBoxes;
    private int formulaBoxIndiceCourant = 0;
    private final PaletteForFormulas paletteForFormulas;
    private boolean success;
    private SATSolverSAT4J playersolver;
    private Referee r;


    /** Creates new form ArgumentDialog */
    public FormulaDialog(javax.swing.JFrame parent, SATSolverSAT4J player, Referee rf, boolean modal) {
        super(parent, modal);
        initComponents();
        formulaBoxes = new ArrayList<>();
        this.playersolver=(SATSolverSAT4J)player.clone();
        this.r=rf;
        paletteForFormulas = new PaletteForFormulas(r.getTopics());
        jScrollPane2.setViewportView(paletteForFormulas);
        reset();
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
        jButton4 = new javax.swing.JButton();
        jScrollPaneFormulas = new javax.swing.JScrollPane();
        jPanelFormulas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formula Writer");

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(240, 32767));
        jScrollPane2.setName("jScrollPane2"); // NOI18N
        mainPanel.add(jScrollPane2, java.awt.BorderLayout.WEST);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setName("jPanel3"); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
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
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jScrollPaneFormulas.setName("jScrollPaneFormulas"); // NOI18N

        jPanelFormulas.setName("jPanelFormulas"); // NOI18N
        jPanelFormulas.setLayout(new javax.swing.BoxLayout(jPanelFormulas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPaneFormulas.setViewportView(jPanelFormulas);

        jPanel2.add(jScrollPaneFormulas, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!isOK()) {
            MessageDialog.displayErrorMessage((Window)this, ErrorEnum.MistakenFormula);
            return;
        }

        SATSolverSAT4J refereesolver=new SATSolverSAT4J();
        loadClausesFromFormulaList(refereesolver);
        for (FormulaBox f : formulaBoxes) 
        {
            if (!f.isEmpty())
            {
                playersolver.addFormula(f.getFormulaForSAT4J());
                refereesolver.addFormula(f.getFormulaForSAT4J());
            
             }
        }

        if (checkSelfConsistency()) 
            checkGloballyConsistency(refereesolver);
        this.setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reset();
}//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFormulas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneFormulas;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

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
        for (FormulaBox f : formulaBoxes) 
            if (!f.isEmpty()) 
                s.add(f.getText());
 
        return s;
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

    private boolean checkSelfConsistency() {
        success = false;
        checkConsistency(playersolver, ErrorEnum.SelfConsistencyFormula);
        return success;
    }

    private boolean checkGloballyConsistency(SATSolverSAT4J solver) {
        success = false;
        checkConsistency(solver, ErrorEnum.GlobalConsistencyFormula);
        // Si ce qui a été entré est consistent avec les connaissances communes,
        //success sera repassé à true;
        return success;
    }

    private void checkConsistency(SATSolverSAT4J solver, ErrorEnum err) {
        try 
        {
            if (solver.isSATFormulaInSchemeVar() != null) 
                success = true;
             else 
                MessageDialog.displayErrorMessage((Window)this, err);

        } catch (Exception ex) {
            SchemeWithKawa.restart();
            MessageDialog.displayErrorMessage((Window)this, ErrorEnum.Solver);
        }

    }

    public SATSolverSAT4J getPlayersolver() {
        return playersolver;
    }

    public void addFormulaFromReferee(Referee referee) {
        paletteForFormulas.addFormulaPanel(referee.getFormulaList(), "Common Formulas :");
    }

    public void addFormulaFromPlayer(Player player) {
        paletteForFormulas.addFormulaPanel(player.getFormulaList(), "Player Formulas :");
    }

        public void loadClausesFromFormulaList(SATSolverSAT4J sol) {
        for (String f: r.getFormulaList())
            sol.addFormula(new FormulaForSAT4J(new Formula(f)));
        for (Argument arg: r.getArgumentList())
        {
            for (Formula f: arg.getSupport())
                if (!r.getFormulaList().contains(f.toString()))
                    sol.addFormula(new FormulaForSAT4J(f));
        }

    }
    
}