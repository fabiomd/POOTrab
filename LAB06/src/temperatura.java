
public class temperatura implements Invoker{
	private float temperatura = 0;
	private float minTemp;
    private float maxTemp;
	private historico historico = new historico(10);
	
    public temperatura(float min,float max){
    	this.minTemp = min;
    	if(min < max){
    		this.maxTemp = max;
    	}else{
    		this.maxTemp = min+1;
    	}
    }
    
	public float getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(float temperaturaAtual) {
		if(temperaturaAtual < minTemp){
			this.temperatura = minTemp;
		}else{
			if(temperaturaAtual > maxTemp){
				this.temperatura = maxTemp;
			}else{
				this.temperatura = temperaturaAtual;
			}
		}
	}
	
	@Override
	public void Undo() {
		String resposta = historico.RemoveCommando();
		String[] temp = resposta.split(" ");
		switch(resposta){
		case "TEMPERATURA":
			setTemperatura(Float.parseFloat(temp[1]));
			break;
		default:
			System.out.println(temp[0]);
		}		
	}
	
	public void Execute() {
	}

	public void Execute(int x) {
	}

	public void Execute(float x) {
		historico.AddCommando("TEMPERATURA "+getTemperatura());
		setTemperatura(x);
	}
}
