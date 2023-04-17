package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroTelefone {

	private JFrame frame;
	private JTextField txtNumero;
	private JButton btnSalvar;
	private JCheckBox cbxOpcaoMovel;
	private JLabel lblMovel;
	private JLabel lblNumero;
	private JLabel lblDdd;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
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
	public TelaCadastroTelefone() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(20, 25, 45, 13);
		frame.getContentPane().add(lblDdd);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(20, 75, 45, 13);
		frame.getContentPane().add(lblNumero);
		
		lblMovel = new JLabel("Móvel:");
		lblMovel.setBounds(20, 125, 45, 13);
		frame.getContentPane().add(lblMovel);
		
		cbxOpcaoMovel = new JCheckBox("Sim/Não");
		cbxOpcaoMovel.setBounds(85, 121, 295, 21);
		frame.getContentPane().add(cbxOpcaoMovel);
		
		JComboBox comboBoxDdd = new JComboBox();
		comboBoxDdd.setBounds(85, 21, 295, 21);
		frame.getContentPane().add(comboBoxDdd);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(85, 72, 295, 19);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		//trocar a primeira linha para "create field" SEMPRE, ou colocar as variáveis lá em cima, ex "private JButton btnSalvar" !!!!!!!!!!!!!!!!
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(170, 182, 85, 21);
		frame.getContentPane().add(btnSalvar);
	}
	
}