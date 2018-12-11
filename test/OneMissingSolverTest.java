import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OneMissingSolverTest {
    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\";

    Board board;
    @Before
    public void setUp()throws InvalidBoardException, IOException{
        board = new Board();
        board.loadBoard(path + "Puzzle-4x4-0001.txt");
        PotentialValueSolver.findPotentialValues(board);
        OneMissingSolver oneMissingSolver = new OneMissingSolver();
        oneMissingSolver.solve(board);
        /*
        2 - 3 1
        1 3 - 4
        3 1 4 -
        - 2 1 3*/
    }
    @Test
    public void validatefindMissingValuesCol(){
        assertEquals(board.getCellArray()[0][1].getValue(), '4');
        assertEquals(board.getCellArray()[1][2].getValue(), '2');
        assertEquals(board.getCellArray()[2][3].getValue(), '2');
        assertEquals(board.getCellArray()[3][0].getValue(), '4');
    }

    @Test
    public void validatefindMissingValuesRow(){
        assertEquals(board.getCellArray()[0][1].getValue(), '4');
    }

    @Test
    public void validateFindMissingBlock(){
        assertEquals(board.getCellArray()[0][1].getValue(), '4' );
        assertEquals(board.getCellArray()[1][2].getValue(), '2' );
        assertEquals(board.getCellArray()[3][0].getValue(), '4' );
        assertEquals(board.getCellArray()[2][3].getValue(), '2' );
    }

}
