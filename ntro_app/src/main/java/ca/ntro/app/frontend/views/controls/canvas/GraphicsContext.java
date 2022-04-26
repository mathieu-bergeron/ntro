package ca.ntro.app.frontend.views.controls.canvas;

public interface GraphicsContext<RAW_GC extends Object,
                                 RAW_CANVAS extends Object> {

	Canvas<RAW_GC, RAW_CANVAS> getCanvas();
	RAW_GC getRawGraphicsContext();

	void save();
	void restore();
	
	void fillRect(double topLeftX, double topLeftY, double width, double height);

	void translate(double x, double y);
	void scale(double x, double y);
	void rotate(double degrees);

}
