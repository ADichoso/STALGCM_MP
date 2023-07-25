import java.util.ArrayList;

public class Transition
{
    private State currentState;
    private char input = '\0';
    private char topOfStack1 = '\0';
    private char topOfStack2 = '\0';

    private State targetState;
    private ArrayList<Character> pushToStack1 = new ArrayList<>();
    private ArrayList<Character> pushToStack2 = new ArrayList<>();

    //δ( q0, a, Z, Z ) = { ( q0, AZ, AZ ) } 
    //δ( currentState, input, topOfStack1, topOfStack2 ) = { ( targetState, pushToStack1, pushToStack2 ) } 
    public Transition (State currenState, State targetState, char input, char topOfStack1, char topOfStack2, ArrayList<Character> pushToStack1, ArrayList<Character> pushToStack2)
    {
        this.currentState = currenState;
        this.targetState = targetState;
        this.input = input;
        this.topOfStack1 = topOfStack1;
        this.topOfStack2 = topOfStack2;
        this.pushToStack1 = pushToStack1;
        this.pushToStack2 = pushToStack2;
    }

    public State getCurrentState()
    {
        return currentState;
    }

    public State getTargetState()
    {
        return targetState;
    }

    public char getInput()
    {
        return input;
    }
    //replacing the top of stack with the pushToStack1 and pushToStack2
    //both conditions for the top of stacks must be true for the transition to operate
    public boolean replace(Stack stack1, Stack stack2)
    {
        if (topOfStack1 == stack1.getTopOfStack() && topOfStack2 == stack2.getTopOfStack())
        {
            stack1.push(pushToStack1);
            stack2.push(pushToStack2);
            return true;
        } else {
            return false;
        }
    }
}
