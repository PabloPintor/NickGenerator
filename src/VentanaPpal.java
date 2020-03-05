import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class VentanaPpal extends JFrame {
	
	private Vista vista;
	private JTextPane nickField;
	public String nick="";
	public String command="";
	private JCheckBox checkNumbers;
	private JLabel lblMadeByPibo;
	
	public VentanaPpal(Vista vista) {
		setResizable(false);
		setTitle("NICKNAME GENERATOR");
		
		this.vista=vista;
		
		setBounds(100, 100, 496, 298);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton buttonGenerateNick = new JButton("Generate nick");
		buttonGenerateNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				generateNickNamePressed();
				
			}
		});
		
		JButton buttonCopyCommand = new JButton("Copy command to clipboard");
		buttonCopyCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				copyCommandClipPressed();
			}
		});
		
		JButton buttonCopyNick = new JButton("Copy nick to clipboard");
		buttonCopyNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buttonCopyNickClipPressed();
			}
		});
		
		nickField = new JTextPane();
		nickField.setEditable(false);
		
		JButton buttonClose = new JButton("Close");
		buttonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buttonClosePressed();
			}
		});
		
		checkNumbers = new JCheckBox("Numbers");
		
		lblMadeByPibo = new JLabel("Made by Pibo || Twitter: @Pibastro");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(nickField, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(checkNumbers)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonGenerateNick, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonClose, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(buttonCopyCommand, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonCopyNick, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(lblMadeByPibo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nickField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblMadeByPibo)
							.addGap(18)
							.addComponent(buttonCopyNick, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonCopyCommand, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(buttonGenerateNick, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkNumbers))
							.addGap(36))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonClose, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(19))))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void copyCommandClipPressed() {
		
		this.vista.writeTextToClipboard(this.command);
		System.exit(0);
		
	}

	protected void buttonCopyNickClipPressed() {

		this.vista.writeTextToClipboard(this.nick);
		System.exit(0);
		
	}

	protected void generateNickNamePressed() {
		
		this.nick=this.vista.generateRandomNick();
		
		if (this.checkNumbers.isSelected()) {
			
			Random random=new Random();
			
			this.nick+="_"+random.nextInt(100);
		}
		
		this.command="/nick -i "+nick;
		
		this.nickField.setText("Nickname:\n      "+this.nick+"\n\n\nCommand\n      "+this.command);
		
	}

	protected void buttonClosePressed() {
		
		System.exit(0);
		
	}
}
