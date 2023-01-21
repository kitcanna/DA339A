/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Model;

public class OrderRegister extends Order{
    private Order[] shoppingcart; //list
    private Order[] orders; //list
    private Order currOrder = null; //working object

    private int cartNo = 0; //always 0 since order is moved to 'orders' when placed
    private int orderNo = 0; //nbr of placed orders 

    public OrderRegister(int max){
        shoppingcart = new Order[max];;
        orders = new Order[max];
        currOrder = new Order();
    }

    public boolean addPizzaToCart(int amount, Pizza in) {
        boolean ok = true;
        if ((cartNo < shoppingcart.length)){
            Pizza p = new Pizza();
            p.setPizzaType(in.getPizzaType());
            p.setTopping1(in.getTopping1());
            p.setTopping2(in.getTopping2());
            p.setTopping3(in.getTopping3());
            p.setPizzaAmount(amount);
            p.setPizzaPrice(in.getPizzaPrice());

            currOrder.setPizza(p);
            shoppingcart[cartNo] = currOrder;
        }
        else {
            ok = false;
        }
        return ok;
    }

    public boolean addDrinkToCart(int amount, Beverages in) {
        boolean ok = true;
         if ((cartNo < shoppingcart.length)){
            Beverages d = new Beverages();
            d.setDrinkName(in.getDrinkName());
            d.setDrinkPercent(in.getDrinkPercent());
            d.setDrinkAmount(amount);
            d.setDrinkPrice(in.getDrinkPrice());

            currOrder.setDrink(d);
            shoppingcart[cartNo] = currOrder;
        }
        else {
        ok = false;
        }
        return ok;
    }

    public boolean createOrder(){
        boolean ok = true;
        if (cartNo < orders.length){
            currOrder.setID(orderNo);
            orders[orderNo] = currOrder;
            orderNo++;
            currOrder = new Order();
        }
        else {
            ok = false;
        }
        return ok;
    }
    
    public Order getElementAt(int index){
        return orders[index];
    }

    public Order getCartElementAt(int index){
        return shoppingcart[index];
    }
    
    //Data that goes to the orderlist
    public String [] setInfoToJList(){
        String newArray[] = new String[orderNo+1];
        int i = 0;
        for (Order ord: orders){
            if (ord != null){
                newArray[i] = ord.toString();
                i++;
            }
        }
        return newArray;
    }
    
    public void deleteOrder(int index){
        if (checkIndex(index))
        orders[index] = null;
        //orderNo--;          //flyttar inte ner index för "köket" har redan fått in ordern och ordernumret 
        moveElementsToLeft(index);
    }
    
    private void moveElementsToLeft(int index){
        for (int i = index+1; i < orders.length; i++){
            if (i > 0){
            orders[i-1] = orders[i];
            }
        }
    }

    private boolean checkIndex(int index){
        if ((index >= 0) && (index < orders.length))
            return true;
        else {
            return false;
        }
    }
}