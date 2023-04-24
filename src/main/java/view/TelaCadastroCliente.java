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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EnderecoController;
import model.exception.CampoInvalidoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEndereco;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	
	private MaskFormatter mascaraCpf;
	private JComboBox cbEndereco;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() throws ParseException{
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mascaraCpf = new MaskFormatter("###.###.###-##");
		mascaraCpf.setValueContainsLiteralCharacters(false);
		
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(85, 60, 300, 20);
		this.getContentPane().add(txtCpf);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 20, 50, 14);
		this.getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(25, 60, 50, 14);
		this.getContentPane().add(lblCpf);
		
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(25, 100, 50, 14);
		this.getContentPane().add(lblEndereco);
		
		txtNome = new JTextField();
		txtNome.setBounds(85, 20, 300, 20);
		this.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		EnderecoController endController = new EnderecoController();
		List<Endereco> enderecosCadastrados = endController.consultarTodos();
		
		cbEndereco = new JComboBox(enderecosCadastrados.toArray());
		cbEndereco.setBounds(85, 100, 300, 22);
		this.getContentPane().add(cbEndereco);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setSize(100, 14);
		btnSalvar.setLocation(158, 169);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente novoCliente = new Cliente();
				novoCliente.setNome(txtNome.getText());
				
				try {
					String cpfSemMascara = (String) mascaraCpf.stringToValue(
							txtCpf.getText());
					novoCliente.setCpf(cpfSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
				novoCliente.setEndereco((Endereco) cbEndereco.getSelectedItem());
				
				ClienteController controller = new ClienteController();
			
				try {
					controller.inserir(novoCliente);
					
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!", 
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CpfJaUtilizadoException | EnderecoInvalidoException | CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		this.getContentPane().add(btnSalvar);
	}
}