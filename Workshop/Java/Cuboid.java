public class Cuboid extends Solid{
	private float length;
	private float breadth;
	private float height;
	
	public Cuboid(){
		this.length=5;
		this.breadth=2;
		this.height=1;

	}
	
	public Cuboid(float length,float breadth,float height){
		this.length=length;
		this.breadth=breadth;
		this.height=height;
	}
	
	public void setTotalSurfaceArea(){
		totalSurfaceArea= 2*(length*breadth + breadth*height + length*height);
	}

	public void setLateralSurfaceArea(){
		lateralSurfaceArea= 2*(length + breadth) *height;
	}
	
	public void setVolume(){
		volume= length*breadth*height;
	}
}
