import javax.swing.*;
import java.awt.*;
public class TracingFrame extends JFrame
{
    public TracingFrame()
    {
        super();
        //Basic JFrame attributes
        setName("2-Stack PDA Tracing");
        setLayout(new BorderLayout());
        setSize(360, 720);
        setResizable(false);
        
        setBackground(new Color(0, 127, 127));

        JPanel topButtonPanel = new JPanel();
        topButtonPanel.setSize(360, 60);
        topButtonPanel.setLayout(new FlowLayout());
        JLabel iterationsLabel = new JLabel("Iterations: 69");
        JLabel expandedNodesLabel = new JLabel("Expanded Nodes: 420");

        topButtonPanel.add(iterationsLabel);
        topButtonPanel.add(expandedNodesLabel);

        add(topButtonPanel, BorderLayout.NORTH);

        JPanel transitionsPanel = new JPanel();
        transitionsPanel.setSize(360, 600);
        transitionsPanel.setLayout(new FlowLayout());
        
        for(int i = 0; i < 5; i++)
            transitionsPanel.add(new TransitionPanel());
        
        add(transitionsPanel, BorderLayout.CENTER);

        JPanel bottomButtonPanel = new JPanel();
        bottomButtonPanel.setSize(360, 60);
        bottomButtonPanel.setLayout(new FlowLayout());
        JButton previousStatesButton = new JButton("Previous Iteration");
        JButton nextStatesButton = new JButton("Next Iteration");

        bottomButtonPanel.add(previousStatesButton);
        bottomButtonPanel.add(nextStatesButton);

        add(bottomButtonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
