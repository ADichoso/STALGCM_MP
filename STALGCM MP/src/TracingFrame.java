import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class TracingFrame extends JFrame{

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
    public TracingFrame()
    {
        super();
        //Basic JFrame attributes
        setName("2-Stack PDA Tracing");
        setLayout(new BorderLayout());
        setSize(360, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        
        add(centerPanel);
        setVisible(true);
    }
}
