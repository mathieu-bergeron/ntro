package ca.ntro.app.frontend.views.controls.canvas;

public abstract class CanvasNtro<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object>

       implements Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> {
	
	private InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> graphicsContext;

	public InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda) {
		graphicsContext.save();
		
		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}
}
