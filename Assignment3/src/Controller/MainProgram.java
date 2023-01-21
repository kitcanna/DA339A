/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Controller;
import Model.Beverages;
import Model.Order;
import Model.OrderRegister;
import Model.PizzaRegister;
import View.MainPanel;

import javax.swing.*;

public class MainProgram {
    void startProgram(){
    	
    	//I chose the initiate my values here. By start, this creates the MainPanel and all the other objects needed
    	//and sets an adjustable starting limit to certain classes. I call for activation of listeners and sets up
    	//my MainFrame but nothing in it is directly decided here but in MainPanel.
    	int max = 100;
        MainPanel view = new MainPanel();
        Order model = new Order();
        OrderRegister cr = new OrderRegister(max);
        PizzaRegister pr = new PizzaRegister(max);
        Beverages dr = new Beverages(max);

        Controller cont = new Controller(model, view, cr, pr, dr);
        cont.addListener(); 

        JFrame frame = new JFrame("Welcome to Malmö University's Pizzeria!");
        ImageIcon image = new ImageIcon("pizza.png");
        frame.setIconImage(image.getImage());
        frame.add(view);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    public static void main(String[] args) {
        MainProgram go = new MainProgram();
        go.startProgram();
    }
}
