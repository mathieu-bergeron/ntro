package ca.ntro.app.frontend.views.controls.canvas;

public interface World2dGraphicsContext<RAW_GC extends Object,
                                        RAW_CANVAS extends Object,
                                        RAW_IMAGE extends Object,
                                        RAW_FONT extends Object,
                                        RAW_COLOR extends Object>

       extends GraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> {

	double worldWidth();
	double worldHeight();

	double viewportTopLeftX();
	double viewportTopLeftY();
	double viewportWidth();
	double viewportHeight();

	double widthOnScreen(double worldWidth);
	double heightOnScreen(double worldHeight);

	double widthInWorld(double screenWidth);
	double heightInWorld(double screenHeight);

} 
