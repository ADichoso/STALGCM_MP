import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame{

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
    public MainFrame()
    {
        super();
        //Basic JFrame attributes
        setName("2-Stack Pushdown Automata");
        setLayout(new BorderLayout());
        setSize(720, 540);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("2-Stack Pushdown Automata Reader");

        topPanel.add(titleLabel);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(255, 0, 0)); 
        centerPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel startStateLabel = new JLabel("Start State:", SwingConstants.CENTER);
        JLabel statesLabel = new JLabel("States: {}", SwingConstants.CENTER);
        JLabel inputAlphabetLabel = new JLabel("Input Alphabet: {}", SwingConstants.CENTER);
        JLabel stackAlphabetLabel = new JLabel("Stack Alphabet: {}", SwingConstants.CENTER);

        String data[][] = 
        {
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" },
            {"a", "b", "c", "a" }
        };

        String column[] = {"w", "z", "y", "w"};

        JTable transitionTable = new JTable(data, column);
        transitionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JLabel transitionLabel = new JLabel("Transition Table:", SwingConstants.CENTER);

        JLabel finalStateLabel = new JLabel("Final State/s: {}", SwingConstants.CENTER);

        startStateLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        statesLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        inputAlphabetLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        stackAlphabetLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        transitionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        transitionTable.setBorder(BorderFactory.createLineBorder(Color.black));
        finalStateLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        contentPanel.add(startStateLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(statesLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(inputAlphabetLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(stackAlphabetLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(finalStateLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(transitionLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(transitionTable);
        
        
        JScrollPane scrollableArea = new JScrollPane(contentPanel);  
  
        scrollableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 

        centerPanel.add(scrollableArea);

        JPanel bottomButtonPanel = new JPanel();
        bottomButtonPanel.setOpaque(false);

        //This one will get the input string
        JTextField inputStringTextField = new JTextField();
        inputStringTextField.setColumns(16);

        //This one will submit the input string for reading
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
        
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomButtonPanel, BorderLayout.SOUTH);

        setVisible(true);

        int scrollMidValue = scrollableArea.getHorizontalScrollBar().getMaximum() / 3;
        scrollableArea.getHorizontalScrollBar().setValue(scrollMidValue);
    }
}
