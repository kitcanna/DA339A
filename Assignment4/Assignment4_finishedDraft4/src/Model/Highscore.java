/* GROUP: 2 

 * Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>
 * 
 * Author: <Yun-Bo Chow>  
 * Id: <am1508>  
 * Study program: <SYS>*/

package Model;

public class Highscore {
    private Player[] scoreboard;
    private int playersInScoreboard;

    //Creates a new highscore with size decided by Controller
    public Highscore(int size) {
        scoreboard = new Player[size];
        playersInScoreboard = 0;
    }

    //Checks so that index isn't out of bounds and
    //adds the score to the list. It then calls for a 
    //sorting method and increments the count.
    public boolean addPlayer(Player player) {
       if (playersInScoreboard < scoreboard.length) {
           scoreboard[playersInScoreboard] = player;
           playersInScoreboard++;
           sortScoreboard();
           return true;
       }
        return false;
    }

    //Sorts the scoreboard by the amount of hits. 
    //Method calls for "Player"'s attribute Score to sort.
    public void sortScoreboard() {
        Player temp;
        int n = playersInScoreboard;
        for (int i = 0; i < n && i < scoreboard.length; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (scoreboard[j - 1].getScore() > scoreboard[j].getScore()) {
                    temp = scoreboard[j - 1];
                    scoreboard[j - 1] = scoreboard[j];
                    scoreboard[j] = temp;
                }
            }
        }
    }

    //Prints the highscore list by looping through all the already
    //registered scores.
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < playersInScoreboard && i < 10; i++) {
            out += scoreboard[i].toString() + " \n";
        }
        return out;
    }
}
