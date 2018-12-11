import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Board {
    int boardSize;
    char possibleValues[];
    Cell[][] cellArray;


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

    public Cell[][] getCellArray() {
        return cellArray;
    }

    public void setCellArray(Cell[][] cellArray) {
        this.cellArray = cellArray;
    }

    public void resetPotentialValues() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                cellArray[row][col].resetPotentialValues();
            }
        }
    }

    public void printBoard() {

        for (char n : possibleValues) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                System.out.print(cellArray[row][col].getValue() + " ");
            }
            System.out.println();
        }
    }

    public void loadBoard(String fileName) throws IOException, InvalidBoardException {

        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

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


        Cell cellArray[][] = new Cell[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {//get the actual board
            counter = 0;
            line = br.readLine();
            String boardValues[] = line.split(" ");
            for (String n : boardValues) {

                char characterArray[] = n.toCharArray();
                if (characterArray.length == 1) {
                    cellArray[row][counter] = new Cell(characterArray[0], row, counter);
                    counter++;
                } else {
                    throw new Error("Invalid value detected");
                }
            }
        }
        this.setCellArray(cellArray);
        //this.printBoard(true, "out.txt");

        this.validateBoardValues();
    }

    public boolean isSolved(){//make sure there are not dashes left
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(cellArray[i][j].getValue() == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(char value, int row) {
        if (row <= boardSize) {
            for (int col = 0; col < boardSize; col++) {
                if (value == cellArray[row][col].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCol(char value, int col) {
        if (col <= boardSize) {
            for (int row = 0; row < boardSize; row++) {
                if (value == cellArray[row][col].getValue()) {
                    return true;
                }
            }
        }
        return false;
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
                if (value == cellArray[rowCounter][colCounter].getValue()) {
                    return true;
                }
            }

        }
        return false;
    }

    public BlockInfo checkBlock(char value, int blockNum) {
        //uses the given row and col to find what block to look for a value

        BlockBoundaries bb = getBlockBoundaries(blockNum);

        int missingRow = 0;
        int missingCol = 0;
        for (int rowCounter = bb.rowStart; rowCounter <= bb.rowEnd; rowCounter++) {
            for (int colCounter = bb.colStart; colCounter <= bb.colEnd; colCounter++) {
                if (value == cellArray[rowCounter][colCounter].getValue()) {
                    return new BlockInfo(rowCounter, colCounter, blockNum, true);
                }else if(cellArray[rowCounter][colCounter].getValue() == '-'){
                    missingRow = rowCounter;
                    missingCol = colCounter;
                }
            }

        }
        return new BlockInfo(missingRow, missingCol, blockNum, false);
    }

    BlockBoundaries getBlockBoundaries(int blockNum){
        //uses the given row and col to find what block to look for a value

        BlockBoundaries bb = new BlockBoundaries();

        if (boardSize == 4) {
            if(blockNum == 1){
                bb.rowStart = 0;
                bb.rowEnd = 1;
                bb.colStart = 0;
                bb.colEnd = 1;
            }else if(blockNum == 2){
                bb.rowStart = 0;
                bb.rowEnd = 1;
                bb.colStart = 2;
                bb.colEnd = 3;
            }else if(blockNum == 3){
                bb.rowStart = 2;
                bb.rowEnd = 3;
                bb.colStart = 0;
                bb.colEnd = 1;
            }else if(blockNum == 4){
                bb.rowStart = 2;
                bb.rowEnd = 3;
                bb.colStart = 2;
                bb.colEnd = 3;
            }
        }

        if (boardSize == 9) {
            if(blockNum == 1){
                bb.rowStart = 0;
                bb.rowEnd = 2;
                bb.colStart = 0;
                bb.colEnd = 2;
            }else if(blockNum == 2){
                bb.rowStart = 0;
                bb.rowEnd = 2;
                bb.colStart = 3;
                bb.colEnd = 5;
            }else if(blockNum == 3){
                bb.rowStart = 0;
                bb.rowEnd = 2;
                bb.colStart = 6;
                bb.colEnd = 8;
            }else if(blockNum == 4){
                bb.rowStart = 3;
                bb.rowEnd = 5;
                bb.colStart = 0;
                bb.colEnd = 2;
            }else if(blockNum == 5){
                bb.rowStart = 3;
                bb.rowEnd = 5;
                bb.colStart = 3;
                bb.colEnd = 5;
            }else if(blockNum == 6){
                bb.rowStart = 3;
                bb.rowEnd = 5;
                bb.colStart = 6;
                bb.colEnd = 8;
            }else if(blockNum == 7){
                bb.rowStart = 6;
                bb.rowEnd = 8;
                bb.colStart = 0;
                bb.colEnd = 2;
            }else if(blockNum == 8){
                bb.rowStart = 6;
                bb.rowEnd = 8;
                bb.colStart = 3;
                bb.colEnd = 5;
            }else if(blockNum == 9){
                bb.rowStart = 6;
                bb.rowEnd = 8;
                bb.colStart = 6;
                bb.colEnd = 8;
            }
        }

        if (boardSize == 16) {
            if(blockNum == 1){
                bb.rowStart = 0;
                bb.rowEnd = 3;
                bb.colStart = 0;
                bb.colEnd = 3;
            }else if(blockNum == 2){
                bb.rowStart = 0;
                bb.rowEnd = 3;
                bb.colStart = 4;
                bb.colEnd = 7;
            }else if(blockNum == 3){
                bb.rowStart = 0;
                bb.rowEnd = 3;
                bb.colStart = 8;
                bb.colEnd = 11;
            }else if(blockNum == 4){
                bb.rowStart = 0;
                bb.rowEnd = 3;
                bb.colStart = 12;
                bb.colEnd = 15;
            }else if(blockNum == 5){
                bb.rowStart = 4;
                bb.rowEnd = 7;
                bb.colStart = 0;
                bb.colEnd = 3;
            }else if(blockNum == 6){
                bb.rowStart = 4;
                bb.rowEnd = 7;
                bb.colStart = 4;
                bb.colEnd = 7;
            }else if(blockNum == 7){
                bb.rowStart = 4;
                bb.rowEnd = 7;
                bb.colStart = 8;
                bb.colEnd = 11;
            }else if(blockNum == 8){
                bb.rowStart = 4;
                bb.rowEnd = 7;
                bb.colStart = 12;
                bb.colEnd = 15;
            }else if(blockNum == 9){
                bb.rowStart = 8;
                bb.rowEnd = 11;
                bb.colStart = 0;
                bb.colEnd = 3;
            }else if(blockNum == 10){
                bb.rowStart = 8;
                bb.rowEnd = 11;
                bb.colStart = 4;
                bb.colEnd = 7;
            }else if(blockNum == 11){
                bb.rowStart = 8;
                bb.rowEnd = 11;
                bb.colStart = 8;
                bb.colEnd = 11;
            }else if(blockNum == 12){
                bb.rowStart = 8;
                bb.rowEnd = 11;
                bb.colStart = 12;
                bb.colEnd = 15;
            }else if(blockNum == 13){
                bb.rowStart = 12;
                bb.rowEnd = 15;
                bb.colStart = 0;
                bb.colEnd = 3;
            }else if(blockNum == 14){
                bb.rowStart = 12;
                bb.rowEnd = 15;
                bb.colStart = 4;
                bb.colEnd = 7;
            }else if(blockNum == 15){
                bb.rowStart = 12;
                bb.rowEnd = 15;
                bb.colStart = 8;
                bb.colEnd = 11;
            }else if(blockNum == 16){
                bb.rowStart = 12;
                bb.rowEnd = 15;
                bb.colStart = 12;
                bb.colEnd = 15;
            }


        }

        if (boardSize == 25) {
            if(blockNum == 1){
                bb.rowStart = 0;
                bb.rowEnd = 4;
                bb.colStart = 0;
                bb.colEnd = 4;
            }else if(blockNum == 2){
                bb.rowStart = 0;
                bb.rowEnd = 4;
                bb.colStart = 5;
                bb.colEnd = 9;
            }else if(blockNum == 3){
                bb.rowStart = 0;
                bb.rowEnd = 4;
                bb.colStart = 10;
                bb.colEnd = 14;
            }else if(blockNum == 4){
                bb.rowStart = 0;
                bb.rowEnd = 4;
                bb.colStart = 15;
                bb.colEnd = 19;
            }else if(blockNum == 5){//
                bb.rowStart = 0;
                bb.rowEnd = 4;
                bb.colStart = 20;
                bb.colEnd = 24;
            }else if(blockNum == 6){
                bb.rowStart = 5;
                bb.rowEnd = 9;
                bb.colStart = 0;
                bb.colEnd = 4;
            }else if(blockNum == 7){
                bb.rowStart = 5;
                bb.rowEnd = 9;
                bb.colStart = 5;
                bb.colEnd = 9;
            }else if(blockNum == 8){
                bb.rowStart = 5;
                bb.rowEnd = 9;
                bb.colStart = 10;
                bb.colEnd = 14;
            }else if(blockNum == 9){
                bb.rowStart = 5;
                bb.rowEnd = 9;
                bb.colStart = 15;
                bb.colEnd = 19;
            }else if(blockNum == 10){//
                bb.rowStart = 5;
                bb.rowEnd = 9;
                bb.colStart = 20;
                bb.colEnd = 24;
            }else if(blockNum == 11){
                bb.rowStart = 10;
                bb.rowEnd = 14;
                bb.colStart = 0;
                bb.colEnd = 4;
            }else if(blockNum == 12){
                bb.rowStart = 10;
                bb.rowEnd = 14;
                bb.colStart = 5;
                bb.colEnd = 9;
            }else if(blockNum == 13){
                bb.rowStart = 10;
                bb.rowEnd = 14;
                bb.colStart = 10;
                bb.colEnd = 14;
            }else if(blockNum == 14){
                bb.rowStart = 10;
                bb.rowEnd = 14;
                bb.colStart = 15;
                bb.colEnd = 19;
            }else if(blockNum == 15){//
                bb.rowStart = 10;
                bb.rowEnd = 14;
                bb.colStart = 20;
                bb.colEnd = 24;
            }else if(blockNum == 16){
                bb.rowStart = 15;
                bb.rowEnd = 19;
                bb.colStart = 0;
                bb.colEnd = 4;
            }else if(blockNum == 17){
                bb.rowStart = 15;
                bb.rowEnd = 19;
                bb.colStart = 5;
                bb.colEnd = 9;
            }else if(blockNum == 18){
                bb.rowStart = 15;
                bb.rowEnd = 19;
                bb.colStart = 10;
                bb.colEnd = 14;
            }else if(blockNum == 19){
                bb.rowStart = 15;
                bb.rowEnd = 19;
                bb.colStart = 15;
                bb.colEnd = 19;
            }else if(blockNum == 20){//
                bb.rowStart = 15;
                bb.rowEnd = 19;
                bb.colStart = 20;
                bb.colEnd = 24;
            }else if(blockNum == 21){
                bb.rowStart = 20;
                bb.rowEnd = 24;
                bb.colStart = 0;
                bb.colEnd = 4;
            }else if(blockNum == 22){
                bb.rowStart = 20;
                bb.rowEnd = 24;
                bb.colStart = 5;
                bb.colEnd = 9;
            }else if(blockNum == 23){
                bb.rowStart = 20;
                bb.rowEnd = 24;
                bb.colStart = 10;
                bb.colEnd = 14;
            }else if(blockNum == 24){
                bb.rowStart = 20;
                bb.rowEnd = 24;
                bb.colStart = 15;
                bb.colEnd = 19;
            }else if(blockNum == 25){//
                bb.rowStart = 20;
                bb.rowEnd = 24;
                bb.colStart = 20;
                bb.colEnd = 24;
            }
        }

        return bb;
    }



    void validateValueInPossibleValues(Cell cell)throws InvalidBoardException{
        boolean isValid = false;
        for(int k = 0; k < boardSize; k++) {
            if(cell.getValue() == possibleValues[k] || cell.getValue() == '-' ){
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
                validateValueInPossibleValues(cellArray[i][j]);
            }
        }
    }
    List<SolverInfo> solve() {

        List<SolverInfo> solvers = new ArrayList();

        OneMissingSolver oneMissingSolver = new OneMissingSolver();
        PotentialValueSolver potentialValueSolver = new PotentialValueSolver();
        HiddenTwinRow hiddenTwinRowSolver = new HiddenTwinRow();
        HiddenTwinCol hiddenTwinColSolver = new HiddenTwinCol();
        HiddenTwinBlock hiddenTwinBlockSolver = new HiddenTwinBlock();

        SolverInfo potentialValueInfo = new SolverInfo("Potential Value Solver");
        SolverInfo oneMissingInfo = new SolverInfo("One Missing Solver");
        SolverInfo hiddenTwinRowInfo = new SolverInfo("Hidden Twin Row Solver");
        SolverInfo hiddenTwinColInfo = new SolverInfo("Hidden Twin Col Solver");
        SolverInfo hiddenTwinBlockInfo = new SolverInfo("Hidden Twin Block Solver");

        solvers.add(potentialValueInfo);
        solvers.add(oneMissingInfo);
        solvers.add(hiddenTwinRowInfo);
        solvers.add(hiddenTwinColInfo);
        solvers.add(hiddenTwinBlockInfo);

        int counter = 0;
        long potentialValueTimer = 0;
        long oneMissingTimer = 0;
        long hiddenTwinRowTimer = 0;
        long hiddenTwinColTimer = 0;
        long hiddenTwinBlockTimer = 0;
        int potentialValueCounter = 0;
        int oneMissingCounter = 0;
        int hiddenTwinRowCounter = 0;
        int hiddenTwinColCounter = 0;
        int hiddenTwinBlockCounter = 0;

        while(!this.isSolved() && counter < 300) {
            resetPotentialValues();

            // Get all of the potential values
            PotentialValueSolver.findPotentialValues(this);

            // Adjust the potential values by looking for hidden twins
          //  hiddenTwinRowTimer += hiddenTwinRowSolver.solve(this);
          //  hiddenTwinColTimer += hiddenTwinColSolver.solve(this);
          //  hiddenTwinBlockTimer += hiddenTwinBlockSolver.solve(this);


            // Set cells with only 1 potential value
            potentialValueTimer += potentialValueSolver.solve(this);

            // Set cells with only 1 possible value per row/col/block
            oneMissingTimer += oneMissingSolver.solve(this);

            System.out.println("************************************************************************************");
            this.printBoard();
            System.out.println("************************************************************************************");

            counter++;
            potentialValueCounter++;
            oneMissingCounter++;
            hiddenTwinRowCounter++;
            hiddenTwinColCounter++;
            hiddenTwinBlockTimer++;
        }
        if(!this.isSolved()){
            System.out.println("Can't solve the puzzle");
        }
        potentialValueInfo.setSolverTime(potentialValueTimer);
        potentialValueInfo.setTimesUsed(potentialValueCounter);

        oneMissingInfo.setSolverTime(oneMissingTimer);
        oneMissingInfo.setTimesUsed(oneMissingCounter);

        hiddenTwinRowInfo.setSolverTime(hiddenTwinRowTimer);
        hiddenTwinRowInfo.setTimesUsed(hiddenTwinRowCounter);

        hiddenTwinColInfo.setSolverTime(hiddenTwinColTimer);
        hiddenTwinColInfo.setTimesUsed(hiddenTwinColCounter);

        hiddenTwinBlockInfo.setSolverTime(hiddenTwinBlockTimer);
        hiddenTwinBlockInfo.setTimesUsed(hiddenTwinBlockCounter);

        return solvers;
    }
}