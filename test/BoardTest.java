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

    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\Puzzle-4x4-0001.txt";
    @Test
    public void validateCheckRow(){
        Board board = new Board();
        try {
            board.loadBoard(path);
            assertEquals(board.checkRow('2', 0), true);
            assertEquals(board.checkRow('3', 0), true);
            assertEquals(board.checkRow('1', 0), true);

            assertEquals(board.checkRow('1', 1), true);
            assertEquals(board.checkRow('3', 1), true);
            assertEquals(board.checkRow('4', 1), true);

            assertEquals(board.checkRow('3', 2), true);
            assertEquals(board.checkRow('1', 2), true);
            assertEquals(board.checkRow('4', 2), true);

            assertEquals(board.checkRow('2', 3), true);
            assertEquals(board.checkRow('1', 3), true);
            assertEquals(board.checkRow('3', 3), true);

        }catch (IOException e){
            e.printStackTrace();
        }catch (InvalidBoardException e){
            assertEquals(true, false);
        }
    }

//    @Test
//    public void validateCheckCol(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path);
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

//    @Test
//    public void validateCheckBlock(){
//        Board board = new Board();
//        try {
//            board.loadBoard(path);
//            /*
//                2 - 3 1
//                1 3 - 4
//                3 1 4 -
//                - 2 1 3*/
//            board.checkBlock('2',0,0);
//            board.checkBlock('-', 0, 1 );
//            board.checkBlock('3', 0, 2 );
//            board.checkBlock('1', 0, 3 );
//
//            board.checkBlock('1', 1, 0 );
//            board.checkBlock('3', 1, 1 );
//            board.checkBlock('-', 1, 2 );
//            board.checkBlock('4', 1, 3 );
//
//            board.checkBlock('3', 2, 0 );
//            board.checkBlock('1', 2, 1 );
//            board.checkBlock('4', 2, 2 );
//            board.checkBlock('-', 2, 3 );
//
//            board.checkBlock('-', 3, 0 );
//            board.checkBlock('2', 3, 1 );
//            board.checkBlock('1', 3, 2 );
//            board.checkBlock('3', 3, 3 );
//
//            assertEquals(true, true);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (InvalidBoardException e){
//            assertEquals(true, false);
//        }
//    }


}