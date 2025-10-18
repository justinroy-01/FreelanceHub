package FreelanceHub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameManager {
	public static JFrame frame;

    public static void initFrame() {
    	if (frame == null) {
    	
        SwingUtilities.invokeLater(() -> {
            
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            Color bgColor = new Color(240, 245, 250); 
            Color panelColor = Color.WHITE;
            Color primaryBlue = new Color(0, 120, 215);
            Color primaryBlueHover = new Color(0, 100, 190);
            Color darkText = new Color(40, 40, 40);
            Color borderColor = new Color(220, 225, 230);


            frame = new JFrame("FreelanceHub");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            frame.setLayout(new BorderLayout(15, 15)); 
            frame.getContentPane().setBackground(bgColor);
            frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            
            frame.add(new AnimatedPanel(), BorderLayout.NORTH);

            
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            centerPanel.setBackground(panelColor);

            ImageIcon icon = new ImageIcon(Main.class.getResource("/images/freelance2-Photoroom.png"));
            JLabel label1 = new JLabel(icon);
            label1.setAlignmentX(Component.CENTER_ALIGNMENT);

            
            JTextPane text = new JTextPane();
            text.setContentType("text/html");
            text.setText("<html><div style='text-align:center;font-family:Sans-serif;font-size:16px;color:rgb(80,80,80)'>"
                    + "<strong> FreelanceHub </strong> is a Java-based project built to explore how"
                    + " projects can be organized and managed through software.<br>"
                    + " It focuses on basics of object-oriented programming concepts"
                    + " along with database connectivity.<br><br>"
                    + " Though not a commercial product, <strong>FreelanceHub</strong> serves as a<br>"
                    + " learning project that demonstrates how logic can be applied<br>"
                    + " to real-world scenarios."
                    + "</div></html>");
            text.setEditable(false);
            text.setBackground(panelColor); 
            text.setMaximumSize(new Dimension(800, 300)); 
            
            centerPanel.add(Box.createVerticalGlue()); 
            centerPanel.add(label1);
            centerPanel.add(Box.createVerticalStrut(20)); 
            centerPanel.add(text);
            centerPanel.add(Box.createVerticalGlue()); 
            
            centerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor),
                BorderFactory.createEmptyBorder(20, 25, 20, 25) 
            ));

            frame.add(centerPanel, BorderLayout.CENTER);

            JPanel westPanel = new JPanel();
            westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
            westPanel.setBackground(panelColor);
            
            JTextPane text2 = new JTextPane();
            text2.setContentType("text/html");
            text2.setText("<html><div style='text-align:center;font-family:Sans-serif;font-size:12px;color:rgb(90,90,90)'>"
                    + "<strong style='font-size:16px;color:rgb(50,50,50)'>Collaborators(GitHub)</strong><br><br>"
                    + "(justinroy-01)<br><br>"
                    + "Sharx05<br><br>"
                    + "IslamSMytheen<br><br>"
                    + "kashinathcep-cmd<br><br>"
                    + "kailas395<br><br>"
                    + "</div></html>");
            text2.setEditable(false);
            text2.setBackground(panelColor);
            westPanel.add(text2);
            
            westPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor),
                BorderFactory.createEmptyBorder(15, 20, 15, 20) 
            ));
            frame.add(westPanel, BorderLayout.WEST);


           
            JPanel eastPanel = new JPanel();
            eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS)); 
            eastPanel.setBackground(panelColor);
            
            eastPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor),
                BorderFactory.createEmptyBorder(20, 30, 20, 30) 
            ));

            Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
            Dimension buttonSize = new Dimension(200, 45);

            JButton button = new JButton("Login");
            button.addActionListener(e -> {
                 Auth a = new Auth();
                 a.login();
            });
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setFont(buttonFont);
            button.setMaximumSize(buttonSize);
            button.setBackground(primaryBlue);
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));

            JButton button2 = new JButton("Register");
            button2.addActionListener(e -> { 
                 Auth a = new Auth();
                 a.register();  
            });
            button2.setAlignmentX(Component.CENTER_ALIGNMENT);
            button2.setFont(buttonFont);
            button2.setMaximumSize(buttonSize);
            button2.setBackground(primaryBlue);
            button2.setForeground(Color.WHITE);
            button2.setFocusPainted(false);
            button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            MouseAdapter buttonHover = new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    ((JButton)evt.getSource()).setBackground(primaryBlueHover);
                }
                public void mouseExited(MouseEvent evt) {
                    ((JButton)evt.getSource()).setBackground(primaryBlue);
                }
            };
            button.addMouseListener(buttonHover);
            button2.addMouseListener(buttonHover);

            JLabel eastTitle = new JLabel("      Get Started      ");
            eastTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
            eastTitle.setForeground(darkText);
            eastTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            eastPanel.add(Box.createVerticalGlue()); 
            eastPanel.add(eastTitle);
            eastPanel.add(Box.createVerticalStrut(25));
            eastPanel.add(button);
            eastPanel.add(Box.createVerticalStrut(15));
            eastPanel.add(button2);
            eastPanel.add(Box.createVerticalGlue()); 

            frame.add(eastPanel, BorderLayout.EAST);
            
            JPanel southPanel = new JPanel();
            southPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
            southPanel.setBackground(bgColor); 
            southPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); 
            
            JTextPane text3 = new JTextPane();
            text3.setContentType("text/html");
            text3.setText("<html><div style='text-align:center;font-family:Sans-serif;font-size:12px;color:rgb(100,100,100)'>"
                    + "Made with love ❤️ and coffee"
                    + "</div></html>");
            text3.setEditable(false);
            text3.setBackground(bgColor); 
            southPanel.add(text3);
            
            frame.add(southPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        }); 
    } 
} 

    public static JFrame getFrame() {
        initFrame();
        return frame;
    }
}