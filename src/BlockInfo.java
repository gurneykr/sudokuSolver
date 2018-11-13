public class BlockInfo {
    private int row;
    private int col;
    private int blockNum;
    private boolean found = false;

    public BlockInfo(int row, int col, int blockNum, boolean found) {
        this.row = row;
        this.col = col;
        this.blockNum = blockNum;
        this.found = found;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
