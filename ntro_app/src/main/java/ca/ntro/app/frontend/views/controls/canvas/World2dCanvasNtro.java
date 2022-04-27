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

    private double viewportTopLeftX = 0;
    private double viewportTopLeftY = 0;
	private double viewportWidth = 400;
	private double viewportHeight = 400;

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

	public double getViewportTopLeftX() {
		return viewportTopLeftX;
	}

	public void setViewportTopLeftX(double viewportTopLeftX) {
		this.viewportTopLeftX = viewportTopLeftX;
	}

	public double getViewportTopLeftY() {
		return viewportTopLeftY;
	}

	public void setViewportTopLeftY(double viewportTopLeftY) {
		this.viewportTopLeftY = viewportTopLeftY;
	}

	public WORLD2D getWorld() {
		return world;
	}

	public void setWorld(WORLD2D world) {
		this.world = world;
	}

	@Override
	public double viewportTopLeftX() {
		return getViewportTopLeftX();
	}

	@Override
	public double viewportTopLeftY() {
		return getViewportTopLeftY();
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
		
		getGraphicsContext().setTransform(1.0, 0.0, 0.0, 1.0, viewportTopLeftX, viewportTopLeftY);
		
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
	public void resizeViewport(double width, double height) {
		setViewportWidth(width);
		setViewportHeight(height);
	}


	@Override
	public void relocateViewport(double topLeftX, double topLeftY) {
		setViewportTopLeftX(topLeftX);
		setViewportTopLeftY(topLeftY);
	}

	@Override
	public void relocateResizeViewport(double topLeftX, double topLeftY, double width, double height) {
		relocateViewport(topLeftX, topLeftY);
		resizeViewport(width, height);
		
	}

	@Override
	public void clearViewport() {
		drawOnViewport(gc -> {
			gc.clearRect(0, 0, viewportWidth, viewportHeight);
		});
	}

	@Override
	public void displayViewport() {
		drawOnViewport(gc -> {
			gc.strokeRect(0,0,viewportWidth, viewportHeight);
		});
		
	}

	@Override
	public void clearWorld() {
		drawOnWorld(gc -> {
			gc.clearRect(0,0,getWorld().getWidth(), getWorld().getHeight());
		});
	}


	@Override
	public void displayWorld2d(WORLD2D world2d) {
		getGraphicsContext().save();
		getGraphicsContext().beginPath();

		getGraphicsContext().rect(viewportTopLeftX(), 
				                  viewportTopLeftY(), 
				                  viewportWidth(), 
				                  viewportHeight());

		getGraphicsContext().clip();
		
		//getGraphicsContext().setTransform(0.25, 0, 0, 1.0, 0, 0);

		world2d.draw(getGraphicsContext());
		
		getGraphicsContext().restore();
	}

	@Override
	public void displayFps(String fps) {
		drawOnCanvas(gc -> {

			gc.fillText(fps, 0, 12);
		});
	}

	@Override
	public void clearCanvas() {
		drawOnCanvas(gc -> {
			gc.clearRect(0,0,canvasWidth(), canvasHeight());
		});
	}


}
