import java.util.ArrayList;
import java.util.List;

public class HiddenTwinBlock extends HiddenTwin {
    @Override
    public long solve(Board board) {
        long startTime = System.currentTimeMillis();

        findHiddenTwinBlock(board);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public List<Cell> gatherCellsInBlock(Board board, int blockNumber){
        BlockBoundaries bb = board.getBlockBoundaries(blockNumber);
        List<Cell> cellsInBlock = new ArrayList();

        for(int row = bb.rowStart; row < bb.rowEnd; row++){
            for(int col = bb.colStart; col < bb.colEnd; col++){
                cellsInBlock.add(board.cellArray[row][col]);
            }
        }
        return cellsInBlock;
    }


    // Find hidden twin - two cells have the same two potential values
    public void findHiddenTwinBlock(Board board) {
        List<Cell> possibleHiddenTwinArray = new ArrayList();

        for(int i = 1; i <= board.getBoardSize(); i++){
            List<Cell> cellsInBlock = gatherCellsInBlock(board, i);
             // Reset the possibleHidddenTwinArray for the next row
            possibleHiddenTwinArray.clear();

            for(int cellIndex = 0; cellIndex < board.getBoardSize(); cellIndex++){
                if(cellsInBlock.get(cellIndex).getPotentialValues().size() > 1){//don't care about cells unless there is more than 1 potential value
                    possibleHiddenTwinArray.add(cellsInBlock.get(cellIndex));//find cells that meet the criteria
                }
            }
            for(int j = 0; j < board.getPossibleValues().length - 1; j++) {
                char firstValue = board.getPossibleValues()[j];
                char secondValue = board.getPossibleValues()[j + 1];

                List<Cell> twinCells = findTwinCombinations(possibleHiddenTwinArray, firstValue, secondValue);
                if(twinCells.size() == 2){//found exactly two cells with those potential values
                    //tell the board to eliminate those potential values from other cells in the row
                    
                }
            }

        }


    protected void eliminateTwinsFromOtherPotentialValueBlock(Board board, List<Cell> twinCells, int col, char firstEliminatedValue, char secondEliminatedValue){
        Cell cell;

        // Removes the twin values from all of the cells EXCEPT the twin values
        for(int row = 0; row < board.getBoardSize(); row++){
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
