/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

//Subclass Battleship (Superclass Ship)
//with a size of 5, and set to it's
//ShipType (enum) immediately.
public class Battleship extends Ship {
    public Battleship() {
        super(5, ShipType.Battleship);
    }
}
