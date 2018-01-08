import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class BasicClient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicClient window = new BasicClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BasicClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setSize(400, 500);
		frame.setTitle("Client GUI");
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 10);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, -50, 468);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(-25);
		panel_1.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(208, 41, 61, 26);
		frame.getContentPane().add(spinner);
		
		JLabel lblProblemId = new JLabel("Problem Id");
		lblProblemId.setBounds(87, 46, 79, 16);
		frame.getContentPane().add(lblProblemId);
		
		JLabel lblAlternativeId = new JLabel("Alternative Id");
		lblAlternativeId.setBounds(87, 104, 94, 16);
		frame.getContentPane().add(lblAlternativeId);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(208, 99, 61, 26);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblAlternativeName = new JLabel("Alternative Name");
		lblAlternativeName.setBounds(87, 162, 115, 16);
		frame.getContentPane().add(lblAlternativeName);
		
		textField = new JTextField();
		textField.setBounds(208, 157, 136, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCritereId = new JLabel("Critere Id");
		lblCritereId.setBounds(87, 221, 94, 16);
		frame.getContentPane().add(lblCritereId);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(214, 216, 55, 26);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblCritereName = new JLabel("Critere Name");
		lblCritereName.setBounds(87, 278, 94, 16);
		frame.getContentPane().add(lblCritereName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 273, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEvalId = new JLabel("Eval Id");
		lblEvalId.setBounds(87, 330, 61, 16);
		frame.getContentPane().add(lblEvalId);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(214, 325, 55, 26);
		frame.getContentPane().add(spinner_3);
		
		JLabel lblEvalName = new JLabel("Eval Name");
		lblEvalName.setBounds(87, 380, 79, 16);
		frame.getContentPane().add(lblEvalName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 375, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEvalValue = new JLabel("Eval Value");
		lblEvalValue.setBounds(87, 421, 79, 16);
		frame.getContentPane().add(lblEvalValue);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(208, 416, 34, 26);
		frame.getContentPane().add(spinner_4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(112, 449, 117, 29);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				int problemId = (Integer) spinner.getValue();
				ProblemModel model = new ProblemModel(problemId);	
				
				ApiService.sendData(model);
				
			} 
		});
	
	}
}
