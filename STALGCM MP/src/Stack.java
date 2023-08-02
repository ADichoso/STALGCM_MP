import java.util.ArrayList;
import java.util.Collections;

public class Stack
{
    private ArrayList<Character> stack;
    public char initialSymbol = 'Z';

    public Stack()
    {
        stack = new ArrayList<Character>();
        stack.add(initialSymbol);
    }

    //for custom pushdown symbol
    public Stack(char initialSymbol)
    {
        stack = new ArrayList<Character>();
        stack.add(initialSymbol);
    }

    public char getTopOfStack()
    {
        System.out.println("Top of Stack: " + stack.get(0));
        return stack.get(0);
    }

    //push by removing the top of the stack and adding the new symbol
    public void push (ArrayList<Character> symbol)
    {
        stack.remove(0);
        stack.addAll(0,symbol);
    }

    public boolean isEmpty()
    {
        return stack.size() == 0;
    }

    public void printStack()
    {
        System.out.println(stack);
    }

}