package ca.ntro.app.world2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class Object2dFx extends Object2d<GraphicsContext, 
                                                  Object2dFx,
                                                  World2dFx> {
	
	protected abstract boolean onMouseEvent(MouseEvent evtFx, double x, double y);

}
