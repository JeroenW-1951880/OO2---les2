package vieropeenrij;

/**
 * @author Jeroen Weltens
 */
public class Loserstrategy implements VorStrategy{
    /**
     * Calculates a column in which a disc should drop, evading a 4 adjecent
     * @param vMatrix the datamodel based on which the calculations can be executed
     * @return the column that is selected for this move
     * @pre there is at least one column in which a new element can be dropped
     */
    public int doMove(VorMatrix vMatrix){
        for(int i = 0; i < VierOpEenRij.ROWS + 1; ++i){
            try{
                if(!vMatrix.test_move(VierOpEenRij.FILL.YELLOW, i)){
                    return i;
                }
            } catch (ColumnFullException e) {

            }
        }
        int column = 0;
        do{
            column = (int)(10 * Math.random()) % VierOpEenRij.COLS;
        }while(vMatrix.getFill(column,VierOpEenRij.ROWS-1) != VierOpEenRij.FILL.EMPTY);
        return column;
    }
}
