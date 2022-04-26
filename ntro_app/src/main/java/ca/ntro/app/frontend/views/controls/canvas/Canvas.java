package ca.ntro.app.frontend.views.controls.canvas;

public interface Canvas<GC extends GraphicsContext> {
	
	double canvasWidth();
	double canvasHeight();

	double viewportWidth();
	double viewportHeight();
	
	void drawOnCanvas(CanvasDrawingLambda lambda);
	void drawOnViewport(CanvasDrawingLambda lambda);

}
