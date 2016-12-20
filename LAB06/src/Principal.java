import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Invoker> botoes = new ArrayList<Invoker>();
		ArrayList<AparelhoEletronico> AES = new ArrayList<AparelhoEletronico>();
		historico historico =  new historico(10);
		AparelhoEletronico ASom = new aparelhodeSom();
		AparelhoEletronico arCon = new arCondicionado();
		AparelhoEletronico forno = new forno();
		AparelhoEletronico panela = new panelaEletrica();
		AES.add(ASom);
		AES.add(arCon);
		AES.add(forno);
		AES.add(panela);
		int[] tempvalues = new int[AES.size()];
		int count = 0;
		for(int i=0;i<tempvalues.length;i++){
			tempvalues[i]=count;
			count = tempvalues[i] + AES.get(i).getMaxBotoes() ;
		}
		
		fill(botoes,ASom);
		fill(botoes,arCon);
		fill(botoes,forno);
		fill(botoes,panela);
		botoes.add(new Macro(AES));
		botoes.add(new Desfaz(historico,botoes));
		
		int op,c=0;
		while(true){
			for(int i=0;i<botoes.size();i++){
				if(c < tempvalues.length && tempvalues[c] == i){
					System.out.println("Controle "+AES.get(c).getClass().getSimpleName());
					c++;
				}
				if(botoes.get(i)!= null){
					System.out.println("BOTAO "+i+": "+botoes.get(i).getClass().getSimpleName());
				}
			}
			System.out.println("OPCAO ");
			op = scanner.nextInt();
			if(op > botoes.size() || op < 0)
				break;
			switch(botoes.get(op).getClass().getSimpleName().toUpperCase()){
			case "VOLUME":
				int v;
				System.out.print("Volume: ");
				v = scanner.nextInt();
				botoes.get(op).Execute(v);
				break;
			case "TEMPERATURA":
				float t;
				System.out.print("TEMPERATURA: ");
				t = scanner.nextFloat();
				botoes.get(op).Execute(t);
				break;
			case "TIMER":
				int t2;
				System.out.println("TIMER: ");
				t2 = scanner.nextInt();
				botoes.get(op).Execute(t2);
				break;
			default:
				botoes.get(op).Execute();
				break;
			}
			if(botoes.get(op).getClass().getSimpleName() != "Desfaz" || botoes.get(op).getClass().getSimpleName() != "MACRO")
				historico.AddCommando("BOTAO "+op);
		}
		try {
			int pause= System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void fill(ArrayList<Invoker> botoes,AparelhoEletronico AE){
		for(int i=1;i<AE.getMaxBotoes() + 1;i++){
			botoes.add(AE.getInv(i));
		}
	}
	
	public static void Undo(historico historico,ArrayList<Invoker> botoes) {
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
}
