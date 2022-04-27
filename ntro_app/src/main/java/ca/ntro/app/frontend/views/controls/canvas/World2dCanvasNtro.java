package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.world2d.Object2d;
import ca.ntro.app.world2d.World2d;

public abstract class World2dCanvasNtro<RAW_GC extends Object,
                                        RAW_CANVAS extends Object, 
                                        RAW_IMAGE extends Object,
                                        RAW_FONT extends Object,
                                        RAW_COLOR extends Object,

                                        GC extends GraphicsContext<RAW_GC, 
                                                                   RAW_CANVAS, 
                                                                   RAW_IMAGE,
                                                                   RAW_FONT,
                                                                   RAW_COLOR>,

							            OBJECT2D extends Object2d<RAW_GC, 
														          RAW_CANVAS, 
														          RAW_IMAGE,
														          RAW_FONT,
														          RAW_COLOR,
														          GC,
														          OBJECT2D,
														          WORLD2D>,

							            WORLD2D  extends World2d<RAW_GC, 
														         RAW_CANVAS, 
														         RAW_IMAGE, 
														         RAW_FONT,
														         RAW_COLOR,
														         GC,
														         OBJECT2D,
														         WORLD2D>> 

       extends CanvasNtro<RAW_GC, 
                          RAW_CANVAS, 
                          RAW_IMAGE,
                          RAW_FONT,
                          RAW_COLOR>

       implements World2dCanvas<RAW_GC, 
                                RAW_CANVAS, 
                                RAW_IMAGE, 
                                RAW_FONT,
                                RAW_COLOR,
                                GC,
                                OBJECT2D, 
                                WORLD2D> {
    	   
    private WORLD2D world;

	private double viewportWidth;
	private double viewportHeight;

	public double getViewportWidth() {
		return viewportWidth;
	}

	public void setViewportWidth(double viewportWidth) {
		this.viewportWidth = viewportWidth;
	}

	public double getViewportHeight() {
		return viewportHeight;
	}

	public void setViewportHeight(double viewportHeight) {
		this.viewportHeight = viewportHeight;
	}

	public WORLD2D getWorld() {
		return world;
	}

	public void setWorld(WORLD2D world) {
		this.world = world;
	}

	@Override
	public double viewportWidth() {
		return getViewportWidth();
	}

	@Override
	public double viewportHeight() {
		return getViewportHeight();
	}
	
	@Override 
	public WORLD2D world() {
		return getWorld();
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> lambda) {
		getGraphicsContext().save();
		
		lambda.draw(getGraphicsContext());
		
		getGraphicsContext().restore();
	}

	@Override
	public void drawOnWorld(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR> lambda) {
		getGraphicsContext().save();
		
		lambda.draw(getGraphicsContext());
		
		getGraphicsContext().restore();
		
	}

	@Override
	public void resizeViewport(double incrementX, double incrementY) {
		viewportWidth += incrementX;
		viewportHeight += incrementY;
	}

}
