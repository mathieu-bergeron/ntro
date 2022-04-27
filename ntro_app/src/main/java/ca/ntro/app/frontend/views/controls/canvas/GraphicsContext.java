package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.frontend.views.elements.Image;

public interface GraphicsContext<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object,
                                 RAW_FONT extends Object,
                                 RAW_COLOR extends Object> {

	Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> getCanvas();
	RAW_GC getRawGraphicsContext();

	
	void fillRect(double topLeftX, double topLeftY, double width, double height);
	
	void drawImage(Image<RAW_IMAGE> image, double topLeftX, double topLeftY);

	void translate(double x, double y);
	void scale(double x, double y);
	void rotate(double degrees);

}
