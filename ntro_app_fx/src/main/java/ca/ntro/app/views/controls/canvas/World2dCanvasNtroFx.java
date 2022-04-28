package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.World2dCanvasNtro;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class World2dCanvasNtroFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D>,
                                 WORLD2D  extends World2dFx<OBJECT2D, WORLD2D>> 

       extends World2dCanvasNtro<GraphicsContext, 
                                 Canvas, 
                                 Image, 
                                 Font, 
                                 Color,
                                 GraphicsContextFx,
                                 OBJECT2D,
                                 WORLD2D> {
	
	private World2dCanvasFx<OBJECT2D, WORLD2D> canvasFx;

	public World2dCanvasFx<OBJECT2D, WORLD2D> getCanvasFx() {
		return canvasFx;
	}

	public void setCanvasFx(World2dCanvasFx<OBJECT2D, WORLD2D> canvasFx) {
		this.canvasFx = canvasFx;
	}

	public World2dCanvasNtroFx(GraphicsContextFx graphicsContext, World2dCanvasFx<OBJECT2D, WORLD2D> canvasFx) {
		setGraphicsContext(graphicsContext);
		setCanvasFx(canvasFx);
	}

	@Override
	public Canvas getRawCanvas() {
		return getCanvasFx().getRawCanvas();
	}

	@Override
	public double canvasWidth() {
		return getCanvasFx().canvasWidth();
	}

	@Override
	public double canvasHeight() {
		return getCanvasFx().canvasHeight();
	}

	public void handleMouseEvent(MouseEvent event, MouseEventHandler handler) {
		double x = event.getX();
		double y = event.getY();
		
		// FIXME: should simply memorize the transform outside
		//        of the graphicsContext
		setWorld2dTransform();

		double mxx = getGraphicsContext().getRawGraphicsContext().getTransform().getMxx();
		double myy = getGraphicsContext().getRawGraphicsContext().getTransform().getMyy();
		double tx = getGraphicsContext().getRawGraphicsContext().getTransform().getTx();
		double ty = getGraphicsContext().getRawGraphicsContext().getTransform().getTy();
		
		double worldX = (x - tx) / mxx;
		double worldY = (y - ty) / myy;
		
		handler.handle(event, worldX, worldY);
		
	}



}
