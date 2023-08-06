//Tree Data Structure
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class TreeDS 
{
    private Transition value;
    private ArrayList<Character> inputString;
    private int inputStringIndex = 0;
    private boolean accepted = false;
    private boolean isLeaf = true;
    private List<TreeDS> childNodes;
    private TreeDS parent;
    private Stack stack1;
    private Stack stack2;

    public TreeDS() 
    {
        this.value = null;
        this.childNodes = new LinkedList<>();
        this.parent = null;
        
    }
    
    public TreeDS(Transition value, Stack stack1, Stack stack2, ArrayList<Character> inputString, int index) 
    {
        this.value = value;
        this.childNodes = new LinkedList<>();
        this.parent = null;
        this.stack1 = new Stack(stack1);
        this.stack2 = new Stack(stack2);
        this.inputString = (ArrayList<Character>) inputString.clone();
        this.inputStringIndex = index;
        // System.out.println("STACK for the new node");
        // stack1.printStack();
        // stack2.printStack();
    }

    public void addChild(TreeDS childNode) {
        childNode.setParent(this);
        this.childNodes.add(childNode);
        isLeaf = false;
    }

    public TreeDS getParent() {
        return parent;
    }

    public List<TreeDS> getChildren()
    {
        return childNodes;
    }

    public Transition getValue() {
        return value;
    }

    public void setParent(TreeDS parent) {
        this.parent = parent;
    }

    public void printValue()
    {
        value.printTransition();
    }
    public boolean isLeaf()
    {
        return isLeaf;
    }

    public void setAccepted()
    {
        accepted = true;
    }
    
    public boolean isAccepted()
    {
        return accepted;
    }

    public Stack getStack(int stackNumber)
    {
        if (stackNumber == 1)
        {
            return stack1;
        }
        else
        {
            return stack2;
        }
    }
}