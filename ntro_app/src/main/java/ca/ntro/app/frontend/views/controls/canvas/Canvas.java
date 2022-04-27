package ca.ntro.app.frontend.views.controls.canvas;

public interface Canvas<RAW_GC extends Object,
                        RAW_CANVAS extends Object, 
                        RAW_IMAGE extends Object> {

	RAW_CANVAS getRawCanvas();
	
	double canvasWidth();
	double canvasHeight();

	double viewportWidth();
	double viewportHeight();
	
	void drawOnWorld(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda);
	void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda);
	void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda);

}
