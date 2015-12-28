import java.util.Random;

/**
  The Die class simulates a die roll
*/

public class Die
{
  private int sides;   //Number of die sides
  private int value;  //The Die's value
  
  /**
    Constructor
  */
  
  public Die(int numSides)
  {
    sides = numSides;
  }
  
  /**
    The roll method simulates a roll, of the die
  */
  
  public void roll()
  {
    //create a random object
    Random rand = new Random();
    
    //Get a random value for the die
    value = rand.nextInt(sides) + 1;
  }
  
  /**
    getValue method
    @return The value of the die
  */
  
  public int getValue()
  {
    return value;
  }
}