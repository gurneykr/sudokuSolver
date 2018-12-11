import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HiddenTwinRowTest {
    String path = "C:\\Users\\Krista Gurney\\Documents\\cs5700\\sudokuSolver\\SamplePuzzles\\";

    @Test
    public void testFindHiddenTwinRow()throws InvalidBoardException, IOException {
        Board board = new Board();
        board.loadBoard(path +"testPuzzle9x9.txt");
        HiddenTwinRow hiddenTwinRow = new HiddenTwinRow();

        PotentialValueSolver.findPotentialValues(board);

        assertEquals(board.getCellArray()[0][1].getPotentialValues().size(), 3);
        assertEquals(board.getCellArray()[0][1].getPotentialValues().get(0).toCharArray()[0], '2' );
        assertEquals(board.getCellArray()[0][1].getPotentialValues().get(1).toCharArray()[0], '8' );
        assertEquals(board.getCellArray()[0][1].getPotentialValues().get(2).toCharArray()[0], '9' );

        hiddenTwinRow.solve(board);
        assertEquals(board.getCellArray()[0][1].getPotentialValues().size(), 2);
        assertEquals(board.getCellArray()[0][1].getPotentialValues().get(0).toCharArray()[0], '2' );
        assertEquals(board.getCellArray()[0][1].getPotentialValues().get(1).toCharArray()[0], '8' );
    }


    @Test
    public void testEliminateTwinsFromOtherPotentialValueRow() throws InvalidBoardException{

        Board board = new Board();
        board.setBoardSize(4);
        Cell cellArray[][] = new Cell[board.getBoardSize()][board.getBoardSize()];
        HiddenTwinRow hiddenTwinRow = new HiddenTwinRow();
    /*
    - - 3 1
    1 3 - 4
    3 - 4 -
    - 2 - 3 */

        ///CASE 1- two cells have the same twin values- eliminate value from non twin////
        Cell cell00 = new Cell('2', 0, 0);
        cell00.addPotentialValue('1');
        cell00.addPotentialValue('2');
        cell00.addPotentialValue('4');
        cellArray[0][0] = cell00;

        Cell cell01 = new Cell('3', 0, 1);
        cell01.addPotentialValue('1');
        cell01.addPotentialValue('2');
        cell01.addPotentialValue('3');
        cellArray[0][1] = cell01;

        Cell cell02 = new Cell('4', 0, 2);
        cell02.addPotentialValue('2');
        cell02.addPotentialValue('3');
        cellArray[0][2] = cell02;

        Cell cell03 = new Cell('4', 0, 3);
        cell03.addPotentialValue('1');
        cell03.addPotentialValue('4');
        cellArray[0][3] = cell03;

        board.setCellArray(cellArray);
        List<Cell> twinCells = new ArrayList();
        twinCells.add(cell00);
        twinCells.add(cell01);

        hiddenTwinRow.eliminateTwinsFromOtherPotentialValueRow(board, twinCells, 0, '1', '2');
        assertEquals(cell00.getPotentialValues().size(), 2);
        assertEquals(cell00.getPotentialValues().get(0), "1");
        assertEquals(cell00.getPotentialValues().get(1), "2");

        assertEquals(cell01.getPotentialValues().size(), 2);
        assertEquals(cell01.getPotentialValues().get(0), "1");
        assertEquals(cell01.getPotentialValues().get(1), "2");

        assertEquals(cell03.getPotentialValues().size(), 1);
        assertEquals(cell03.getPotentialValues().get(0), "4");

        assertEquals(cell02.getPotentialValues().size(), 1);
        assertEquals(cell02.getPotentialValues().get(0), "3");

        ////////////////////////


    }

}
