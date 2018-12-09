import java.util.ArrayList;
import java.util.List;

public class OneMissingSolver implements Solver {
    @Override
    public long solve(Board board) {
        long startTime = System.currentTimeMillis();

        findMissingBlock(board);
        findMissingValuesCol(board);
        findMissingValuesRow(board);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public void findMissingValuesCol(Board board){
       // char[][] actualValues = board.getActualValues();
        Cell [][] cellValues = board.getCellArray();
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
                if (cellValues[row][col].getValue() == '-') {
                    dashCount++;
                    dashIndex = col;     //keep track of what column the dash is in
                }else{
                    possibleValueList.remove(String.valueOf(cellValues[row][col].getValue()));
                }
            }
            if(dashCount == 1){
                String value = possibleValueList.get(0);
                char[] array = value.toCharArray();
                cellValues[row][dashIndex].setValue( array[0] );
                return;
            }
        }
    }

    public void findMissingValuesRow(Board board){
        Cell [][] cellValues = board.getCellArray();
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
                if (cellValues[row][col].getValue() == '-') {
                    dashCount++;
                    dashIndex = row;     //keep track of what row the dash is in
                }else{
                    possibleValueList.remove(String.valueOf(cellValues[row][col].getValue()));
                }
            }
            if(dashCount == 1){
                String value = possibleValueList.get(0);
                char[] array = value.toCharArray();
                cellValues[dashIndex][col].setValue( array[0] );
                return;
            }
        }
    }

    public void findMissingBlock(Board board){
        Cell [][] cellValues = board.getCellArray();
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
                    possibleValueList.remove(String.valueOf(cellValues[blockInfo.getRow()][blockInfo.getCol()].getValue()));
                }else{
                    notFound++;
                    missingBlockInfo = blockInfo;
                }
            }
            if(notFound == 1){
                String value = possibleValueList.get(0);
                char[] array = value.toCharArray();
                cellValues[ missingBlockInfo.getRow() ][ missingBlockInfo.getCol() ].setValue(array[0]);
                return;
            }
        }
    }


}
