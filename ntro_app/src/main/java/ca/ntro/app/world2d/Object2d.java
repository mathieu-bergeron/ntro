package ca.ntro.app.world2d;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.GraphicsContext;
import ca.ntro.app.models.Value;
import ca.ntro.core.data_structures.trees.region_tree.Region2d;

public interface Object2d<RAW_GC extends Object,
                          RAW_CANVAS extends Object, 
                          RAW_IMAGE extends Object,
                          RAW_FONT extends Object,
                          RAW_COLOR extends Object,
                          CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>,

                          GC extends GraphicsContext<RAW_GC, 
                                                     RAW_CANVAS, 
                                                     RAW_IMAGE,
                                                     RAW_FONT,
                                                     RAW_COLOR,
                                                     CANVAS>,

						  OBJECT2D extends Object2dNtro<RAW_GC, 
														RAW_CANVAS, 
														RAW_IMAGE,
														RAW_FONT,
														RAW_COLOR,
														CANVAS,
													    GC,
														OBJECT2D,
														WORLD2D,
														OPTIONS>,

					      WORLD2D  extends World2d<RAW_GC, 
											       RAW_CANVAS, 
											       RAW_IMAGE, 
												   RAW_FONT,
												   RAW_COLOR,
												   CANVAS,
												   GC,
												   OBJECT2D,
												   WORLD2D,
												   OPTIONS>,

					      OPTIONS extends World2dDrawingOptions> 

      extends Region2d, Value {
                                                    	 
                                                    	 
     WORLD2D world();

	 double speedX(); 
	 double speedY(); 

}
