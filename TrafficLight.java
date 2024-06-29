package LabFile;

import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends Frame implements ActionListener, WindowListener 
{
    private Label messageLabel;
    private Button redButton, yellowButton, greenButton, resetButton;
    
    
    public TrafficLight() 
    {
        setTitle("Traffic Light");
        setSize(300, 150);
        setLocationRelativeTo(null);
        
        Panel buttonPanel = new Panel();
        redButton = new Button("Red");
        redButton.addActionListener(this);
        buttonPanel.add(redButton);
        yellowButton = new Button("Yellow");
        yellowButton.addActionListener(this);
        buttonPanel.add(yellowButton);
        greenButton = new Button("Green");
        greenButton.addActionListener(this);
        buttonPanel.add(greenButton);
        
        add(buttonPanel, BorderLayout.CENTER);
        
        Panel messagePanel = new Panel();
        messagePanel.setBackground(Color.BLACK);
        messagePanel.setLayout(new BorderLayout());
        messageLabel = new Label("", Label.CENTER);
        messageLabel.setFont(new Font("Dialog", Font.BOLD, 36));
        messagePanel.add(messageLabel, BorderLayout.CENTER);

        Panel leftPanel = new Panel();
        leftPanel.setBackground(Color.BLACK);
        messagePanel.add(leftPanel, BorderLayout.WEST);

        Panel rightPanel = new Panel();
        rightPanel.setBackground(Color.BLACK);
        messagePanel.add(rightPanel, BorderLayout.EAST);

        add(messagePanel, BorderLayout.NORTH);

        Panel resetPanel = new Panel();
        resetButton = new Button("Reset");
        resetButton.addActionListener(this);
        resetPanel.add(resetButton);
        add(resetPanel, BorderLayout.SOUTH);
        
        addWindowListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) 
    {
        String buttonLabel = event.getActionCommand();
        if (buttonLabel.equals("Red")) 
        {
            messageLabel.setText("Stop");
            messageLabel.setForeground(Color.RED);
        } else if (buttonLabel.equals("Yellow")) 
        {
            messageLabel.setText("Ready");
            messageLabel.setForeground(Color.YELLOW);
        } else if (buttonLabel.equals("Green")) 
        {
            messageLabel.setText("Go");
            messageLabel.setForeground(Color.GREEN);
        }
        else if (buttonLabel.equals("Reset")) 
        {
            messageLabel.setText("");
        }
    }
    
    public void windowClosing(WindowEvent event) 
    {
        dispose();
        System.exit(0);
    }
    
    // Unused methods of WindowListener
    public void windowActivated(WindowEvent event) {}
    public void windowClosed(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
    public void windowDeiconified(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowOpened(WindowEvent event) {}
    
    public static void main(String[] args) {
        new TrafficLight();
    }
}
