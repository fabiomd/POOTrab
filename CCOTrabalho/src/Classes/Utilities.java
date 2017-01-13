package Classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utilities {
	
	public static Element ReadMatrix(){
		Element temp = new Element();
		List<String> matrix = ReadFile("matrix.txt");
		String[] values = matrix.get(0).split(" ");
		temp.matrix = new int[matrix.size()][values.length];
		temp.direction = new int[matrix.size()][values.length];
		for(int i=0;i<matrix.size();i++){
			values = matrix.get(i).split(" ");
			for(int j=0;j<values.length;j++)
				temp.matrix[i][j] = Integer.parseInt(values[j]);
		}
		int tempcount = values.length;
		boolean ut = false;
		boolean vt = false;
		int count = 0;
		
		List<String> u = ReadFile("u.txt");
		values = u.get(0).split(" ");
		if(matrix.size() == values.length){
			temp.u = new int[values.length + 1];
			ut=true;
		}
		else
			temp.u = new int[values.length];
		
		for(int j=0;j<values.length;j++){
			temp.u[j] = Integer.parseInt(values[j]);
			count += temp.u[j];
			}
		
		if(ut)
			temp.u[temp.u.length - 1] = count;
		
		List<String> v = ReadFile("v.txt");
		values =v.get(0).split(" ");
		
		tempcount = values.length;
		if(tempcount == values.length){
			temp.v = new int[values.length + 1];
			vt=true;
		}
		else
			temp.v = new int[values.length];
		
		count = 0;
		for(int j=0;j<values.length;j++){
			temp.v[j] = Integer.parseInt(values[j]);
			count +=temp.v[j];
		}
		if(vt)
			temp.v[temp.v.length - 1] = count;
		
		return temp;
	}
	
	public static List<String> ReadFile(String fileName){
		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName));
			return lines;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void fill(Element e){

		e.matrix = new int[3][4];
		e.u = new int[4];
		e.v = new int[5];
		e.direction = new int[3][4];
		
		e.matrix[0][0] = 1;
		e.matrix[1][0] = 4;
		e.matrix[2][0] = 0;
		
		e.matrix[0][1] = 2;
		e.matrix[1][1] = 3;
		e.matrix[2][1] = 2;
		
		e.matrix[0][2] = 3;
		e.matrix[1][2] = 2;
		e.matrix[2][2] = 2;
		
		e.matrix[0][3] = 4;
		e.matrix[1][3] = 4;
		e.matrix[2][3] = 1;
		
		e.v[0] = 4;
		e.v[1] = 7;
		e.v[2] = 6;
		e.v[3] = 7;
		e.v[4] = 24;
		
		e.u[0] = 6;
		e.u[1] = 8;
		e.u[2] = 10;
		e.u[3] = 24;
	}

}
