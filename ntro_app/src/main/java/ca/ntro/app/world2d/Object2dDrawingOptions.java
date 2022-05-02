package ca.ntro.app.world2d;

public interface Object2dDrawingOptions {
	
	double screenWidth(double worldWidth);
	double screenHeight(double worldHeight);

	double worldWidth(double screenWidth);
	double worldHeight(double screenHeight);

}
