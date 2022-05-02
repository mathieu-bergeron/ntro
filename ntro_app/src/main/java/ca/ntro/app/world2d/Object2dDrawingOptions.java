package ca.ntro.app.world2d;

public interface Object2dDrawingOptions {
	
	double widthOnScreen(double worldWidth);
	double heightOnScreen(double worldHeight);

	double widthInWorld(double screenWidth);
	double heightInWorld(double screenHeight);

}
