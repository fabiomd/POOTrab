import java.io.IOException;
import java.util.Scanner;

public class main {
	
	 public static void main(String[] args) {
		 
		 Scanner keyboard = new Scanner(System.in);
		 controll.fillProducts();
		 
		 while(true) {
			 System.out.println("MENU PRINCIPAL");
			 System.out.println("1- Add usuario");
			 System.out.println("2- Login");
			 System.out.println("3- Listar produtos");
			 System.out.println("9-EXIT");
			 System.out.print("Opcao: ");
			 switch(Integer.parseInt(keyboard.nextLine())) {
			 case 1:
				 if(controll.AddUsuario()) {
					 System.out.println("Usuario adicionado");
				 }else {
					 System.out.println("Erro na inserção");
				 }
				 break;
			 case 2:
				 controll.Login();
				 break;
			 case 3:
				 controll.listarProduct();
				 break;
			 case 9:
			     return;
			}
		 }
//		 janelaDeCadastro window = new janelaDeCadastro();
//		 window.setVisible(true);
	 }	 
}