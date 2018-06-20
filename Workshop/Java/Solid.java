public abstract class Solid{
	protected float totalSurfaceArea;
	protected float lateralSurfaceArea;
	protected float volume;
	

	abstract void setTotalSurfaceArea();
	abstract void setLateralSurfaceArea();
	abstract void setVolume();	
	
	
	public void showTotalSurfaceArea(){
		System.out.println("The total surface area is "+totalSurfaceArea);
	}
	
	public void showLateralSurfaceArea(){
		System.out.println("The lateral surface area is "+lateralSurfaceArea);
	}

   public void showVolume(){
		System.out.println("The volume is "+volume);
	}
}
	