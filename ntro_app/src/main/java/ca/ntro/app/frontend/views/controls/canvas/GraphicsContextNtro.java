package ca.ntro.app.frontend.views.controls.canvas;

public abstract class GraphicsContextNtro<RAW_GC extends Object, 
                                          RAW_CANVAS extends Object,
                                          RAW_IMAGE extends Object,
                                          RAW_FONT extends Object,
                                          RAW_COLOR extends Object>

       implements GraphicsContext<RAW_GC,RAW_CANVAS,RAW_IMAGE, RAW_FONT, RAW_COLOR>,
                  InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> {
	
	private Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> canvas;

	public Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> canvas) {
		this.canvas = canvas;
	}

}
