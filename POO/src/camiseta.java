

public abstract class camiseta extends product implements detail{
	
	private String color;
	private impress estampa;
	
	public camiseta(String color, float price){
		super(price);
		this.setColor(color);
		this.setEstampa(estampa);
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public impress getEstampa() {
		return estampa;
	}
	public void setEstampa(impress estampa) {
		this.estampa = estampa;
	}
	
	public void details() {
		super.details();
		System.out.println("COR: "+this.getColor());
		if(this.getEstampa() != null) {
			this.getEstampa().details();
		}
		else {
			System.out.println("Sem estampa");
		}
	}
}
