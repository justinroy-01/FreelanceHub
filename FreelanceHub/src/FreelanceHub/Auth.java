package FreelanceHub;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class Auth {
	
	
	void login()
	{	String password = null;
		String user_ID = JOptionPane.showInputDialog("Enter your USER ID:");
		if (user_ID != null) {
			JPasswordField passwordField = new JPasswordField();
		    int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		    if (option == JOptionPane.OK_OPTION) {
		        String password2 = new String(passwordField.getPassword());
		        password=password2;
		    }
            if (password != null) {
                Connection conn = DatabaseConnection.getConnection();

                if (conn == null) {
                    System.out.println("Failed to make connection!");
                } else {
                    PreparedStatement pstmt = null;
                    java.sql.ResultSet rs = null;
                    try {
                        String sql = "SELECT COUNT(*) FROM users WHERE user_id = ? AND password = ?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, user_ID);
                        pstmt.setString(2, password);
                        rs = pstmt.executeQuery();
                        int count = 0;
                        if (rs.next()) {
                            count = rs.getInt(1);
                        }

                        if (count > 0) {
                            
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
                            
                        	JFrame frame = FrameManager.getFrame();
                        	frame.setTitle("Dashboard - " + user_ID);

                        	frame.getContentPane().removeAll();
                        	frame.setLayout(new BorderLayout(15, 15)); 

                            Color bgColor = new Color(245, 248, 250); 
                            Color headerColor = new Color(60, 90, 150); 
                            Color panelColor = Color.WHITE;
                            Color fontColor = Color.WHITE;
                            Color buttonHoverColor = new Color(230, 240, 255);
                            Color borderColor = new Color(220, 220, 220); 

                        	frame.getContentPane().setBackground(bgColor);

                        	JPanel northPanel = new JPanel();
                        	northPanel.setBackground(headerColor);
                        	northPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

                        	JLabel titleLabel = new JLabel("Irasshaimase "+ user_ID);
                        	titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                            titleLabel.setForeground(fontColor);
                        	northPanel.add(titleLabel);

                        	frame.add(northPanel, BorderLayout.NORTH);

                        	JPanel westPanel = new JPanel();
                        	westPanel.setLayout(new GridLayout(4, 1, 10, 10)); 
                        	westPanel.setBackground(panelColor);
                        	westPanel.setBorder(BorderFactory.createCompoundBorder(
                        	        BorderFactory.createEmptyBorder(15, 15, 15, 15),  
                        	        BorderFactory.createCompoundBorder(               
                        	            BorderFactory.createLineBorder(borderColor),  
                        	            BorderFactory.createEmptyBorder(20, 20, 20, 20) 
                        	        )
                        	));

                        	Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 16);

                        	JButton createBtn = new JButton("Add Record");
                        	JButton deleteBtn = new JButton("Delete Record");
                        	JButton viewBtn = new JButton("View Records");
                        	JButton updateBtn = new JButton("Update Record");

                        	JButton[] buttons = {createBtn, deleteBtn, viewBtn, updateBtn};
                        	for (JButton btn : buttons) {
                        	    btn.setFont(buttonFont);
                        	    btn.setBackground(panelColor);
                                btn.setForeground(new Color(40, 40, 40));
                        	    btn.setFocusPainted(false); 
                                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                btn.setMargin(new Insets(10, 15, 10, 15)); 
                                
                                btn.addMouseListener(new MouseAdapter() {
                                    public void mouseEntered(MouseEvent evt) {
                                        btn.setBackground(buttonHoverColor);
                                    }
                                    public void mouseExited(MouseEvent evt) {
                                        btn.setBackground(panelColor);
                                    }
                                });
                        	    westPanel.add(btn);
                        	}

                        	frame.add(westPanel, BorderLayout.WEST);
                            
                        	JPanel centerPanel = new JPanel(new BorderLayout()); 
                        	centerPanel.setBackground(panelColor);
                        	centerPanel.setBorder(BorderFactory.createLineBorder(borderColor));
                            
                            JLabel welcomeMessage = new JLabel("Select an option from the menu");
                            welcomeMessage.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 22));
                            welcomeMessage.setForeground(Color.GRAY);
                            welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
                            centerPanel.add(welcomeMessage, BorderLayout.CENTER);

                        	frame.add(centerPanel, BorderLayout.CENTER);

                        	JPanel southPanel = new JPanel();
                        	southPanel.setBackground(headerColor);
                        	southPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

                        	JLabel footerLabel = new JLabel("<html><body> Made with love ❤️</body> </html>");
                        	footerLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
                            footerLabel.setForeground(fontColor);
                        	southPanel.add(footerLabel);

                        	frame.add(southPanel, BorderLayout.SOUTH);

                        	frame.revalidate();
                        	frame.repaint();
                            
                        	createBtn.addActionListener(e -> {
                        		Create c = new Create();
                        	    c.create(); 
                        	});

                        	deleteBtn.addActionListener(e -> {
                        		Delete d = new Delete();
                        	    d.delete(); 
                        	});

                        	viewBtn.addActionListener(e -> {
                        	    View v = new View();
                        	    TableModel tableModel = v.view();

                        	    if (tableModel != null) {
                        	        
                        	        if (tableModel.getRowCount() == 0) {
                        	            JOptionPane.showMessageDialog(frame, "No records found.", "View Result", JOptionPane.INFORMATION_MESSAGE);
                        	            return; 
                        	        }
                                    
                        	        JTable table = new JTable(tableModel);
                        	       
                        	        table.setFillsViewportHeight(true); 
                        	        table.setAutoCreateRowSorter(true); 
                        	        table.setRowHeight(28); 
                                    table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
                                    table.setGridColor(borderColor);
                                    table.setSelectionBackground(buttonHoverColor); 
                                    table.setSelectionForeground(Color.BLACK);

                                    JTableHeader header = table.getTableHeader();
                        	        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                                    header.setBackground(new Color(240, 240, 240)); 
                                    header.setForeground(new Color(50, 50, 50));
                                    header.setBorder(BorderFactory.createLineBorder(borderColor));
                                    
                                    ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

                        	        JScrollPane scrollPane = new JScrollPane(table);
                                    scrollPane.setBorder(BorderFactory.createLineBorder(borderColor));
                                    scrollPane.getViewport().setBackground(Color.WHITE);

                        	        BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
                        	        Component oldCenterComponent = layout.getLayoutComponent(BorderLayout.CENTER);
                        	        if (oldCenterComponent != null) {
                        	            frame.getContentPane().remove(oldCenterComponent);
                        	        }

                        	        frame.add(scrollPane, BorderLayout.CENTER);

                        	        frame.revalidate();
                        	        frame.repaint();
                        	    }
                        	});

                        	updateBtn.addActionListener(e -> {
                        		Update u = new Update();
                        	    u.update(); 
                        	});

                        } else {
                            JOptionPane.showMessageDialog(null, "User doesn't exist, register please!");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Login failed: " + e.getMessage());
                        e.printStackTrace();
                    } finally {
                        try {
                            if (rs != null) rs.close();
                            if (pstmt != null) pstmt.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
	}
	void register()
	{	String password = null;
		String user_ID = JOptionPane.showInputDialog("Create your USER ID:");
        if (user_ID != null) {
        	JPasswordField passwordField = new JPasswordField();
		    int option = JOptionPane.showConfirmDialog(null, passwordField, "Create Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		    if (option == JOptionPane.OK_OPTION) {
		        String password2 = new String(passwordField.getPassword());
		        password=password2;
		    }
            if (password != null) {
                Connection conn = DatabaseConnection.getConnection();
                if (conn != null) {
                    try {
                        String sql = "INSERT INTO users (user_id, password) VALUES (?, ?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, user_ID);
                        pstmt.setString(2, password);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registration successful!");
                        pstmt.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Registration failed: " + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Database connection failed!");
                }
            }
        }
	}

}