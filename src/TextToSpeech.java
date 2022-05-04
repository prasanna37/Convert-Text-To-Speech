import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.swing.DropMode;

public class TextToSpeech 
 {
	private JFrame frmSpeech;
	private JFrame frame;
	
	private static final String SayWhat = "kevin16";

	public TextToSpeech() 
	{
		initialize();	
	}
	private void initialize()
	{
		frmSpeech = new JFrame();
		frmSpeech.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmSpeech.setTitle("Conversion of TextTo Speech");
		frmSpeech.setBounds(0, 0, 1360, 800);
		frmSpeech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpeech.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 12));
		panel.setBounds(12, 13, 1318, 147);
		frmSpeech.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversion of TextTo Speech");
		lblNewLabel.setBounds(155, 13, 1052, 110);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 72));
		lblNewLabel.setBorder(new LineBorder(new Color(0,0,0),8));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 12));
		panel_1.setBounds(12, 186, 1318, 554);
		frmSpeech.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel txtSpeech = new JPanel();
		txtSpeech.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSpeech.setBounds(430, 58, 846, 399);
		
		panel_1.add(txtSpeech);
		txtSpeech.setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setTabSize(0);
		textArea.setDropMode(DropMode.INSERT);
		textArea.setRows(100);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 30));
		textArea.setBounds(0, 0, 846, 399);
		textArea.setBorder(new LineBorder(new Color(0,0,0),8));
		txtSpeech.add(textArea);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				textArea.setText(null);
			}
		});
		
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnClear.setBounds(115, 233, 213, 57);
		panel_1.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit","Speech",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnExit.setBounds(115, 372, 213, 57);
		panel_1.add(btnExit);	
		
		JButton btnCnvrt = new JButton(" Convert ");
		btnCnvrt.setHorizontalAlignment(SwingConstants.LEFT);
		btnCnvrt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				VoiceManager vm=VoiceManager.getInstance();
				Voice iTalk = vm.getVoice(SayWhat);
				iTalk.allocate();				
				try
				{
					iTalk.speak(textArea.getText());
				}
				catch(Exception ex)
				{
					JOptionPane.showConfirmDialog(null, "hii hello");
				}				
					}
		});
		btnCnvrt.setFont(new Font("Tahoma", Font.BOLD, 37));
		btnCnvrt.setBounds(115, 89, 213, 62);
		panel_1.add(btnCnvrt);
	}	

	public static void main(String[] args)
     {
	EventQueue.invokeLater(new Runnable() 
	{
		public void run() 
		{
			try 
			{
				Speech window = new Speech();
				window.getFrmSpeech().setVisible(true);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			}
		});
  }
 

public JFrame getFrmSpeech()
{
 return frmSpeech;	
}
 public void setFrmSpeech(JFrame frmSpeech)
 {
	 this.frmSpeech=frmSpeech;
 }
}