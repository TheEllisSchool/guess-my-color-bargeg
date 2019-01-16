import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GuessMyColor extends JFrame{
	private int compRed = 0;
	private int compGreen = 0; 
	private int compBlue = 0; 
	private Color compColor = new Color (compRed, compGreen, compBlue); 
	private int myRed = 0;
	private int myGreen = 0; 
	private int myBlue = 0; 
	
	private Color myColor = new Color (myRed, myGreen, myBlue); 
	private JPanel myPanel = new JPanel(); 
	

	public GuessMyColor(){	
// first real function, the constructor is called in main		
		initGUI(); //graphical user interface - setting up things in window
		
		setTitle("Game Window");
		setSize(200, 100); //pixels
		setResizable(true);
		pack(); //pack means pack tightly- overrides size
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

			
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //what's going to happen when you hit the 'x'

	}
	
	public void initGUI(){
		//TITLE
		//create label
		JLabel titleLabel = new JLabel("Guess My Color");
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		//customize label
		Font titleFont = new Font ("Times new Roman" , Font.BOLD + Font.ITALIC,  32);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.GRAY);
		titleLabel.setBackground(Color.DARK_GRAY);
		titleLabel.setOpaque(true);
		
		//CENTER PANEL
		JPanel centerPanel = new JPanel(); 
		centerPanel.setBackground(Color.WHITE);
		add(centerPanel, BorderLayout.CENTER);
		
		Dimension size = new Dimension (50,50);
		
	
		myPanel.setBackground(myColor);
		myPanel.setPreferredSize(size);
		centerPanel.add(myPanel, BorderLayout.PAGE_START);
		//range of RGB values go from 0-255, so 256 options- highest a value can be is 255
		
		
		JPanel computerPanel = new JPanel(); 
		generateRandomColor(); 
		computerPanel.setBackground(compColor);
		computerPanel.setPreferredSize(size);
		centerPanel.add(computerPanel, BorderLayout.PAGE_END);
		
		//BUTTON PANEL
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		add(buttonPanel, BorderLayout.PAGE_END);
		
		//buttons
		JButton moreRedButton = new JButton("+");
		moreRedButton.setBackground(Color.RED);
		//action listener
		moreRedButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				addRed(); 
			}
		}); 
		buttonPanel.add(moreRedButton); // add button to panel LAST
		JButton lessRedButton = new JButton("-");
		lessRedButton.setBackground(Color.RED);
		lessRedButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				subRed(); 
			}
		}); 
		buttonPanel.add(lessRedButton);
		JButton moreGreenButton = new JButton("+");
		moreGreenButton.setBackground(Color.GREEN);
		JButton lessGreenButton = new JButton("-");
		moreGreenButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				addGreen(); 
			}
		}); 
		buttonPanel.add(moreGreenButton);
		lessGreenButton.setBackground(Color.GREEN);
		lessGreenButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				subGreen(); 
			}
		}); 
		buttonPanel.add(lessGreenButton);
		
		JButton moreBlueButton = new JButton("+");
		moreBlueButton.setBackground(Color.BLUE);
		moreBlueButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				addBlue(); 
			}
		}); 
		buttonPanel.add(moreBlueButton);
		JButton lessBlueButton = new JButton("-");
		lessBlueButton.setBackground(Color.BLUE);
		lessBlueButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				subBlue(); 
			}
		}); 
		buttonPanel.add(lessBlueButton);
	}
	private void generateRandomColor() {
		compRed = (int) (Math.random() * 15 +1) * 17;
		compGreen = (int) (Math.random() * 15 +1) * 17;
		compBlue = (int) (Math.random() * 15 +1) * 17;
		
		compColor = new Color(compRed, compGreen, compBlue);
	}
	private void addRed() {
		myRed += 17;
		if (myRed > 255) {
			myRed = 0; 
		}
		updateColor(); 
	}
	private void subRed() {
		myRed -= 17;
		if (myRed <0) {
			myRed = 255; 
		}
		updateColor(); 
	}
	private void addGreen() {
		myGreen += 17;
		if (myGreen > 255) {
			myGreen = 0; 
		}
		updateColor(); 
	}
	private void subGreen() {
		myGreen -= 17;
		if (myGreen <0) {
			myGreen = 255; 
		}
		updateColor(); 
	}
	private void addBlue() {
		myBlue += 17;
		if (myBlue > 255) {
			myBlue = 0; 
		}
		updateColor(); 
	}
	private void subBlue() {
		myBlue -= 17;
		if (myBlue <0) {
			myBlue = 255; 
		}
		updateColor(); 
	}
	private void updateColor() {
		myColor = new Color (myRed, myGreen, myBlue); 
		myPanel.setBackground(myColor); 
		
		if(myRed == compRed && myBlue == compBlue && myGreen == compBlue) {
			JOptionPane.showMessageDialog(null, "Congrats! You win!"); 
		}
			
	}
	

	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new GuessMyColor();
            }   
        });
        // starts with the main function 

	}

}
