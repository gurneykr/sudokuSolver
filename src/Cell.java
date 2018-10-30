public class Cell {
    private char value;
    private char potentialValues[];

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

    public char[] getPotentialValues() {
        return potentialValues;
    }

    public void setPotentialValues(char[] potentialValues) {
        this.potentialValues = potentialValues;
    }
}
