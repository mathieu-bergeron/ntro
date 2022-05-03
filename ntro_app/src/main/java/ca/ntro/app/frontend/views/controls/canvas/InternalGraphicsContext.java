package ca.ntro.app.frontend.views.controls.canvas;

public interface InternalGraphicsContext<RAW_GC extends Object,
                                         RAW_CANVAS extends Object, 
                                         RAW_IMAGE extends Object,
                                         RAW_FONT extends Object,
                                         RAW_COLOR extends Object,
                                         CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>> 

       extends   GraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> {

	void save();
	void restore();

    void setTransform(double scaleX, double shearX, double shearY, double scaleY, double translateX, double translateY);


}
