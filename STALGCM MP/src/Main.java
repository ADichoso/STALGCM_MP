import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        float number = 1 + 1.0f;
        System.out.println("Hello world!" + number);
        ReadGrammar grammar = new ReadGrammar("testinput.txt");
        Machine machine = grammar.loadGrammar();

        
        MainFrame frame = new MainFrame();
        TracingFrame childFrame = new TracingFrame();   

        frame.setMachine(machine);
        machine.printMachine();

        machine.run(Utilities.stringToCharArrayList("111"));
        
    }
}