package blockgame;

public abstract class CollidableObject extends GameObject {

	protected int width, height;
	
	public CollidableObject(float x, float y, int width, int height, ID id) {
		super(x, y, id);
		
		this.width = width;
		this.height = height;
		
	}

	public boolean collidesWith(CollidableObject otherObject) {
		
	    //This collider
	    int r1 = (int) (x + width/2);
	    int l1 = (int) (x - width/2);
	    int t1 = (int) (y + height/2);
	    int b1 = (int) (y - height/2);

	    //The other collider
	    int r2 = (int) (otherObject.getX() + otherObject.getWidth()/2);
	    int l2 = (int) (otherObject.getX() - otherObject.getWidth()/2);
	    int t2 = (int) (otherObject.getY() + otherObject.getHeight()/2);
	    int b2 = (int) (otherObject.getY() - otherObject.getHeight()/2);

	    if (r1 < l2 || l1 > r2 || t1 < b2 || b1 > t2)
	       return false;
	    else
	       return true;

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
