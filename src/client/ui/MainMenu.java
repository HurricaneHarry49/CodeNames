package client.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JFrame {
	
	private int width = 400;
	private int height = 400;
	private static JPanel displayPanel;
	private static final long serialVersionUID = 1L;

	public MainMenu() {
		initUI();
	}
	
	public void initUI() {
		displayPanel = new JPanel();
		setTitle("Main Menu");
		setSize(width, height);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton startButton = new JButton("Join Game");
        JButton instructionsButton = new JButton("How to play");
        JButton creditsButton = new JButton("Credits");
        JButton quitButton = new JButton("Quit");
        
        String[] args = new String[0];
        startButton.addActionListener((ActionEvent event) -> {
        	FindGameMenu.main(args);
        	leavePage();
        });
        
        instructionsButton.addActionListener((ActionEvent event) -> {
        	HowToPlayMenu.main(args);
        	leavePage();
        });
        
        creditsButton.addActionListener((ActionEvent event) -> {
        	CreditsMenu.main(args);
        	leavePage();
        });
        
        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        displayPanel.add(startButton);
        displayPanel.add(instructionsButton);
        displayPanel.add(creditsButton);
        displayPanel.add(quitButton);
        this.add(displayPanel);
        this.setVisible(true);
	}
	
	private void leavePage() {
		this.removeAll();
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        });
	}

}