/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Model;

public class PizzaRegister extends Pizza{
    private Pizza[] pizzalist; 
    private int numOfPizzas = 0; 

    public PizzaRegister(int max){
        pizzalist = new Pizza[max];
        Pizza marg = new Pizza(0, "Margherita", 110.0, "Mozzarella", "Basil", "Olive Oil");
        Pizza ves = new Pizza(0, "Vesuvio", 90.0, "Ham", "Oregano", "");
        Pizza cap = new Pizza(0, "Capricciosa", 90.0,"Mushroom", "Ham", "");
        Pizza keb = new Pizza(0, "Kebabpizza", 110.0, "Kebabkött", "Sås", "Feferoni");
        Pizza pes = new Pizza(0, "Pescatore", 90.0, "Tonfisk", "Lök", "");
        createPizza(marg);
        createPizza(ves);
        createPizza(cap);
        createPizza(keb);
        createPizza(pes);
    }

    public void createPizza(Pizza pizzaIN){
            pizzalist[numOfPizzas] = pizzaIN;
            numOfPizzas++;
    }

    public Pizza getPizza(int index) {
        return pizzalist[index];
    }
    
    public String [] setInfoToPJList(){
        String newArray[] = new String[numOfPizzas];
        int i = 0;
        for (Pizza yum: pizzalist){
            if (yum != null){
                newArray[i] = yum.pjList();
                i++;
            }
        }
        return newArray;
    }

    //NOT IN USE
    public boolean isContactUnique(String name){
        boolean isContactUnique = true;

        for (Pizza yum: pizzalist){
            if (yum.getPizzaType().compareToIgnoreCase(name) == 0){
                isContactUnique = false;
            }
        }
        return isContactUnique;
    }

    public String [] getInfoStrings(){
        String infoStrings [] = new String[numOfPizzas];
        int i = 0;
        for (Pizza yum: pizzalist){
            if (yum != null){
                infoStrings[i] = yum.toString();
                i++;
            }
        }
        return infoStrings;
    }
  

    // Lägger till en CREATED pizza och bestämmer priset utifrån antalet toppings
    public boolean createPizza(String name, String topping1, String topping2, String topping3){
        boolean ok = true;
        if ((numOfPizzas < pizzalist.length)){
            Pizza pizza = new Pizza(0, "", 0, "", "", "");
            double price = 110.0;
		    if (topping1.isEmpty()) {
			    price -= 20;
		    }
		    if (topping2.isEmpty()) {
			    price -= 20;
		    }
		    if (topping3.isEmpty()) {
			    price -= 20;
		    }

            pizza.setPizzaAmount(0);
            pizza.setPizzaType(name);
            pizza.setPizzaPrice(price);
            pizza.setTopping1(topping1);
            pizza.setTopping2(topping2);
            pizza.setTopping3(topping3);

            pizzalist[numOfPizzas++] = pizza;
        }
        else ok = false;

        return ok;
    }
}