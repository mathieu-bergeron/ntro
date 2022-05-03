package ca.ntro.app.frontend.views.controls.canvas;

public interface Canvas<RAW_GC extends Object,
                        RAW_CANVAS extends Object, 
                        RAW_IMAGE extends Object,
                        RAW_FONT extends Object,
                        RAW_COLOR extends Object,
                        CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>> {

	RAW_CANVAS getRawCanvas();

	double canvasWidth();
	double canvasHeight();
	
	void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> lambda);
	
	void clearCanvas();

}
