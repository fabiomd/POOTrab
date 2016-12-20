
public class ligarDesligar implements Invoker{
	private boolean ligado = false;
	
	public void Execute() {
		if(getLigado()){
			Desligar();
		}else{
			Ligar();
		}
	}
	
	public void Execute(int x) {
	}

	@Override
	public void Execute(float x) {
	}
	
	@Override
	public void Undo() {
		if(getLigado()){
			Desligar();
		}else{
			Ligar();
		}		
	}
	
	private void Ligar(){
		setLigado(true);
	}
	
	private void Desligar(){
		setLigado(false);
	}

	private boolean getLigado() {
		return this.ligado;
	}

	private void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
}
