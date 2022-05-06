package ca.ntro.app.frontend.views.controls.canvas;

public interface World2dDimensions {

	double worldWidth();
	double worldHeight();

	double viewportTopLeftX();
	double viewportTopLeftY();
	double viewportWidth();
	double viewportHeight();

	double widthOnScreen(double widthInWorld);
	double heightOnScreen(double heightInWorld);

	double widthInWorld(double widthOnScreen);
	double heightInWorld(double heightOnScreen);

}
