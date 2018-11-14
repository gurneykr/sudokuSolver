import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OneMissingSolverTest {
    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\";
//    @Test
//    public void validatefindMissingValuesCol()throws InvalidBoardException, IOException {
//        Board board = new Board();
//        board.loadBoard(path + "Puzzle-4x4-0001.txt");
//        board.solve();
//        assertEquals(board.getActualValues()[0][1], '4');
//    }

//    @Test
//    public void validatefindMissingValuesRow()throws InvalidBoardException, IOException {
//        Board board = new Board();
//        board.loadBoard(path + "Puzzle-4x4-0001.txt");
//        board.solve();
//        assertEquals(board.getActualValues()[0][1], '4');
//    }

    @Test
    public void validateFindMissingBlock() throws InvalidBoardException, IOException{
        Board board = new Board();
        board.loadBoard(path + "Puzzle-4x4-0001.txt");
        /*
        2 - 3 1
        1 3 - 4
        3 1 4 -
        - 2 1 3*/

        OneMissingSolver missingSolver = new OneMissingSolver();
        missingSolver.solve(board);
        assertEquals(board.getActualValues()[0][1], '4' );
        assertEquals(board.getActualValues()[1][2], '2' );
        assertEquals(board.getActualValues()[3][0], '4' );
        assertEquals(board.getActualValues()[2][3], '2' );
    }

}
