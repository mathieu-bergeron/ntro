package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.CanvasDrawingLambda;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CanvasFx extends ResizableCanvas implements Canvas<GraphicsContext, javafx.scene.canvas.Canvas, Image> {
	
	private CanvasNtroFx canvasNtroFx = new CanvasNtroFx(new GraphicsContextFx(getGc()), this);

	@Override
	protected void initialize() {
	}

	@Override
	protected void onInitialSize(double initialWidth, double initialHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onNewSize(double oldWidth, double oldHeight, double newWidth, double newHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public javafx.scene.canvas.Canvas getRawCanvas() {
		return getCanvas();
	}


	@Override
	public double canvasWidth() {
		return canvasNtroFx.getCanvasWidth();
	}

	@Override
	public double canvasHeight() {
		return canvasNtroFx.getCanvasHeight();
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
	public void drawOnCanvas(CanvasDrawingLambda<GraphicsContext, javafx.scene.canvas.Canvas, Image> lambda) {
		canvasNtroFx.drawOnCanvas(lambda);
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<GraphicsContext, javafx.scene.canvas.Canvas, Image> lambda) {
		canvasNtroFx.drawOnViewport(lambda);
	}


}
