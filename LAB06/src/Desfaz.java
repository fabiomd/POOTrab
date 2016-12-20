import java.util.ArrayList;

public class Desfaz implements Invoker{
	
	private historico historico;
	private ArrayList<Invoker> botoes;
	
	public Desfaz(historico historico,ArrayList<Invoker> aES){
		this.historico = historico;
		this.botoes = aES;
	}
	
	public void Desfazer() {
		String resposta = historico.RemoveCommando();
		String[] temp = resposta.split(" ");
		switch(temp[0]){
		case "BOTAO":
			botoes.get(Integer.parseInt(temp[1])).Undo();
			break;
		default:
			System.out.println(resposta);
		}		
	}

	@Override
	public void Execute() {
		Desfazer();
	}

	@Override
	public void Undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Execute(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Execute(float x) {
		// TODO Auto-generated method stub
		
	}
}
