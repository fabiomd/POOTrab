package Classes;

public class Methods {
	
	private static Pile visited;
	private static Pile way;
	
	public static Element CalculateBasics(Element e){
		int i=0,j=0;
		Element temp = new Element();
		Expand(e,temp);
		CopyUV(e,temp);
		while(i < (temp.u.length - 1) && j < (temp.v.length - 1)){
			if(temp.u[i] < temp.v[j]){
				temp.matrix[i][j] = temp.u[i];
				temp.v[j] -= temp.u[i];
				temp.u[i] = 0;
				temp.direction[i][j] = 1;
				i++;
			}else{
				temp.matrix[i][j] =  temp.v[j];
				temp.u[i] -= temp.v[j];
				temp.v[j] = 0;
				temp.direction[i][j] = -1;
				j++;
			}
		}
		return temp;
	}
	
	public static Element CalculateUV(Element e){
		Element temp = new Element();
		Expand(e,temp);
		copyFirst2Second(e.matrix,temp.matrix);
		copyFirst2Second(e.direction,temp.direction);
		CopyUV(e,temp);
		temp.u[0] = 0;
		int i=0,j=0;		
		int u = 1;
		int v = 0;
		
		for(i=0;i<temp.direction.length;i++){
			for(j=0;j< temp.direction[i].length;j++){
				
				if(temp.direction[i][j] != 0){
					if(i < u){
						temp.v[j] = temp.matrix[i][j] - temp.u[i];
						v++;
					}else
						if(j < v){
							temp.u[i] = temp.matrix[i][j] - temp.v[j];
							u++;
						}
				}
			}
		}
		return temp;
	}
	
	public static Element CalculateNBasics(Element e){
		Element temp = new Element();
		Expand(e,temp);
		copyFirst2Second(e.matrix,temp.matrix);
		copyFirst2Second(e.direction,temp.direction);
		CopyUV(e,temp);
		
		for(int i=0;i<temp.matrix.length;i++){
			for(int j=0;j<temp.matrix[i].length;j++){
				if(temp.direction[i][j] == 0){
					temp.matrix[i][j] = e.matrix[i][j] - temp.u[i] - temp.v[j];
				}
			}
		}
		
		return temp;
	}
	
	public static Element CalculateOptimumSolution(Element e,Element e2,Element previosly){
		Element temp = new Element();
		Expand(e,temp);
		copyFirst2Second(e.matrix,temp.matrix);
		copyFirst2Second(e.direction,temp.direction);
		CopyUV(e,temp);
		
		Point smaller = Smaller(temp);
		if (temp.matrix[smaller.getX()][smaller.getY()] >= 0)
			if(previosly != null){
				return zerateNBasics(previosly);
			}else{
				return zerateNBasics(e);
			}
		
		way = new Pile();
		visited = new Pile();
		way.StackUp(smaller);
		visited.StackUp(smaller);
		while(!way.wayClosed()){
			basicX(temp);
			basicY(temp);
		}
		Point smaller2 = way.smallOne(temp);
		Point temp2 = way.Unpack();
		int value = temp.matrix[smaller2.getX()][smaller2.getY()];
		temp.matrix[smaller.getX()][smaller.getY()] = 0;
		temp.direction[smaller.getX()][smaller.getY()] = 1;
		temp.direction[smaller2.getX()][smaller2.getY()] = 0;
		int c=0;
		while(temp2!=null){
			if(c%2 == 0){
				temp.matrix[temp2.getX()][temp2.getY()] -= value; 
			}else{
				temp.matrix[temp2.getX()][temp2.getY()] += value;
			}
			temp2 = way.Unpack();
			c = ++c%2;
		}		
		smaller = Smaller(temp);
		if(temp.matrix[smaller.getX()][smaller.getY()] < 0){
			Element temp3 = new Element();
			Expand(temp,temp3);
			copyFirst2Second(e2.matrix,temp3.matrix);
			copyFirst2Second(temp.direction,temp3.direction);
			CopyUV(e2,temp3);
			Element UV = CalculateUV(temp3);
			Element Nbasics = CalculateNBasics(UV);
			Methods.CopyUV(e2, Nbasics);
			return zerateNBasics(CalculateOptimumSolution(Nbasics,e2,temp));
		}
		
		return zerateNBasics(temp);
	}
	
	private static Element zerateNBasics(Element e){
		Element temp = new Element();
		Expand(e,temp);
		copyFirst2Second(e.matrix,temp.matrix);
		copyFirst2Second(e.direction,temp.direction);
		CopyUV(e,temp);
		for(int i=0;i<e.matrix.length;i++){
			for(int j=0;j<e.matrix[i].length;j++){
				if(temp.direction[i][j] == 0)
					temp.matrix[i][j] =0;
			}
		}
		return temp;
	}
	
	public static void basicX(Element e){
		Point temp = way.Unpack();
		if(temp == null)
			return;
		way.StackUp(temp);
		
		for(int j=0;j<e.matrix[temp.getX()].length;j++){
			if(e.direction[temp.getX()][j] != 0  && e.matrix[temp.getX()][j] > 0 && !visited.PiledUp(new Point(temp.getX(),j))){
				way.StackUp(new Point(temp.getX(),j));
				visited.StackUp(new Point(temp.getX(),j));
				return;
			}
		}
	}
	
	public static void PrintPoint(Point p){
		System.out.println("I "+p.getX()+" J "+p.getY());
	}
	
	public static void basicY(Element e){
		Point temp = way.Unpack();
		if(temp == null)
			return;
		way.StackUp(temp);
		
		for(int i=0;i<e.matrix.length;i++){
			if(e.direction[i][temp.getY()] != 0  && e.matrix[i][temp.getY()] > 0 && !visited.PiledUp(new Point(i,temp.getY()))){
				way.StackUp(new Point(i,temp.getY()));
				visited.StackUp(new Point(i,temp.getY()));
				return;
			}
		}
	}
	
	public static Point Smaller(Element e){
		Point smaller = new Point(0,0);
		for(int i=0;i<e.matrix.length;i++){
			for(int j=0;j<e.matrix[i].length;j++){
				if(e.matrix[i][j] < e.matrix[smaller.getX()][smaller.getY()] && e.direction[i][j] == 0){
					smaller = new Point(i,j);
				}
			}
		}
		return smaller;
	}
	
	public static void Expand(Element e,Element temp){
		temp.u = iniciateSameSizeAt(e.u);
		temp.v = iniciateSameSizeAt(e.v);
		temp.matrix = iniciateSameSizeAt(e.matrix);
		temp.direction = iniciateSameSizeAt(e.matrix);
	}
	
	public static void CopyUV(Element e,Element temp){
		copyFirst2Second(e.u,temp.u);
		copyFirst2Second(e.v,temp.v);
	}

	private static int[][] iniciateSameSizeAt(int[][] matrix){
		return new int[matrix.length][matrix[0].length];
	}
	
	private static int[] iniciateSameSizeAt(int[]matrix){
		return new int[matrix.length];
	}
	
	public static void copyFirst2Second(int[][] x,int[][] y){
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[i].length;j++){
				y[i][j] = x[i][j];
			}
		}
	}
	
	public static void copyFirst2Second(int[] x,int[] y){
		for(int i=0;i<x.length;i++){
			y[i] = x[i];
		}
	}
}
