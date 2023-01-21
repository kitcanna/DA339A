/*  Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/
package partyModel;

public class GuestManager {

  private int nbrOfGuests = 0;
  private Guest[] guestList;

  /* Create a constructor with one parameter which is
     the max number of elements (guests) in the list/array.
     Create the array with the max number of elements.
     Check that the max number of Guests is larger than 0.
     If max number of guests is not larger than 0 ask the user to give a new value
     until you get a value that is larger than 0.
   */
  public GuestManager(int maxNbrOfGuests){    
    if (maxNbrOfGuests <= 0) {
    	System.out.println("Please allow guestlist to be bigger.");
    }
    else {
    	guestList = new Guest[maxNbrOfGuests];
    }

  }

  public int getNbrOfGuests(){
    return nbrOfGuests;
  }

  /* Create a method to add a guest to the list with all the parameters
     matching instance variables of Guest and Address.
     In the method create a new Guest-object and let classes Guest and Address
     take care of issues with values of the parameters.
     Add the new Guest-object to the array at the first empty element (here is where you
     use the instance variable for number of guests stored in the list). If there are no
     more empty elements call a private method in GuestManager to increase the size
     of the array ana then add the new Guest-object. Do not forget to update the value
     of the instance variable for number of guests in the list.
   */
  
  public void addGuest(Guest guestIN) {
	  
	  if (nbrOfGuests>=0 && nbrOfGuests < guestList.length) {
			  guestList[nbrOfGuests] = guestIN;
			  nbrOfGuests++;
	  }	  
	  
	  else {
		  increaseGuestList();
		  guestList[nbrOfGuests] = guestIN;
		  nbrOfGuests++;
	  }
  }

  /* Create method to delete a guest by giving the index in the array
     for the object (guest) to delete as a parameter to the method.
     This method should call the private method moveElementsToleft to remove
     the empty element in between other objects (may not be necessary
     if the guest removed was the last guest in the list).
     Remember to update the value of the instance variable for
     number of guests in the list.
   */
  public boolean delete(int index) {
		boolean success = true; 

			if (index >= 0 && index < guestList.length) {
				guestList[index] = null;
				nbrOfGuests--;
				moveElementsToLeft(index);
			}
			else {
				success = false;
				System.out.println("Object could not be deleted.");
			}
		
		return success;	
	}


  private void moveElementsToLeft(int index){
        /* Add code to remove empty element places that
           is not at the end of the array. Start at
           the parameter index that is the empty element
           whose gap we want to fill.
         */
		for(int i = index+1; i < guestList.length; i++) {
			Guest temp = guestList[i-1]; 
			guestList[i-1] = guestList[i];
			guestList[i] = temp;
		}
  }

  private void increaseGuestList(){
	  /* Write code that creates a new array of Guest-objects
       that is 10 elements larger that the current array instance variable .

       Copy the current array to the larger array and after that is done
       point the instance variable to the new array.

       Do not take a shot cut by using class Array from the Java-library.
     */
	  Guest[] newGuestList;
	  newGuestList = new Guest[guestList.length + 10];
	  
	  for(int i = 0; i < guestList.length; i++) {
		  newGuestList[i] = guestList[i];
	  }
	  guestList = newGuestList;
  }

  /* A method that returns the Guest-object at the given
     index n the parameter.
   */
  public Guest getGuestAt(int index){
    /* Add code to check that the parameter index
       has a value within the range of the array.
       If index is not in valid range return null.
       Yes, some checks are done in the Controller-object
       in this program but we do not want this class to depend
       on other classes for this, so sometimes we write redundant
       error handling in different ways to have more robust classes or code.
     */
	  if (index <= guestList.length) {
		  return guestList[index];
	  }
	  else {
		  return null;
	  }
  }

  public String[] getInfoStrings() {
    /* Write code that returns an array of strings where each element
       represents information about one guest in the list by calling every
       Guest-object's toString method.

       The number of elements in the array should be equal to the
       number of guests currently stored in the list.
       (no strings should be created for empty places at the end of the array st)
    */

    String [] infoString = new String[nbrOfGuests];
	int i = 0;
    for (Guest g : guestList){
        if (g != null){
            infoString[i] = g.toString();
            i++;
        }
    }
	return infoString;
	}

}
