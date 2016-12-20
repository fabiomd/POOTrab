
public class forno implements AparelhoEletronico{

	private Invoker botao1 = new ligarDesligar();
	private Invoker botao2 = new temperatura(0f,250f);
	private Invoker botao3 = new timer();
	
	public Invoker getInv(int i){
		switch(i){
		case 1:
			return botao1;
		case 2:
			return botao2;
		case 3:
			return botao3;
		default: 
		    return null;
		}
	}

	@Override
	public int getMaxBotoes() {
		// TODO Auto-generated method stub
		return 3;
	}
}
