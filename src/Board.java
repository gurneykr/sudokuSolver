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
        if(boardSize != 4 || boardSize !=  9 || boardSize !=  16 || boardSize !=  25) {
            throw new InvalidBoardException("Invalid Board Size");
        }else{
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
    public void loadBoard(String fileName)throws IOException, InvalidBoardException{

        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        Board board = new Board();
        String line;
        line = br.readLine();
        int boardSize = Integer.parseInt(line);

        board.setBoardSize(boardSize);

        line = br.readLine();
        String possibleValueString[] = line.split(" ");
        char possibleValues[]= new char[boardSize];
        int counter = 0;
        for(String n: possibleValueString) {
            char characterArray[] =  n.toCharArray();
            if(characterArray.length == 1){
                possibleValues[counter++]= characterArray[0];
            }else{
                throw new Error("Invalid value detected");
            }
        }
        board.setPossibleValues(possibleValues);


        char actualValue[][]= new char[boardSize][boardSize];
        for(int row = 0; row < boardSize; row++){//get the actual board
            counter = 0;
            line = br.readLine();
            String boardValues[] = line.split(" ");
            for(String n: boardValues){
                //char valueArray[]= n.toCharArray();
                char characterArray[] =  n.toCharArray();
                if(characterArray.length == 1){
                    actualValue[row][counter++] = characterArray[0];
                }else{
                    throw new Error("Invalid value detected");
                }
            }
        }
        board.setActualValues(actualValue);

        board.printBoard();
    }
}
