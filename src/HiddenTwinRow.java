import java.util.ArrayList;
import java.util.List;

public class HiddenTwinRow extends HiddenTwin {

    @Override
    public long solve(Board board) {
        long startTime = System.currentTimeMillis();

        findHiddenTwinRow(board);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    //find hidden twin - two cells have the same two potential values
    //if there is a hidden twin
    public void findHiddenTwinRow(Board board){
        Cell[][] cellArray = board.getCellArray();
        List<Cell> possibleHiddenTwinArray = new ArrayList();

        //look for cells in a row that have the same 2 potenial values, but the values are ONLY in those 2 cells
        for(int row = 0; row < board.getBoardSize(); row++){
            // Reset the possibleHidddenTwinArray for the next row
            possibleHiddenTwinArray.clear();

            for(int col = 0; col < board.getBoardSize(); col++){
                if(cellArray[row][col].getPotentialValues().size() > 1){//don't care about cells unless there is more than 1 potential value
                    possibleHiddenTwinArray.add(cellArray[row][col]);//find cells that meet the critieria
                }
            }

            if(possibleHiddenTwinArray.size() > 0) {
                for (int i = 0; i < board.getPossibleValues().length; i++) {
                    char firstValue = board.getPossibleValues()[i];

                    for (int j = i + 1; j < board.getPossibleValues().length; j++) {
                        char secondValue = board.getPossibleValues()[j];

                        List<Cell> twinCells = findTwinCombinations(possibleHiddenTwinArray, firstValue, secondValue);
                        if (twinCells.size() == 2) {//found exactly two cells with those potential values
                            //tell the board to eliminate those potential values from other cells in the row
                            eliminateTwinsFromOtherPotentialValueRow(board, twinCells, row, firstValue, secondValue);
                        }
                    }
                }
            }

        }
    }

    protected void eliminateTwinsFromOtherPotentialValueRow(Board board, List<Cell> twinCells, int row, char firstEliminatedValue, char secondEliminatedValue){
        Cell cell;

        // Removes the twin values from all of the cells EXCEPT the twin values
        for(int col = 0; col < board.getBoardSize(); col++){
            cell = board.getCellArray()[row][col];

            //is this cell one of our twin cells? yes- leave it alone no-remove the first and second eliminatedValues
            //this might be the problem?
            if(cell.getRow() == twinCells.get(0).getRow() && cell.getCol() == twinCells.get(0).getCol() ||
                    cell.getRow() == twinCells.get(1).getRow() && cell.getCol() == twinCells.get(1).getCol()){
                //leave it alone

            }else{//no-remove the first and second eliminatedValues
                cell.removePotentialValue(firstEliminatedValue);
                cell.removePotentialValue(secondEliminatedValue);
            }
        }

        // Remove potential values from the twin cells that are NOT one of the twin values
        for(int i = 0; i < twinCells.size(); i++){
            List<String> potentialValues = twinCells.get(i).getPotentialValues();
            for(int j = 0; j < potentialValues.size(); j++) {

                if( !potentialValues.get(j).equals(String.valueOf(firstEliminatedValue)) && !potentialValues.get(j).equals(String.valueOf(secondEliminatedValue))){
                    twinCells.get(i).removePotentialValue(potentialValues.get(j).toCharArray()[0]);
                }

            }
        }
    }

}