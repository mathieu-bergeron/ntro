package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.GraphicsContextNtro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GraphicsContextFx extends GraphicsContextNtro<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color> {
	
	private GraphicsContext gc;

	public GraphicsContextFx(GraphicsContext gc) {
		this.gc = gc;
	}

	@Override
	public void save() {
		gc.save();
	}

	@Override
	public void restore() {
		gc.restore();
	}

	@Override
	public void translate(double x, double y) {
		gc.translate(x, y);
	}

	@Override
	public void scale(double x, double y) {
		gc.scale(x, y);
	}

	@Override
	public void rotate(double degrees) {
		gc.rotate(degrees);
	}

	@Override
	public GraphicsContext getRawGraphicsContext() {
		return gc;
	}

	@Override
	public void fillRect(double topLeftX, double topLeftY, double width, double height) {
		gc.fillRect(topLeftX, topLeftY, width, height);
	}

	@Override
	public void drawImage(ca.ntro.app.frontend.views.elements.Image<Image> image, double topLeftX, double topLeftY) {
		gc.drawImage(image.getRawImage(), topLeftX, topLeftY);
	}

}
