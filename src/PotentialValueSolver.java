public class PotentialValueSolver implements Solver{
    @Override
    public void solve(Board board) {
        //for a row/col compare our actual values with the possible values
        //if a possible value is not in the row, column and block, add it to the potential value
        //if only one potential value is left that is the solution
    }

    public Cell[][] initializeCells(Board board){

        char[][] actualValues = board.getActualValues();
        Cell[][] cellValues = new Cell[board.getBoardSize()][board.getBoardSize()];

        for(int row = 0; row < board.getBoardSize(); row++){
            for(int col = 0; col < board.getBoardSize(); col++) {
                cellValues[row][col].setValue(actualValues[row][col]);
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
            }
        }
        //loop through all the possible values
        //checkRow checkCol checkBlock for that value
        //if it's not found add it to a potential value array
        //if potential value only has one

    }
}
