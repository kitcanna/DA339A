/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

//Subclass Torpedo (Superclass Ship)
//with a size of 2, and set to it's
//ShipType (enum) immediately.
public class Torpedo extends Ship {
    public Torpedo(){
        super(2, ShipType.Torpedo);
    }
}
