import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class BaseScreen2 extends JFrame implements ActionListener, MouseListener  
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static String Aches;
	static String Temp;
	static String Cough;
	static String Dangerzone;
	static String Throat;
   
   BaseScreen2(String title)
   {
	   DecimalFormat df = new DecimalFormat ("##.00");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTemperature = new JLabel("Temperature :");
		lblTemperature.setBounds(101, 11, 92, 14);
		contentPane.add(lblTemperature);
		
		JLabel lblAches = new JLabel("Aches :");
		lblAches.setBounds(133, 36, 46, 14);
		contentPane.add(lblAches);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(195, 32, 46, 23);
		contentPane.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(243, 32, 46, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblCough = new JLabel("Cough :");
		lblCough.setBounds(133, 61, 46, 14);
		contentPane.add(lblCough);
		
		JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBounds(195, 58, 46, 23);
		contentPane.add(rdbtnYes_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBounds(243, 58, 52, 23);
		contentPane.add(rdbtnNo_1);
		
		JLabel lblNewLabel = new JLabel("Sore throat :");
		lblNewLabel.setBounds(106, 86, 73, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setBounds(195, 84, 46, 23);
		contentPane.add(rdbtnYes_2);
		
		JRadioButton rdbtnNo_2 = new JRadioButton("No");
		rdbtnNo_2.setBounds(243, 82, 46, 23);
		contentPane.add(rdbtnNo_2);
		
		JLabel lblRecentlyTravelled = new JLabel("Recently Travelled :");
		lblRecentlyTravelled.setBounds(70, 111, 123, 14);
		contentPane.add(lblRecentlyTravelled);
		
		JRadioButton rdbtnYes_3 = new JRadioButton("Yes");
		rdbtnYes_3.setBounds(195, 110, 46, 23);
		contentPane.add(rdbtnYes_3);
		
		JRadioButton rdbtnNo_3 = new JRadioButton("No");
		rdbtnNo_3.setBounds(243, 108, 46, 23);
		contentPane.add(rdbtnNo_3);
		
		ButtonGroup acheBg = new ButtonGroup();
			acheBg.add(rdbtnYes);
			acheBg.add(rdbtnNo);
			acheBg.clearSelection();
		ButtonGroup coughBg = new ButtonGroup();
			coughBg.add(rdbtnYes_1);
			coughBg.add(rdbtnNo_1);
			coughBg.clearSelection();	
		ButtonGroup throatBg = new ButtonGroup();
			throatBg.add(rdbtnYes_2);
			throatBg.add(rdbtnNo_2);
			throatBg.clearSelection();
		ButtonGroup dangerzoneBg = new ButtonGroup();
			dangerzoneBg.add(rdbtnYes_3);
			dangerzoneBg.add(rdbtnNo_3);
			dangerzoneBg.clearSelection();
		JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Hot", "Normal", "Cool", "Cold"}));
			comboBox.setBounds(203, 8, 74, 20);
			contentPane.add(comboBox);
		JButton btnSubmit = new JButton("Submit Symptoms");
			btnSubmit.setBounds(143, 152, 146, 32);
			contentPane.add(btnSubmit);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(dangerzoneBg.getSelection()==null || throatBg.getSelection()==null || coughBg.getSelection()==null || acheBg.getSelection()==null) {
						JOptionPane.showMessageDialog(contentPane,
								
							    "Finish selecting options",
							    " Incomplete form",
							    JOptionPane.INFORMATION_MESSAGE);
					}else {
					if(rdbtnYes.isSelected()) {
						Aches = "yes";
						
					}
					if(rdbtnNo.isSelected())
					{
						System.out.println("Aches No");
						
						Aches = "no";
					}
					if(rdbtnYes_1.isSelected())
					{
						System.out.println("Cough yes");
						Cough = "yes";
					}
					if(rdbtnNo_1.isSelected())
					{
						System.out.println("Cough No");
						Cough = "no";
					}
					if(rdbtnYes_2.isSelected())
					{
						
						Throat = "yes";
					}
					if(rdbtnNo_2.isSelected())
					{
						
						Throat = "no";
					}
					if(rdbtnYes_3.isSelected())
					{
						
						Dangerzone = "yes";
					}
					if(rdbtnNo_3.isSelected())
					{
						
						Dangerzone = "no";
					}
					if(comboBox.getSelectedItem() != null)
					{
						
						if(comboBox.getSelectedIndex()==0)
						{
							System.out.println(comboBox.getSelectedItem());
							Temp = (String) comboBox.getSelectedItem();
						}
						if(comboBox.getSelectedIndex()==1)
						{
							Temp = (String) comboBox.getSelectedItem();
						}
						if(comboBox.getSelectedIndex()==2)
						{
							Temp = (String) comboBox.getSelectedItem();
						}
						if(comboBox.getSelectedIndex()==3)
						{
							Temp = (String) comboBox.getSelectedItem();
						}
					}
					
					DataProcessing.processResults(Temp, Aches, Cough, Throat, Dangerzone);
					DataProcessing.processData();
					//calculates whether the probability the patient doesnt have coronavirus> the probability the patient has coronavirus
					if(DataProcessing.covidNo>DataProcessing.covidYes)
					{
						double probability = DataProcessing.covidNo*100/1;
						JOptionPane.showMessageDialog(contentPane,
							"Patient does not have covid-19\n Probability = "
							+df.format(probability)+ "%","% No covid-19",
							JOptionPane.INFORMATION_MESSAGE);
					}
					//calculates whether the probability the patient has coronavirus> the probability the patient doesnt have coronavirus
					if(DataProcessing.covidYes>DataProcessing.covidNo)
					{
						double probability = DataProcessing.covidYes*100/1;
						JOptionPane.showMessageDialog(contentPane,
						"Patient has covid-19\n Probability = "
						+df.format(probability)+ "%"," Has covid-19",
						JOptionPane.INFORMATION_MESSAGE);
				}
				}
			}
		});
			
			
		JTextArea textArea = new JTextArea();
			textArea.setBounds(121, 217, 224, 22);
		contentPane.add(textArea);
			
		
		
			
		JButton btnNewButton = new JButton("Reset");
			btnNewButton.setBounds(301, 152, 123, 32);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Test Model");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					FileProcessing.testData();
					//displays accuracy of program.
					String text = "Program is " + df.format(FileProcessing.testprob) + "% accurate";
					textArea.setText(String.valueOf(text));
					btnNewButton_1.setEnabled(false); 
					
				}
			});
			btnNewButton_1.setBounds(10, 152, 123, 32);
			contentPane.add(btnNewButton_1);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					dangerzoneBg.clearSelection();
					coughBg.clearSelection();
					acheBg.clearSelection();
					throatBg.clearSelection();
		
				}
			});
   }
public void mouseClicked(MouseEvent arg0) {}
public void mouseEntered(MouseEvent arg0) {}
public void mouseExited(MouseEvent arg0) {}
public void mousePressed(MouseEvent arg0) {}
public void mouseReleased(MouseEvent arg0) {}
public void actionPerformed(ActionEvent e) {}
}