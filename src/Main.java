import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
    Cell cell = new Cell();

    public static void main(String[] args)throws Exception {


        if(args.length == 0){
            System.out.println("You must provide a text file");
            System.exit(1);
        }
        Board board = new Board();
        board.loadBoard(args[0]);

        if(args.length == 1){
            if(args[0].equals("-h")){
                System.out.println("Provide input file and/or output file: <input file name> <output file name>");
            }
        }
        if(args.length == 2) {
            PrintStream o = new PrintStream(args[1]);
            System.setOut(o);
        }
        System.out.println(board.getBoardSize());
        board.printBoard();

        long startTime = System.currentTimeMillis();
        List<SolverInfo> solverInfoList = board.solve();
        long endTime = System.currentTimeMillis();

        board.isSolved();

        System.out.println("Solution:");
        board.printBoard();
        System.out.println();
        System.out.println();

        String  title = String.format("%-24s %-10s %-10s", "Strategy", "Uses", "Time");

        System.out.println(title);
        //System.out.println("           Strategy          Uses           Time");

        solverInfoList.forEach((solverInfo)->{
            String solvers = String.format("%-24s %2d   %02d:%02d:%02d.%d",
                    solverInfo.getSolverName(),
                    solverInfo.getTimesUsed(),
                    TimeUnit.MILLISECONDS.toHours(solverInfo.getSolverTime()),
                    TimeUnit.MILLISECONDS.toMinutes(solverInfo.getSolverTime()) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(solverInfo.getSolverTime())),
                    TimeUnit.MILLISECONDS.toSeconds(solverInfo.getSolverTime()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(solverInfo.getSolverTime())),
                    solverInfo.getSolverTime());
            System.out.println(solvers);
        });



        long millis = endTime - startTime;

        String hms = String.format("%-17s %02d:%02d:%02d.%d",
                " ",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                millis);
        System.out.println("Total Time: " + hms);
    }
}
