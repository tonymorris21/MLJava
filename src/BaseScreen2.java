

/*******************************************************
 * 
 * 
 *   Lab 5: GUI solution 
 * 
 * 
 *******************************************************/
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BaseScreen2 extends JFrame implements ActionListener, MouseListener  
{


   private JPanel contentPane;
   private JButton 		button1;
   private JButton		button2;
   private JTextField 	tf1;
   private JLabel 		label; 
      
   
   BaseScreen2(String title)
   {
  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTemperature = new JLabel("Temperature :");
		lblTemperature.setBounds(10, 11, 73, 14);
		contentPane.add(lblTemperature);
		
		
		String [] tempStrings = { "Hot", "Normal", "Cool", "Cold" };
		JComboBox<String> comboBox = new JComboBox<>(tempStrings);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(82, 8, 58, 20);
		contentPane.add(comboBox);
		
		JLabel lblAches = new JLabel("Aches :");
		lblAches.setBounds(10, 36, 46, 14);
		contentPane.add(lblAches);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(62, 32, 46, 23);
		contentPane.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(110, 32, 46, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblCough = new JLabel("Cough :");
		lblCough.setBounds(10, 61, 46, 14);
		contentPane.add(lblCough);
		
		JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBounds(62, 57, 43, 23);
		contentPane.add(rdbtnYes_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBounds(110, 57, 52, 23);
		contentPane.add(rdbtnNo_1);
		
		JLabel lblNewLabel = new JLabel("Sore throat :");
		lblNewLabel.setBounds(10, 86, 73, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setBounds(82, 82, 46, 23);
		contentPane.add(rdbtnYes_2);
		
		JRadioButton rdbtnNo_2 = new JRadioButton("No");
		rdbtnNo_2.setBounds(130, 82, 46, 23);
		contentPane.add(rdbtnNo_2);
		
		JLabel lblRecentlyTravelled = new JLabel("Recently Travelled");
		lblRecentlyTravelled.setBounds(10, 111, 98, 14);
		contentPane.add(lblRecentlyTravelled);
		
		JRadioButton rdbtnYes_3 = new JRadioButton("Yes");
		rdbtnYes_3.setBounds(105, 108, 46, 23);
		contentPane.add(rdbtnYes_3);
		
		JRadioButton rdbtnNo_3 = new JRadioButton("No");
		rdbtnNo_3.setBounds(158, 107, 46, 23);
		contentPane.add(rdbtnNo_3);
		
		
	}

@Override
public void mouseClicked(MouseEvent arg0) {

	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}




}