/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

//Subclass Cruiser (Superclass Ship)
//with a size of 4, and set to it's
//ShipType (enum) immediately.
public class Cruiser extends Ship {
    public Cruiser() {
        super(4, ShipType.Cruiser);
    }
}
