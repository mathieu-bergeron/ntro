package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.world2d.Object2d;
import ca.ntro.app.world2d.World2d;

public interface World2dCanvas<RAW_GC extends Object,
                               RAW_CANVAS extends Object, 
                               RAW_IMAGE extends Object,
                               RAW_FONT extends Object,
                               RAW_COLOR extends Object,

                               GC extends GraphicsContext<RAW_GC, 
                                                          RAW_CANVAS, 
                                                          RAW_IMAGE,
                                                          RAW_FONT,
                                                          RAW_COLOR>,

							   OBJECT2D extends Object2d<RAW_GC, 
														 RAW_CANVAS, 
														 RAW_IMAGE,
														 RAW_FONT,
														 RAW_COLOR,
														 GC,
														 OBJECT2D,
														 WORLD2D>,

							   WORLD2D  extends World2d<RAW_GC, 
														RAW_CANVAS, 
														RAW_IMAGE, 
														RAW_FONT,
														RAW_COLOR,
														GC,
														OBJECT2D,
														WORLD2D>> 

       extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> {

	WORLD2D world();

	double viewportWidth();
	double viewportHeight();
	
	void drawOnWorld(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> lambda);
	void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> lambda);
}
