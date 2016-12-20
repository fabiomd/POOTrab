import java.util.ArrayList;

public class historico {
	private ArrayList<String> commandos = new ArrayList<String>();
	private int max = 1;
	
	public historico(int max){
		this.max = max;
	}
	
	public void AddCommando(String commando){
		if(commandos.size() == max){
			commandos.remove(0);
		}
		commandos.add(commando.toUpperCase());
	}
	
	public String RemoveCommando(){
		if(commandos.size() == 0){
			return "NAO HA MAIS HISTORICO";
		}
		else{
			String temp = commandos.get(commandos.size()-1);
			commandos.remove(commandos.size()-1);
			return temp;
		}
	}
}
