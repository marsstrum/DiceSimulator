import java.awt.*;       //for Border Layout Class
import java.awt.event.*; //for event listeners
import javax.swing.*;    //for GUI Swing classes

/**
  David M French HVCC Fall 2015 CISS111 Section 300
  Unit 5 Chapter 13 Coding Assignment: Dice Simulator Ch. 13 PC 9
  This program creates a GUI that simulates a dice role.
  Each time a "roll dice" button is clicked the application rolls and shows the dice
*/

public class DiceSimulator extends JFrame
{
  private JPanel westPanel;                        //Panel to hold the die on the left
  private JPanel eastPanel;                        //Panel to hold the die on the right
  private JPanel buttonPanel;                      //Panel to hold the "Roll Die" button
  private JLabel westLabel;                        //Label to show the left die image
  private JLabel eastLabel;                        //Label to show the right die image
  private JButton button;                          //Label to show the "Roll Die" button
  private final int WINDOW_WIDTH = 250;
  private final int WINDOW_HEIGHT = 200;
  
  /**
    Constructor
  */
  
  public DiceSimulator()
  {
    setTitle("Dice Simulator");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    
    //Action for the close button
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Create a Border Layout manager
    setLayout(new BorderLayout());
    
    //Build the button panel
    buildButtonPanel(); //Only the button panel will be visible until the die are rolled
    
   //Center the JFRame on the screen
    setLocationRelativeTo(null);
    
    //Pack and display the window
    pack();
    setVisible(true);    
  }
  
  /**
    buildButtonPanel method adds the button to the panel
  */
  
  public void buildButtonPanel()
  {
    //create the panel
    JPanel buttonPanel = new JPanel();
    
    //create button
    button = new JButton("Roll Die");
    
    //Add an action listener to the button
    button.addActionListener(new ButtonListener());
    
    //Add button to panel
    buttonPanel.add(button);
    
    //position the panel in the content pane
    add(buttonPanel, BorderLayout.SOUTH);
    
  }
  
  /**
   ButtonListener is an action listener class for the "Roll Die" button 
  */
  
  private class ButtonListener implements ActionListener
  {
    /**
     The actionPerformed method executes when the user clicks on the "Roll Die" button
     @param e The event object
    */
     
    public void actionPerformed(ActionEvent e)
    {
     final int DIE1_SIDES = 6;
     final int DIE2_SIDES = 6;
     
     //create two instances of the die
     Die die1 = new Die(DIE1_SIDES);
     Die die2 = new Die(DIE2_SIDES);
     
     //Roll the dice
     die1.roll();
     die2.roll();
     
     String leftDiePath = "Dice\\Die"+Integer.toString(die1.getValue())+".png";
     String rightDiePath = "Dice\\Die"+Integer.toString(die2.getValue())+".png";
     
    /**
     Build the die panels each time dice are rolled
    */
     
     //Create the panels
     JPanel westPanel = new JPanel();
     JPanel eastPanel = new JPanel();
     
    //Create images for the labels
     ImageIcon leftDie = new ImageIcon(leftDiePath);
     ImageIcon rightDie = new ImageIcon(rightDiePath);
     
     //Create west label and add die image to the west label
     JLabel westLabel = new JLabel();
     westLabel.setIcon(leftDie);
     westPanel.add(westLabel);
     
     //Create east label and add die image to the east label
     JLabel eastLabel = new JLabel();
     eastLabel.setIcon(rightDie);
     eastPanel.add(eastLabel);
     
     //add and position the panels to the content pane
     add(westPanel, BorderLayout.WEST);
     add(eastPanel, BorderLayout.EAST);
     
     //pack the frame to fit the dice images
     pack();
     
    }
  }
  
  /**
    Main method to create instance of the DiceSimulator Class
  */
  public static void main(String[] args)
  {
    new DiceSimulator();
  }
}