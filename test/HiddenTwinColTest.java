import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HiddenTwinColTest {
    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\";

    @Test
    public void testFindHiddenTwinCol()throws InvalidBoardException, IOException {
        Board board = new Board();
        board.loadBoard(path +"testHiddenTwinCol9x9.txt");
        HiddenTwinCol hiddenTwinCol = new HiddenTwinCol();

        PotentialValueSolver.findPotentialValues(board);

        assertEquals(board.getCellArray()[0][2].getPotentialValues().size(), 2);
        assertEquals(board.getCellArray()[0][2].getPotentialValues().get(0).toCharArray()[0], '1' );
        assertEquals(board.getCellArray()[0][2].getPotentialValues().get(1).toCharArray()[0], '2' );
       // assertEquals(board.getCellArray()[0][2].getPotentialValues().get(2).toCharArray()[0], '9' );

        hiddenTwinCol.solve(board);
        assertEquals(board.getCellArray()[0][2].getPotentialValues().size(), 2);
        assertEquals(board.getCellArray()[0][2].getPotentialValues().get(0).toCharArray()[0], '1' );
        assertEquals(board.getCellArray()[0][2].getPotentialValues().get(1).toCharArray()[0], '2' );
    }


}
