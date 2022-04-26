package ca.ntro.app.frontend.views.controls.canvas;

public abstract class GraphicsContextNtro<RAW_GC extends Object, 
                                          RAW_CANVAS extends Object,
                                          GC extends GraphicsContext<RAW_GC, RAW_CANVAS, GC, CANVAS>,
                                          CANVAS extends Canvas<RAW_GC, RAW_CANVAS, GC, CANVAS>>

       implements GraphicsContext<RAW_GC, RAW_CANVAS, GC,CANVAS> {
	
	private CANVAS canvas;

	public CANVAS getCanvas() {
		return canvas;
	}

	public void setCanvas(CANVAS canvas) {
		this.canvas = canvas;
	}

}
