/*  Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/
package partyModel;

public class Address {

	private String street;
	private String city;
	private String zipCode;
	private Countries country;
	
	 public Address(){
		 initializeValues();
	 }
	    
	 public void initializeValues(){
	        street = "";
	        city = "";
	        zipCode = "";
	        country = country.Unknown;
	 }
 
	 public Address (String street, String city, String zipCode, Countries country) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	 }

	 public String getStreet() {
	        return street;
	 }
	 public void setStreet(String street) {
	        this.street = street;
	 }
	 public String getCity() {
	        return city;
	 }
	 public void setCity(String city) {
	        this.city = city;
	 }
	 public String getZipCode() {
		   	return zipCode;
	 }
	 public void setZipCode(String zipCode) {
		    this.zipCode = zipCode;
	 }
	 public Countries getCountry() {
	        return country;
	 }
	 public void setCountry(Countries country){
	        this.country = country;
	 }

	public String toString() {
			String str= String.format(street + ", " + city + ", " + zipCode + ", " + getCountry());
			return str;
	}

}
