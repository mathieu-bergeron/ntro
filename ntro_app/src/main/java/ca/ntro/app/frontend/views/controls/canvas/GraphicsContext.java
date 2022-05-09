package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.frontend.views.elements.Color;
import ca.ntro.app.frontend.views.elements.Image;

public interface GraphicsContext<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object,
                                 RAW_FONT extends Object,
                                 RAW_COLOR extends Object,
                                 CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>> {

	Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> getCanvas();
	RAW_GC getRawGraphicsContext();
	
	void setFill(Color<RAW_COLOR> color);
	void setStroke(Color<RAW_COLOR> color);

	void clearRect(double topLeftX, double topLeftY, double width, double height);
	
	void fillRect(double topLeftX, double topLeftY, double width, double height);
	void strokeRect(double topLeftX, double topLeftY, double width, double height);

	void fillArc(double topLeftX, double topLeftY, double width, double height, double startAngle, double arcExtent);
	void strokeArc(double topLeftX, double topLeftY, double width, double height, double startAngle, double arcExtent);
	
	void drawImage(Image<RAW_IMAGE> image, double topLeftX, double topLeftY);

	void fillText(String text, double topLeftX, double topLeftY);
	void strokeText(String text, double topLeftX, double topLeftY);

	void translate(double x, double y);
	void scale(double x, double y);
	void rotate(double degrees);

	void beginPath();
	void rect(double topLeftX, double topLeftY, double width, double height);
	void clip();
	

}
