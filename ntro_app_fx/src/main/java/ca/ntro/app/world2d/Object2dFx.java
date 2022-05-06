package ca.ntro.app.world2d;

import ca.ntro.app.views.controls.canvas.AbstractWorld2dCanvasFx;
import ca.ntro.app.views.controls.canvas.World2dGraphicsContextFx;
import ca.ntro.app.views.controls.canvas.World2dMouseEventFx;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class Object2dFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                 WORLD2D extends World2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                 OPTIONS extends DrawingOptions> 
       
      extends Object2dNtro<GraphicsContext, 
                           Canvas,
                           Image,
                           Font,
                           Color,
                           AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>,
                           World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS>,
                           OBJECT2D,
                           WORLD2D,
                           OPTIONS>  {
	
	protected abstract boolean onMouseEvent(World2dMouseEventFx mouseEvent);

}
