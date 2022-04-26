package ca.ntro.app.frontend.views.controls.canvas;

public interface Canvas<RAW_GC extends Object,
                        RAW_CANVAS extends Object,
                        GC extends GraphicsContext<RAW_GC, RAW_CANVAS, GC, CANVAS>,
                        CANVAS extends Canvas<RAW_GC, RAW_CANVAS, GC, CANVAS>> {

	RAW_CANVAS getRawCanvas();
	GC getGraphicsContext();
	
	double canvasWidth();
	double canvasHeight();

	double viewportWidth();
	double viewportHeight();
	
	void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, GC, CANVAS> lambda);
	void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, GC, CANVAS> lambda);

}
