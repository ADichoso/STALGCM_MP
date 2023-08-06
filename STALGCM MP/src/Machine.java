import java.util.ArrayList;
import java.util.Collections;

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
        //Collections.reverse(inputString);
        root = new TreeDS();
        //WARNING: NOT OPTIMIZED FOR GUI (yet)
        //loop through arraylist transition, if transition has same start state, continue with function
        boolean result = false;
        for (Transition transition: Delta)
        {
            if (transition.getCurrentState() == q0)
            {

                stack1 = new Stack(Z1);
                stack2 = new Stack(Z2);
                
                
                System.out.println("Input String: " + inputString.toString());
                System.out.println("Current Input: " + inputString.get(0));
                System.out.println("=====================================================START OF START STATE ============================================");
                //if the first transition function is accepted, continue with the path, else ignore and move on.
                transition.printTransition();
                boolean accepted = transition.replace(stack1, stack2, inputString.get(0));
                stack1.printStack();
                stack2.printStack();

                TreeDS nextNode = new TreeDS(transition, stack1, stack2, inputString, 0);
                System.out.println(0);
                nextNode.printValue();
                //append it to the tree
                root.addChild(nextNode);

                if (accepted)
                {
                    result = checkPath (transition.getTargetState(), inputString, 1, nextNode, transition, stack1, stack2);
                }
                    
                if (result == true)
                {
                    System.out.println("ACCEPTED");
                    return true;
                }
            }
            //loop through the connections
        }
        return result;
    }

    public boolean checkPath (State currentState, ArrayList<Character> inputString, int index, TreeDS currentNode, Transition currentTransition, Stack stack1, Stack stack2)
    {
        boolean legal = false;
        System.out.println("=======================================================================");
        Stack oldStack1 = new Stack(stack1);
        Stack oldStack2 = new Stack(stack2);

        //if this is the last input, check if the current state is an accepting state
        if (inputString.size() - 1 == index && stack1.isEmpty() && stack2.isEmpty())
        {
            currentNode.setAccepted();
            return true;   
        }

        if (inputString.size() - 1 == index)
        {
            for (State state: F) {
                if (state.getName().equals(currentTransition.getCurrentState().getName())) {
                    currentNode.setAccepted();
                    return true;
                }
            }

        }
        //System.out.println("Current Input: " + inputString.get(index));
        //System.out.println("Current State: " + currentState.getName());
        for(Transition transition: Delta) {

            //if the transition function has the same current state as the parameter and the input string is still not empty
            if (transition.getCurrentState() == currentState) {

                
                // stack1.printStack();
                // stack2.printStack();
                //System.out.println(accepted);

                //attempt to replace the top of the stack with the input, returns false if the conditions stated in the transition function is not satisfied.
                boolean accepted = transition.replace(stack1, stack2, inputString.get(index));
                stack1.printStack();
                stack2.printStack();

                //make new child node for the current transition function
                TreeDS nextNode = new TreeDS(transition, stack1, stack2, inputString, index);
                System.out.println(index);
                nextNode.printValue();
                //append it to the tree
                currentNode.addChild(nextNode);

                //if the conditions of the transition function are satisfied and the two stacks are updated.
                if (accepted)
                {
                    //if transition takes in a lambda input, dont proceed with the next input but continue with the next transition function
                    if(transition.getInput() == '&' || inputString.size() <= index + 1)
                    {
                        legal = checkPath(transition.getTargetState(), inputString, index, nextNode, transition, stack1, stack2);
                    }
                    else
                    {
                        legal = checkPath(transition.getTargetState(), inputString, index + 1, nextNode, transition, stack1, stack2);              
                    }
                }

                if (legal) return legal;
                
                stack1 = new Stack(oldStack1);
                stack2 = new Stack(oldStack2);

            } 
        }

        return false;
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
