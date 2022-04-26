package ca.ntro.app.frontend.views.controls.canvas;

public abstract class GraphicsContextNtro<RAW_GC extends Object, 
                                          RAW_CANVAS extends Object,
                                          RAW_IMAGE extends Object>

       implements InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> {
	
	private Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> canvas;

	public Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> canvas) {
		this.canvas = canvas;
	}

}
