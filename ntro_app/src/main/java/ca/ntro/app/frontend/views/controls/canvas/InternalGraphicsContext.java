package ca.ntro.app.frontend.views.controls.canvas;

public interface InternalGraphicsContext<RAW_GC extends Object,
                                         RAW_CANVAS extends Object, 
                                         RAW_IMAGE extends Object> 

       extends   GraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE> {

	void save();
	void restore();

}
