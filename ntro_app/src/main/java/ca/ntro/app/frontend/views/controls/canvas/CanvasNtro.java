package ca.ntro.app.frontend.views.controls.canvas;

public abstract class CanvasNtro<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object,
                                 RAW_FONT extends Object,
                                 RAW_COLOR extends Object,
                                 CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>>

       implements Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> {
	
	private InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> graphicsContext;

	public InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> lambda) {
		graphicsContext.save();

		graphicsContext.setTransform(1.0, 0, 0, 1.0, 0, 0); 

		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}
}
