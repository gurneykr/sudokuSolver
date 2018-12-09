import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HiddenTwinTest {
    HiddenTwinRow hiddenTwinRow = new HiddenTwinRow();

    @Test
    public void testContainsPotentialValues(){
        Cell cell = new Cell('5', 1, 1);

        boolean flag = hiddenTwinRow.containsPotentialValues(cell, '1', '3');
        assertEquals(flag, false);

        cell.addPotentialValue('1');
        boolean flag2 = hiddenTwinRow.containsPotentialValues(cell, '1', '3');
        assertEquals(flag2, false);//only one matches

        cell.addPotentialValue('3');
        boolean flag3 = hiddenTwinRow.containsPotentialValues(cell, '1', '3');
        assertEquals(flag3, true);//both match

        cell.addPotentialValue('4');
        boolean flag4 = hiddenTwinRow.containsPotentialValues(cell, '1', '3');
        assertEquals(flag4, true);

        //check for only one matching potential value
        Cell cell2 = new Cell('1', 0, 0);
        boolean flag5 = hiddenTwinRow.containsPotentialValues(cell2, '5', '6');
        cell2.addPotentialValue('5');
        cell2.addPotentialValue('7');
        assertEquals(flag5, false);
    }

    @Test
    public void testFindTwinCombinations(){
        List<Cell> possiblehiddenTwinArray = new ArrayList();
        Cell cell = new Cell('-', 0, 0);

        cell.addPotentialValue('1');
        possiblehiddenTwinArray.add(cell);

        List<Cell> cellCombinations = hiddenTwinRow.findTwinCombinations(possiblehiddenTwinArray, '1', '2');
        //no possible twin
        assertEquals(cellCombinations.size(), 0);

        cell.addPotentialValue('2');
        cellCombinations = hiddenTwinRow.findTwinCombinations(possiblehiddenTwinArray, '1', '2');
        //one cell possible
        assertEquals(cellCombinations.size(), 1);

        Cell cell2 = new Cell('2', 0, 1);
        cell2.addPotentialValue('1');
        cell2.addPotentialValue('2');
        possiblehiddenTwinArray.add(cell2);

        cellCombinations = hiddenTwinRow.findTwinCombinations(possiblehiddenTwinArray, '1', '2');
        //two cells possible
        assertEquals(cellCombinations.size(), 2);

        Cell cell3 = new Cell('3', 0, 2);
        cell3.addPotentialValue('1');
        possiblehiddenTwinArray.add(cell3);

        cellCombinations = hiddenTwinRow.findTwinCombinations(possiblehiddenTwinArray, '1', '2');
        assertEquals(cellCombinations.size(), 2);

        cell3.addPotentialValue('2');
        cellCombinations = hiddenTwinRow.findTwinCombinations(possiblehiddenTwinArray, '1', '2');
        //three cells possible
        assertEquals(cellCombinations.size(), 3);
    }

    @Test
    public void testEliminateTwinsFromOtherPotentialValueRow() throws InvalidBoardException{

        Board board = new Board();
        board.setBoardSize(4);
        Cell cellArray[][] = new Cell[board.getBoardSize()][board.getBoardSize()];

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
    }

//    @Test
//    public void testFindhiddenTwinRowRowRow(){
//
//    }

}
