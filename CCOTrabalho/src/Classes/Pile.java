package Classes;

import java.util.ArrayList;

public class Pile {
	
	private ArrayList<Point> pile = new ArrayList<Point>();
	
	public void StackUp(Point point){
		pile.add(point);
	}
	
	public Point Unpack(){
		if(pile.size() == 0)
			return null;
		Point temp = pile.get(pile.size() - 1);
		pile.remove(pile.size() -1);
		return temp;
	}
	
	public boolean PiledUp(Point point){
		for(int i=0;i<pile.size();i++){
			if(pile.get(i).Igual(point)){
				return true;
			}
		}
		return false;
	}
	
	public Point smallOne(Element e){
		int x=e.matrix[pile.get(1).getX()][pile.get(1).getY()];
		int t=1;
		for(int i=2;i<pile.size();i++){
			if(e.matrix[pile.get(i).getX()][pile.get(i).getY()] < x && i%2 == 1){
				x=e.matrix[pile.get(i).getX()][pile.get(i).getY()];
				t=i;
			}
		}
		return getIndex(t);
	}
	
	private Point getIndex(int i){
		return pile.get(i);
	}
	
	public boolean wayClosed(){
		if(pile.size() < 2){
			return false;
		}
		//return pile.get(0).Igual(pile.get(pile.size() -1));
		return pile.get(0).getY() == pile.get(pile.size() -1).getY();
	}
}
