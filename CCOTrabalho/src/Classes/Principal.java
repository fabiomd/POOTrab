package Classes;

public class Principal {
	
	public static void main(String[] args){
		
		Element matrix = Utilities.ReadMatrix();
		Northwest NW = new Northwest();
		NW.Calculate(matrix);
	}
}
