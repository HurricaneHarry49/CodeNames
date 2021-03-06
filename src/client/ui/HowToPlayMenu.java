package client.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HowToPlayMenu extends JFrame {
	
	private final int WIDTH = 450;
	private final int HEIGHT = 400;
	private static JPanel displayPanel;
	private final int MAX_PAGES = 10;
	private int current;
	private int numPages;
	public HowToPlayMenu() {
		initUI();
	}
	
	public void initUI() {
		
		displayPanel = new JPanel();
		setTitle("How to play");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("pics/Frame.png");
        setIconImage(icon.getImage());
        
        String[] howTo = new String[]{"<html>","<html>","<html>","<html>","<html>","<html>","<html>","<html>","<html>","<html>"};
        int i = 0;
        current = 0;
        numPages = 0;
        File rules = new File("textFiles/rules.txt");
        try {
        	BufferedReader br = new BufferedReader(new FileReader(rules));
        	for(i=0; i<MAX_PAGES; i++) {
        		boolean flag = false;
            	for(int j=0; j<10; j++) {
            		String line = br.readLine();
            		if(line == null) {
            			flag = true;
            			break;
        			}
            		howTo[i] += line+"<br>";
            	}
            	howTo[i]+="</html>";
            	if(flag) {break;}
            }
        } catch(IOException E) {
        	JOptionPane.showMessageDialog(null, "The rules.txt file has been does not exist!\nReturning to main menu!");
        	this.leavePage();
        }
       numPages = i;
        
//        System.out.println("I:"+i+"/nMaxPages:"+MaxPages);
//        System.out.println(howTo[0]);
        
        ImageIcon next = new ImageIcon("pics/NextArrow.png");
        ImageIcon prev = new ImageIcon("pics/PrevArrow.png");
        
        JButton mainButton = new JButton("Main Menu"); //returns users to the main menu
        JLabel instructions = new JLabel(howTo[0]); //a label that contains the current page of instructions
        JButton nextDialog = new JButton(next); //a button to display the next page of instructions
        JButton prevDialog = new JButton(prev); //a button to display the previous page of instructions
        
        //this button functionality is completed
        mainButton.addActionListener((ActionEvent event) -> {
        	leavePage();
        });
        
        //when users click this button it loads the next page of instuctions
        nextDialog.addActionListener((ActionEvent event) -> {
        	if(current < numPages) {
        		current++;
        		instructions.setText(howTo[current]);
        		if(current == numPages) {
        			nextDialog.setVisible(false);
        		}else if(current == 1) {
        			prevDialog.setVisible(true);
        		}
        	}
        });
        
      //when users click this button it loads the previous page of instuctions
        prevDialog.addActionListener((ActionEvent event) -> {
        	if(current != 0) {
        		current--;
        		instructions.setText(howTo[current]);
        		if(current == 0) {
        			prevDialog.setVisible(false);
        		}else if(current == numPages - 1) {
        			nextDialog.setVisible(true);
        		}
        	}
        });
        
        displayPanel.add(mainButton);
        displayPanel.add(instructions);
        displayPanel.add(prevDialog);
        displayPanel.add(nextDialog);
        this.add(displayPanel);
        this.setVisible(true);
	}
	
	private void leavePage() {
		String[] args = new String[0];
		this.removeAll();
		this.setVisible(false);
		MainMenu.main(args);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(() -> {
			HowToPlayMenu mm = new HowToPlayMenu();
            mm.setVisible(true);
        });
	}
}
