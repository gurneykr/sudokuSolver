import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void testRemovePotentialValue(){
        Cell cell = new Cell('1', 0, 0);
        cell.addPotentialValue('1');
        cell.addPotentialValue('2');
        cell.addPotentialValue('3');
        cell.removePotentialValue('2');
        assertEquals(cell.getPotentialValues().size(), 2);
        assertEquals(cell.getPotentialValues().get(0), "1");
        assertEquals(cell.getPotentialValues().get(1), "3");
    }
}
