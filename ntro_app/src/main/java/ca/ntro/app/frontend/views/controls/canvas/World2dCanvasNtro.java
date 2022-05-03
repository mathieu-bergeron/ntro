package ca.ntro.app.frontend.views.controls.canvas;

import ca.ntro.app.world2d.Object2dNtro;
import ca.ntro.app.world2d.Object2dDrawingOptions;
import ca.ntro.app.world2d.World2d;
import ca.ntro.app.world2d.World2dDrawingOptions;

public abstract class World2dCanvasNtro<RAW_GC extends Object,
                                        RAW_CANVAS extends Object, 
                                        RAW_IMAGE extends Object,
                                        RAW_FONT extends Object,
                                        RAW_COLOR extends Object,
                                        CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>,

                                        GC extends GraphicsContext<RAW_GC, 
                                                                   RAW_CANVAS, 
                                                                   RAW_IMAGE,
                                                                   RAW_FONT,
                                                                   RAW_COLOR,
                                                                   CANVAS>,

							            OBJECT2D extends Object2dNtro<RAW_GC, 
														          RAW_CANVAS, 
														          RAW_IMAGE,
														          RAW_FONT,
														          RAW_COLOR,
														          CANVAS,
														          GC,
														          OBJECT2D,
														          WORLD2D>,

							            WORLD2D  extends World2d<RAW_GC, 
														         RAW_CANVAS, 
														         RAW_IMAGE, 
														         RAW_FONT,
														         RAW_COLOR,
														         CANVAS,
														         GC,
														         OBJECT2D,
														         WORLD2D>> 

       extends CanvasNtro<RAW_GC, 
                          RAW_CANVAS, 
                          RAW_IMAGE,
                          RAW_FONT,
                          RAW_COLOR,
                          CANVAS>

       implements World2dCanvas<RAW_GC, 
                                RAW_CANVAS, 
                                RAW_IMAGE, 
                                RAW_FONT,
                                RAW_COLOR,
                                CANVAS,
                                GC,
                                OBJECT2D, 
                                WORLD2D>,
       
                 World2dDrawingOptions {
    	   
    	   
    private double worldWidth = 0;
    private double worldHeight = 0;

    private double viewportTopLeftX = 0;
    private double viewportTopLeftY = 0;
	private double viewportWidth = 0;
	private double viewportHeight = 0;

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

	public double getWorldWidth() {
		return worldWidth;
	}

	public void setWorldWidth(double worldWidth) {
		this.worldWidth = worldWidth;
	}

	public double getWorldHeight() {
		return worldHeight;
	}

	public void setWorldHeight(double worldHeight) {
		this.worldHeight = worldHeight;
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
	public double worldWidth() {
		return getWorldWidth();
	}

	@Override
	public double worldHeight() {
		return getWorldHeight();
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> lambda) {
		getGraphicsContext().save();
		
		//getGraphicsContext().setTransform(1.0, 0.0, 0.0, 1.0, viewportTopLeftX, viewportTopLeftY);
		// FIXME:
		setWorld2dTransform();
		
		lambda.draw(getGraphicsContext());
		
		getGraphicsContext().restore();
	}

	@Override
	public void drawOnWorld(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> lambda) {
		getGraphicsContext().save();

		// FIXME:
		setWorld2dTransform();

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
	public void clearWorld() {
		drawOnWorld(gc -> {
			gc.clearRect(0,0,worldWidth, worldHeight);
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

		throw new RuntimeException("FIXME");
		//world2d.draw(getGraphicsContext(), this);
		
		//getGraphicsContext().restore();
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
	public void clearCanvas() {
		drawOnCanvas(gc -> {
			gc.clearRect(0,0,canvasWidth(), canvasHeight());
		});
	}

	@Override
	public double widthOnScreen(double widthInWorld) {
		return widthInWorld * canvasWidth() / viewportWidth;
	}

	@Override
	public double heightOnScreen(double heightInWorld) {
		return heightInWorld * canvasHeight() / viewportHeight;
	}

	@Override
	public double widthInWorld(double widthOnScreen) {
		return widthOnScreen * viewportWidth / canvasWidth();
	}

	@Override
	public double heightInWorld(double heightOnScreen) {
		return heightOnScreen * viewportHeight / canvasHeight();
	}

	@Override
	public Object2dDrawingOptions toObject2dDrawingOptions() {
		return (Object2dDrawingOptions) this;
	}

}
