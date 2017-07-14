

public class textImpress extends impress{
	
	public textImpress(String text){
		this.setText(text);
	}
	
	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void details() {
		System.out.println("Texto estampado: " + this.getText());
	}
	
}
