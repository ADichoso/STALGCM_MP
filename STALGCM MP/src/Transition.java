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
    public Transition(State currenState, State targetState, char input, char topOfStack1, char topOfStack2, ArrayList<Character> pushToStack1, ArrayList<Character> pushToStack2)
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
    //also the input character must match the input defined in the transition function
    public boolean replace(Stack stack1, Stack stack2, char input)
    {
        if ((topOfStack1 == stack1.getTopOfStack() || (topOfStack1 == '&')) && (topOfStack2 == stack2.getTopOfStack() || topOfStack2 == '&') && input == this.input)
        {
            //System.out.println("Push to Stack 1: " + pushToStack1.get(0));
            if (!pushToStack1.contains('&'))
            {
                if (topOfStack1 != '&')
                {
                    stack1.push(pushToStack1);
                } else {
                    stack1.pushFromLambda(pushToStack1);
                }

            } else {
                if (topOfStack1 != '&')
                {
                    stack1.pop();
                }
            }
            
            if (!pushToStack1.contains('&'))
            {
                if (topOfStack2 != '&')
                {
                    stack2.push(pushToStack2);
                } else {
                    stack2.pushFromLambda(pushToStack2);
                }
            } else {
                if (topOfStack2 != '&')
                {
                    stack2.pop();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void printTransition()
    {
        System.out.println(showTransition());
    }

    public String showTransition()
    {
        return "δ(" + currentState.getName() + ", " + input + ", " + topOfStack1 + ", " + topOfStack2 + ") = (" + targetState.getName() + ", " + pushToStackToString(pushToStack1) + ", " + pushToStackToString(pushToStack2) + ")";
    }

    private String pushToStackToString(ArrayList<Character> pushToStack)
    {
        String stackString = "";

        for(Character c : pushToStack)
            stackString += c;
        
        return stackString;
    }
}
