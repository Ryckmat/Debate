/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DebateFrame.java
 *
 * Created on 17 avr. 2012, 17:31:21
 */
package debate.gui;

import debate.game.Referee;
import debate.game.HandStatus;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import satoulouse.ArgumentDialog;
import satoulouse.FormulaDialog;

/**
 *
 * @author Propriétaire
 */
public final class DebateFrame extends javax.swing.JFrame {

    PlayerPane player1, player2;
    RefereePane refereepane;
    MovesPane moves;
    Referee referee;

    /** Creates new form DebateFrame */
    public DebateFrame() {
        initComponents();
        player1 = new PlayerPane();
        refereepane = new RefereePane();
        player2 = new PlayerPane();
        moves = new MovesPane();
        defineEventsHandlersMoves(moves.getButtonlist());
        defineEventsHandlerNewGame(refereepane.getNewGameButton());
        this.setLayout(new BorderLayout());
        this.add(player1, BorderLayout.WEST);
        this.add(refereepane, BorderLayout.CENTER);
        this.add(player2, BorderLayout.EAST);
        this.add(moves, BorderLayout.SOUTH);
        this.setLocation(0, 0);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

    }

    public ArrayList<PlayerPane> associateNumberwithPlayerPane(HandStatus s) {
        ArrayList<PlayerPane> pa = new ArrayList<PlayerPane>();
        if (s == HandStatus.PlayerOneHasHand) {
            pa.add(player1);
            pa.add(player2);
        } else {
            pa.add(player2);
            pa.add(player1);
        }
        return pa;
    }

    public void defineEventsHandlersMoves(ArrayList<JButton> buttonlist) {

        buttonlist.get(0).setEnabled(true);
        buttonlist.get(0).addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (referee.moveEnabled()) // Si un des buzzers est vert
                {
                    displayFormulaDialog();
                }
            }
        });

        buttonlist.get(1).setEnabled(true);
        buttonlist.get(1).addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (referee.moveEnabled()) // Si un des buzzers est vert
                {
                    displayArgumentDialog();
                }
            }
        });

        for (int i = 2; i < buttonlist.size(); i++) {
            buttonlist.get(i).setEnabled(false);
        }
    }

    public void endofMove(ArrayList<String> s, boolean success) {
        ArrayList<PlayerPane> players = associateNumberwithPlayerPane(referee.getCurrentplayer());
        // A l'indice 0 on a le joueur venant d'effectué le coup
        //A l'indice 1, celui qui attendé

        fillBuzzer(players.get(0).getBuzzer(), BuzzerColor.GREEN); //Extinction du buzzer du dernier joueur
        fillBuzzer(players.get(1).getBuzzer(), BuzzerColor.GREEN);

        players.get(1).startTimer();
        referee.setCurrentplayer(HandStatus.NoOneHasHand);
        if (success) {
            try {
                actualizeTable(s, players);
            } catch (Exception ex) {
                Logger.getLogger(DebateFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void defineEventsHandlerNewGame(JButton bu) {
        bu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    private void startGame() {
        if (!player1.getReady()) {
            JOptionPane.showMessageDialog(this, "Player 1 absent", "Expected 2 players", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!player2.getReady()) {
            JOptionPane.showMessageDialog(this, "Player 2 absent", "Expected 2 players", JOptionPane.ERROR_MESSAGE);
            return;

        }
        player1.startTimer();
        player2.startTimer();
        // Placer ici pour éviter que les joueurs ne puissent buzzer avant
        // que la partie ait effectivement débuté
        referee = new Referee();
        defineEventsHandlerBuzzP1(player1.getBuzzer());
        defineEventsHandlerBuzzP2(player2.getBuzzer());
        fillBuzzer(player1.getBuzzer(), BuzzerColor.GREEN); //Extinction du buzzer du dernier joueur
        fillBuzzer(player2.getBuzzer(), BuzzerColor.GREEN);
        refereepane.getNewGameButton().setVisible(false);

    }

    public void displayArgumentDialog() {
        ArgumentDialog dialog = new ArgumentDialog(this, associateNumberwithPlayerPane(referee.getCurrentplayer()).get(0).
                getPlayer().getSolver(), true);
        dialog.setVisible(true);
        associateNumberwithPlayerPane(referee.getCurrentplayer()).get(0).
                getPlayer().setSolver(dialog.getPlayersolver());
        endofMove(dialog.getArrayListFormulas(), dialog.getSuccess());
    }

    public void displayFormulaDialog() {
        FormulaDialog dialog = new FormulaDialog(this, associateNumberwithPlayerPane(referee.getCurrentplayer()).get(0).
                getPlayer().getSolver(), true);
        dialog.setVisible(true);
        associateNumberwithPlayerPane(referee.getCurrentplayer()).get(0).
                getPlayer().setSolver(dialog.getPlayersolver());
        endofMove(dialog.getArrayListFormulas(), dialog.getSuccess());
    }

    //Vérifier redondance, si formule entrée et validée n'a pas déja était écrite
    public boolean checkRedundancy(Vector<String> s, String formula) {
        if (!s.isEmpty()) {
            if (s.contains(formula)) {
                JOptionPane.showMessageDialog(this, "The last formula entered has been yet"
                        + "written by you", "Redundancy", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public void actualizeTable(ArrayList<String> s, ArrayList<PlayerPane> p) throws Exception {
        if (!checkRedundancy(p.get(0).getPlayer().getFormulaList(), s.get(0))) {
            for (String c : s) {
                p.get(0).getPlayer().getFormulaList().add(c);
                p.get(0).getjList1().setListData(p.get(0).getPlayer().getFormulaList());
                // referee.getFormulaList().add(c);
                //refereepane.getjList1().setListData(referee.getFormulaList());

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1157, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 622, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void defineEventsHandlerBuzzP1(JLabel la) {
        la.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (referee.getCurrentplayer() != HandStatus.PlayerTwoHasHand) {                           // Si le joueur 2 n'est pas déja en train de jouer
                    player1.startTimer(); //Départ du timer
                    fillBuzzer(player1.getBuzzer(), BuzzerColor.ORANGE); //Activation du buzzer
                    fillBuzzer(player2.getBuzzer(), BuzzerColor.RED);
                    player2.stopTimer();  //Blocage du timer de l'adversaire
                    referee.setCurrentplayer(HandStatus.PlayerOneHasHand); //Joueur courant <- 1
                } else {
                    warningImpossibleBuzz(player2.getPlayer().getNickname());
                }
            }
        });
    }

    public void warningImpossibleBuzz(String name) {
        JOptionPane.showMessageDialog(this, "Your opponent " + name
                + " is playing", "You have to wait your turn !", JOptionPane.ERROR_MESSAGE);
    }

    private void defineEventsHandlerBuzzP2(JLabel la) {
        la.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                if (referee.getCurrentplayer() != HandStatus.PlayerOneHasHand) {// Si le joueur 1 n'est pas déja en train de jouer
                    player2.startTimer();
                    fillBuzzer(player2.getBuzzer(), BuzzerColor.ORANGE);
                    fillBuzzer(player1.getBuzzer(), BuzzerColor.RED);
                    player1.stopTimer();
                    referee.setCurrentplayer(HandStatus.PlayerTwoHasHand);
                } else {
                    warningImpossibleBuzz(player1.getPlayer().getNickname());
                }

            }
        });
    }

    public void fillBuzzer(JLabel la, BuzzerColor c) {
        switch (c) {
            case GREEN:
                la.setIcon(new ImageIcon("src/icons/greenbuzz.png"));
                break;
            case ORANGE:
                la.setIcon(new ImageIcon("src/icons/orangebuzz.png"));
                break;
            case RED:
                la.setIcon(new ImageIcon("src/icons/redbuzz.png"));
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
