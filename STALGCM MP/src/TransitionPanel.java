import javax.swing.*;

import java.awt.*;
public class TransitionPanel extends JPanel{

    public TransitionPanel(Transition transition)
    {
        super();
        //Basic JPanel attributes
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(330, 36));
        setBackground(new Color(0, 255, 127));

        //Text to describe 
        JLabel transitionText = new JLabel(transition.showTransition(), SwingConstants.CENTER);
        add(transitionText, BorderLayout.NORTH);
        setVisible(true);
    }
}
