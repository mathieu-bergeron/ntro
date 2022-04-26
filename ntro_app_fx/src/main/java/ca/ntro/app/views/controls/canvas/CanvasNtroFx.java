package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.CanvasNtro;
import javafx.scene.canvas.GraphicsContext;

public class CanvasNtroFx extends CanvasNtro<GraphicsContext, javafx.scene.canvas.Canvas> {
	
	private CanvasFx canvasFx;

	public CanvasFx getCanvasFx() {
		return canvasFx;
	}

	public void setCanvasFx(CanvasFx canvasFx) {
		this.canvasFx = canvasFx;
	}
	
	public CanvasNtroFx(GraphicsContextFx graphicsContext, CanvasFx canvasFx) {
		setGraphicsContext(graphicsContext);
		setCanvasFx(canvasFx);
	}

	@Override
	public javafx.scene.canvas.Canvas getRawCanvas() {
		return getCanvasFx().getRawCanvas();
	}

}
