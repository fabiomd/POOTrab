package Classes;

public class Point {
	
	private int x,y;
	
	public Point(int x,int y){
		this.setX(x);
		this.setY(y);
	}

	public boolean Igual(Point p){
		if(p == null)
			return false;
		return p.getX() == this.getX() && p.getY() == this.getY();
	}
	
	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
}
