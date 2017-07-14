

public abstract class product implements detail{
	
	private float price;	
	private String description;
	
	public product(float price){
		this.setPrice(price);
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void details() {
		System.out.println("Preco: "+this.getPrice());
		if(this.getDescription() != null) {
			System.out.println("Descricao: "+this.getDescription());
		}
	}
}
