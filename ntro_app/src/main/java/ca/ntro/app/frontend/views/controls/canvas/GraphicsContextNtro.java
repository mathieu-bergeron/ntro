package ca.ntro.app.frontend.views.controls.canvas;

public abstract class GraphicsContextNtro<RAW_GC extends Object, 
                                          RAW_CANVAS extends Object>

       implements InternalGraphicsContext<RAW_GC, RAW_CANVAS> {
	
	private Canvas<RAW_GC, RAW_CANVAS> canvas;

	public Canvas<RAW_GC, RAW_CANVAS> getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas<RAW_GC, RAW_CANVAS> canvas) {
		this.canvas = canvas;
	}

}
