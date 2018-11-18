public class PotentialValueSolver implements Solver{
    @Override
    public long solve(Board board) {
        long startTime = System.currentTimeMillis();
        //for a row/col compare our actual values with the possible values
        //if a possible value is not in the row, column and block, add it to the potential value
        //if only one potential value is left that is the solution
        Cell[][] cellArray = initializeCells(board);
        findPotentialValues(cellArray, board);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public Cell[][] initializeCells(Board board){

        char[][] actualValues = board.getActualValues();
        Cell[][] cellValues = new Cell[board.getBoardSize()][board.getBoardSize()];

        for(int row = 0; row < board.getBoardSize(); row++){
            for(int col = 0; col < board.getBoardSize(); col++) {
                Cell cell = new Cell(actualValues[row][col]);
                cellValues[row][col] = cell;
            }
        }
        return cellValues;
    }

    public void findPotentialValues(Cell[][] cellValues, Board board){
        //find dashes

        for(int row = 0; row < board.getBoardSize(); row++ ){
            for(int col = 0; col < board.getBoardSize(); col++){
                if(cellValues[row][col].getValue() == '-'){
                    char[] possibleValues = board.getPossibleValues();

                    for(char n : possibleValues){
                        if(!board.checkRow(n, row) && !board.checkCol(n, col) && !board.checkBlock(n, row, col)){
                            cellValues[row][col].addPotentialValue(n);
                        }

                    }
                }
                if(cellValues[row][col].getPotentialValues().size() == 1){
                    //sets the value to the potentialvalue[0]
                    board.getActualValues()[row][col] = cellValues[row][col].getPotentialValues().get(0).toCharArray()[0];
                }
            }
        }
    }
}
