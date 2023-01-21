/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

//Subclass Hunter (Superclass Ship)
//with a size of 3, and set to it's
//ShipType (enum) immediately.
public class Hunter extends Ship {
    public Hunter() {
        super(3, ShipType.Hunter);
    }
}
