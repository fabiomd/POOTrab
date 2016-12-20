
public class panelaEletrica implements AparelhoEletronico{
	private Invoker botao1 = new ligarDesligar();
	private Invoker botao2 = new timer();
	
	public Invoker getInv(int i){
		switch(i){
		case 1:
			return botao1;
		case 2:
			return botao2;
		default: 
		    return null;
		}
	}

	@Override
	public int getMaxBotoes() {
		// TODO Auto-generated method stub
		return 2;
	}
}
