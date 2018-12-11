import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlockInfoTest {

    @Test
    public void testConstructor(){
        BlockInfo blockInfo = new BlockInfo(0, 1  , 2, true);
        assertEquals(blockInfo.getCol(), 1);
        assertEquals(blockInfo.getRow(), 0);
        assertEquals(blockInfo.getBlockNum(), 2);
        assertEquals(blockInfo.isFound(),true);
    }
}
