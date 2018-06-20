public class SolidDriver{
	public static void main(String args[]){
		Sphere s = new Sphere();
	    Cube c = new Cube(10);
	    Cuboid cu = new Cuboid();
	    Cylinder cy = new Cylinder();
	    
	    System.out.println("Sphere :");
	    s.setLateralSurfaceArea();
	    s.showLateralSurfaceArea();
	    s.setTotalSurfaceArea();
	    s.showTotalSurfaceArea();
	    s.setVolume();
	    s.showVolume();

        System.out.println("Cube :");
	    c.setLateralSurfaceArea();
	    c.showLateralSurfaceArea();
	    c.setTotalSurfaceArea();
	    c.showTotalSurfaceArea();
	    c.setVolume();
	    c.showVolume();
 
        System.out.println("Cuboid :");
	    cu.setLateralSurfaceArea();
	    cu.showLateralSurfaceArea();
	    cu.setTotalSurfaceArea();
	    cu.showTotalSurfaceArea();
	    cu.setVolume();
	    cu.showVolume();
	    
        System.out.println("Cylinder :");
	    cy.setLateralSurfaceArea();
	    cy.showLateralSurfaceArea();
	    cy.setTotalSurfaceArea();
	    cy.showTotalSurfaceArea();
	    cy.setVolume();
	    cy.showVolume();




	}
}
		
	
