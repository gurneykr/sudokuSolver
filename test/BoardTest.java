import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BoardTest{

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

    @Test
    public void loadInvalidPossibleValues(){
        Board board = new Board();
        try {
            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\invalidPossibleValues.txt");
            assertEquals(true, false);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InvalidBoardException e){
            assertEquals(true, true);
        }
    }

    @Test
    public void tooManyPossibleValues(){
        Board board = new Board();
        try {
            board.loadBoard("C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\test\\tooManyPossibleValues.txt");
            assertEquals(true, false);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InvalidBoardException e){
            assertEquals(true, true);
        }
    }
}