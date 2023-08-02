//Tree Data Structure
import java.util.LinkedList;
import java.util.List;
public class TreeDS 
{
    private Transition value;
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
    }

    public void addChild(TreeDS childNode) {
        childNode.parent = this;
        this.childNodes.add(childNode);
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

}