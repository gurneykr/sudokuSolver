import java.util.ArrayList;
import java.util.List;

public abstract class HiddenTwin implements Solver {

    protected List<Cell> findTwinCombinations(List<Cell> possibleHiddenTwinArray, char firstValue, char secondValue){
        //take the possible values from the board and make combinations

        List<Cell> twinCells = new ArrayList();

        for(int j = 0; j < possibleHiddenTwinArray.size(); j++){
            Cell cell = possibleHiddenTwinArray.get(j);
            if(containsPotentialValues(cell, firstValue, secondValue)){
                twinCells.add(cell);
            }
        }
        return twinCells;
    }

    protected boolean containsPotentialValues(Cell cell, char firstValue, char secondValue){
        int counter = 0;
        for(int i = 0; i < cell.getPotentialValues().size(); i++){
            if(cell.getPotentialValues().get(i).equals(String.valueOf(firstValue))){
                counter++;
            }
            if (cell.getPotentialValues().get(i).equals(String.valueOf(secondValue))){
                counter++;
            }
        }
        return counter == 2;
    }
}
