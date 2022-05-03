package ca.ntro.app.frontend.views.controls.canvas;

public interface World2dGraphicsContext<RAW_GC extends Object,
                                        RAW_CANVAS extends Object,
                                        RAW_IMAGE extends Object,
                                        RAW_FONT extends Object,
                                        RAW_COLOR extends Object,
                                        CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>>

       extends GraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> {

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
