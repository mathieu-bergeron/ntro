package ca.ntro.app.frontend.views.controls.canvas;

public interface GraphicsContext<RAW_GC extends Object, 
                                 RAW_CANVAS extends Object,
                                 GC extends GraphicsContext<RAW_GC, RAW_CANVAS, GC, CANVAS>,
                                 CANVAS extends Canvas<RAW_GC, RAW_CANVAS, GC, CANVAS>> {

	CANVAS getCanvas();
	RAW_GC getRawGraphicsContext();

	void save();
	void restore();

	void translate(double x, double y);
	void scale(double x, double y);
	void rotate(double degrees);

}
