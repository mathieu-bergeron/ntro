package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.CanvasDrawingLambda;
import javafx.scene.canvas.GraphicsContext;

public class CanvasFx extends ResizableCanvas implements Canvas<GraphicsContext, CanvasFx, GraphicsContextFx, CanvasFx> {
	
	private CanvasNtroFx canvasNtroFx = new CanvasNtroFx(new GraphicsContextFx(getGc()), this);

	@Override
	public void initialize() {
		System.out.println("Initialize\n\n");
	    canvasNtroFx = new CanvasNtroFx(new GraphicsContextFx(getGc()), this);
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
	public CanvasFx getRawCanvas() {
		return this;
	}

	@Override
	public GraphicsContextFx getGraphicsContext() {
		return canvasNtroFx.getGraphicsContext();
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
	public void drawOnCanvas(CanvasDrawingLambda<GraphicsContext, CanvasFx, GraphicsContextFx, CanvasFx> lambda) {
		canvasNtroFx.drawOnCanvas(lambda);
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<GraphicsContext, CanvasFx, GraphicsContextFx, CanvasFx> lambda) {
		canvasNtroFx.drawOnViewport(lambda);
	}


}
