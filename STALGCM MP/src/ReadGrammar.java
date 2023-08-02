//read the grammar from txt file (im not sure if it is called grammar)

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadGrammar
{
    //Goal: return machine

    private String path;

    public ReadGrammar(String path) {
        this.path = path;
    }

    //Reads the grammar of the text file; Refer to template.txt for the format
    public Machine loadGrammar() throws IOException
    {
        char currentChar;
        //reads the file
        FileReader input = null;
        
        input = new FileReader(path);
        Scanner s = new Scanner(input);
        


        //2-stack pda definition
        ArrayList<State> Q = new ArrayList<State>();
        ArrayList<Character> E = new ArrayList<Character>();
        ArrayList<Character> Gamma = new ArrayList<Character>();
        ArrayList<Transition> Delta = new ArrayList<Transition>();
        State q0 = null;
        char Z1 = 'Z';
        char Z2 = 'Z';
        ArrayList<State> F = new ArrayList<State>();

        //states
        int stateAmount = s.nextInt();
        System.out.println(stateAmount);

        for (int i = 0; i < stateAmount; i++)
        {
            char stateName = s.next().charAt(0);
            State state = new State(Character.toString(stateName));
            Q.add(state);
            System.out.println(stateName);
        }

        //input alphabet
        int inputAlphabetAmount = s.nextInt();
        System.out.println(inputAlphabetAmount);

        for (int i = 0; i < inputAlphabetAmount; i++)
        {
            char inputAlphabet = s.next().charAt(0);
            E.add(inputAlphabet);
            System.out.println(inputAlphabet);
        }

        //2 initial stack symbols
        Z1 = s.next().charAt(0);
        System.out.println(Z1);
        Z2 = s.next().charAt(0);
        System.out.println(Z2);

        //stack alphabet
        int stackAlphabetAmount = s.nextInt();
        System.out.println(stackAlphabetAmount);
        for(int i = 0; i < stackAlphabetAmount; i++)
        {
            char stackAlphabet = s.next().charAt(0);
            Gamma.add(stackAlphabet);
            System.out.println(stackAlphabet);
        }

        //transition functions
        int transitionAmount = s.nextInt();
        System.out.println(transitionAmount);

        for (int i = 0; i < transitionAmount; i++)
        {
            char currentStateName = s.next().charAt(0);
            char inputSymbol = s.next().charAt(0);
            char stack1Symbol = s.next().charAt(0); //top of stack1
            char stack2Symbol = s.next().charAt(0); //top of stack2
            char targetStateName = s.next().charAt(0);
            String stack1Push = s.next();
            String stack2Push = s.next();

            ArrayList <Character> stack1PushArray = Utilities.stringToCharArrayList(stack1Push);
            ArrayList <Character> stack2PushArray = Utilities.stringToCharArrayList(stack2Push);

            State currentState = null;
            State targetState = null;

            for (State state : Q)
            {
                if (state.getName().equals(Character.toString(currentStateName)))
                {
                    currentState = state;
                }
                if (state.getName().equals(Character.toString(targetStateName)))
                {
                    targetState = state;
                }
            }
            Transition transition = new Transition(currentState, targetState, inputSymbol, stack1Symbol, stack2Symbol, stack1PushArray, stack2PushArray);
            Delta.add(transition);
        }

        //start state
        char startStateName = s.next().charAt(0);
        System.out.println(startStateName);

        for (State state : Q)
        {
            if (state.getName().equals(Character.toString(startStateName)))
            {
                q0 = state;
                break;
            }
        }

        //final states
        int finalStateAmount = s.nextInt();
        System.out.println(finalStateAmount);

        for (int i = 0; i < finalStateAmount; i++)
        {
            char finalStateName = s.next().charAt(0);
            System.out.println(finalStateName);

            for (State state : Q)
            {
                if (state.getName().equals(Character.toString(finalStateName)))
                {
                    F.add(state);
                }
            }
        }
        


        input.close();

        return new Machine(Q, E, Gamma, Delta, q0, Z1, Z2, F);
    }
    
}