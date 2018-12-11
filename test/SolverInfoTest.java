import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolverInfoTest {

    @Test
    public void testConstructor(){
        SolverInfo solverInfo = new SolverInfo("Solver1");
        assertEquals(solverInfo.getSolverName(), "Solver1");
    }
}
