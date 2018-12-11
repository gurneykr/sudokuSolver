import java.util.ArrayList;
import java.util.List;

public class Cell {
    private char value;
    private List<String> potentialValuesList = new ArrayList();
    private int row;
    private int col;

    public Cell(char value, int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public List<String> getPotentialValues() {
        return potentialValuesList;
    }

    public void addPotentialValue(char potentialValue) {

        this.potentialValuesList.add(String.valueOf(potentialValue));
    }

    public void resetPotentialValues() { potentialValuesList = new ArrayList(); }

    public void removePotentialValue(char potentialValue){
        for(int i = 0; i < potentialValuesList.size(); i++){
            if(potentialValuesList.get(i).equals(String.valueOf(potentialValue))){
                potentialValuesList.remove(i);
                break;
            }
        }
    }
}
