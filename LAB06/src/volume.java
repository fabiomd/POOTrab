
public class volume implements Invoker{
	private int volume=1;
	private int maxVolume;
	protected historico historico = new historico(10);
	
	public volume(int max){
		if(max<0){
			this.maxVolume = 10;
		}else{
			this.maxVolume = max;
		}
	}
	
	public void Execute(int x) {
		SetVolume(x);
		historico.AddCommando("VOLUME "+x);
	}
	
	public void Undo() {
		String resposta = historico.RemoveCommando();
		String[] temp = resposta.split(" ");
		switch(temp[0]){
		case "VOLUME":
			SetVolume(Integer.parseInt(temp[1]));
			break;
		default:
			System.out.println(temp[0]);
		}		
	}
	
	protected void SetVolume(int v){
		if(v>maxVolume){
			this.volume= this.maxVolume;
		}else{
			if(v<0){
				this.volume = 0;
			}
			else{
				this.volume = v;
			}
		}
	}
	
	public int GetVolume(){
		return this.volume;
	}

	public void Execute() {
	}

	public void Execute(float x) {
	}
}
