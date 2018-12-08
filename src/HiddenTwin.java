import java.util.ArrayList;
import java.util.List;

public class HiddenTwin implements Solver{
    @Override
    public long solve(Board board) {
        findHiddenTwinRow(board);
        return 0;
    }

    //find hidden twin - two cells have the same two potential values
    //if there is a hidden twin
    public void findHiddenTwinRow(Board board){
        Cell[][] cellArray = board.getCellArray();
        List<Cell> possibleHiddenTwinArray = new ArrayList();

        //look for cells in a row that have the same 2 potenial values, but the values are ONLY in those 2 cells
        for(int row = 0; row < board.getBoardSize(); row++){
            for(int col = 0; col < board.getBoardSize(); col++){
                if(cellArray[row][col].getPotentialValues().size() > 1){//don't care about cells unless there is more than 1 potential value
                    possibleHiddenTwinArray.add(cellArray[row][col]);//find cells that meet the critieria
                }
            }

        }

        for(int i = 0; i < board.getPossibleValues().length - 1; i++) {
            char firstValue = board.getPossibleValues()[i];
            char secondValue = board.getPossibleValues()[i + 1];

            List<Cell> twinCells = createTwinCombinations(possibleHiddenTwinArray, firstValue, secondValue);
            if(twinCells.size() == 2){//found exactly two cells with those potential values
                //tell the board to eliminate those potential values from other cells in the row
                for(int row = 0; row < board.getBoardSize(); row++) {
                    elminateTwinsFromOtherPotentialValueRow(board, twinCells, row, firstValue, secondValue);
                }
            }
        }
    }

    private void elminateTwinsFromOtherPotentialValueRow(Board board, List<Cell> twinCells, int row, char firstEliminatedValue, char secondEliminatedValue){
        Cell cell;
        for(int col = 0; col < board.getBoardSize(); col++){
            cell = board.getCellArray()[row][col];

            //is this cell one of our twin cells? yes- leave it alone no-remove the first and second eliminatedValues
            if(cell.getRow() == twinCells.get(0).getRow() && cell.getCol() == twinCells.get(0).getCol() ||
               cell.getRow() == twinCells.get(1).getRow() && cell.getCol() == twinCells.get(1).getCol()){
                //leave it alone

            }else{//no-remove the first and second eliminatedValues
                cell.removePotentialValue(firstEliminatedValue);
                cell.removePotentialValue(secondEliminatedValue);
            }
        }
        for(int i = 0; i < twinCells.size(); i++){
            List<String> potentialValues = twinCells.get(i).getPotentialValues();
            for(int j = 0; j < potentialValues.size(); j++) {

                if( !potentialValues.get(j).equals(firstEliminatedValue) && !potentialValues.get(j).equals(secondEliminatedValue)){
                    twinCells.get(i).removePotentialValue(firstEliminatedValue);
                    twinCells.get(i).removePotentialValue(secondEliminatedValue);
                }

            }
        }
    }

    private List<Cell> createTwinCombinations(List<Cell> possibleHiddenTwinArray, char firstValue, char secondValue){
        //take the possible values from the board and make combinations

        List<Cell> twinCells = new ArrayList();

        for(int j = 0; j < possibleHiddenTwinArray.size(); j++){
            Cell cell = possibleHiddenTwinArray.get(j);
            if(containsPotentialValues(cell, firstValue, secondValue)){
                twinCells.add(cell);
            }
        }
        return twinCells;
    }

    private boolean containsPotentialValues(Cell cell, char firstValue, char secondValue){
        int counter = 0;
        for(int i = 0; i < cell.getPotentialValues().size(); i++){
            if(cell.getPotentialValues().get(i).equals(String.valueOf(firstValue))){
                counter++;
            }
            if (cell.getPotentialValues().get(i).equals(String.valueOf(secondValue))){
                counter++;
            }
        }
        return counter == 2;
    }
}
