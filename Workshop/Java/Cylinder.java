public class Cylinder extends Solid{
	private float radius;
	private float height;
	
	public Cylinder(){
		this.radius=5;
		this.height=2;
	}
	
	public Cylinder(float radius,float height){
		this.radius=radius;
		this.height=height;
	}
	
	public void setTotalSurfaceArea(){
		totalSurfaceArea=(float)6.28*radius*(radius+height);
	}

	public void setLateralSurfaceArea(){
		lateralSurfaceArea=(float)6.28*radius*height;
	}
	public void setVolume(){
		volume=(float)3.14*radius*radius*height;
	}
}

