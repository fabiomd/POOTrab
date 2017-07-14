
public abstract class person implements detail{
	private String firstName;
	private String lastName;
	private String CPF;
	
	public person(String firstName,String lastName,String CPF) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setCPF(CPF);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public void details() {
		System.out.println("Nome: "+this.getFirstName());
		System.out.println("Sobrenome: "+this.getLastName());
		System.out.println("CPF: "+this.getCPF());
	}
}
