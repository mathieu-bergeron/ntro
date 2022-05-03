package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class World2dGraphicsContextFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D>,
                                      WORLD2D  extends World2dFx<OBJECT2D, WORLD2D>> 

       extends GraphicsContextFx<AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D>>

       implements World2dGraphicsContext<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D>> {

	public World2dGraphicsContextFx(GraphicsContext gc, AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D> canvas) {
		super(gc);
		setCanvas(canvas);
	}

	@Override
	public double worldWidth() {
		return getCanvas().worldWidth();
	}

	@Override
	public double worldHeight() {
		return getCanvas().worldHeight();
	}

	@Override
	public double viewportTopLeftX() {
		return getCanvas().viewportTopLeftX();
	}

	@Override
	public double viewportTopLeftY() {
		return getCanvas().viewportTopLeftY();
	}

	@Override
	public double viewportWidth() {
		return getCanvas().viewportWidth();
	}

	@Override
	public double viewportHeight() {
		return getCanvas().viewportHeight();
	}

	@Override
	public double widthOnScreen(double widthInWorld) {
		return widthInWorld * getCanvas().canvasWidth() / viewportWidth();
	}

	@Override
	public double heightOnScreen(double heightInWorld) {
		return heightInWorld * getCanvas().canvasHeight() / viewportHeight();
	}

	@Override
	public double widthInWorld(double widthOnScreen) {
		return widthOnScreen * viewportWidth() / getCanvas().canvasWidth();
	}

	@Override
	public double heightInWorld(double heightOnScreen) {
		return heightOnScreen * viewportHeight() / getCanvas().canvasHeight();
	}
}
