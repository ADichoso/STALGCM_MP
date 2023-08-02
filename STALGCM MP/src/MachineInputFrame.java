import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;

public class MachineInputFrame extends JFrame{
    public MachineInputFrame()
    {
        super();
        //Basic JFrame attributes
        setName("Get Machine Definition File");
        setLayout(new BorderLayout());
        setSize(400, 500);


        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
        
        add(fileChooser, BorderLayout.CENTER);
    }
    
}
