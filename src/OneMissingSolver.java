import java.util.ArrayList;
import java.util.List;

public class OneMissingSolver implements Solver {
    @Override
    public void solve(Board board) {
        //use this to solve for only 1 missing character
        //findMissingValuesCol(board);
        findMissingBlock(board);
        findMissingValuesCol(board);
        findMissingValuesRow(board);
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

            //reload the possible value list
            possibleValueList.clear();
            for (char c : possibleValues) {
                possibleValueList.add(String.valueOf(c));
            }

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

    public void findMissingValuesRow(Board board){
        char[][] actualValues = board.getActualValues();
        char[] possibleValues = board.getPossibleValues();

        List<String> possibleValueList = new ArrayList();
        for (char c : possibleValues) {
            possibleValueList.add(String.valueOf(c));
        }
        int boardSize = board.getBoardSize();

        for(int col = 0; col < boardSize ; col++) {
            int dashCount = 0;
            int dashIndex = 0;

            //reload the possible value list
            possibleValueList.clear();
            for (char c : possibleValues) {
                possibleValueList.add(String.valueOf(c));
            }

            for (int row = 0; row < boardSize; row++){
                if (actualValues[row][col] == '-') {
                    dashCount++;
                    dashIndex = row;     //keep track of what row the dash is in
                }else{
                    possibleValueList.remove(String.valueOf(actualValues[row][col]));
                }
            }
            if(dashCount == 1){
                String value = possibleValueList.get(0);
                char[] array = value.toCharArray();
                actualValues[dashIndex][col] = array[0];
            }
        }
    }

    public void findMissingBlock(Board board){
        char[][] actualValues = board.getActualValues();
        char[] possibleValues = board.getPossibleValues();

        List<String> possibleValueList = new ArrayList();
        for (char c : possibleValues) {
            possibleValueList.add(String.valueOf(c));
        }
        int boardSize = board.getBoardSize();
        int notFound = 0;

        for(int blockNum = 1; blockNum <= boardSize; blockNum++) {
            notFound = 0;
            BlockInfo missingBlockInfo = null;

            possibleValueList.clear();
            for (char c : possibleValues) {
                possibleValueList.add(String.valueOf(c));
            }

            for( char c: possibleValues) {
                BlockInfo blockInfo = board.checkBlock(c, blockNum);
                if (blockInfo.isFound()){
                    possibleValueList.remove(String.valueOf(actualValues[blockInfo.getRow()][blockInfo.getCol()]));
                }else{
                    notFound++;
                    missingBlockInfo = blockInfo;
                }
            }
            if(notFound == 1){
                String value = possibleValueList.get(0);
                char[] array = value.toCharArray();
                actualValues[ missingBlockInfo.getRow() ][ missingBlockInfo.getCol() ] = array[0];
            }
        }
    }


}
