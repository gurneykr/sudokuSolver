import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BoardTest{

//    @Test
//    public void loadInvalidBoard(){
//        Board board = new Board();
//        try {
//            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\invalidBoardSize.txt");
//            assertEquals(true, false);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, true);
//        }
//    }
//
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

    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\";

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
//            board.checkBlock('4',0,0);
//            board.checkBlock('1', 0, 2 );
//            board.checkBlock('9', 0, 8 );
//
//            board.checkBlock('1', 3, 3 );
//            board.checkBlock('6', 3, 4 );
//            board.checkBlock('8', 3, 7 );
//
//            board.checkBlock('6', 6, 2 );
//            board.checkBlock('8', 6,3  );
//            board.checkBlock('7', 6, 8 );
//
//            assertEquals(true, true);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }

    @Test
    public void validateCheckBlock16x16(){
        Board board = new Board();
        try {
            board.loadBoard(path+"Puzzle-16x16-0001.txt");
            /*
            7 1 - - A - E C - 3 2 - 6 - - 8
            6 - 2 - - - - - - - E - D C - 9
            E 8 - B - 3 - - 1 - G - - 4 5 -
            - 3 F - B - - - - 6 D - - - A -
         /  - E - - F C B - - 9 - D - 3 - -
            1 - 3 - 4 - 8 - A - - - - 9 - -
            - 7 C - - G - - - B F - A - - -
            - - - - - - 5 - 2 4 8 - C D 6 -
        /   - - - - - - C - 6 8 9 - 1 2 G -
            - G 8 - - 6 - - - 5 7 - 3 - - -
            C - E - 3 - A - B - - - - 7 - -
            - 4 - - 5 8 F - - G - C - 6 - -
       /    - C 9 - G - - - - F A - - - 2 -
            B A - E - 2 - - G - 5 - - 1 9 -
            4 - 6 - - - - - - - B - 8 E - G
            5 D - - 1 - 3 8 - E 4 - 7 - - B*/
            assertEquals(board.checkBlock('2',0,0), true);
            assertEquals(board.checkBlock('A', 0, 5), true);
            assertEquals(board.checkBlock('E', 0, 11 ), true);
            assertEquals(board.checkBlock('5', 0, 15 ), true);

            assertEquals(board.checkBlock('C', 4, 0 ), true);
            assertEquals(board.checkBlock('B', 4, 5 ), true);
            assertEquals(board.checkBlock('F', 4, 11 ), true);
            assertEquals(board.checkBlock('9', 4,15  ), true);

            assertEquals(board.checkBlock('G', 8, 0 ),true);
            assertEquals(board.checkBlock('A', 8, 5 ), true);
            assertEquals(board.checkBlock('B', 8, 11 ), true);
            assertEquals(board.checkBlock('7', 8, 15), true);

            assertEquals(board.checkBlock('D', 12, 0 ), true);
            assertEquals(board.checkBlock('G', 12, 5 ), true);
            assertEquals(board.checkBlock('5', 12, 11 ), true);
            assertEquals(board.checkBlock('9', 12, 15), true);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InvalidBoardException e){
            assertEquals(true, false);
        }
    }


}