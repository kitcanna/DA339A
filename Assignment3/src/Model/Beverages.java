/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

 package Model;

public class Beverages extends Food {
    private String drinkName;
    private String drinkPercent;
    private int drinkAmount;
	private double drinkPrice;

    private String category;

    private Beverages[] drinklist;

    public Beverages(int max){
        drinklist = new Beverages[max];
        Beverages d2 = new Beverages(0,     "Water",                25.0,   "");
        Beverages d3 = new Beverages(0,     "Sparkling Water",      25.0,   "");
        Beverages d4 = new Beverages(0,     "CocaCola",             25.0,   "");
        Beverages d5 = new Beverages(0,     "Fanta",                25.0,   "");
        Beverages d6 = new Beverages(0,     "Sprite",               25.0,   "");
        Beverages d7 = new Beverages(0,     "Alcohol free Beer",    25.0,   "");
        Beverages d8 = new Beverages(0,     "Alcohol free Wine",    25.0,   "");
        Beverages d9 = new Beverages(0,     "Wine",                 75.0,   "13.5%");
        Beverages d10 = new Beverages(0,    "Beer",                 75.0,   "4.5%");
        Beverages d11 = new Beverages(0,    "Cocktail",             75.0,   "8.0%");

        createDrink(d2);
        createDrink(d3);
        createDrink(d4);
        createDrink(d5);
        createDrink(d6);
        createDrink(d7);
        createDrink(d8);
        createDrink(d9);
        createDrink(d10);
        createDrink(d11);
    }
    public Beverages () {
        drinkName = "";
        drinkPercent = "";
        drinkAmount = 0;
        drinkPrice = 0.0;
        category = "Drink";
    }

    public Beverages(int drinkAmount, String drinkName, double drinkPrice, String drinkPercent) {
        this.drinkName = drinkName;
        this.drinkAmount = drinkAmount;
        this.drinkPercent = drinkPercent;
        this.drinkPrice = drinkPrice;
    }

    private void createDrink(Beverages dr) {
        drinklist[drinkAmount] = dr;
        drinkAmount++;
    }

    public String[] setInfoToDrinkJList() {
        String newArray[] = new String[drinkAmount];
        int i = 0;
        for (Beverages dr: drinklist){
            if (dr != null){
                newArray[i] = dr.toMenu();
                i++;
            }
        }
        return newArray;
    }

    ////////////////////////////////////////////////////////////////
    
    //String that goes to the drinkmenu
    public String toMenu() {
		return String.format("%s | %sSEK | %s", drinkName, drinkPrice, drinkPercent);
	}

    ////////////////////////////////////////////////////////////////

    public Beverages getDrinkAt(int index) { return drinklist[index]; }
    public String getDrinkName() { return drinkName; }
	public void setDrinkName(String drinkName) { this.drinkName = drinkName; }
    public String getDrinkPercent() { return drinkPercent; }
	public void setDrinkPercent(String drinkPercent) { this.drinkPercent = drinkPercent; }
    public double getDrinkPrice() { return drinkPrice; }
	public void setDrinkPrice(double drinkPrice) { this.drinkPrice = drinkPrice; }
    public int getDrinkAmount() { return drinkAmount; }
	public void setDrinkAmount(int drinkAmount) { this.drinkAmount = drinkAmount; }

    //////////////////From abstract class Food//////////////////////
    @Override
    String getCategory() {return category;}
    ////////////////////////////////////////////////////////////////

	/* CURRENTLY NOT IN USE
    @Override
     public String toString() {
        return String.format("%s %20s %20s", drinkAmount, drinkName, calcTotalDrink());
	}*/
}
