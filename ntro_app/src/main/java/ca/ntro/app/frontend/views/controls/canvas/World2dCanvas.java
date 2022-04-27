package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.world2d.World2d;

public interface World2dCanvas <RAW_GC extends Object,
                                RAW_CANVAS extends Object, 
                                RAW_IMAGE extends Object> 

       extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> {

	World2d getWorld();

	double viewportWidth();
	double viewportHeight();
	
	void drawOnWorld(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda);
	void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda);
}
