import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    public ArrayList<Character> stringToArrayList(String oldString)
    {
        ArrayList<Character> newStringList = new ArrayList<Character>();
        //Loop through the characters in the string
        for(int i = 0; i < oldString.length(); i++)
            newStringList.add(0, oldString.charAt(i));
        
        return newStringList;
    }

    public ArrayList<Character> currInputList;
    public MainFrame()
    {
        super();
        //Basic JFrame attributes
        setName("2-Stack Pushdown Automata");
        setLayout(new BorderLayout());
        setSize(720, 540);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topButtonPanel = new JPanel();
        topButtonPanel.setOpaque(false);

        add(topButtonPanel, BorderLayout.NORTH);

        JPanel bottomButtonPanel = new JPanel();
        bottomButtonPanel.setOpaque(false);

        JTextField inputStringTextField = new JTextField();
        inputStringTextField.setColumns(16);

        JButton inputStringSubmitButton = new JButton("Submit");
        inputStringSubmitButton.addActionListener(e ->
        {
            String input = inputStringTextField.getText();
            if(!input.equals(""))
            {
                ArrayList<Character> stringList = stringToArrayList(input);

                for(char inputChar : stringList)
                {
                    System.out.println(inputChar);
                }
                currInputList = stringList;
            }
        });
        bottomButtonPanel.add(inputStringTextField, BorderLayout.SOUTH);
        bottomButtonPanel.add(inputStringSubmitButton, BorderLayout.SOUTH);
        add(bottomButtonPanel, BorderLayout.SOUTH);

        setVisible(true);
        //nerd
    }
}
