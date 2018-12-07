import java.util.ArrayList;
import java.util.List;

public class HiddenTwin implements Solver{
    @Override
    public long solve(Board board) {
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

        //loop through the possibleHiddenTwinArray
//        if(possibleHiddenTwinArray.size() > 1){
//            for(int i = 0; i < possibleHiddenTwinArray.size(); i++){
//                //find combinations of twins
//
//            }
//        }


        //eliminate other potential values
    }

    private List<Cell> createTwinCombinations(List<Cell> possibleHiddenTwinArray, Board board){
        //take the possible values from the board and make combinations

        List<Cell> twinCells = new ArrayList();

        for(int i = 0; i < board.getPossibleValues().length - 1; i++){
            char firstValue = board.getPossibleValues()[i];
            char secondValue = board.getPossibleValues()[i+1];


            for(int j = 0; j < possibleHiddenTwinArray.size(); j++){
                Cell cell = possibleHiddenTwinArray.get(j);
                if(containsPotentialValues(cell, firstValue, secondValue)){
                    twinCells.add(cell);
                }
            }
            if(twinCells.size() == 2){//found exactly two cells with those potential values
                //tell the board to eliminate those potential values from other cells in the row
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
