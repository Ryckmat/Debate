/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Player.java
 *
 * Created on 17 avr. 2012, 17:32:37
 */
package debate.gui;

import debate.game.Player;
import debate.logical.Argument;
import debate.logical.Request;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Propriétaire
 */
public class PlayerPane extends javax.swing.JPanel {

    private Player p;
    private Timer t;
    private boolean ready; // Joueur pret ou non

    /** Creates new form Player */
    public PlayerPane() {
        initComponents();
        jListFormula.setModel(new DefaultListModel());
        jListArguments.setModel(new DefaultListModel());
        jListRequests.setModel(new DefaultListModel());
        jListFormula.setCellRenderer(new ListCellRendererForFormula());
        jListRequests.setCellRenderer(new ListCellRendererForRequest());
        jListArguments.setCellRenderer(new ListCellRendererForArgument());
        jProgressBar1.setMaximum(250);
        t = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.setSpeechtime(p.getSpeechtime() - 1);
                chronojLabel.setText("" + p.getSpeechtime());
                jProgressBar1.setValue(250 - p.getSpeechtime());
            }
        });

    }

    public Player getPlayer() {
        return p;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListFormula = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListRequests = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListArguments = new javax.swing.JList();
        movesPane1 = new debate.gui.MovesPane();
        jPanel2 = new javax.swing.JPanel();
        chronojLabel = new javax.swing.JLabel();
        takeHandjButton = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        registrationJButton = new javax.swing.JButton();
        buzzer1 = new debate.gui.Buzzer();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PlayerName", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        setPreferredSize(new java.awt.Dimension(320, 475));

        jSeparator1.setName("jSeparator1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 2, 2));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jListFormula.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulas"));
        jListFormula.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListFormula.setName("jListFormula"); // NOI18N
        jScrollPane1.setViewportView(jListFormula);

        jPanel1.add(jScrollPane1);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jListRequests.setBorder(javax.swing.BorderFactory.createTitledBorder("Requests"));
        jListRequests.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRequests.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRequests.setName("jListRequests"); // NOI18N
        jListRequests.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListRequestsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListRequests);

        jPanel1.add(jScrollPane3);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jListArguments.setBorder(javax.swing.BorderFactory.createTitledBorder("Arguments"));
        jListArguments.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListArguments.setName("jListArguments"); // NOI18N
        jScrollPane2.setViewportView(jListArguments);

        jPanel1.add(jScrollPane2);

        movesPane1.setName("movesPane1"); // NOI18N
        jPanel1.add(movesPane1);

        jPanel2.setName("jPanel2"); // NOI18N

        chronojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chrono.png"))); // NOI18N
        chronojLabel.setText("000");
        chronojLabel.setToolTipText("Speech time remaining");
        chronojLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        chronojLabel.setName("chronojLabel"); // NOI18N

        takeHandjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/TakeHandStart.png"))); // NOI18N
        takeHandjButton.setText("Take Hand");
        takeHandjButton.setEnabled(false);
        takeHandjButton.setName("takeHandjButton"); // NOI18N

        jProgressBar1.setName("jProgressBar1"); // NOI18N

        registrationJButton.setText("Registration");
        registrationJButton.setName("registrationJButton"); // NOI18N
        registrationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationJButtonActionPerformed(evt);
            }
        });

        buzzer1.setEnabled(false);
        buzzer1.setName("buzzer1"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrationJButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(chronojLabel)
                        .addGap(18, 18, 18)
                        .addComponent(takeHandjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buzzer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(registrationJButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chronojLabel)
                            .addComponent(takeHandjButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buzzer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registrationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationJButtonActionPerformed

        String n = null;
        do {
            n = JOptionPane.showInputDialog(this, "Enter your nickname", "Registration",
                    JOptionPane.QUESTION_MESSAGE);
            if (n == null || n.trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter your nickname", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } while (n == null || n.equals(""));
        newPlayer(n.trim());
    }//GEN-LAST:event_registrationJButtonActionPerformed

    private void jListRequestsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListRequestsValueChanged
        if (jListRequests.getSelectedValue() == null) {
            movesPane1.activateAcceptButton(false);
        } else {
            movesPane1.activateAcceptButton(true);
        }
    }//GEN-LAST:event_jListRequestsValueChanged

    public void newPlayer(String n) {
        p = new Player(n, 250);
        setBorder(javax.swing.BorderFactory.createTitledBorder("" + p));
        chronojLabel.setText("250");
        registrationJButton.setVisible(false);
        buzzer1.setRed();
        buzzer1.setVisible(true);
        ready = true;
    }

    public void updateDisplay(boolean hasHand, boolean anyoneHasHand) {
        if (ready) {
            buzzer1.setEnabled(true);
            if (hasHand) {
                buzzer1.setRed();
                takeHandjButton.setEnabled(true);
                takeHandjButton.setText("End Turn");
                takeHandjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/TakeHandStop.png"))); // NOI18N
                setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 217, 42), 2), "" + p));

            } else {
                if (anyoneHasHand) {
                    buzzer1.setOrange();
                    takeHandjButton.setEnabled(false);
                    takeHandjButton.setText("Waiting...");
                } else {
                    buzzer1.setGreen();
                    takeHandjButton.setEnabled(true);
                    takeHandjButton.setText("Take Hand");
                    takeHandjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/TakeHandStart.png"))); // NOI18N
                }
                setBorder(javax.swing.BorderFactory.createTitledBorder("" + p));
            }
            movesPane1.enableMovesButton(hasHand);
        } else {
            buzzer1.setEnabled(false);
            takeHandjButton.setEnabled(false);
            movesPane1.enableMovesButton(false);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private debate.gui.Buzzer buzzer1;
    private javax.swing.JLabel chronojLabel;
    private javax.swing.JList jListArguments;
    private javax.swing.JList jListFormula;
    private javax.swing.JList jListRequests;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private debate.gui.MovesPane movesPane1;
    private javax.swing.JButton registrationJButton;
    private javax.swing.JButton takeHandjButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jList1
     */
    public javax.swing.JList getjList1() {
        return jListFormula;
    }

    /**
     * @return the jList2
     */
    public javax.swing.JList getjList2() {
        return jListArguments;
    }

    /**
     * @return the jList3
     */
    public javax.swing.JList getjList3() {
        return jListRequests;
    }

    /**
     * @return the takeHandjButton
     */
    public JButton getTakeHandjButton() {
        return takeHandjButton;
    }

    public Timer getTimer() {
        return t;
    }

    public JButton getAssertButton() {
        return movesPane1.getAssertButton();
    }

    public JButton getAcceptButton() {
        return movesPane1.getAcceptButton();
    }

    public JButton getArgueButton() {
        return movesPane1.getArgueButton();
    }

    public void refreshModel() {
        ((DefaultListModel) jListFormula.getModel()).clear();
        for (String s : p.getFormulaList()) {
            ((DefaultListModel) jListFormula.getModel()).addElement(s);
        }
        ((DefaultListModel) jListRequests.getModel()).clear();
        for (Request r : p.getRequestList()) {
            ((DefaultListModel) jListRequests.getModel()).addElement(r);
        }
        ((DefaultListModel) jListArguments.getModel()).clear();
        for (Argument a : p.getArgumentList()) {
            ((DefaultListModel) jListArguments.getModel()).addElement(a);
        }
    }

    public void startTimer() {
        t.start();
    }

    public void stopTimer() {
        t.stop();
    }

    public boolean getReady() {
        return ready;
    }

    public Buzzer getBuzzer() {
        return buzzer1;
    }

    public void setBuzzerGreen() {
        buzzer1.setGreen();
    }

    public void setBuzzerRed() {
        buzzer1.setRed();
    }

    public void setBuzzerOrange() {
        buzzer1.setOrange();
    }

    public Request getSelectedRequest() {
        if (jListRequests.getSelectedValue() instanceof Request) {
            return ((Request) jListRequests.getSelectedValue());
        }
        return null;
    }
}