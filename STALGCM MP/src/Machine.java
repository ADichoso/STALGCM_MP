import java.util.ArrayList;

public class Machine {

    private ArrayList<State> Q; //finite set of states
    private ArrayList<Character> E; //input alphabet
    private ArrayList<Character> Gamma; //stack alphabet
    private ArrayList<Transition> Delta; //the transition relation
    private State q0; //start state
    private char Z1;// the initial stack symbol
    private char Z2;// the initial stack symbol
    private ArrayList<State> F; //list of accepting states.
    private Stack stack1; //first stack
    private Stack stack2; //second stack

    private TreeDS root; //root of the tree datastructure

    public Machine(ArrayList<State> Q, ArrayList<Character> E, ArrayList<Character> Gamma, ArrayList<Transition> Delta, State q0, char Z1, char Z2, ArrayList<State> F) {
        this.Q = Q;
        this.E = E;
        this.Gamma = Gamma;
        this.Delta = Delta;
        this.q0 = q0;
        this.Z1 = Z1;
        this.Z2 = Z2;
        this.F = F;

        stack1 = new Stack(Z1);
        stack2 = new Stack(Z2);

        root = new TreeDS();
    }

    public boolean run(ArrayList<Character> inputString)
    {
        //WARNING: NOT OPTIMIZED FOR GUI (yet)
        //loop through arraylist transition, if transition has same start state, continue with function
        for (Transition transition: Delta)
        {
            if (transition.getCurrentState() == q0)
            {
                //if it finds a transition function from the start state, being searching.
                checkPath (transition.getCurrentState(), inputString, 0, root, transition);
            }
            //loop through the connections
        }
        return true;
    }

    public void checkPath (State currentState, ArrayList<Character> inputString, int index, TreeDS currentNode, Transition currentTransition)
    {
        //make new child node for the current transition function
        TreeDS nextNode = new TreeDS(currentTransition);

        //append it to the tree
        currentNode.addChild(nextNode);

        for(Transition transition: Delta) {
            //if the current state of the transition is the same as the target state of the current transition, it means that it is the next step to check
            if (transition.getCurrentState() == currentTransition.getTargetState()) {
                boolean accepted = transition.replace(stack1, stack2, inputString.get(index));
                if(accepted) {
                    checkPath(transition.getTargetState(), inputString, index + 1, nextNode, transition);                
                }
            } 
        }
    }

    public void printMachine() {
        System.out.println("Q: " + Q);
        System.out.println("E: " + E);
        System.out.println("Gamma: " + Gamma);
        System.out.println("Delta: ");
        for (Transition transition : Delta) {
            transition.printTransition();
        }
        System.out.println("q0: " + q0);
        System.out.println("Z1: " + Z1);
        System.out.println("Z2: " + Z2);
        System.out.println("F: " + F);
    }
    public TreeDS getTree ()
    {
        return root;
    }
}
