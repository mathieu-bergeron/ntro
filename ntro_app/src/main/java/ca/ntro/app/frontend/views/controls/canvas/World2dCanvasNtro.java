package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.world2d.World2d;

public abstract class World2dCanvasNtro<RAW_GC extends Object,
                                        RAW_CANVAS extends Object,
                                        RAW_IMAGE extends Object> 

       extends CanvasNtro<RAW_GC, RAW_CANVAS, RAW_IMAGE>

       implements World2dCanvas<RAW_GC, RAW_CANVAS, RAW_IMAGE> {

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

	@Override
	public double viewportWidth() {
		return getViewportWidth();
	}

	@Override
	public double viewportHeight() {
		return getViewportHeight();
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda) {
		getGraphicsContext().save();
		
		lambda.draw(getGraphicsContext());
		
		getGraphicsContext().restore();
	}

	@Override
	public World2d getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void drawOnWorld(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE> lambda) {
		// TODO Auto-generated method stub
		
	}

}
