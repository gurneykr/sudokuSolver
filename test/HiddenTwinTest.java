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
        List<Cell> possibleHiddenTwinArray = new ArrayList();
        Cell cell = new Cell('-', 0, 0);

        cell.addPotentialValue('1');
        possibleHiddenTwinArray.add(cell);

        List<Cell> cellCombinations = hiddenTwinRow.findTwinCombinations(possibleHiddenTwinArray, '1', '2');
        //no possible twin
        assertEquals(cellCombinations.size(), 0);

        cell.addPotentialValue('2');
        cellCombinations = hiddenTwinRow.findTwinCombinations(possibleHiddenTwinArray, '1', '2');
        //one cell possible
        assertEquals(cellCombinations.size(), 1);

        Cell cell2 = new Cell('2', 0, 1);
        cell2.addPotentialValue('1');
        cell2.addPotentialValue('2');
        possibleHiddenTwinArray.add(cell2);

        cellCombinations = hiddenTwinRow.findTwinCombinations(possibleHiddenTwinArray, '1', '2');
        //two cells possible
        assertEquals(cellCombinations.size(), 2);

        Cell cell3 = new Cell('3', 0, 2);
        cell3.addPotentialValue('1');
        possibleHiddenTwinArray.add(cell3);

        cellCombinations = hiddenTwinRow.findTwinCombinations(possibleHiddenTwinArray, '1', '2');
        assertEquals(cellCombinations.size(), 2);

        cell3.addPotentialValue('2');
        cellCombinations = hiddenTwinRow.findTwinCombinations(possibleHiddenTwinArray, '1', '2');
        //three cells possible
        assertEquals(cellCombinations.size(), 3);
    }

}
