package ca.ntro.app.frontend.views.controls.canvas;

public abstract class GraphicsContextNtro<RAW_GC extends Object, 
                                          RAW_CANVAS extends Object,
                                          RAW_IMAGE extends Object,
                                          RAW_FONT extends Object,
                                          RAW_COLOR extends Object,
                                          CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>>
                                          

       implements GraphicsContext<RAW_GC,RAW_CANVAS,RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>,
                  InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> {
	
	private CANVAS canvas;

	public CANVAS getCanvas() {
		return canvas;
	}

	public void setCanvas(CANVAS canvas) {
		this.canvas = canvas;
	}

}
