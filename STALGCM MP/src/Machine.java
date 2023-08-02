import java.util.ArrayList;

public class Machine {

    public ArrayList<State> Q; //finite set of states
    public ArrayList<Character> E; //input alphabet
    public ArrayList<Character> Gamma; //stack alphabet
    public ArrayList<Transition> Delta; //the transition relation
    public State q0; //start state
    public char Z1;// the initial stack symbol
    public char Z2;// the initial stack symbol
    public ArrayList<State> F; //list of accepting states.
    public Stack stack1; //first stack
    public Stack stack2; //second stack

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
                stack1 = new Stack(Z1);
                stack2 = new Stack(Z2);
                System.out.println("START RUNNING ============================================");
                //if it finds a transition function from the start state, being searching.
                checkPath (transition.getCurrentState(), inputString, 0, root, transition, stack1, stack2);
            }
            //loop through the connections
        }
        return true;
    }

    public void checkPath (State currentState, ArrayList<Character> inputString, int index, TreeDS currentNode, Transition currentTransition, Stack stack1, Stack stack2)
    {
        Stack oldStack1 = new Stack(stack1);
        Stack oldStack2 = new Stack(stack2);
        for(Transition transition: Delta) {

            //if the current state of the transition is the same as the target state of the current transition, it means that it is the next step to check
            if (transition.getCurrentState() == currentState && inputString.size() > index) {

                //make new child node for the current transition function
                TreeDS nextNode = new TreeDS(transition);
                System.out.println(index);
                nextNode.printValue();
                //append it to the tree
                currentNode.addChild(nextNode);
                stack1.printStack();
                stack2.printStack();
                boolean accepted = transition.replace(stack1, stack2, inputString.get(index));
                stack1.printStack();
                stack2.printStack();
                System.out.println(accepted);

                if(accepted) {
                    checkPath(transition.getTargetState(), inputString, index + 1, nextNode, transition, stack1, stack2);              
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
