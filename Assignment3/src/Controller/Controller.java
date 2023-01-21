/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Controller;

import Model.Beverages;
import Model.Order;
import Model.OrderRegister;
import Model.Pizza;
import Model.PizzaRegister;
import View.MainPanel;
import javax.swing.*;

public class Controller {
    private Order model;
    private MainPanel mp;
    private OrderRegister or;
    private PizzaRegister pr;
    private Beverages dr;

    //Constructor called from MainProgram
    //Creating and declaring objects of the instance variables that Controller is said to contain from Main Program
    public Controller(Order model, MainPanel mp, OrderRegister or, PizzaRegister pr, Beverages dr) {
        this.model = model;
        this.mp = mp;
        this.or = or;
        this.pr = pr;
        this.dr = dr;
        //Sets default pizzas and drinks to their JLists.
        addPizzasToJList();
        addDrinksToJList();
        //Sets the button for add drink to unavailable since an order needs to contain at least 1 pizza
        mp.getAddDrink().setEnabled(false);
    }

    //Adds listeners to all the buttons and functions necessary
    public void addListener() {
        mp.getAddPizza().addActionListener(e -> addPizzaToCart());
        
        mp.getAddDrink().addActionListener(e -> addDrinkToCart());
        mp.getSave().addActionListener(e -> addOrder());

        mp.getJList().addListSelectionListener(e -> {
            showSelectedContactInGUI();
            mp.getErase().setEnabled(true);
        });

        mp.getErase().addActionListener(e -> deleteOrder());

        mp.getCreate().addActionListener(e -> addPizza());
    }

    //If index is valid and amount is at least 1: 
    //add the pizza by the method addPizzaToCart in Order Register. 
    //Send in amount and pizza as an object decided by index to this method.
    //Make add drink button available if successful.
    private void addPizzaToCart() {
        int index = mp.getPJList().getSelectedIndex();
        Pizza in = pr.getPizza(index);
        String amount = mp.getTfpAmount();
        char c = amount.charAt(0);

        if ((!amount.isEmpty()) && (c!='0') && index >= 0) {
            or.addPizzaToCart(Integer.parseInt(amount), in);
            mp.getAddDrink().setEnabled(true); 
            
            //Adds the pizza's "toString" to the shopping cart
            //so that we can see the items
            addToViewCartP(index);
            mp.setRes("Added to cart");
            //Clears all the selections and inputed amounts
            mp.clearCart();
        } 
        else {
            mp.setRes("Please order at least 1 pizza!");
        }
        mp.getTerms().setSelected(false);
        mp.getErase().setEnabled(false);
    }
    
    //If index is valid and amount is at least 1: 
    //add the drink by the method addDrinkToCart in Order Register.
    //Send in amount and drink as an object decided by index to this method.
    //If index is bigger than a certain number, it means that it contains alcohol and
    //if this index is chosen, the user must check the "over 18" box to confirm their age
    //This is hardcoded at the moment but could be replaced by creating seperate drinklists. 
    private void addDrinkToCart() {
        int index = mp.getDrinkJList().getSelectedIndex();
        Beverages in = dr.getDrinkAt(index);
        String amount = mp.getTfdAmount();
        char c = amount.charAt(0);
        
        if (index < 0){
            mp.setRes("Please select a drink!");
        }
        else {
        	//Checks index and amount
            if (!amount.isEmpty() && (c!='0') && index >= 0) {
            	//Checks if index is Alcohol, and then if checkbox is checked.
                if (index >= 7 && mp.getTerms().isSelected()) {
                    or.addDrinkToCart(Integer.parseInt(amount), in);
                    //Adds the pizza's "toString" to the shopping cart
                    //so that we can see the items
                    addToViewCartD(index);
                    mp.setRes("Added to cart");
                    //Clears all the selections and inputed amounts
                    mp.clearCart();
                }
                //Checks index and amount for non-alcoholic drinks
                else if (index <= 6) {
                    or.addDrinkToCart(Integer.parseInt(amount), in);
                    //Adds the drinks "toString" to the shopping cart
                    //so that we can see the items
                    addToViewCartD(index);
                    mp.setRes("Added to cart");
                    //Clears all the selections and inputed amounts
                    mp.clearCart();
                }
                else {
                    mp.setRes("Please confirm that you are over the age of 18!");
                }
            }
            else {
                mp.setRes("Please order at least 1 drink!");
            }
        }
        mp.getTerms().setSelected(false);
        mp.getErase().setEnabled(false);
    }

    //Calls to the method create order in Order register that takes the 
    //shoppingcart and adds the item(s) to the orderlist.
    //The method then calls to set the order in the JList and
    //clears all the selections and inputs.
    //Set buttons to their default mode again.
    private void addOrder() {	
        or.createOrder();
        addToJList();
        mp.setRes("Order created!");
        clearTextFields();
        mp.getErase().setEnabled(false);
        mp.getAddDrink().setEnabled(false);
    }

    //Gets the inputed values and checks that the Pizza has at least
    //a name and 1 topping, and inputs the values to the method createPizza in Pizza Register.
    private void addPizza() {
        String createName = mp.getTco();
        String t1 = mp.getTft1();
        String t2 = mp.getTft2();
        String t3 = mp.getTft3();

        if ((!createName.isEmpty())&&(!t1.isEmpty())) {
            pr.createPizza(createName, t1, t2, t3);
            //Adds the created pizza to the pizza menu
            addPizzasToJList();
            mp.setRes("Pizza created!");
            //Clears all the selections and inputed amounts
            mp.clearCart();
        } else {
            mp.setRes("Pizzas needs at least 1 topping and a name!");
        }
        mp.getTerms().setSelected(false);
        mp.getErase().setEnabled(false);
    }

    //Double checks that the user wants to delete an order, checks that
    //index is valid and if so, calls for deleteOrder method in Order Register.
    //Then calls for addToJList to update the current list we can see. 
    //BUGG som ej är kodad för pga det är ej ett krav! - Index kommer inte ändras och därför blir
    //showSelectedContactInGUI() fel därefter. 
    private void deleteOrder() {
        int result = JOptionPane.showConfirmDialog(null,
                "Do you really want to delete this order?",
                "Warning", JOptionPane.YES_NO_OPTION);

        if (result == 0) {
            int index = mp.getJList().getSelectedIndex();
            or.deleteOrder(index);
            addToJList();
            clearTextFields();
            mp.setRes("Order deleted!");
            mp.getErase().setEnabled(false);
        } 
        //If user presses no: jumps out of method.
        else {
            return;
        }
    }

    //When user clicks on an order in the orderlist, it takes the index
    //and uses this to show the Order's "toString" in the details section.
    private void showSelectedContactInGUI() {
        if (mp.getJList().getSelectedIndex() < 0){
            return;
        }
        else {
            int index = mp.getJList().getSelectedIndex();
            mp.setTextArea(or.getElementAt(index).toShowSelected());
        }
    }

    //A method that sets the JList in the MainPanel with values from 
    //the Order Register (toString's for every order existing)
    private void addToJList() {
        mp.setJList(or.setInfoToJList());
    }
    
    //A method that sets the Pizza's JList in the MainPanel with values from 
    //the Pizza Register (toString's for every Pizza existing)
    private void addPizzasToJList() {
        mp.setPJList(pr.setInfoToPJList());
    }
    
    //A method that sets the Drink's JList in the MainPanel with values from 
    //the Beverages Class (toString's for every Drink existing)
    private void addDrinksToJList() {
        mp.setDrinkJList(dr.setInfoToDrinkJList());
    }

    //A method that sets the already existing values (mp.getCartArea())
    //+ the newly added item (by getCartElementAt in Order Register)
    //to the Cart so that we can see the ongoing order. 
    //TOP = Pizzas
    //BOTTOM = Drinks
    private void addToViewCartP(int index) {
        String str = String.format("%s %s\n", mp.getCartArea(), or.getCartElementAt(0).pjListCart()) ;
        mp.setCartArea(str);
    }
    private void addToViewCartD(int index) {
        String str = String.format("%s %s\n", mp.getCartArea(), or.getCartElementAt(0).djListCart()) ;
        mp.setCartArea(str);
    }

    //Calls for the MainPanel's function to clean the selected items and inputed values
    private void clearTextFields() {
        mp.clearFields();
    }
}
