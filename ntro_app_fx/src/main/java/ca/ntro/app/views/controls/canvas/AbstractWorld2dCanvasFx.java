package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.World2dCanvas;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public interface AbstractWorld2dCanvasFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D>,
                                         WORLD2D  extends World2dFx<OBJECT2D, WORLD2D>> 

       extends World2dCanvas<GraphicsContext, 
                             Canvas, 
                             Image, 
                             Font, 
                             Color,
                             AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D>,
                             World2dGraphicsContextFx<OBJECT2D, WORLD2D>,
                             OBJECT2D,
                             WORLD2D> {


}
