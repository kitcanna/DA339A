/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

import java.util.Random;
import Controller.Controller;

public class GameBoard {
    private Controller controller;
    private Ship[][] gameboard;
    private int totalNbrOfShips; 
    private Submarine uboat;
    private Torpedo torpedBoat;
    private Hunter jagare;
    private Cruiser kryssare;
    private Battleship slagskepp;

    //Creates the board by 10 x 10 size,
    //creates one ship of each type
    //and randomizes their placements.
    public GameBoard(Controller controller) {
        this.controller = controller;
        gameboard = new Ship[10][10];
        uboat = new Submarine();
        torpedBoat = new Torpedo();
        jagare = new Hunter();
        kryssare = new Cruiser();
        slagskepp = new Battleship();
        totalNbrOfShips = 15;
        placeShipsRandom();
    }

    //Places ships in random order.
    private void placeShipsRandom() {
        randomizeShips(slagskepp);
        randomizeShips(kryssare);
        randomizeShips(jagare);
        randomizeShips(torpedBoat);
        randomizeShips(uboat);
    }

    //Randomizes the placement in both X and Y direction.
    private void randomizeShips(Ship skepp) {
        Random random = new Random();

        for(int i=1; i>0; i--) {
            int riktning = random.nextInt(2); //0 = vertical, 1 = horizontal
            int y = random.nextInt(gameboard.length); //y
            int x = random.nextInt(gameboard.length); //x

            //Check if the random indexes are within bounds, 
            //if it isn't it will go "reversed" by making the 
            //index start on the last index if it was reversed.
            if (riktning == 0) {
                if (y + skepp.getSize() > gameboard.length) {
                    y -= skepp.getSize();
                }
            } else if (riktning == 1) {
                if (x + skepp.getSize() > gameboard.length) {
                    x -= skepp.getSize();
                }
            }

            //Check if the spot is free
            boolean free = true;
            if (riktning == 0) {
                for (int k = y; k < y+skepp.getSize(); k++) {
                    if (gameboard[k][x] instanceof Ship) {
                        free = false;
                        break;
                    }
                }

            } else {
                for (int l = x; l < x+skepp.getSize(); l++) {
                    if (gameboard[y][l] instanceof Ship) {
                        free = false;
                        break;
                    }
                }
            }
            //If it isn't free, retry
            if(!free){
                i++;
                continue;
            }

            //Placing the ships
            for (int j = 0; j < skepp.getSize(); j++) {
                gameboard[y][x] = skepp;
                if (riktning==0) {
                    y++;
                } else if (riktning==1) {
                    x++;
                }
            }
        }
    }

    //Checks the hit index. If the value isn't null, it will decrement
    //the hit ship byt 1. It then calls for the hit ships' toString and 
    //let's the player know what ship it hit. 
    //If the size is 0 and decrementing isn't possible, it sinks the 
    //ship and decrements the amount of ships.
    public boolean fireAt (int x, int y) {
        if (gameboard[y][x] != null) {
            gameboard[y][x].setSize(gameboard[y][x].getSize() - 1);
            String shipType = gameboard[y][x].toString();
            controller.setGameEvents("You hit a: " + shipType + "!");
            totalNbrOfShips--;

            if (gameboard[y][x].getSize() < 1) {
                controller.setGameEvents("You SANK a: " + shipType + "!");
                return true;
            }
            return true;
        }
        return false;
    }

    //Checks so that all the ships are completely hit.
    public boolean winCondition() {
        if (totalNbrOfShips != 0) {
            return false;
        }
        else {
            return true;
        }
    }


}
