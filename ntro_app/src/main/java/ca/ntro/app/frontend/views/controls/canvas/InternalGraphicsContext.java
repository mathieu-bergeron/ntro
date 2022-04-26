package ca.ntro.app.frontend.views.controls.canvas;

public interface InternalGraphicsContext<RAW_GC extends Object,
                                         RAW_CANVAS extends Object> 

       extends   GraphicsContext<RAW_GC, RAW_CANVAS> {

	void save();
	void restore();

}
