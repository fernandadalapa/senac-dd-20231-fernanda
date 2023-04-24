package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import controller.EnderecoController;
import model.vo.telefonia.Endereco;

import javax.swing.JLabel;
import javax.swing.JButton;


public class TelaListagemEndereco {

	private JFrame frmListaDeEndereos;
	private JTable tblEnderecos;
	private String[] nomesColunas = { "#", "CEP", "Rua", "Numero", "Bairro", "Cidade", "Estado" };
	
	private ArrayList<Endereco> enderecos; //Lista para armezenar os endereços consultados no banco
	
	private Endereco enderecoSelecionado;
	private EnderecoController enderecoController = new EnderecoController();
	private JButton btnBuscar;
	private JButton btnExcluir;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemEndereco window = new TelaListagemEndereco();
					window.frmListaDeEndereos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaDeEndereos = new JFrame();
		frmListaDeEndereos.setTitle("Lista de Endereços");
		frmListaDeEndereos.setBounds(100, 100, 450, 360);
		frmListaDeEndereos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListaDeEndereos.getContentPane().setLayout(null);
		
		tblEnderecos = new JTable();
		tblEnderecos.setBounds(10, 69, 414, 193);
		frmListaDeEndereos.getContentPane().add(tblEnderecos);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 69, 46, 14);
		frmListaDeEndereos.getContentPane().add(label);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(170, 35, 89, 23);
		frmListaDeEndereos.getContentPane().add(btnBuscar);
		
		btnExcluir = new JButton("Editar");
		btnExcluir.setBounds(120, 285, 89, 23);
		frmListaDeEndereos.getContentPane().add(btnExcluir);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(230, 285, 89, 23);
		frmListaDeEndereos.getContentPane().add(btnExcluir);
	}
	
	//método para atualizar tabela de endereços
	
	//método para o evento de clique em uma linha da tabela >> habilita/desabilita os botões "Editar" e "Excluir";
	
}
