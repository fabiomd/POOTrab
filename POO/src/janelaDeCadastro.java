import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class janelaDeCadastro extends JFrame{
	
	private JPanel panel = new JPanel();
	private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	private ArrayList<String> textCamps = new ArrayList<String>();
	
	public janelaDeCadastro() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(new Dimension(600,600));
		this.setResizable(false);
		this.setLayout(null);
        textCamps.add("Nome:");
        textCamps.add("Sobrenome");
        textCamps.add("CPF");
        textCamps.add("Sale");
		this.setTextField();
		this.setTextField();
		this.setTextField();
		this.setTextField();
		this.setTitle();        
        this.setButton();
	}
	
	private void setTitle() {
		JTextArea txt = new JTextArea();
        txt.setBounds(110, 95, 390, 30);
        txt.setText("CADASTRO DE USUARIO");
        txt.setEditable(false);
        this.add(txt);
	}
	
	private void setButton() {
		JButton button = new JButton("SAVE");
		button.setBounds(200, 300, 200, 50);
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
//            	user temp = new user(textFields.get(0).getText(),textFields.get(1).getText(),textFields.get(2).getText(),Float.valueOf(textFields.get(3).getText()));
            }
        });
	    this.add(button);
	}
	
	private void setTextField() {
		JTextField field = new JTextField(10);
		field.setBounds(200, 35 * (textFields.size() + 1) +100, 300, 30);
		this.add(field);
		
		JTextArea txt = new JTextArea();
        txt.setBounds(110, 35 * (textFields.size()+1) + 100, 80, 30);
		txt.setText(textCamps.get(textFields.size()));
		txt.setEditable(false);
        
        this.add(txt);
		textFields.add(field);
	}
}
