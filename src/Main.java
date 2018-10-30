import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    Cell cell = new Cell();

    public static void main(String[] args)throws Exception {
        if(args.length == 0){
            System.out.println("You must provide a text file");
            System.exit(1);
        }
        Board board = new Board();
        board.loadBoard(args[0]);
    }


}
