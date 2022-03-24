package ca.ntro.app.world2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class World2dFx extends World2d<GraphicsContext, 
                                                Object2dFx,
                                                World2dFx> {

	public void dispatchMouseEvent(MouseEvent evtFx, double x, double y) {
		boolean dispatched = false;
		for(Object2dFx object : getObjects()) {
			if(object.collidesWith(x-2, y-2, 4, 4)) {
				object.onMouseEvent(evtFx, x, y);
				dispatched = true;
			}
		}

		if(!dispatched) {
			onMouseEventNotDispatched(evtFx, x, y);
		}
	}

	protected abstract void onMouseEventNotDispatched(MouseEvent evtFx, double x, double y);

}
