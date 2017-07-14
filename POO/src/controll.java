import java.util.ArrayList;
import java.util.Scanner;

public class controll {
	
	private static ArrayList<user> users = new ArrayList<user>();
	private static ArrayList<product> products = new ArrayList<product>();
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void fillProducts() {
		
		camiseta temp = new camisetaSemManga("Azul", 80.0f);
		temp.setEstampa(new textImpress("Rock 2010"));
		((product)temp).setDescription("Uma camiseta azul muito loka");
		controll.products.add(temp);
		temp = new camisetaSemManga("Verde", 20.0f);
		((product)temp).setDescription("100 % algodão");
		controll.products.add(temp);
		controll.products.add(new camisetaSemManga("Branca", 50.0f));
		
		temp = new camisetaComManga("Preta", 80.10f);
		temp.setEstampa(new textImpress("Need coffe"));
		((product)temp).setDescription("camiseta de programador");
		controll.products.add(temp);
		controll.products.add(new camisetaComManga("Amarela", 20.0f));
		temp = new camisetaComManga("Laranja", 50.0f);
		temp.setEstampa(new textImpress("Dont ask me, im lost too"));
		controll.products.add(temp);
	}
	
	public static boolean AddUsuario() {
		String firstName;
		String lastName;
		String cpf;
		float sale;
		String login;
		String password;
		
		System.out.print("Nome: ");
		firstName = keyboard.nextLine();
		System.out.print("Sobrenome: ");
		lastName = keyboard.nextLine();
		System.out.print("CPF: ");
		cpf = keyboard.nextLine();
		System.out.print("Saldo inicial: ");
		sale = Float.parseFloat(keyboard.nextLine());
		System.out.print("Login: ");
		login = keyboard.nextLine();
		System.out.print("Password: ");
		password = keyboard.nextLine();
		
		if(firstName != "" && lastName !="" && cpf!="" && sale >= 0f && login != "" && password != "") {
			controll.users.add(new user(firstName,lastName,cpf,sale,login,password));
			return true;
		}
		
		return false;
	}

    public static void Login() {    	
    	String login;
		String password;
		System.out.print("Login: ");
		login = keyboard.nextLine();
		System.out.print("Password: ");
		password = keyboard.nextLine();
    	boolean auth = false;
		
		for(user temp : users) {
			if(temp.autentificate(login, password)) {
				controll.loggedMenu(temp);
				auth = true;
				break;
			}
		}
		
		if(!auth) {
			System.out.println("Usuario login ou senha incorreta");
		}else {
			System.out.println("Loggout bem sucedido");
		}
    }
    
    private static void loggedMenu(user user) {
    	while(true) {
    		System.out.println("USUARIO CONECTADO");
    		System.out.println("1- Exibir dados de usuario");
    		System.out.println("2- Listar produtos");
    		System.out.println("3- Buscar produto");
    		System.out.println("9- loggout");
    		System.out.print("Opcao: ");
    		switch(Integer.parseInt(keyboard.nextLine())) {
    		case 1:
    			user.details();
    			break;
    		case 2:
    			controll.listarProduct();
    			break;
    		case 3:
    			System.out.println("Indique o indice do produto:");
    			product temp = controll.buscarProduct(Integer.parseInt(keyboard.nextLine()));
    			System.out.println("Comprar? S/N");
    			String answer = keyboard.nextLine();
    			if(answer.toLowerCase().equals("s")) {
    				if(controll.comprar(user, temp)) {
    					System.out.println("Compra realizada com sucesso");
    				}else {
    					System.out.println("Erro na compra");
    				}
    			}
    			break;
    		case 9:
    			return;
    		}
    	}
    }
    
    public static void listarProduct() {
    	int i=0;
    	for(product temp : products) {
    		System.out.println("Produto "+ i +": " +temp.getClass().getSimpleName());
    		temp.details();
    		System.out.println("");
    		i++;
    	}
    }
    
    private static product buscarProduct(int i) {
    	if(products.size() < i) {
    		return null;
    	}
    	return controll.products.get(i);
    }
    
    private static boolean comprar(user usuario,product prod) {
    	if(prod.getPrice() <= usuario.getSale()) {
    		usuario.setSale(usuario.getSale() - prod.getPrice());
    		return true;
    	}
    	return false;
    }
}

