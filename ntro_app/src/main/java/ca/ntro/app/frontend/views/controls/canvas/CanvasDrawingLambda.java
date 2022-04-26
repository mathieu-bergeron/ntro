package ca.ntro.app.frontend.views.controls.canvas;

public interface CanvasDrawingLambda<RAW_GC extends Object,
                                     RAW_CANVAS extends Object,
                                     GC extends GraphicsContext<RAW_GC, RAW_CANVAS, GC, CANVAS>,
                                     CANVAS extends Canvas<RAW_GC, RAW_CANVAS, GC, CANVAS>>  {

	void draw(GraphicsContext<RAW_GC, RAW_CANVAS, GC, CANVAS> gc);

}
