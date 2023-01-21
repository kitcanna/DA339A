/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Model;

interface IOrder {
	void setID(int id);
	int getID();
	double getTotal();
	void setTotal(double total);
}

public class Order implements IOrder{
	private Pizza[] pizzas;
	private int indexForPizza;

	private Beverages[] drinks;
	private int indexForDrinks;

	private Beverages drink;
	private Pizza pizza;

	private int id;
	private double total;
	
	private int maxAmount = 100;

	public Order() {
		pizzas = new Pizza[maxAmount];
		drinks = new Beverages[maxAmount];
		drink = new Beverages();
		pizza = new Pizza();
		id = 0;
		total = 0;
		indexForPizza = 0;
		indexForDrinks = 0;
	}

	public void addToPizzas(Pizza pizza){
		pizzas[indexForPizza] = pizza;
		indexForPizza++;
	}
	public void addToDrinks(Beverages drink){
		drinks[indexForDrinks] = drink;
		indexForDrinks++;
	}
	
	////////////////////////////////////////////////////////////////

	private int getAmountOfPizzas(){
		int amountOfPizzas = 0;
		for(int i = 0; i < indexForPizza; i++){
			amountOfPizzas += pizzas[i].getPizzaAmount();
		}
		return amountOfPizzas;
	}
	private int getAmountOfDrinks(){
		int amountOfDrinks = 0;
		for(int i = 0; i < indexForDrinks; i++){
			amountOfDrinks += drinks[i].getDrinkAmount();
		}
		return amountOfDrinks;
	}

	////////////////////////////////////////////////////////////////

	private double getPizzaTotal(){
		double pizzaTotal = 0.0;
		for(int i = 0; i < indexForPizza; i++){
			pizzaTotal += pizzas[i].getPizzaPrice() * pizzas[i].getPizzaAmount();
		}
		return pizzaTotal;
	}

	private double getDrinkTotal(){
		double drinkTotal = 0.0;
		for(int i = 0; i < indexForDrinks; i++){
			drinkTotal += drinks[i].getDrinkPrice() * drinks[i].getDrinkAmount();
		}
		return drinkTotal;
	}

	private double calcTotal() {
		double total = 0.0;
		total = getPizzaTotal() + getDrinkTotal();
		return total;
	}

	////////////////////////////////////////////////////////////////

	//Data that goes to the shoppingcart for Pizzas when you add a Pizza
	public String pjListCart() {
		String str = String.format("%s %10s: %s %6s %6sSEK", getPizzaAmount(), pizza.getCategory() ,getPizzaType(), "á", getPizzaPrice());
		return str;
	}

	//Data that goes to the shoppingcart for Drinks when you add a Drink
	public String djListCart() {
		String str = String.format("%s %10s: %s %6s %6sSEK", getDrinkAmount(), drink.getCategory(), getDrinkType(), "á", getDrinkPrice());
		return str;
	}

	////////////////////////////////////////////////////////////////

	//Data that goes to the details when an order is placed
	@Override 
	public String toString(){
		String str = String.format("%s%s %20s%s %20s%s %20s%sSEK ", "ID: ",getID(), "Pizzas: ",getAmountOfPizzas(), "Drinks: ",getAmountOfDrinks(), "Total: ",calcTotal());
		return str;
	} 

	////////////////////////////////////////////////////////////////

	//Data that goes to the details when an already placed order is selected
	public String toShowSelected() {
		return getPizzasString().toString() + getDrinksString().toString();
	}

	private StringBuilder getPizzasString(){
		StringBuilder str= new StringBuilder();
		for(int i=0; i<indexForPizza; i++){
			str.append(String.format("%s %15s %10s %10sSEK \n", pizzas[i].getPizzaAmount(), pizzas[i].getPizzaType(), "á", pizzas[i].getPizzaPrice()));
		}
		return str;
	}

	private StringBuilder getDrinksString(){
		StringBuilder str = new StringBuilder();
		for(int i=0; i<indexForDrinks; i++){
			str.append(String.format("%s %15s %10s %10sSEK \n", drinks[i].getDrinkAmount(), drinks[i].getDrinkName(), "á", drinks[i].getDrinkPrice()));
		}
		return str;
	}

	////////////////////////////////////////////////////////////////
	@Override
	public void setID(int id) {this.id = id;}
	@Override
	public int getID() {return id;}

	@Override
	public void setTotal(double total) {this.total = total;	}
	@Override
	public double getTotal() {return total;}
	
	///////////////PIZZA//////////////////
	public Pizza getPizza() {return pizza;}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
		addToPizzas(this.pizza);
	}

	public String getPizzaType() {return pizza.getPizzaType();}
	public void setPizzaType(String pizzaType) {pizza.setPizzaType(pizzaType);}
	public int getPizzaAmount() {return pizza.getPizzaAmount();}
	public void setPizzaAmount(int pizzaAmount) {pizza.setPizzaAmount(pizzaAmount);}
	public double getPizzaPrice() {return pizza.getPizzaPrice();}
	
	///////////////DRINK//////////////////
	public Beverages getDrink() {return drink;}
	public void setDrink(Beverages drink) {
		this.drink = drink;
		addToDrinks(this.drink);
	}

	public String getDrinkType() {return drink.getDrinkName();}
	public int getDrinkAmount() {return drink.getDrinkAmount();	}
	public void setDrinkAmount(int drinkAmount) {drink.setDrinkAmount(drinkAmount);}
	public double getDrinkPrice() {return drink.getDrinkPrice();}







}
