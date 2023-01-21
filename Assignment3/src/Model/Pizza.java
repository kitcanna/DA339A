/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Model;

//since I didnt create a new class for every pizza but instead created an array of them, the interface here might seem "less" useful. 
interface IPizza { 
	void setPizzaType(String pizzaType);
	String getPizzaType();
	void setPizzaPrice(double pizzaPrice);
	double getPizzaPrice();
	void setPizzaAmount(int pizzaAmount);
	int getPizzaAmount();
	void setTopping1(String topping1);
	String getTopping1();
	void setTopping2(String topping2);
	String getTopping2();
	void setTopping3(String topping3);
	String getTopping3();
}

public class Pizza extends Food implements IPizza{
	private String pizzaType;
	private String topping1;
	private String topping2;
	private String topping3;
	private String topping4;
	private String topping5;
	private int pizzaAmount;
	private double pizzaPrice;

	private String category;

	public Pizza(int max){
		Pizza[] piz = new Pizza[max];
    }
	
	public Pizza() {
		pizzaType = "";
		topping1 = "";
		topping2 = "";
		topping3 = "";
		topping4 = "Tomato sauce";
		topping5 = "Cheese";
		pizzaAmount = 0;
		pizzaPrice = 50.0;
		category = "Pizza";
	}
	
	public Pizza (int pizzaAmount, String pizzaType, double pizzaPrice, String topping1, String topping2, String topping3) {
		this.pizzaAmount = pizzaAmount;
		this.pizzaPrice = pizzaPrice;
		this.pizzaType = pizzaType;
		this.topping1 = topping1;
		this.topping2 = topping2;
		this.topping3 = topping3;
		topping4 = "Tomato sauce";
		topping5 = "Cheese";
	}

	////////////////////////////////////////////////////////////////
	
	////String that goes to the pizzamenu
	public String pjList() { 
		return String.format("%S | %sSEK | %s %s %s %s %s ",pizzaType, pizzaPrice, topping1, topping2, topping3, topping4,
				topping5);
	}

	////////////////////////////////////////////////////////////////
	@Override
	public void setPizzaPrice(double pizzaPrice) {this.pizzaPrice = pizzaPrice;}
	@Override
	public double getPizzaPrice() {return pizzaPrice;}

	@Override
	public void setPizzaAmount(int pizzaAmount) {this.pizzaAmount = pizzaAmount;}
	@Override
	public int getPizzaAmount() {return pizzaAmount;}

	@Override
	public void setPizzaType(String pizzaType) {this.pizzaType = pizzaType;}
	@Override
	public String getPizzaType() {return pizzaType;}

	@Override
	public void setTopping1(String topping1) {this.topping1 = topping1;}
	@Override
	public String getTopping1() {return topping1;}

	@Override
	public void setTopping2(String topping2) {this.topping2 = topping2;}
	@Override
	public String getTopping2() {return topping2;}

	@Override
	public void setTopping3(String topping3) {this.topping3 = topping3;}
	@Override
	public String getTopping3() {return topping3;}

	//////////////////From abstract class Food//////////////////////
	@Override
	String getCategory() {return category;}
	////////////////////////////////////////////////////////////////

	/* CURRENTLY NOT IN USE
	@Override
	public String toString(){
		return String.format("%s %20s %20s", pizzaAmount, pizzaType, calcTotalPizza());	
	}*/


}
