//Tree Data Structure
import java.util.LinkedList;
import java.util.List;
public class TreeDS 
{
    private Transition value;
    private boolean accepted = false;
    private boolean isLeaf = true;
    private List<TreeDS> childNodes;
    private TreeDS parent;

    public TreeDS() 
    {
        this.value = null;
        this.childNodes = new LinkedList<>();
        this.parent = null;
        
    }
    
    public TreeDS(Transition value) 
    {
        this.value = value;
        this.childNodes = new LinkedList<>();
        isLeaf = true;
    }

    public void addChild(TreeDS childNode) {
        childNode.parent = this;
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
}