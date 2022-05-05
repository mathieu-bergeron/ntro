package ca.ntro.app.world2d;

import ca.ntro.app.views.controls.canvas.AbstractWorld2dCanvasFx;
import ca.ntro.app.views.controls.canvas.World2dGraphicsContextFx;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class World2dFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                WORLD2D  extends World2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                OPTIONS extends DrawingOptions> 

       extends World2d<GraphicsContext, 
                       Canvas,
                       Image,
                       Font,
                       Color,
                       AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>,
                       World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS>,
                       OBJECT2D,
                       WORLD2D,
                       OPTIONS> {

	public void dispatchMouseEvent(MouseEvent evtFx, 
			                       double worldX, 
			                       double worldY) {

		boolean consumed = false;
		for(OBJECT2D object : getObjects()) {
			if(object.collidesWith(worldX-2, worldY-2, 4, 4)) {
				consumed = consumed || object.onMouseEvent(evtFx, worldX, worldY);
			}
		}

		if(!consumed) {
			onMouseEventNotConsumed(evtFx, worldX, worldY);
		}
	}

	protected abstract void onMouseEventNotConsumed(MouseEvent evtFx, 
			                                        double worldX, 
			                                        double worldY);

}
