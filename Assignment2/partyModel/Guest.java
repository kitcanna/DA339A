/*  Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/
package partyModel;

import javax.swing.JOptionPane;

public class Guest {

	private String firstName;
    private String familyName; 
    private Address address;
    
    public Guest(){
    	initializeValues();
    }
    
    public void initializeValues(){
    	firstName = "";
    	familyName = "";
    	address = new Address();
    }

    public Guest (String firstName, String familyName, String street, String city, String zipCode, Countries country) {
    		this.address = new Address(street, city, zipCode, country);
    	 	this.firstName = firstName; 
        	this.familyName = familyName;
    }
    
    public String getFirstName() {
        return firstName;
	}
	public void setFirstName(String firstName) {
        this.firstName = firstName;
	}
	public String getFamilyName() {
	        return familyName;
	}
	public void setFamilyName(String familyName) {
	        this.familyName = familyName;
	}
	public String getStreet() {
	        return address.getStreet();
	}
	public void setStreet(String street) {
	        address.setStreet(street);
	}
	public String getCity() {
	        return address.getCity();
	}
	public void setCity(String city) {
	        address.setCity(city);
	} 
	public String getZipCode() {
		   	return address.getZipCode();
	}
	public void setZipCode(String zipCode) {
		    address.setZipCode(zipCode);
	}
	public Countries getCountry() {
	        return address.getCountry();
	}
	public void setCountry(Countries country){
	        address.setCountry(country); 
	}

	public String toString() {
		String str= String.format("%S, %-15s %s", familyName, firstName, address.toString());
		return str;
	}
}
