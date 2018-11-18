public class SolverInfo {

    String solverName;

    public SolverInfo(String solverName) {
        this.solverName = solverName;
    }

    long solverTime;
    int timesUsed;

    public long getSolverTime() {
        return solverTime;
    }

    public void setSolverTime(long solverTime) {
        this.solverTime = solverTime;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public String getSolverName() {
        return solverName;
    }

    public void setSolverName(String solverName) {
        this.solverName = solverName;
    }
}
