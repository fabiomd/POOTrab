
public class user extends person implements detail{
	
	private String login;
	private String password;
	private float sale;
	
	public user(String firstName,String lastName,String CPF,float sale,String login,String senha) {
		super(firstName, lastName, CPF);
		this.setSale(sale);
		this.setLogin(login);
		this.setPassword(senha);
	}

	public boolean autentificate(String login,String password) {
		return this.getLogin().equals(login) && this.getPassword().equals(password);
	}
	
	private String getLogin() {
		return login;
	}

	private void setLogin(String login) {
		this.login = login;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}

	@Override
	public void details() {
		super.details();
		System.out.println("Saldo: "+this.getSale());
	}
}
