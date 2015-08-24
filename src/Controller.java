
import java.util.ArrayList;

public class Controller {

    public Controller() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        
        // later change format to use chars
        
        String inputFile = args[0];
        String outputFile = args[1];
        
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> ignore = new ArrayList<>();
        
        InputReader ir = new InputReader(inputFile);
        titles = ir.getTitles();
        ignore = ir.getIgnoreWords();
        
        DataStorage ds = new DataStorage(ir);
        
        CircularShifter cs = new CircularShifter(ds);
        cs.setup();
        
        Alphabetizer a = new Alphabetizer(cs.getCircularShifts());
        for (int i = 0; i < a.getSortedShifts().size(); i++) {
            System.out.println(a.getSortedShifts().get(i));
        }
        
        OutputPrinter op = new OutputPrinter(outputFile, a.getSortedShifts());
        op.writeFile(outputFile);

    }

}
