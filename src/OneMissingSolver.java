import java.util.ArrayList;
import java.util.List;

public class OneMissingSolver implements Solver {
    @Override
    public void solve(Board board) {
        //use this to solve for only 1 missing character
        findMissingValuesCol(board);
    }
    public void findMissingValuesCol(Board board){
        char[][] actualValues = board.getActualValues();
        char[] possibleValues = board.getPossibleValues();

        List<String> possibleValueList = new ArrayList();
        for (char c : possibleValues) {
            possibleValueList.add(String.valueOf(c));
        }
        int boardSize = board.getBoardSize();

        for(int row = 0; row < boardSize ; row++) {
            int dashCount = 0;
            int dashIndex = 0;
            for (int col = 0; col < boardSize; col++){
                if (actualValues[row][col] == '-') {
                    dashCount++;
                    dashIndex = col;     //keep track of what column the dash is in
                }else{
                    possibleValueList.remove(String.valueOf(actualValues[row][col]));
                }
            }
            if(dashCount == 1){
                String value = possibleValueList.get(0);
                char[] array = value.toCharArray();
                actualValues[row][dashIndex] = array[0];
            }
        }
    }

}
