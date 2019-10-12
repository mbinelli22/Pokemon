package HW4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PokemonControlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pokemon leftPokemon, rightPokemon;
	private Animations animate;
	boolean isDead = false;

	//Physcial, Special, Potion, Ether
	private JButton[] leftButtons = new JButton[]{new JButton(),new JButton(),new JButton(),new JButton()};
	private JButton[] rightButtons = new JButton[]{new JButton(),new JButton(),new JButton(),new JButton()};

	//Name, Health, Power, Level, Num Potions, Num Ethers
	private JLabel[] leftLabels = new JLabel[] {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	private JLabel[] rightLabels = new JLabel[] {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	boolean turn;
	JPanel middleSection;
	JLabel labelTurn;

	public PokemonControlPanel(Pokemon l, Pokemon r, Animations animate) {

		this.animate = animate;
		turn = true;
		this.leftPokemon = l;
		this.rightPokemon = r;

		this.setLayout(new GridLayout(1,5));

		fillPanel(leftPokemon);
		middleSection = new JPanel();
		labelTurn = new JLabel(leftPokemon.getName() + " turn");
		middleSection.add(labelTurn);
		add(middleSection);
		fillPanel(rightPokemon);

	}

	private void fillPanel(Pokemon p) {

		JButton buttons[];
		JLabel labels[];
		if(p == leftPokemon) {
			buttons = leftButtons;
			labels = leftLabels;
		}else {
			buttons = rightButtons;
			labels = rightLabels;
		}

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		buttons[0] = new JButton("Physical Attack");
		buttons[0].addActionListener(new PerformAction());
		panel.add(buttons[0]);
		buttons[1] = new JButton(" Special Attack ");
		buttons[1].addActionListener(new PerformAction());
		panel.add(buttons[1]);
		buttons[2] = new JButton(" Use Potion ");
		buttons[2].addActionListener(new PerformAction());
		panel.add(buttons[2]);
		buttons[3] = new JButton(" Use Ether ");
		buttons[3].addActionListener(new PerformAction());
		panel.add(buttons[3]);

		labels[0] = new JLabel("Name: " + p.name);
		panel.add(labels[0]);
		labels[1] = new JLabel("Health: " + p.currentHealth);
		panel.add(labels[1]);
		labels[2] = new JLabel("Power: " + p.currentPower);
		panel.add(labels[2]);
		labels[3] = new JLabel("Potions Left: " + p.getPotions());
		panel.add(labels[3]);
		labels[4] = new JLabel("Ethers Left: " + p.getEthers());
		panel.add(labels[4]);
		add(panel);
	}

	private class PerformAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(isDead) {
				return;
			}

			JButton clicked = (JButton) e.getSource();
			boolean successfulAttack = false;
			if(turn && clicked == leftButtons[0]) {
				successfulAttack = leftPokemon.physicalAttack(rightPokemon);
				if(successfulAttack)
					animate.pikaAttackAnim();
			} else if(turn && clicked == leftButtons[1]) {
				successfulAttack = leftPokemon.specialAttack(rightPokemon);
				if(successfulAttack)
					animate.pikaAttackAnim();
			} else if(turn && clicked == leftButtons[2]) {
				successfulAttack = leftPokemon.usePotion();
				if(successfulAttack)
					animate.resetBoth();
			} else if(turn && clicked == leftButtons[3]) {
				successfulAttack =  leftPokemon.useEther();
				if(successfulAttack)
					animate.resetBoth();
			} else if(!turn && clicked == rightButtons[0]) {
				successfulAttack = rightPokemon.physicalAttack(leftPokemon);
				if(successfulAttack)
					animate.charAttackAnim();
			} else if(!turn && clicked == rightButtons[1]) {
				successfulAttack = rightPokemon.specialAttack(leftPokemon);
				if(successfulAttack)
					animate.charAttackAnim();
			} else if(!turn && clicked == rightButtons[2]) {
				successfulAttack = rightPokemon.usePotion();
				if(successfulAttack)
					animate.resetBoth();
			} else if(!turn && clicked == rightButtons[3]) {
				successfulAttack = rightPokemon.useEther();
				if(successfulAttack)
					animate.resetBoth();
			}
			revalidate();
			repaint();
			if(successfulAttack) {
				turn = !turn;
				updateLabels();
			}
		}

	}

	private void updateLabels() {
		leftLabels[1].setText("Health: " + leftPokemon.getHealth());
		leftLabels[2].setText("Power: " + leftPokemon.getPower());
		leftLabels[3].setText("Potions Left: " + leftPokemon.getPotions());
		leftLabels[4].setText("Ethers Left: " + leftPokemon.getEthers());

		rightLabels[1].setText("Health: " + rightPokemon.getHealth());
		rightLabels[2].setText("Power: " + rightPokemon.getPower());
		rightLabels[3].setText("Potions Left: " + rightPokemon.getPotions());
		rightLabels[4].setText("Ethers Left: " + rightPokemon.getEthers());

		if(turn) {
			labelTurn.setText(leftPokemon.getName() + " turn");
		} else {
			labelTurn.setText(rightPokemon.getName() + " turn");
		}

		if(leftPokemon.getHealth() == 0 || rightPokemon.getHealth() == 0) {
			winner();
		}
	}

	private void winner() {
		isDead = true;
		String winner, loser;
		if(leftPokemon.getHealth() == 0) {
			winner = rightPokemon.getName();
			loser = leftPokemon.getName();
		} else {
			loser = rightPokemon.getName();
			winner = leftPokemon.getName();
		}

		JOptionPane.showMessageDialog(null, winner + " has won!\n" + loser + " has fainted.");

		labelTurn.setText("Game over");
	}

}
