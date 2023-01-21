/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

//Subclass Submarine (Superclass Ship)
//with a size of 1, and set to it's
//ShipType (enum) immediately.
public class Submarine extends Ship {
    public Submarine(){
        super(1, ShipType.Submarine);
    }
}
