
public class timer implements Invoker{
	private int contador = 0;
	private int contadorMax = 0;
	private historico historico = new historico(10);
	
	public boolean Esgotado(){
		return getContadorMax() == getContador();
	}
	
	public void Update(){
		if(!Esgotado())
			setTempo(getContadorMax() + 1);
	}
	
	private int getContador() {
		return contador;
	}

	private int getContadorMax() {
		return contadorMax;
	}

	public void setTempo(int contadorMax) {
		if(contadorMax < 0){
			this.contadorMax = 0;
		}else{
			this.contadorMax = contadorMax;
		}
	}
	
	public void Undo() {
		String resposta = historico.RemoveCommando();
		String[] temp = resposta.split(" ");
		switch(temp[0]){
		case "TIMER":
			setTempo(Integer.parseInt(temp[1]));
			break;
		default:
			System.out.println(temp[0]);
		}		
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Execute(int x) {
		historico.AddCommando("TIMER "+getContador());
		setTempo(x);
	}

	@Override
	public void Execute(float x) {
		// TODO Auto-generated method stub
		
	}
}
