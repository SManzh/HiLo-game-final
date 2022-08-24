import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GuessingGame extends JFrame {
	
	private JTextField txtGuess;
	
	private JLabel lblOutput;
	
	private int theNumber;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber) {
			message = guess + " is too low. Try again.";
		} else if (guess > theNumber) {
			message = guess + " is too high. Try again.";
		} else {
			message = guess + " is correct. You win! Let's play again";
			newGame();
		}
		lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
	}
	
	public void newGame() {
		theNumber = (int)(Math.random()*200 - 99);
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Slava's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 36, 566, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess number between -100 and 100");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(77, 91, 248, 22);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(245, 149, 85, 22);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 207, 576, 19);
		getContentPane().add(lblOutput);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(402, 93, 96, 19);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(600,300));
		theGame.setVisible(true);
	}
}
