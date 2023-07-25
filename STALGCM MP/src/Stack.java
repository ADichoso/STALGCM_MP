import java.util.ArrayList;

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
        return stack.get(stack.size() - 1);
    }

    //push by removing the top of the stack and adding the new symbol
    public void push (ArrayList<Character> symbol)
    {
        stack.remove(stack.size() - 1);
        stack.addAll(symbol);
    }

    public boolean isEmpty()
    {
        return stack.size() == 0;
    }

}