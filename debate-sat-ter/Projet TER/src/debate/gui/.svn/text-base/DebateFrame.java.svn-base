/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DebateFrame2.java
 *
 * Created on 19 avr. 2012, 00:51:05
 */
package debate.gui;

import debate.move.Assert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import satoulouse.FormulaArgumentDialog;

/**
 *
 * @author julien
 */
public class DebateFrame extends javax.swing.JFrame {

    /*************************/
    /*                       */
    /*     ENUMS             */
    /*                       */
    /*************************/
    public enum HandStatus {

        NoOneHasHand,
        PlayerOneHaveHand,
        PlayerTwoHaveHand
    }
    private HandStatus status;

    /*************************/
    /*                       */
    /*     BUILDER           */
    /*                       */
    /*************************/
    public DebateFrame() {
        initComponents();
        status = HandStatus.NoOneHasHand;
        // Listener sur les boutons de prise de main
        playerPane1.getTakeHandjButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // Selon le status on prend ou on rend la main
                if (status == HandStatus.NoOneHasHand) {
                    status = HandStatus.PlayerOneHaveHand;
                    playerPane1.getTimer().start();
                    updateDisplay(status);
                } else {
                    status = HandStatus.NoOneHasHand;
                    updateDisplay(status);
                    playerPane1.getTimer().stop();
                }
            }
        });
        playerPane2.getTakeHandjButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // Selon le status on prend ou on rend la main
                if (status == HandStatus.NoOneHasHand) {
                    status = HandStatus.PlayerTwoHaveHand;
                    updateDisplay(status);
                    playerPane2.getTimer().start();
                } else {
                    status = HandStatus.NoOneHasHand;
                    updateDisplay(status);
                    playerPane2.getTimer().stop();
                }
            }
        });



        final String onQPressed = "onQpressed";
        final String onMPressed = "onMpressed";
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("Q"), onQPressed);
        inputMap.put(KeyStroke.getKeyStroke("M"), onMPressed);
        ActionMap actionMap = this.getRootPane().getActionMap();
        actionMap.put(onQPressed,
                new AbstractAction() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playerPane1.getTakeHandjButton().doClick();
                    }
                });
        actionMap.put(onMPressed,
                new AbstractAction() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playerPane2.getTakeHandjButton().doClick();
                    }
                });




        // Initialisation joueur 1
        String n = null;
        do {
            n = JOptionPane.showInputDialog(null, "Enter your nickname", "Registration Player 1",
                    JOptionPane.QUESTION_MESSAGE);
            if (n.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your nickname", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } while (n == null);
        playerPane1.newPlayer(n);
        // Initialisation joueur 2
        n = null;
        do {
            n = JOptionPane.showInputDialog(null, "Enter your nickname", "Registration Player 2",
                    JOptionPane.QUESTION_MESSAGE);
            if (n.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your nickname", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } while (n == null);
        playerPane2.newPlayer(n);
        // Mise à jour des boutons
        updateDisplay(HandStatus.NoOneHasHand);
        // Listener Ajout de Formule
        playerPane1.getAssertButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               Assert.assertFormula(playerPane1.getPlayer(), playerPane2.getPlayer(), refereePane.getReferee());
               playerPane1.refreshModel();
               playerPane2.refreshModel();
            }
        });
    }

    /*************************/
    /*                       */
    /*     METHODS           */
    /*                       */
    /*************************/
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerPane1 = new debate.gui.PlayerPane();
        playerPane2 = new debate.gui.PlayerPane();
        refereePane = new debate.gui.RefereePane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerPane1.setName("playerPane1"); // NOI18N

        playerPane2.setName("playerPane2"); // NOI18N

        refereePane.setName("refereePane"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refereePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refereePane, 0, 0, Short.MAX_VALUE)
                    .addComponent(playerPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void defineEventsHandlers(ArrayList<JButton> buttonlist) {
        for (JButton bu : buttonlist) {
            bu.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    displayFormulaArgumentDialog();
                }
            });
        }

    }

    public void displayFormulaArgumentDialog() {
        new FormulaArgumentDialog(this, true).setVisible(true);

    }

    public void updateDisplay(HandStatus status) {
        switch (status) {
            case NoOneHasHand: {
                playerPane1.updateDisplay(false, false);
                playerPane2.updateDisplay(false, false);
                break;
            }
            case PlayerOneHaveHand: {
                playerPane1.updateDisplay(true, true);
                playerPane2.updateDisplay(false, true);
                break;
            }
            case PlayerTwoHaveHand: {
                playerPane1.updateDisplay(false, true);
                playerPane2.updateDisplay(true, true);
                break;
            }
        }
    }

    public void actualizeTable(ArrayList<String> s) {
//        for (String c : s) {
//            playerPane1.getPlayer().getFormulaList().add(c);
//            playerPane1.getjList1().setListData(playerPane1.getPlayer().getFormulaList());
//            refereePane.getReferee().getFormulaList().add(c);
//            refereePane.getjList1().setListData(refereePane.getReferee().getFormulaList());
//
//        }
    }

    /*************************/
    /*                       */
    /*     MAIN              */
    /*                       */
    /*************************/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DebateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DebateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DebateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DebateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DebateFrame().setVisible(true);
            }
        });
    }
    
    /*************************/
    /*                       */
    /*     VARIABLES         */
    /*                       */
    /*************************/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private debate.gui.PlayerPane playerPane1;
    private debate.gui.PlayerPane playerPane2;
    private debate.gui.RefereePane refereePane;
    // End of variables declaration//GEN-END:variables
}
