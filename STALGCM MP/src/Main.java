import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        float number = 1 + 1.0f;
        System.out.println("Hello world!" + number);
        
        MainFrame frame = new MainFrame();
        TracingFrame childFrame = new TracingFrame();

        //For testing the machine
        ReadGrammar grammar = new ReadGrammar("STALGCM MP\\src\\testinput.txt");
        Machine machine = grammar.loadGrammar();
        machine.printMachine();

        System.out.println("RESULT: " + machine.run(Utilities.stringToCharArrayList("11")));
        
    }
}