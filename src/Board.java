public class Board {
    int boardSize;
    char possibleValues[];
    char actualValues[][];
   // Cell[][] cellArray = new Cell[][];


    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public char[] getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(char[] possibleValues) {
        this.possibleValues = possibleValues;
    }

    public char[][] getActualValues() {
        return actualValues;
    }

    public void setActualValues(char[][] actualValues) {
        this.actualValues = actualValues;
    }
    public void printBoard(){
        System.out.println(boardSize);
        for(char n: possibleValues){
            System.out.print(n +" ");
        }
        System.out.println();
        for(int row = 0; row < boardSize; row++){
            for(int col = 0; col < boardSize; col++){
                System.out.print(actualValues[row][col] +" ");
            }
            System.out.println();
        }
    }
}
