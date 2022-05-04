package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.GraphicsContextNtro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GraphicsContextFx<CANVAS extends Canvas<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CANVAS>>

       extends GraphicsContextNtro<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CANVAS> {
	
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

	@Override
	public void clearRect(double topLeftX, double topLeftY, double width, double height) {
		gc.clearRect(topLeftX, topLeftY, width, height);
		
	}

	@Override
	public void fillText(String text, double topLeftX, double topLeftY) {
		gc.fillText(text, topLeftX, topLeftY);
	}

	@Override
	public void beginPath() {
		gc.beginPath();
	}

	@Override
	public void rect(double topLeftX, double topLeftY, double width, double height) {
		gc.rect(topLeftX, topLeftY, width, height);
	}

	@Override
	public void clip() {
		gc.clip();
	}

	@Override
	public void setTransform(double scaleX, 
			                 double shearX, 
			                 double shearY, 
			                 double scaleY, 
			                 double translateX, 
			                 double translateY) {
		
		gc.setTransform(scaleX, 
				        shearX, 
				        shearY, 
				        scaleY, 
				        translateX, 
				        translateY);
	}

	@Override
	public void strokeRect(double topLeftX, double topLeftY, double width, double height) {
		gc.strokeRect(topLeftX, topLeftY, width, height);
	}

	@Override
	public void setFill(ca.ntro.app.frontend.views.elements.Color<Color> color) {
		gc.setFill(color.rawColor());
	}

	@Override
	public void setStroke(ca.ntro.app.frontend.views.elements.Color<Color> color) {
		gc.setStroke(color.rawColor());
	}

	@Override
	public void strokeText(String text, double topLeftX, double topLeftY) {
		gc.strokeText(text, topLeftX, topLeftY);
	}

}
