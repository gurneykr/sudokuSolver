import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    Cell cell = new Cell();


    public static void createBoard(int boardSize){

    }
    public static void main(String[] args)throws Exception {
        File file = new File("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\Puzzle-4x4-0001.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        Board board = new Board();
        String line;
        line = br.readLine();
        int boardSize = Integer.parseInt(line);
        board.setBoardSize(boardSize);

       // System.out.println(boardSize);

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
