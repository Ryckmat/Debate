/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MovesPaneNew.java
 *
 * Created on 19 avr. 2012, 15:02:50
 */
package debate.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import satoulouse.FormulaArgumentDialog;

/**
 *
 * @author julien
 */
public class MovesPaneNew extends javax.swing.JPanel {

    /** Creates new form MovesPaneNew */
    public MovesPaneNew() {
        initComponents();
        buttonlist = new ArrayList<JButton>();
        buttonlist.add(acceptButton);
        buttonlist.add(argueButton);
        buttonlist.add(assertButton);
        buttonlist.add(challengeButton);
        buttonlist.add(closeButton);
        buttonlist.add(dismantleButton);
        buttonlist.add(quizButton);
        buttonlist.add(quizLinkButton);
        buttonlist.add(replaceButton);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assertButton = new javax.swing.JButton();
        argueButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        challengeButton = new javax.swing.JButton();
        replaceButton = new javax.swing.JButton();
        dismantleButton = new javax.swing.JButton();
        quizButton = new javax.swing.JButton();
        quizLinkButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(3, 3));

        assertButton.setText("Assert");
        assertButton.setName("assertButton"); // NOI18N
        add(assertButton);

        argueButton.setText("Argue");
        argueButton.setName("argueButton"); // NOI18N
        add(argueButton);

        acceptButton.setText("Accept");
        acceptButton.setName("acceptButton"); // NOI18N
        add(acceptButton);

        challengeButton.setText("Challenge");
        challengeButton.setName("challengeButton"); // NOI18N
        add(challengeButton);

        replaceButton.setText("Replace");
        replaceButton.setName("replaceButton"); // NOI18N
        add(replaceButton);

        dismantleButton.setText("Dismantle");
        dismantleButton.setName("dismantleButton"); // NOI18N
        add(dismantleButton);

        quizButton.setText("Quiz");
        quizButton.setName("quizButton"); // NOI18N
        add(quizButton);

        quizLinkButton.setText("Quiz Link");
        quizLinkButton.setName("quizLinkButton"); // NOI18N
        add(quizLinkButton);

        closeButton.setText("Close");
        closeButton.setName("closeButton"); // NOI18N
        add(closeButton);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton argueButton;
    private javax.swing.JButton assertButton;
    private javax.swing.JButton challengeButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton dismantleButton;
    private javax.swing.JButton quizButton;
    private javax.swing.JButton quizLinkButton;
    private javax.swing.JButton replaceButton;
    // End of variables declaration//GEN-END:variables
    private List<JButton> buttonlist ;
    
    public List<JButton> getButtonlist() {
        return buttonlist;
    }
    
    public void enableMovesButton(boolean activated) {
        for (JButton b : buttonlist) {
            b.setEnabled(activated);
        }
    }

    public JButton getAssertButton() {
       return assertButton;
    }

}
