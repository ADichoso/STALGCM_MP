import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        float number = 1 + 1.0f;
        System.out.println("Hello world!" + number);
        MainFrame frame = new MainFrame();
        TracingFrame childFrame = new TracingFrame();
        ReadGrammar grammar = new ReadGrammar("./testinput.txt");
        Machine machine = grammar.loadGrammar();

        machine.printMachine();

        machine.run(Utilities.stringToCharArrayList("111"));
        
    }


}