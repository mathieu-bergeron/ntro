package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.world2d.Object2d;
import ca.ntro.app.world2d.Object2dDrawingOptions;
import ca.ntro.app.world2d.World2d;
import ca.ntro.app.world2d.World2dDrawingOptions;

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
                                WORLD2D>,
       
                 World2dDrawingOptions {
    	   
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
		
		//getGraphicsContext().setTransform(1.0, 0.0, 0.0, 1.0, viewportTopLeftX, viewportTopLeftY);
		// FIXME:
		setWorld2dTransform();
		
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
		drawOnWorld(gc -> {
			gc.strokeRect(viewportTopLeftY,
					      viewportTopLeftY,
					      viewportWidth, 
					      viewportHeight);
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

		setWorld2dTransform();

		getGraphicsContext().rect(viewportTopLeftX(), 
				                  viewportTopLeftY(), 
				                  viewportWidth(), 
				                  viewportHeight());

		getGraphicsContext().clip();

		world2d.draw(getGraphicsContext(), this);
		
		getGraphicsContext().restore();
	}

	protected void setWorld2dTransform() {
		double scaleX = 1.0;
		double shearX = 0;
		double shearY = 0;
		double scaleY = 1.0;
		double translateX = 0;
		double translateY = 0;
		
		scaleX = canvasWidth() / viewportWidth;
		scaleY = canvasHeight() / viewportHeight;
		
		translateX = -viewportTopLeftX * scaleX;
		translateY = -viewportTopLeftY * scaleY;

		getGraphicsContext().setTransform(scaleX,
				                          shearX,
				                          shearY,
				                          scaleY,
				                          translateX,
				                          translateY);
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

	@Override
	public RAW_CANVAS getRawCanvas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double canvasWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double canvasHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double screenWidth(double worldWidth) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double screenHeight(double worldHeight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object2dDrawingOptions toObject2dDrawingOptions() {
		return (Object2dDrawingOptions) this;
	}


}
