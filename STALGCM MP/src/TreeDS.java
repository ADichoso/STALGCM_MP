//Tree Data Structure
import java.util.LinkedList;
import java.util.List;
public class TreeDS 
{
    private Transition value;
    private List<TreeDS> childNodes;

    public TreeDS() 
    {
        this.value = null;
        this.childNodes = new LinkedList<>();
    }
    
    public TreeDS(Transition value) 
    {
        this.value = value;
        this.childNodes = new LinkedList<>();
    }

    public void addChild(TreeDS childNode) {
        this.childNodes.add(childNode);
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