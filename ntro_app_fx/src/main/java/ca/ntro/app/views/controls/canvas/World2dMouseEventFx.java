package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.World2dMouseEvent;
import javafx.scene.input.MouseEvent;

public class World2dMouseEventFx implements World2dMouseEvent<MouseEvent> {
	
	private MouseEvent rawMouseEvent;
	private World2dCanvasNtroFx world2dCanvas;
	private double worldX;
	private double worldY;

	@SuppressWarnings("rawtypes")
	public World2dMouseEventFx(MouseEvent rawMouseEvent, 
			                   World2dCanvasNtroFx world2dCanvas, 
			                   double worldX, 
			                   double worldY) {
		
		this.rawMouseEvent = rawMouseEvent;
		this.world2dCanvas = world2dCanvas;
		this.worldX = worldX;
		this.worldY = worldY;
	}

	@Override
	public MouseEvent rawMouseEvent() {
		return rawMouseEvent;
	}

	@Override
	public double canvasX() {
		return rawMouseEvent.getX();
	}

	@Override
	public double canvasY() {
		return rawMouseEvent.getY();
	}

	@Override
	public double worldX() {
		return worldX;
	}

	@Override
	public double worldY() {
		return worldY;
	}

	@Override
	public double worldWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double worldHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewportTopLeftX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewportTopLeftY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewportWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double viewportHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double widthOnScreen(double widthInWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double heightOnScreen(double heightInWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double widthInWorld(double widthOnScreen) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double heightInWorld(double heightOnScreen) {
		// TODO Auto-generated method stub
		return 0;
	}

}
