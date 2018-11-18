import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
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
        Map<String, Long> timerMap = board.solve();
        long endTime = System.currentTimeMillis();

        board.isSolved();

        System.out.println("Solution:");
        board.printBoard();
        System.out.println();
        System.out.println();

        timerMap.forEach((name,time)->{
            String solvers = String.format("%24s     %02d:%02d:%02d.%d",
                    name,
                    TimeUnit.MILLISECONDS.toHours(time),
                    TimeUnit.MILLISECONDS.toMinutes(time) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)),
                    TimeUnit.MILLISECONDS.toSeconds(time) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)),
                    time);
            System.out.println(solvers);
        });



        long millis = endTime - startTime;

        String hms = String.format("                 %02d:%02d:%02d.%d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                millis);
        System.out.println("Total Time: " + hms);
    }
}
