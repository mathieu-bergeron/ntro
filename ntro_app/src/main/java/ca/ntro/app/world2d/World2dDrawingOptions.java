package ca.ntro.app.world2d;

public interface World2dDrawingOptions extends Object2dDrawingOptions {
	
	double viewportTopLeftX();
	double viewportTopLeftY();
	double viewportWidth();
	double viewportHeight();
	
	Object2dDrawingOptions toObject2dDrawingOptions();
	

}
