import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.IOException;
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

    private ArrayList<ArrayList<String>> machineData[][];
    private ArrayList<String> machineColumn[];

    private JButton machineFileButton;
    private JLabel startStateLabel;
    private JLabel statesLabel;
    private JLabel inputAlphabetLabel;
    private JLabel stackAlphabetLabel;
    private JTable transitionTable;
    private DefaultTableModel transitionTableModel;
    private JLabel transitionLabel;
    private JLabel finalStateLabel;

    private Machine currMachine;
    private String filename;
    private ReadGrammar readGrammar;

    private boolean currResult = false;
    private TracingFrame childFrame;
    public MainFrame()
    {
        super();
        //Basic JFrame attributes
        setName("2-Stack Pushdown Automata");
        setLayout(new BorderLayout());
        setSize(720, 540);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        childFrame = new TracingFrame();

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("2-Stack Pushdown Automata Reader");
        machineFileButton = new JButton("Input Machine File");
        
        machineFileButton.addActionListener(e -> 
        {
            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    generateMachine(fileChooser.getSelectedFile().getPath());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("Cancel was selected");
            }
        });

        topPanel.add(machineFileButton);
        topPanel.add(titleLabel);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(255, 0, 0)); 
        centerPanel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        startStateLabel = new JLabel("Start State:", SwingConstants.CENTER);
        statesLabel = new JLabel("States: {}", SwingConstants.CENTER);
        inputAlphabetLabel = new JLabel("Input Alphabet: {}", SwingConstants.CENTER);
        stackAlphabetLabel = new JLabel("Stack Alphabet: {}", SwingConstants.CENTER);
        transitionLabel = new JLabel("Transition Table:", SwingConstants.CENTER);
        finalStateLabel = new JLabel("Final State/s: {}", SwingConstants.CENTER);

        startStateLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));
        statesLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));
        inputAlphabetLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));
        stackAlphabetLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));
        transitionLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));
        finalStateLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 14));

        transitionTableModel = new DefaultTableModel();

        transitionTable = new JTable(transitionTableModel);
        transitionTable.setRowHeight(20);

        transitionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

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
            if(currMachine != null)
            {
                String input = inputStringTextField.getText();
                if(!input.equals(""))
                {
                    currInputList = stringToArrayList(input);
                    currResult = currMachine.run(currInputList);

                    inputStringTextField.setText("");
                    childFrame.passResults(currMachine, currResult);
                }
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

        
        String data[] = {"Transition Functions"};
        transitionTableModel.addColumn("Transition Functions", data);
    }

    
    private void generateMachine(String filepath) throws IOException
    {
        filename = filepath;
        System.out.println(filename);

        readGrammar = new ReadGrammar(filename);
        currMachine = readGrammar.loadGrammar();

        updateMachineInfo();
    }

    private void updateMachineInfo()
    {
        //Show Info of states
        startStateLabel.setText("Start State: " + currMachine.Q.get(0).getName());

        //List of States
        String statesText = "States: {";
        for(int i = 0; i < currMachine.Q.size(); i++)
        {
            statesText += currMachine.Q.get(i).getName();

            if(i < currMachine.Q.size() - 1)
                statesText += ", ";
            else
                statesText += "}";
        }
        statesLabel.setText(statesText);

        //Input Alphabet
        String inputAlphabetText = "Input Alphabet: {";
        for(int i = 0; i < currMachine.E.size(); i++)
        {
            inputAlphabetText += currMachine.E.get(i);

            if(i < currMachine.E.size() - 1)
                inputAlphabetText += ", ";
            else
                inputAlphabetText += "}";
        }
        inputAlphabetLabel.setText(inputAlphabetText);

        //Stack Alphabet
        String stackAlphabetText = "Stack Alphabet: {";
        for(int i = 0; i < currMachine.Gamma.size(); i++)
        {
            stackAlphabetText += currMachine.Gamma.get(i);

            if(i < currMachine.Gamma.size() - 1)
                stackAlphabetText += ", ";
            else
                stackAlphabetText += "}";
        }
        stackAlphabetLabel.setText(stackAlphabetText);

        //Final States
        String finalStatesText = "Final State/s: {";
        for(int i = 0; i < currMachine.F.size(); i++)
        {
            finalStatesText += currMachine.F.get(i).getName();

            if(i < currMachine.F.size() - 1)
                finalStatesText += ", ";
            else
                finalStatesText += "}";
        }
        finalStateLabel.setText(finalStatesText);

        // Set transition function for transitionTable;
        for(int i = 0; i < currMachine.Delta.size(); i++)
        {
            String rowData[] = {currMachine.Delta.get(i).showTransition()};
            transitionTableModel.insertRow(1 + i, rowData);
        }
    }
}
