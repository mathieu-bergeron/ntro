package ca.ntro.app.frontend.views.controls.canvas;

public abstract class CanvasNtro<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object>

       implements Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> {
	
	private double canvasWidth;
	private double canvasHeight;

	private double viewportWidth;
	private double viewportHeight;

	private InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> graphicsContext;

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

	public InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> graphicsContext) {
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
	public void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda) {
		graphicsContext.save();
		
		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda) {
		graphicsContext.save();
		
		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}

}
