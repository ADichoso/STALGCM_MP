import java.util.ArrayList;

public class Machine {

    private ArrayList<State> Q; //finite set of states
    private String E; //input alphabet
    private String Gamma; //stack alphabet
    private ArrayList<Transition> Delta; //the transition relation
    private State q0; //start state
    private char Z1;// the initial stack symbol
    private char Z2;// the initial stack symbol
    private ArrayList<State> F; //list of accepting states.


    public Machine(ArrayList<State> Q, String E, String Gamma, ArrayList<Transition> Delta, State q0, char Z1, char Z2, ArrayList<State> F) {
        this.Q = Q;
        this.E = E;
        this.Gamma = Gamma;
        this.Delta = Delta;
        this.q0 = q0;
        this.Z1 = Z1;
        this.Z2 = Z2;
        this.F = F;
    }

    

}
