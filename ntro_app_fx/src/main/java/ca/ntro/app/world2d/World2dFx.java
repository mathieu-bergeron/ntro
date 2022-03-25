package ca.ntro.app.world2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class World2dFx extends World2d<GraphicsContext, 
                                                Object2dFx,
                                                World2dFx> {

	public void dispatchMouseEvent(MouseEvent evtFx, double x, double y) {
		boolean consumed = false;
		for(Object2dFx object : getObjects()) {
			if(object.collidesWith(x-2, y-2, 4, 4)) {
				consumed = consumed || object.onMouseEvent(evtFx, x, y);
			}
		}

		if(!consumed) {
			onMouseEventNotConsumed(evtFx, x, y);
		}
	}

	protected abstract void onMouseEventNotConsumed(MouseEvent evtFx, double x, double y);

}
