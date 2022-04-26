package ca.ntro.app.frontend.views.controls.canvas;

public interface CanvasDrawingLambda<RAW_GC extends Object,
                                     RAW_CANVAS extends Object> {

	void draw(GraphicsContext<RAW_GC, RAW_CANVAS> gc);

}
