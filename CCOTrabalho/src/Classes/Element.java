package Classes;

public class Element {
	public int[][] matrix;
	public int[][] direction;
	public int[] u;
	public int[] v;
	
	public void PrintAll(){
		if(matrix!=null && u!= null && v != null){
			for(int i=0;i<matrix.length;i++)
				System.out.print("     ");
			System.out.println("U");
			for(int i=0;i<matrix.length;i++){
				System.out.print("  ");
				for(int j=0;j<matrix[0].length;j++)
					System.out.printf("%02d ",matrix[i][j]);
				System.out.printf("%02d ", u[i]);
				System.out.println("");
			}
			System.out.print("V ");
			printV();
			System.out.println("");
		}
	}
	
	public void PrintAll2(String title){
		String temp ="";
		if(matrix!=null && u!= null && v != null){
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[0].length;j++){
					if(Integer.toString(matrix[i][j]).length() == 1)
						temp+="0";
					temp +=matrix[i][j] + " ";
				}
				if(Integer.toString(u[i]).length() == 1)
					temp+="0";
				temp +=u[i]+"\n";
				//System.out.println("");
			}
			temp +=printV2();
			View.infoBox(temp, title);
		}
	}
	
	public static void Mix(Element e1, Element e2){
		for(int i=0;i<e1.direction.length;i++){
			for(int j=0;j<e1.direction[i].length;j++){
				if(e2.direction[i][j] == 0){
					e2.matrix[i][j] = e1.matrix[i][j];
				}
			}
		}
	}
	
	public void printMatrix(){
		if(matrix!=null){
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[0].length;j++)
					System.out.printf("%02d ",matrix[i][j]);
				System.out.println("");
			}
			System.out.println("");
		}
    }
	
	public void printDirection(){
		if(direction!=null){
			for(int i=0;i<direction.length;i++){
				for(int j=0;j<direction[0].length;j++)
					System.out.printf("%02d ",direction[i][j]);
				System.out.println("");
			}
			System.out.println("");
		}
    }
	
	public void printU(){
		if(u!=null){
			for(int i=0;i<u.length;i++)
				System.out.printf("%02d \n",u[i]);
			System.out.println("");
		}
    }
	
	public void printV(){
		if(v!=null){
			for(int i=0;i<v.length;i++)
				System.out.printf("%02d ",v[i]);
			System.out.println("");
		}
    }
	
	public String printV2(){
		String temp = "";
		if(v!=null){
			for(int i=0;i<v.length;i++){
				if(Integer.toString(v[i]).length() == 1)
					temp+="0";
				temp +=v[i] +" ";
			}
		}
		return temp + "\n";
    }
}
