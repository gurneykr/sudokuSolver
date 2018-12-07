import java.util.ArrayList;
import java.util.List;

public class Cell {
    private char value;
    private List<String> potentialValuesList = new ArrayList();

    public Cell(char value){
        this.value = value;
    }
    public Cell(){

    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public List<String> getPotentialValues() {
        return potentialValuesList;
    }

    public void addPotentialValue(char potentialValue) {

        this.potentialValuesList.add(String.valueOf(potentialValue));
    }

    public void resetPotentialValues() { potentialValuesList = new ArrayList(); }
}
