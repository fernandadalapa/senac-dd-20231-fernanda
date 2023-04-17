package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EnderecoController;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;

public class TelaCadastroCliente1 extends JFrame {

	private JPanel contentPane;
	private JFrame frmCadastroDeClientes;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEndereco;
	private JComboBox cbxEndereco;
	
	private MaskFormatter mascaraCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente1 frame = new TelaCadastroCliente1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroCliente1() {
		getContentPane().setLayout(null);
		frmCadastroDeClientes = new JFrame();
		frmCadastroDeClientes.setTitle("Cadastro de clientes");
		frmCadastroDeClientes.setBounds(100, 100, 450, 300);
		frmCadastroDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeClientes.getContentPane().setLayout(null);
		
		//NOME
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 22, 38, 24);
		frmCadastroDeClientes.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(81, 25, 331, 19);
		frmCadastroDeClientes.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		//CPF
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(24, 76, 38, 13);
		frmCadastroDeClientes.getContentPane().add(lblCpf);
		
		//MÁSCARA PARA O CPF
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException erro) {
			erro.printStackTrace();
		}
		JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(81, 73, 331, 19);
		frmCadastroDeClientes.getContentPane().add(txtCpf);
		
		
		//ENDEREÇO
		EnderecoController endController = new EnderecoController();
		List<Endereco> enderecos = endController.consultarTodos();
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 131, 52, 13);
		frmCadastroDeClientes.getContentPane().add(lblEndereco);
		
		cbxEndereco = new JComboBox(enderecos.toArray());
		cbxEndereco.setBounds(81, 127, 331, 21);
		frmCadastroDeClientes.getContentPane().add(cbxEndereco);
		
		//BOTÃO
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente novoCliente = new Cliente();
				novoCliente.setNome(txtNome.getText());
				novoCliente.setCpf(txtCpf.getText());
				novoCliente.setEndereco((Endereco)cbxEndereco.getSelectedItem());
				
				ClienteController controller = new ClienteController();
				try {
					controller.inserir(novoCliente);
				} catch () {
					
				}
				
				
			}
		});
		btnSalvar.setBounds(173, 193, 85, 21);
		frmCadastroDeClientes.getContentPane().add(btnSalvar);
	}
}