import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Write a description of class MainFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainFrame  
{
    public void CreateFrame()
    {
        // inishilaizes the frame window
        JFrame f = new JFrame("windowed applet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(200, 200, 400, 300);
        
        // creates the content pain
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        //adds the content pane to the frame "windowed Applet"
        f.setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // creates the lable
        JLabel lblNewLabel = new JLabel("Screen Pong by: Troy M.");
        lblNewLabel.setBounds(28, 13, 344, 38);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        contentPane.add(lblNewLabel);
        
        // creates the button
        JButton btnStart = new JButton("Start!!!");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{                  
                       Running run = new Running();
                       run.Init();
                } catch (Exception e) {
        			e.printStackTrace();
                }
            }
        });
        btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        btnStart.setBackground(new Color(255, 255, 255));
        btnStart.setBounds(38, 75, 323, 152);
        contentPane.add(btnStart);
        
         // sets the frame to be visible
        f.setVisible(true);
    }
}



