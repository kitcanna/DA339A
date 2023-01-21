/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

public abstract class Ship {
    private int size;
    ShipType shipType;

    public Ship(int size,ShipType shipType) {
        this.shipType = shipType;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
       return String.format("%s ", shipType);
    }

}
