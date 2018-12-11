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

        for(int row = bb.rowStart; row <= bb.rowEnd; row++){
            for(int col = bb.colStart; col <= bb.colEnd; col++){
                cellsInBlock.add(board.cellArray[row][col]);
            }
        }
        return cellsInBlock;
    }


    // Find hidden twin - two cells have the same two potential values
    public void findHiddenTwinBlock(Board board) {
        List<Cell> possibleHiddenTwinArray = new ArrayList();

        for (int blockNum = 1; blockNum <= board.getBoardSize(); blockNum++) {
            // Get all of the cells in the given block number
            List<Cell> cellsInBlock = gatherCellsInBlock(board, blockNum);

            // Reset the possibleHidddenTwinArray for the next row
            possibleHiddenTwinArray.clear();

            // Gather cells that have more than 1 potential value
            for (int cellIndex = 0; cellIndex < board.getBoardSize(); cellIndex++) {
                if (cellsInBlock.get(cellIndex).getPotentialValues().size() > 1) {//don't care about cells unless there is more than 1 potential value
                    possibleHiddenTwinArray.add(cellsInBlock.get(cellIndex));//find cells that meet the criteria
                }
            }

            // Examine every combination of possible values
            for (int i = 0; i < board.getPossibleValues().length - 1; i++) {
                char firstValue = board.getPossibleValues()[i];

                for (int j = i + 1; j < board.getPossibleValues().length - 1; j++) {
                    char secondValue = board.getPossibleValues()[j];

                    List<Cell> twinCellsList = findTwinCombinations(possibleHiddenTwinArray, firstValue, secondValue);
                    if (twinCellsList.size() == 2) {//found exactly two cells with those potential values
                        //tell the board to eliminate those potential values from other cells in the row
                        eliminatePotentialValuesFromBlock(board, cellsInBlock, twinCellsList, firstValue, secondValue);
                    }
                }
            }

        }
    }

    protected void eliminatePotentialValuesFromBlock(Board board, List<Cell> cellsInBlock, List<Cell> twinCellsList, char firstValue, char secondValue) {
        // 1. Remove potential values from the cells in the block that are NOT the twin cells
        // 2. Remove potential values from the twin cells list that at NOT the first or second value

        for(int i=0; i < cellsInBlock.size(); i++) {
            for(int j=0; j < board.getPossibleValues().length; j++) {
                Cell cell = cellsInBlock.get(i);
                char potentialValue = board.getPossibleValues()[j];

                // Make sure that this cell is NOT one of the twin cells
                if(cell.getRow() != twinCellsList.get(0).getRow() && cell.getCol() != twinCellsList.get(0).getCol() &&
                        cell.getRow() != twinCellsList.get(1).getRow() && cell.getCol() != twinCellsList.get(1).getCol()) {
                    // This is NOT one of the twin cells

                    // Remove the first and second values from the potential list
                    cell.removePotentialValue(firstValue);
                    cell.removePotentialValue(secondValue);
                } else {
                    // This is one of the twin cells - remove

                    // Remove if NOT one the first or second value
                    if (potentialValue != firstValue && potentialValue != secondValue) {
                        cell.removePotentialValue(potentialValue);
                    }
                }
            }
        }
    }
}
