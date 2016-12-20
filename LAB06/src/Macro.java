import java.util.ArrayList;

public class Macro implements Invoker{
	
	private ArrayList<AparelhoEletronico> AE = new ArrayList<AparelhoEletronico>();
	
	public Macro(ArrayList<AparelhoEletronico> AE){
		this.AE = AE;
	}
	
	public void Macro1(AparelhoEletronico ASom,AparelhoEletronico arCon,AparelhoEletronico forno,AparelhoEletronico panela){
		arCon.getInv(1).Execute();
		arCon.getInv(2).Execute(22);
		forno.getInv(1).Execute();
		forno.getInv(2).Execute(200f);
		forno.getInv(3).Execute(30);
		panela.getInv(1).Execute();
		ASom.getInv(1).Execute();
		ASom.getInv(2).Execute(20);
	}

	@Override
	public void Execute() {
		if(AE.size()>=4)
			Macro1(AE.get(0),AE.get(1),AE.get(2),AE.get(3));
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
