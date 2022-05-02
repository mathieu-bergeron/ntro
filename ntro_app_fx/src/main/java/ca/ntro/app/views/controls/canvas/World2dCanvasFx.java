package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.CanvasDrawingLambda;
import ca.ntro.app.frontend.views.controls.canvas.World2dCanvas;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.World2dFx;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class World2dCanvasFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D>,
                                      WORLD2D  extends World2dFx<OBJECT2D, WORLD2D>> 

       extends  Canvas 

       implements World2dCanvas<GraphicsContext, 
                                Canvas, 
                                Image, 
                                Font, 
                                Color,
                                GraphicsContextFx,
                                OBJECT2D,
                                WORLD2D> {
	
	private World2dCanvasNtroFx<OBJECT2D, WORLD2D> canvasNtroFx = new World2dCanvasNtroFx<OBJECT2D,WORLD2D>(new GraphicsContextFx(getGraphicsContext2D()), this);
	
	private double worldWidth = 0;
	private double worldHeight = 0;
	
	private Pos position = Pos.CENTER;

	public Pos getPosition() {
		return position;
	}

	public void setPosition(Pos position) {
		this.position = position;
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
	

	/*
	public void displayWorld2d(World2dFx world2d) {

		getGc().save();
		getGc().beginPath();
		getGc().rect(0, 0, worldWidth, worldHeight);
		getGc().clip();
		
		world2d.draw(new GraphicsContextFx(getGc()));
		
		getGc().restore();
	}
	*/

	/*
	public void clearCanvas() {
		getGc().save();
		getGc().setTransform(1.0, 0, 0, 1.0, 1.0, 1.0); 
		getGc().clearRect(0, 0, getWidth(), getHeight());
		getGc().restore();
	}
	*/
	
	public <T extends MouseEvent> void addMouseEventFilter(EventType<T> eventType, MouseEventHandler handler) {
		addEventFilter(eventType, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				canvasNtroFx.handleMouseEvent(event, handler);
			}
		});
	}

	@Override
	public Canvas getRawCanvas() {
		return this;
	}

	@Override
	public double canvasWidth() {
		return getWidth();
	}

	@Override
	public double canvasHeight() {
		return getHeight();
	}


	@Override
	public double worldWidth() {
		return canvasNtroFx.worldWidth();
	}

	@Override
	public double worldHeight() {
		return canvasNtroFx.worldHeight();
	}

	@Override
	public double viewportWidth() {
		return canvasNtroFx.getViewportWidth();
	}

	@Override
	public double viewportHeight() {
		return canvasNtroFx.getViewportHeight();
	}

	@Override
	public void drawOnWorld(CanvasDrawingLambda<GraphicsContext, Canvas, Image, Font, Color> lambda) {
		canvasNtroFx.drawOnWorld(lambda);
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<GraphicsContext, Canvas, Image, Font, Color> lambda) {
		canvasNtroFx.drawOnViewport(lambda);
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<GraphicsContext, Canvas, Image, Font, Color> lambda) {
		canvasNtroFx.drawOnCanvas(lambda);
	}

	@Override
	public void clearViewport() {
		canvasNtroFx.clearViewport();
	}

	@Override
	public void clearWorld() {
		canvasNtroFx.clearWorld();
	}
	
	@Override
	public void clearCanvas() {
		canvasNtroFx.clearCanvas();
	}


	@Override
	public void displayWorld2d(WORLD2D world2d) {
		canvasNtroFx.displayWorld2d(world2d);
	}

	@Override
	public double viewportTopLeftX() {
		return canvasNtroFx.getViewportTopLeftX();
	}

	@Override
	public double viewportTopLeftY() {
		return canvasNtroFx.getViewportTopLeftY();
	}

	@Override
	public void resizeViewport(double incrementX, double incrementY) {
		canvasNtroFx.resizeViewport(incrementX, incrementY);
	}

	@Override
	public void relocateViewport(double topLeftX, double topLeftY) {
		canvasNtroFx.relocateViewport(topLeftX, topLeftY);
	}

	@Override
	public void relocateResizeViewport(double topLeftX, double topLeftY, double width, double height) {
		canvasNtroFx.relocateResizeViewport(topLeftX, topLeftY, width, height);
	}

	@Override
	public void displayViewport() {
		canvasNtroFx.displayViewport();
	}

	@Override
	public void displayFps(String fps) {
		canvasNtroFx.displayFps(fps);
	}

}
