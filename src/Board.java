import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    int boardSize;
    char possibleValues[];
    char actualValues[][];
    // Cell[][] cellArray = new Cell[][];


    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) throws InvalidBoardException {
        System.out.println("Board size => " + boardSize);
        if (boardSize != 4 && boardSize != 9 && boardSize != 16 && boardSize != 25) {
            throw new InvalidBoardException("Invalid Board Size");
        } else {
            this.boardSize = boardSize;
        }
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

    public void setCharacter(char value, int row, int col)throws InvalidBoardException{
        if(row <= boardSize && col <= boardSize){
            validateValueInPossibleValues(value);
        }else{
            throw new InvalidBoardException("Value is not possible");
        }
    }

    public void printBoard() {
        for (char n : possibleValues) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                System.out.print(actualValues[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void loadBoard(String fileName) throws IOException, InvalidBoardException {

        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        //Board board = new Board();
        String line;
        line = br.readLine();
        int boardSize = Integer.parseInt(line);

        this.setBoardSize(boardSize);

        line = br.readLine();
        String possibleValueString[] = line.split(" ");
        char possibleValues[] = new char[boardSize];
        if (boardSize != possibleValueString.length) {
            throw new InvalidBoardException("Possible value length does not match board size");
        }
        int counter = 0;
        for (String n : possibleValueString) {
            char characterArray[] = n.toCharArray();
            if (characterArray.length == 1) {
                possibleValues[counter++] = characterArray[0];
            } else {
                throw new InvalidBoardException("Invalid value detected");
            }
        }
        this.setPossibleValues(possibleValues);


        char actualValue[][] = new char[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {//get the actual board
            counter = 0;
            line = br.readLine();
            String boardValues[] = line.split(" ");
            for (String n : boardValues) {
                //char valueArray[]= n.toCharArray();
                char characterArray[] = n.toCharArray();
                if (characterArray.length == 1) {
                    actualValue[row][counter++] = characterArray[0];
                } else {
                    throw new Error("Invalid value detected");
                }
            }
        }
        this.setActualValues(actualValue);
        this.printBoard();
        // board.checkRow('4', 2);
        // board.checkCol('3', 2);
        this.checkBlock('3', 1);
        this.validateBoardValues();
    }

    public boolean isSolved(){//make sure there are not dashes left
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(actualValues[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(char value, int row) {
        if (row <= boardSize) {
            for (int col = 0; col < boardSize; col++) {
                if (value == actualValues[row][col]) {
                    System.out.println("Value " + value + " is in row " + row);
                    return true;
                }
            }
            System.out.println();
        }
        System.out.println("Value " + value + " was not in row " + row);
        return false;
    }

    public boolean checkCol(char value, int col) {
        if (col <= boardSize) {
            for (int row = 0; row < boardSize; row++) {
                if (value == actualValues[row][col]) {
                    System.out.println("Value " + value + " is in col " + col);
                    return true;
                }
            }
            System.out.println();
        }
        System.out.println("Value " + value + " was not in col " + col);
        return false;
    }


    public BlockInfo checkBlock(char value, int blockNum) {
        //uses the given row and col to find what block to look for a value
        int rowStart = 0;
        int rowEnd = 0;
        int colStart = 0;
        int colEnd = 0;

        if (boardSize == 4) {
            if(blockNum == 1){
                rowStart = 0;
                rowEnd = 1;
                colStart = 0;
                colEnd = 1;
            }else if(blockNum == 2){
                rowStart = 0;
                rowEnd = 1;
                colStart = 2;
                colEnd = 3;
            }else if(blockNum == 3){
                rowStart = 2;
                rowEnd = 3;
                colStart = 0;
                colEnd = 1;
            }else if(blockNum == 4){
                rowStart = 2;
                rowEnd = 3;
                colStart = 2;
                colEnd = 3;
            }
        }

        if (boardSize == 9) {
            if(blockNum == 1){
                rowStart = 0;
                rowEnd = 2;
                colStart = 0;
                colEnd = 2;
            }else if(blockNum == 2){
                rowStart = 0;
                rowEnd = 2;
                colStart = 3;
                colEnd = 5;
            }else if(blockNum == 3){
                rowStart = 0;
                rowEnd = 2;
                colStart = 6;
                colEnd = 8;
            }else if(blockNum == 4){
                rowStart = 3;
                rowEnd = 5;
                colStart = 0;
                colEnd = 2;
            }else if(blockNum == 5){
                rowStart = 3;
                rowEnd = 5;
                colStart = 3;
                colEnd = 5;
            }else if(blockNum == 6){
                rowStart = 3;
                rowEnd = 5;
                colStart = 6;
                colEnd = 8;
            }else if(blockNum == 7){
                rowStart = 6;
                rowEnd = 8;
                colStart = 0;
                colEnd = 2;
            }else if(blockNum == 8){
                rowStart = 6;
                rowEnd = 8;
                colStart = 3;
                colEnd = 5;
            }else if(blockNum == 9){
                rowStart = 6;
                rowEnd = 8;
                colStart = 6;
                colEnd = 8;
            }
        }

        if (boardSize == 16) {
            if(blockNum == 1){
                rowStart = 0;
                rowEnd = 3;
                colStart = 0;
                colEnd = 3;
            }else if(blockNum == 2){
                rowStart = 0;
                rowEnd = 3;
                colStart = 4;
                colEnd = 7;
            }else if(blockNum == 3){
                rowStart = 0;
                rowEnd = 3;
                colStart = 8;
                colEnd = 11;
            }else if(blockNum == 4){
                rowStart = 0;
                rowEnd = 3;
                colStart = 12;
                colEnd = 15;
            }else if(blockNum == 5){
                rowStart = 4;
                rowEnd = 7;
                colStart = 0;
                colEnd = 3;
            }else if(blockNum == 6){
                rowStart = 4;
                rowEnd = 7;
                colStart = 4;
                colEnd = 7;
            }else if(blockNum == 7){
                rowStart = 4;
                rowEnd = 7;
                colStart = 8;
                colEnd = 11;
            }else if(blockNum == 8){
                rowStart = 4;
                rowEnd = 7;
                colStart = 12;
                colEnd = 15;
            }else if(blockNum == 9){
                rowStart = 8;
                rowEnd = 11;
                colStart = 0;
                colEnd = 3;
            }else if(blockNum == 10){
                rowStart = 8;
                rowEnd = 11;
                colStart = 4;
                colEnd = 7;
            }else if(blockNum == 11){
                rowStart = 8;
                rowEnd = 11;
                colStart = 8;
                colEnd = 11;
            }else if(blockNum == 12){
                rowStart = 8;
                rowEnd = 11;
                colStart = 12;
                colEnd = 15;
            }else if(blockNum == 13){
                rowStart = 12;
                rowEnd = 15;
                colStart = 0;
                colEnd = 3;
            }else if(blockNum == 14){
                rowStart = 12;
                rowEnd = 15;
                colStart = 4;
                colEnd = 7;
            }else if(blockNum == 15){
                rowStart = 12;
                rowEnd = 15;
                colStart = 8;
                colEnd = 11;
            }else if(blockNum == 16){
                rowStart = 12;
                rowEnd = 15;
                colStart = 12;
                colEnd = 15;
            }


        }

        if (boardSize == 25) {
            if(blockNum == 1){
                rowStart = 0;
                rowEnd = 4;
                colStart = 0;
                colEnd = 4;
            }else if(blockNum == 2){
                rowStart = 0;
                rowEnd = 4;
                colStart = 5;
                colEnd = 9;
            }else if(blockNum == 3){
                rowStart = 0;
                rowEnd = 4;
                colStart = 10;
                colEnd = 14;
            }else if(blockNum == 4){
                rowStart = 0;
                rowEnd = 4;
                colStart = 15;
                colEnd = 19;
            }else if(blockNum == 5){//
                rowStart = 0;
                rowEnd = 4;
                colStart = 20;
                colEnd = 24;
            }else if(blockNum == 6){
                rowStart = 5;
                rowEnd = 9;
                colStart = 0;
                colEnd = 4;
            }else if(blockNum == 7){
                rowStart = 5;
                rowEnd = 9;
                colStart = 5;
                colEnd = 9;
            }else if(blockNum == 8){
                rowStart = 5;
                rowEnd = 9;
                colStart = 10;
                colEnd = 14;
            }else if(blockNum == 9){
                rowStart = 5;
                rowEnd = 9;
                colStart = 15;
                colEnd = 19;
            }else if(blockNum == 10){//
                rowStart = 5;
                rowEnd = 9;
                colStart = 20;
                colEnd = 24;
            }else if(blockNum == 11){
                rowStart = 10;
                rowEnd = 14;
                colStart = 0;
                colEnd = 4;
            }else if(blockNum == 12){
                rowStart = 10;
                rowEnd = 14;
                colStart = 5;
                colEnd = 9;
            }else if(blockNum == 13){
                rowStart = 10;
                rowEnd = 14;
                colStart = 10;
                colEnd = 14;
            }else if(blockNum == 14){
                rowStart = 10;
                rowEnd = 14;
                colStart = 15;
                colEnd = 19;
            }else if(blockNum == 15){//
                rowStart = 10;
                rowEnd = 14;
                colStart = 20;
                colEnd = 24;
            }else if(blockNum == 16){
                rowStart = 15;
                rowEnd = 19;
                colStart = 0;
                colEnd = 4;
            }else if(blockNum == 17){
                rowStart = 15;
                rowEnd = 19;
                colStart = 5;
                colEnd = 9;
            }else if(blockNum == 18){
                rowStart = 15;
                rowEnd = 19;
                colStart = 10;
                colEnd = 14;
            }else if(blockNum == 19){
                rowStart = 15;
                rowEnd = 19;
                colStart = 15;
                colEnd = 19;
            }else if(blockNum == 20){//
                rowStart = 15;
                rowEnd = 19;
                colStart = 20;
                colEnd = 24;
            }else if(blockNum == 21){
                rowStart = 20;
                rowEnd = 24;
                colStart = 0;
                colEnd = 4;
            }else if(blockNum == 22){
                rowStart = 20;
                rowEnd = 24;
                colStart = 5;
                colEnd = 9;
            }else if(blockNum == 23){
                rowStart = 20;
                rowEnd = 24;
                colStart = 10;
                colEnd = 14;
            }else if(blockNum == 24){
                rowStart = 20;
                rowEnd = 24;
                colStart = 15;
                colEnd = 19;
            }else if(blockNum == 25){//
                rowStart = 20;
                rowEnd = 24;
                colStart = 20;
                colEnd = 24;
            }
        }
        int missingRow = 0;
        int missingCol = 0;
        for (int rowCounter = rowStart; rowCounter <= rowEnd; rowCounter++) {
            for (int colCounter = colStart; colCounter <= colEnd; colCounter++) {
                if (value == actualValues[rowCounter][colCounter]) {
                   // System.out.println("Start Row " + rowStart + " end row " + rowEnd + " start column " + colStart + " end column " + colEnd);
                   // System.out.println("Value " + value + " in [" + rowCounter + "][" + colCounter + "]");
                    return new BlockInfo(rowCounter, colCounter, blockNum, true);
                }else if(actualValues[rowCounter][colCounter] == '-'){
                    missingRow = rowCounter;
                    missingCol = colCounter;
                }
            }

        }
        //System.out.println("Start Row " + rowStart + " end row " +rowEnd + " start column " + colStart + " end column "+ colEnd);
        System.out.println("Value " + value + " is not in block " + blockNum);

        return new BlockInfo(missingRow, missingCol, blockNum, false);
    }

    public boolean checkBlock(char value, int row, int col) {
        int rowStart = 0;
        int rowEnd = 0;
        int colStart = 0;
        int colEnd = 0;
        if (boardSize == 4) {
            if (row < 2) {
                rowStart = 0;
                rowEnd = 1;
            } else {
                rowStart = 2;
                rowEnd = 3;
            }
            if (col < 2) {
                colStart = 0;
                colEnd = 1;
            } else {
                colStart = 2;
                colEnd = 3;
            }

        }

        if (boardSize == 9) {
            if (row < 3) {
                rowStart = 0;
                rowEnd = 2;
            } else if (row < 6) {
                rowStart = 3;
                rowEnd = 5;
            } else {
                rowStart = 6;
                rowEnd = 8;
            }

            if (col < 3) {
                colStart = 0;
                colEnd = 2;
            } else if (col < 6) {
                colStart = 3;
                colEnd = 5;
            } else {
                colStart = 6;
                colEnd = 8;
            }
        }

        if (boardSize == 16) {
            if (row < 4) {
                rowStart = 0;
                rowEnd = 3;
            } else if (row < 8) {
                rowStart = 4;
                rowEnd = 7;
            } else if (row < 12) {
                rowStart = 8;
                rowEnd = 11;
            } else {
                rowStart = 12;
                rowEnd = 15;
            }
            if (col < 4) {
                colStart = 0;
                colEnd = 3;
            } else if (col < 8) {
                colStart = 4;
                colEnd = 7;
            } else if (col < 12) {
                colStart = 8;
                colEnd = 11;
            } else {
                colStart = 12;
                colEnd = 15;
            }
        }

        if (boardSize == 25) {
            if (row < 5) {
                rowStart = 0;
                rowEnd = 4;
            } else if (row < 10) {
                rowStart = 5;
                rowEnd = 9;
            } else if (row < 15) {
                rowStart = 10;
                rowEnd = 14;
            } else if (row < 20) {
                rowStart = 15;
                rowEnd = 19;
            } else {
                rowStart = 20;
                rowEnd = 24;
            }

            if (col < 5) {
                colStart = 0;
                colEnd = 4;
            } else if (col < 10) {
                colStart = 5;
                colEnd = 9;
            } else if (col < 15) {
                colStart = 10;
                colEnd = 14;
            } else if (col < 20) {
                colStart = 15;
                colEnd = 19;
            } else {
                colStart = 20;
                colEnd = 24;
            }
        }
        for (int rowCounter = rowStart; rowCounter <= rowEnd; rowCounter++) {
            for (int colCounter = colStart; colCounter <= colEnd; colCounter++) {
                if (value == actualValues[rowCounter][colCounter]) {
                    System.out.println("Start Row " + rowStart + " end row " + rowEnd + " start column " + colStart + " end column " + colEnd);
                    System.out.println("Value " + value + " in [" + rowCounter + "][" + colCounter + "]");
                    return true;
                }
            }

        }
        //System.out.println("Start Row " + rowStart + " end row " +rowEnd + " start column " + colStart + " end column "+ colEnd);
        System.out.println("Value " + value + " is not in [" + row + "][" + col + "]");
        return false;
    }

    void validateValueInPossibleValues(char value)throws InvalidBoardException{
        boolean isValid = false;
        for(int k = 0; k < boardSize; k++) {
            if(value == possibleValues[k] || value == '-' ){
                isValid = true;
                break;
            }
        }
        if(!isValid) {
            throw new InvalidBoardException("Invalid character in the board");
        }
    }

    void validateBoardValues() throws InvalidBoardException{//makes sure the board values are one of the possible values
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize;j++ ){
                validateValueInPossibleValues(actualValues[i][j]);
            }
        }
    }
    void solve(){
        OneMissingSolver oneMissing = new OneMissingSolver();
        int counter = 0;
        while(!this.isSolved() && counter < 10) {
            oneMissing.solve(this);
            counter++;
        }
    }
}