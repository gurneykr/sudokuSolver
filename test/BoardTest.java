import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BoardTest{
    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\";

    @Test
    public void loadInvalidBoard(){
        Board board = new Board();
        try {
            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\invalidBoardSize.txt");
            assertEquals(true, false);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InvalidBoardException e){
            assertEquals(true, true);
        }
    }

//    @Test
//    public void loadInvalidPossibleValues(){
//        Board board = new Board();
//        try {
//            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\invalidPossibleValues.txt");
//            assertEquals(true, false);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, true);
//        }
//    }
//
//    @Test
//    public void tooManyPossibleValues(){
//        Board board = new Board();
//        try {
//            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\tooManyPossibleValues.txt");
//            assertEquals(true, false);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, true);
//        }
//    }
//
//    @Test
//    public void invalidValue(){
//        Board board = new Board();
//        try {
//            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\invalidValue.txt");
//            assertEquals(true, false);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, true);
//        }
//    }
//
//
//
//    @Test
//    public void validateCheckRow(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path +"Puzzle-4x4-0001.txt");
//            assertEquals(board.checkRow('2', 0), true);
//            assertEquals(board.checkRow('3', 0), true);
//            assertEquals(board.checkRow('1', 0), true);
//
//            assertEquals(board.checkRow('1', 1), true);
//            assertEquals(board.checkRow('3', 1), true);
//            assertEquals(board.checkRow('4', 1), true);
//
//            assertEquals(board.checkRow('3', 2), true);
//            assertEquals(board.checkRow('1', 2), true);
//            assertEquals(board.checkRow('4', 2), true);
//
//            assertEquals(board.checkRow('2', 3), true);
//            assertEquals(board.checkRow('1', 3), true);
//            assertEquals(board.checkRow('3', 3), true);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }
//
//    @Test
//    public void validateCheckCol(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path +"Puzzle-4x4-0001.txt");
//            assertEquals(board.checkCol('2', 0), true);
//            assertEquals(board.checkCol('1', 0), true);
//            assertEquals(board.checkCol('3', 0), true);
//
//            assertEquals(board.checkCol('3', 1), true);
//            assertEquals(board.checkCol('1', 1), true);
//            assertEquals(board.checkCol('2', 1), true);
//
//            assertEquals(board.checkCol('3', 2), true);
//            assertEquals(board.checkCol('4', 2), true);
//            assertEquals(board.checkCol('1', 2), true);
//
//            assertEquals(board.checkCol('1', 3), true);
//            assertEquals(board.checkCol('4', 3), true);
//            assertEquals(board.checkCol('3', 3), true);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }
//
//    @Test
//    public void validateCheckBlock9x9(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path+"Puzzle-9x9-0001.txt");
//            /*
//            4 9 - 1 3 6 7 - 8
//            - 6 3 5 - - - 9 -
//            5 - - - 2 9 3 6 4
//            - 2 - 3 1 - - 4 -
//            - 7 4 - - - 2 1 -
//            - - 1 - 6 4 - 8 -
//            1 8 6 9 - - - 2 5
//            - 4 - - 5 1 8 3 -
//            3 - 9 4 8 - - 7 -*/
//            assertEquals(board.checkBlock('4',1).isFound(), true);
//            assertEquals(board.checkBlock('4',1).getRow(), 0);
//            assertEquals(board.checkBlock('4',1).getCol(), 0);
//            assertEquals(board.checkBlock('4', 1,1), true);
//
//            assertEquals(board.checkBlock('1', 2).isFound(), true);
//            assertEquals(board.checkBlock('1', 2).getRow(), 0);
//            assertEquals(board.checkBlock('1', 2).getCol(), 3);
//            assertEquals(board.checkBlock('1', 1,3), true);
//
//            assertEquals(board.checkBlock('9', 3 ).isFound(), true);
//            assertEquals(board.checkBlock('9', 3 ).getRow(), 1);
//            assertEquals(board.checkBlock('9', 3 ).getCol(), 7);
//            assertEquals(board.checkBlock('9', 1,8), true);
//
//            assertEquals(board.checkBlock('2', 4).isFound(), true);
//            assertEquals(board.checkBlock('3', 5).isFound(), true);
//            assertEquals(board.checkBlock('1', 6 ).isFound(), true);
//            assertEquals(board.checkBlock('1', 8,1), true);
//
//            assertEquals(board.checkBlock('4',7 ).isFound(), true);
//            assertEquals(board.checkBlock('5', 8 ).isFound(), true);
//            assertEquals(board.checkBlock('7', 9).isFound(), true);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }
//
//    @Test
//    public void validateCheckBlock16x16(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path+"Puzzle-16x16-0001.txt");
//            /*
//            7 1 - - A - E C - 3 2 - 6 - - 8
//            6 - 2 - - - - - - - E - D C - 9
//            E 8 - B - 3 - - 1 - G - - 4 5 -
//            - 3 F - B - - - - 6 D - - - A -
//         /  - E - - F C B - - 9 - D - 3 - -
//            1 - 3 - 4 - 8 - A - - - - 9 - -
//            - 7 C - - G - - - B F - A - - -
//            - - - - - - 5 - 2 4 8 - C D 6 -
//        /   - - - - - - C - 6 8 9 - 1 2 G -
//            - G 8 - - 6 - - - 5 7 - 3 - - -
//            C - E - 3 - A - B - - - - 7 - -
//            - 4 - - 5 8 F - - G - C - 6 - -
//       /    - C 9 - G - - - - F A - - - 2 -
//            B A - E - 2 - - G - 5 - - 1 9 -
//            4 - 6 - - - - - - - B - 8 E - G
//            5 D - - 1 - 3 8 - E 4 - 7 - - B*/
//            assertEquals(board.checkBlock('7', 1).isFound(), true);
//            assertEquals(board.checkBlock('7', 1).getRow(), 0);
//            assertEquals(board.checkBlock('7', 1).getCol(), 0);
//            assertEquals(board.checkBlock('7', 1,1), true);
//
//            assertEquals(board.checkBlock('3',2).isFound(), true);
//            assertEquals(board.checkBlock('3', 2).getRow(), 2);
//            assertEquals(board.checkBlock('3', 2).getCol(), 5);
//            assertEquals(board.checkBlock('3', 2,2), true);
//
//            assertEquals(board.checkBlock('E', 3).isFound(), true);
//            assertEquals(board.checkBlock('E', 3).getRow(), 1);
//            assertEquals(board.checkBlock('E', 3).getCol(), 10);
//            assertEquals(board.checkBlock('E', 1,10), true);
//
//            assertEquals(board.checkBlock('8', 4).isFound(), true);
//            assertEquals(board.checkBlock('8', 0,15), true);
//
//            assertEquals(board.checkBlock('1', 5).isFound(), true);
//            assertEquals(board.checkBlock('4', 6).isFound(), true);
//            assertEquals(board.checkBlock('A', 7).isFound(), true);
//            assertEquals(board.checkBlock('9', 8).isFound(), true);
//
//            assertEquals(board.checkBlock('G', 9 ).isFound(),true);
//            assertEquals(board.checkBlock('6', 10).isFound(), true);
//            assertEquals(board.checkBlock('5',  11 ).isFound(), true);
//            assertEquals(board.checkBlock('G', 12).isFound(), true);
//
//            assertEquals(board.checkBlock('D', 13).isFound(), true);
//            assertEquals(board.checkBlock('G', 14).isFound(), true);
//            assertEquals(board.checkBlock('5', 15).isFound(), true);
//            assertEquals(board.checkBlock('9', 16).isFound(), true);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }
//
//    @Test
//    public void validateCheckBlock25x25(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path+"Puzzle-25x25-0101.txt");
//            /*
//            - L M - O - 2 - 4 5 - 7 - 9 - B - D - F G - I - K
//            K G - I - P - M - O - 2 3 4 - 6 7 8 9 A B - D - F
//            F B C - - K - - I - P - M - O 1 - 3 4 - 6 - 8 - A
//            A - 7 - 9 - B - D - K - H I J P L - N - 1 - 3 4 5
//            5 - 2 3 4 A 6 - 8 9 - B - D - K - H I - P - M - O
//            O - L - N 5 - 2 3 - A 6 7 - 9 F - C - E - G H I J
//            J K G H I O P L M N 5 1 2 3 4 A 6 7 8 9 F B C D E
//            E F B C - J - G H - O - L - N 5 - 2 3 - A 6 7 8 9
//            9 A - 7 - E - B - D - K G - I - P - M - 5 - 2 - 4
//            4 5 1 2 3 9 A 6 7 8 E F B C D J K G H I O P L M N
//            N - P - - 4 5 1 - 3 - A 6 - 8 E - B - D J - G - I
//            I J - G H - O P L M 4 - 1 - 3 - A 6 - 8 - F - C D
//            D E - B C - J - G - N - P L M 4 5 1 - 3 9 - 6 - 8
//            8 - A 6 - D - F B - I J - G - N O - L - 4 5 - 2 3
//            3 4 - 1 - 8 9 A - 7 D - F - C I - K - H N - P L M
//            M N O P L 3 4 5 1 2 8 9 A 6 7 D E F B C I J K G H
//            H - J - G M - O P - 3 4 5 - 2 8 9 A 6 - D E - B C
//            C D - F - H - J - G - N - P L - 4 - 1 2 - 9 A - 7
//            7 8 9 A 6 C D E F B H I J K G M N O P L 3 4 5 1 2
//            2 3 - 5 1 - 8 - - 6 C - E - B - I J - G - N - P L
//            L M N O P 2 3 4 5 1 7 8 9 A 6 C D E F B H I J K G
//            G - I J - L - N O - 2 3 4 - 1 7 - 9 A - C D E F B
//            B C D E F G H I J K L M N O P 2 3 4 5 1 7 8 9 A 6
//            6 7 8 9 A B C D E F G H I J K L M N O P 2 3 4 5 1
//            1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P
//        */
//            assertEquals(board.checkBlock('M',1).isFound(), true);
//            assertEquals(board.checkBlock('M',1).getRow(), 0);
//            assertEquals(board.checkBlock('M',1).getCol(),2 );
//            assertEquals(board.checkBlock('M', 1,1), true);
//
//            assertEquals(board.checkBlock('K', 2).isFound(), true);
//            assertEquals(board.checkBlock('K',2).getRow(), 2);
//            assertEquals(board.checkBlock('K',2).getCol(),5 );
//            assertEquals(board.checkBlock('K', 0,5), true);
//
//            assertEquals(board.checkBlock('7', 3 ).isFound(), true);
//            assertEquals(board.checkBlock('7',3).getRow(), 0);
//            assertEquals(board.checkBlock('7',3).getCol(),11);
//            assertEquals(board.checkBlock('7', 0,10), true);
//
//            assertEquals(board.checkBlock('1', 21 ).isFound(), true);
//            assertEquals(board.checkBlock('1',21).getRow(), 24);
//            assertEquals(board.checkBlock('1',21).getCol(),0);
//            assertEquals(board.checkBlock('1', 24,0), true);
//
//            assertEquals(board.checkBlock('P', 25).isFound(), true);
//            assertEquals(board.checkBlock('P',25).getRow(), 24);
//            assertEquals(board.checkBlock('P',25).getCol(),24);
//            assertEquals(board.checkBlock('P', 24,24), true);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }
//
//    @Test
//    public void validateOneMissingInBlock() throws InvalidBoardException, IOException {
//        Board board = new Board();
//        /*
//        4 - 2 1 3 6 7 5 8
//        7 6 3 5 4 8 - 9 2
//        5 1 8 - 2 9 3 6 4
//        8 2 5 3 1 7 9 4 6
//        6 7 4 - 9 5 2 1 3
//        - 3 1 2 6 4 5 - 7
//        1 8 6 9 7 3 4 - 5
//        2 4 - 6 5 - 8 3 9
//        3 5 9 4 8 2 6 7 1*/
//        try {
//            board.loadBoard(path +"OneMissingInBlock9x9.txt");
//            assertEquals(board.checkBlock('9', 1 ).isFound(), false);
//            assertEquals(board.checkBlock('9', 1).getRow(), 0);
//            assertEquals(board.checkBlock('9', 1).getCol(), 1);
//
//            assertEquals(board.checkBlock('7', 2).isFound(), false);
//            assertEquals(board.checkBlock('7', 2).getRow(), 2);
//            assertEquals(board.checkBlock('7', 2).getCol(), 3);
//
//            assertEquals(board.checkBlock('1', 3).isFound(), false);
//            assertEquals(board.checkBlock('1', 3).getRow(), 1);
//            assertEquals(board.checkBlock('1', 3).getCol(), 6);
//
//            assertEquals(board.checkBlock('9', 4).isFound(), false);
//            assertEquals(board.checkBlock('9', 4).getRow(), 5);
//            assertEquals(board.checkBlock('9', 4).getCol(), 0);
//
//            assertEquals(board.checkBlock('8', 5).isFound(), false);
//            assertEquals(board.checkBlock('8', 5).getRow(), 4);
//            assertEquals(board.checkBlock('8', 5).getCol(), 3);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }
//
//    @Test
//    public void validateIsSolved()throws InvalidBoardException, IOException{
//        Board board = new Board();
//        board.loadBoard(path + "Puzzle-4x4-0001.txt");
//        assertEquals(board.isSolved(), false);
//
//        board.loadBoard(path + "solved.txt");
//        assertEquals(board.isSolved(), true);
//
//    }


}