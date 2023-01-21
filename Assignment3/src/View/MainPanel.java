/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package View;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JLabel name;
    private JLabel pAmount;
    private JLabel drink;
    private JLabel dAmount;
    private JLabel createName;

    private JLabel topping1;
    private JLabel topping2;
    private JLabel topping3;
    private JLabel createInfo;

    private JLabel res;

    private JTextField tfpAmount;
    private JTextField tfdAmount;
    private JTextField tco;
    private JTextField tft1;
    private JTextField tft2;
    private JTextField tft3;

    private JTextArea textArea, cartArea;

    private JButton erase, save, create, addPizza, addDrink;

    private JPanel mainPanel, leftPnl, centerPnl,
            rightPnl, pizzaPnl, createPnl, drinkPnl, detailsPnl, ongoingPnl, btnPnl;

    private JCheckBox terms;

    private JList pjList, drinkjList, jList;

    public MainPanel() {
        createComponents();
    }
    
    public void clearCart() {
        setTfpAmount(null);
        setTco(null);
        setTft1(null);
        setTft2(null);
        setTft3(null);
        setTfdAmount(null);
        clearSelection();
        setTextArea(null);
    }
    
    public void clearFields() {
        setTfpAmount(null);
        setTco(null);
        setTft1(null);
        setTft2(null);
        setTft3(null);
        setTfdAmount(null);
        clearSelection();
        setTextArea(null);
        setCartArea(null);
    }

    public void createComponents() {
        setPreferredSize(new Dimension(1200, 780));
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1200, 750));
        mainPanel.setBackground(new Color(216, 223, 219));

        Dimension tfDim = new Dimension(170, 20);
        Dimension adDim = new Dimension(190, 20);


        String[] title = { "Pizza", "Create Your Own", "Beverage", "Size", "Ongoing order...", "Order details", "Orderlist" };

        /////////////////// PIZZA//////////////////////
        pizzaPnl = new JPanel();
        pizzaPnl.setPreferredSize(new Dimension(300, 220));
        pizzaPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        pizzaPnl.setBorder(BorderFactory.createTitledBorder(title[0]));
        pizzaPnl.setBackground(new Color(216, 223, 219));

        name = new JLabel("Choose pizza:                                               ");
        pAmount = new JLabel("Amount:    ");

        tfpAmount = new JTextField();
        tfpAmount.setPreferredSize(adDim);

        pjList = new JList();
        JScrollPane pizzas = new JScrollPane(pjList);
        pizzas.setPreferredSize(new Dimension(280, 107));
        pizzas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pizzas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        addPizza = new JButton("Add");
        addPizza.setPreferredSize(new Dimension(220, 22));

        pizzaPnl.add(name);
        pizzaPnl.add(pizzas);
        pizzaPnl.add(pAmount);
        pizzaPnl.add(tfpAmount);
        pizzaPnl.add(addPizza);

        /////////////////// BEVERAGE//////////////////////
        drinkPnl = new JPanel();
        drinkPnl.setPreferredSize(new Dimension(300, 220));
        drinkPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        drinkPnl.setBorder(BorderFactory.createTitledBorder(title[2]));
        drinkPnl.setBackground(new Color(216, 223, 219));

        drink = new JLabel("Drinklist:                                                     ");
        drinkjList = new JList();
        JScrollPane drinklist = new JScrollPane(drinkjList);
        drinklist.setPreferredSize(new Dimension(280, 80));
        drinklist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        dAmount = new JLabel("Amount:    ");
        tfdAmount = new JTextField();
        tfdAmount.setPreferredSize(adDim);

        terms = new JCheckBox("I am over 18.");
        terms.setFont(new Font("Arial,", Font.PLAIN, 13));
        terms.setPreferredSize(new Dimension(280, 25));

        addDrink = new JButton("Add");
        addDrink.setPreferredSize(new Dimension(220, 22));

        drinkPnl.add(drink);
        drinkPnl.add(drinklist);
        drinkPnl.add(dAmount);
        drinkPnl.add(tfdAmount);
        drinkPnl.add(terms);
        drinkPnl.add(addDrink);

        //////////////// CREATE OWN/////////////////////////
        createPnl = new JPanel();
        createPnl.setPreferredSize(new Dimension(300, 190));
        createPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        createPnl.setBorder(BorderFactory.createTitledBorder(title[1]));
        createPnl.setBackground(new Color(216, 223, 219));

        createName = new JLabel("Name of pizza: ");
        topping1 = new JLabel("Topping 1:        ");
        topping2 = new JLabel("Topping 2:        ");
        topping3 = new JLabel("Topping 3:        ");
        createInfo = new JLabel("Every pizza comes with tomatosauce and cheese!");
        createInfo.setFont(new Font("Calibri", Font.ITALIC, 11));

        tco = new JTextField();
        tft1 = new JTextField();
        tft2 = new JTextField();
        tft3 = new JTextField();

        tco.setPreferredSize(tfDim);
        tft1.setPreferredSize(tfDim);
        tft2.setPreferredSize(tfDim);
        tft3.setPreferredSize(tfDim);
   
        create = new JButton("Create Pizza");
        create.setPreferredSize(new Dimension(220, 22));

        createPnl.add(createName);
        createPnl.add(tco);
        createPnl.add(topping1);
        createPnl.add(tft1);
        createPnl.add(topping2);
        createPnl.add(tft2);
        createPnl.add(topping3);
        createPnl.add(tft3);
        createPnl.add(createInfo);
        createPnl.add(create);

        ////////////////// BUTTONS///////////////////////
        save = new JButton("Submit order");
        erase = new JButton("Delete Order");
        save.setPreferredSize(new Dimension(150, 30));
        erase.setPreferredSize(new Dimension(150, 30));

        btnPnl = new JPanel();
        btnPnl.setPreferredSize(new Dimension(580, 50));
        btnPnl.setBackground(new Color(216, 223, 219));

        btnPnl.add(save);
        btnPnl.add(erase);

        ///////////////// VÄNSTERSPALT////////////////////////
        leftPnl = new JPanel();
        leftPnl.setPreferredSize(new Dimension(320, 660));
        leftPnl.add(pizzaPnl);
        leftPnl.add(drinkPnl);
        leftPnl.add(createPnl);
        leftPnl.setBackground(new Color(216, 223, 219));

        ////////////////// ORDERDETAILS///////////////////////
        ongoingPnl = new JPanel();
        ongoingPnl.setPreferredSize(new Dimension(300, 317));
        ongoingPnl.setBorder(BorderFactory.createTitledBorder(title[4]));
        ongoingPnl.setBackground(new Color(216, 223, 219));

        cartArea = new JTextArea();
        cartArea.setPreferredSize(new Dimension(280, 275));
        cartArea.setEditable(false);
        ongoingPnl.add(cartArea);
        
        detailsPnl = new JPanel();
        detailsPnl.setPreferredSize(new Dimension(300, 317));
        detailsPnl.setBorder(BorderFactory.createTitledBorder(title[5]));
        detailsPnl.setBackground(new Color(216, 223, 219));

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(280, 275));
        textArea.setEditable(false);
        detailsPnl.add(textArea);


       ///////////////// Mittenspalt ////////////////////////
       centerPnl = new JPanel();
       centerPnl.setPreferredSize(new Dimension(300, 660));
       centerPnl.add(ongoingPnl);
       centerPnl.add(detailsPnl);
       centerPnl.setBackground(new Color(216, 223, 219));
        
        ////////////////// ORDERS ///////////////////////
        rightPnl = new JPanel();
        rightPnl.setPreferredSize(new Dimension(550, 630));
        rightPnl.setBorder(BorderFactory.createTitledBorder(title[6]));
        rightPnl.setBackground(new Color(216, 223, 219));

        jList = new JList();
        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setPreferredSize(new Dimension(500, 550));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

 
        rightPnl.add(scrollPane);

        /////////////ADD ALL/////////////
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.BOLD, 20));
        res.setPreferredSize(new Dimension(500, 20));

        erase.setEnabled(false);

        /////////////ADD ALL/////////////
        mainPanel.add(leftPnl);
        mainPanel.add(centerPnl);
        mainPanel.add(rightPnl);
        mainPanel.add(btnPnl);
        mainPanel.add(res);

        add(mainPanel);
        ///////////////////////////////////////
    }


    ///////////// GS för PizzaInfo/////////////
    public String getTfpAmount() {
        return tfpAmount.getText();
    }
    public void setTfpAmount(String tfpAmount) {
        this.tfpAmount.setText(tfpAmount);
    }
    ///////////////////////////////////////

    ///////////// GS för Orderlista/////////////
    public JList getJList() {
        return jList;
    }
    public void setJList(String string[]) {
        jList.setListData(string);
    }
    public int getJListIndex() {
        return jList.getSelectedIndex();
    }
    ///////////////////////////////////////

    ///////////// GS för pizzameny/////////////
    public JList getPJList() {
        return pjList;
    }
    public void setPJList(String array[]) {
        pjList.setListData(array);
    }
    public int getPJListIndex() {
        return pjList.getSelectedIndex();
    }
    ///////////////////////////////////////


     ///////////// GS för pizzameny/////////////
     public void setCartArea(String cartArea) {
        this.cartArea.setText(cartArea);
    }
    public String getCartArea() {
         return cartArea.getText();
    }
    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }
    ///////////////////////////////////////

    ///////////// GS för drinkar/////////////  
    public JList getDrinkJList() {
        return drinkjList;
    }
    public void setDrinkJList(String array[]) {
        drinkjList.setListData(array);
    }
    public int getDrinkJListIndex() {
        return drinkjList.getSelectedIndex();
    }

    public String getTfdAmount() {
        return tfdAmount.getText();
    }
    public void setTfdAmount(String dAmount) {
        this.tfdAmount.setText(dAmount);
    }
    ///////////////////////////////////////

    ///////////// GS för create/////////////
    public String getTco() {
        return tco.getText();
    }
    public void setTco(String text) {
        this.tco.setText(text);
    }
    public String getTft1() {
        return tft1.getText();
    }
    public void setTft1(String text) {
        this.tft1.setText(text);
    }
    public String getTft2() {
        return tft2.getText();
    }
    public void setTft2(String text) {
        this.tft2.setText(text);
    }
    public String getTft3() {
        return tft3.getText();
    }
    public void setTft3(String text) {
        this.tft3.setText(text);
    }
    ///////////////////////////////////////

    ///////////// GS för buttons/////////////
    public JButton getSave() {
        return save;
    }
    public JButton getErase() {
        return erase;
    }
    public JButton getCreate() {
        return create;
    }
    public JButton getAddPizza() {
        return addPizza;
    }
    public JButton getAddDrink() {
        return addDrink;
    }
    ///////////////////////////////////////

    ///////////////// ETC//////////////////
    public void setTerms(JCheckBox terms) {
        this.terms = terms;
    }
    public JCheckBox getTerms() {
        return terms;
    }
    public void setRes(String res) {
        this.res.setText(res);
    }
    public void clearSelection() {
        terms.setSelected(false);
        pjList.clearSelection();
        drinkjList.clearSelection();
    }
    ///////////////////////////////////////
}
