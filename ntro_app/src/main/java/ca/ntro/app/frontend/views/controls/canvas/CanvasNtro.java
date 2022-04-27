package ca.ntro.app.frontend.views.controls.canvas;

public abstract class CanvasNtro<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object,
                                 RAW_FONT extends Object,
                                 RAW_COLOR extends Object>

       implements Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> {
	
	private InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> graphicsContext;

	public InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> lambda) {
		graphicsContext.save();
		
		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}
}
