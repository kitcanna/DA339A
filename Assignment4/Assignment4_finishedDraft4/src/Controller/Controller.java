/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Controller;

import Model.Highscore;
import Model.Player;
import Model.GameBoard;
import View.MainFrame;

public class Controller {
    private MainFrame mainFrame;
    private GameBoard board;
    private Highscore highscore;
    private Player player;
    private int shots;
    private String name;

    //Initialized our board in the GUI, creates a highschore list and 
    //creates the gameboard with values and the player by calling 
    //reset.
    public Controller() {
        mainFrame = new MainFrame(this);
        highscore = new Highscore(100);
        reset();
    }

    //Checks the position by calling a method in GameBoard, 
    //and if position is available returns a boolean value. 
    //Method is called by actionlisteners in GUI.
    public boolean fireAt(int x, int y) {
        boolean hit;
        if(board.fireAt(x,y)) {
            hit = true;
        }
        else {
            hit = false;
        }

        shoot();
        return hit;

    }

    //Checks if all the ships are hit, 
    //and if so, returns a victory.
    //It then resets the game.
    public void winCondition() {
        boolean win = board.winCondition();
        if(win) {
            showMessage("You sank all the ships!");

            player.setScore(shots);
            highscore.addPlayer(player);
            mainFrame.setHighscore(highscore.toString());
            reset();
        }
    }

    //A method that starts a new round. It creates a new player, 
    //takes the players name or sets it to Anonymous if there's no input 
    //and creates a new board with a new random placement of the ships.
    public void reset() {
        name = mainFrame.dialogPane("Please enter your name: ");
        if (name.isEmpty()) {
            name = "Anonymous";
        }
        board = new GameBoard(this);
        shots = 0;
        player = new Player(name, 0);
    
        mainFrame.reset();
        mainFrame.setName(name);
    }

    //Shows messages in a pop-up window.
    public void showMessage(String text) {
        mainFrame.messagePane(text);
    }
    //Shows messages in "Your Game" panel.
    public void setGameEvents(String text) {
        mainFrame.setGameEvents(text);
    }
    //Counts the shots and puts them in the "Your Game" panel.
    public void shoot() {
        shots++;
        mainFrame.shoot(shots);
    }
}
