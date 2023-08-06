import javax.swing.*;

import java.awt.*;
public class TransitionPanel extends JPanel{

    public TransitionPanel(TreeDS treeNode, String currentInputString, boolean isParentRoot, String initialStateName)
    {
        super();
        //Basic JPanel attributes
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(330, 100));
        

        //Text to describe
        String transitionText = "Transition Function: " + treeNode.getValue().showTransition();
        JLabel transitionLabel = new JLabel(transitionText, SwingConstants.CENTER);
        
        System.out.println("==============EXPANDED============");
        if(!isParentRoot) System.out.println(treeNode.getParent().getValue().showTransition());
        else System.out.println("No parent Root");
        System.out.println(treeNode.getValue().showTransition());
        System.out.println("==============++++++++============");
        
        String stateText = ""; 
        if(isParentRoot)
            stateText = "Starting at " + initialStateName;
        else
            stateText = "Went from " + treeNode.getParent().getValue().getCurrentState().getName() + "->" + treeNode.getValue().getCurrentState().getName();
        JLabel stateLabel = new JLabel(stateText, SwingConstants.CENTER);

        String stack1Text = "Stack 1 Contents: " + treeNode.getStack(1).showStack();
        JLabel stack1Label = new JLabel(stack1Text, SwingConstants.CENTER);

        String stack2Text = "Stack 2 Contents: " + treeNode.getStack(2).showStack();
        JLabel stack2Label = new JLabel(stack2Text, SwingConstants.CENTER);

        String inputStringText = "Current Input: " + currentInputString;
        JLabel inputStringLabel = new JLabel(inputStringText, SwingConstants.CENTER);
        add(transitionLabel);
        add(stateLabel);
        add(stack1Label);
        add(stack2Label);
        add(inputStringLabel);


        if(!treeNode.isLeaf())
        {
            //Color with NonLeaf color
            setBackground(new Color(159, 159, 203));
        } 
        else
        {
            //Either Accepted (Green) or Rejected (Red)
            if(treeNode.isAccepted())
                setBackground(new Color(144, 224, 144));
            else
                setBackground(new Color(232, 120, 120));
        } 
        setVisible(true);
    }
}
