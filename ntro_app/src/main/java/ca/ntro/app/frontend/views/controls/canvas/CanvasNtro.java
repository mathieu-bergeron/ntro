package ca.ntro.app.frontend.views.controls.canvas;

public class CanvasNtro<GC     extends GraphicsContextNtro<GC,CANVAS>,
                        CANVAS extends CanvasNtro<GC,CANVAS>> 

       implements Canvas<GC> {
	
	private double canvasWidth;
	private double canvasHeight;

	private double viewportWidth;
	private double viewportHeight;

	private GC graphicsContext;

	public double getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(double canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public double getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(double canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	public double getViewportWidth() {
		return viewportWidth;
	}

	public void setViewportWidth(double viewportWidth) {
		this.viewportWidth = viewportWidth;
	}

	public double getViewportHeight() {
		return viewportHeight;
	}

	public void setViewportHeight(double viewportHeight) {
		this.viewportHeight = viewportHeight;
	}

	public GC getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(GC graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	@Override
	public double canvasWidth() {
		return getCanvasWidth();
	}

	@Override
	public double canvasHeight() {
		return getCanvasHeight();
	}

	@Override
	public double viewportWidth() {
		return getViewportWidth();
	}

	@Override
	public double viewportHeight() {
		return getViewportHeight();
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda lambda) {
		graphicsContext.save();
		
		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda lambda) {
		graphicsContext.save();
		
		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}

}
