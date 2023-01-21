/*  Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/
package partyController;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainProgram
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int size = Integer.parseInt(JOptionPane.showInputDialog("How many guests do you want your guestlist to cointain?"));   
        
	    while (size <= 0) {
	        size = Integer.parseInt(JOptionPane.showInputDialog("Error, size too small! Choose a number greater than 0."));
	    }
	       	Controller controller = new Controller(size);
        
       	//JOptionPane.showMessageDialog(null, "Error. Not a number.");
    }
}
