import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class TransitionPanel extends JPanel{

    //Converts a string into an arraylist of characters
    public ArrayList<Character> stringToArrayList(String oldString)
    {
        ArrayList<Character> newStringList = new ArrayList<Character>();
        //Loop through the characters in the string
        for(int i = 0; i < oldString.length(); i++)
            newStringList.add(0, oldString.charAt(i));
        
        return newStringList;
    }

    public ArrayList<Character> currInputList;
    public TransitionPanel()
    {
        super();
        //Basic JPanel attributes
        setLayout(new BorderLayout());
        setSize(360, 90);

        //Text to describe 
        JLabel transitionText = new JLabel("");
        add(transitionText);
        setVisible(true);
    }
}
