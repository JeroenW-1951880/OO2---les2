package vieropeenrij;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

/***
 * This class writes a log for each move to a file
 * @author Jeroen Weltens
 */
public class LogGame implements Observer{
    private PrintWriter log;

    /** constructor that initializes the file*/
    LogGame(){
        try {
            log = new PrintWriter("log.txt");
        } catch (java.io.IOException e) {
            System.err.println("An error occurred in creating file.");
        }
    }

    /**
     * gets update from the observable when a move is done
     * @param o the observable (VorMatrix)
     * @param arg the collumn in which the move was done
     */
    @Override
    public void update(Observable o, Object arg) {
        Logmove((java.awt.Point)arg);
        LogBoard((VorMatrix)o);
    }

    /**
     * writes the last move done to file
     * @param drop the collumn where the item dropped
     */
    private void Logmove(java.awt.Point drop){
        log.println("item dropped at column " + (int)drop.getX() + 1);
    }

    /**
     * writes the last instantion of the board to file
     * @param object the object of the board
     */
    private void LogBoard(VorMatrix object){
        for (int i = 0; i < VierOpEenRij.ROWS; ++i) {
            for (int j = 0; j < VierOpEenRij.COLS; ++j) {
                log.write("+-");
            }
            log.write("+\n");
            for (int j = 0; j < VierOpEenRij.COLS; ++j) {
                log.write("|");
                if (object.getFill(j, VierOpEenRij.ROWS - i - 1) == VierOpEenRij.FILL.EMPTY) {
                    log.write(" ");
                } else if (object.getFill(j, VierOpEenRij.ROWS - i - 1) == VierOpEenRij.FILL.RED) {
                    log.write("R");
                } else if (object.getFill(j, VierOpEenRij.ROWS - i - 1) == VierOpEenRij.FILL.YELLOW) {
                    log.write("Y");
                }
            }
            log.write("|\n");
        }
        for (int j = 0; j < VierOpEenRij.COLS; ++j) {
            log.write("+-");
        }
        log.write("+\n");
    }

    @Override
    protected void finalize() throws Throwable {
        log.close();
    }
}
