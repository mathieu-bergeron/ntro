package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.CanvasDrawingLambda;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CanvasFx extends ResizableCanvas implements Canvas<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CanvasFx> {
	
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
		return getWidth();
	}

	@Override
	public double canvasHeight() {
		return getHeight();
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CanvasFx> lambda) {
		canvasNtroFx.drawOnCanvas(lambda);
	}

	@Override
	public void clearCanvas() {
		canvasNtroFx.clearCanvas();
	}


}
