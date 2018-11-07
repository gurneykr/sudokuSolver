public class OneMissingSolver implements Solver {
    @Override
    public void solve(Board board) {
        //use this to solve for only 1 missing character
        char[][] actualValues = board.getActualValues();
        int boardSize = board.getBoardSize();
        char[] possibleValues = board.getPossibleValues();

        for(int row = 0; row < boardSize ; row++) {
            int dashCount = 0;
            for (int col = 0; col < boardSize; col++){
                if (actualValues[row][col] == '-') {
                    dashCount++;
                    //keep track of what column the dash is in

                }
            }
            if(dashCount == 1){
                //loop through the actual values
                //check for the possible value that isn't there
                // set the value to that missing value
            }

        }
    }
}
