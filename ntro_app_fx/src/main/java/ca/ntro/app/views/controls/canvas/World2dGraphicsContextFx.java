package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.GraphicsContextNtro;
import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class World2dGraphicsContextFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D>,
                                      WORLD2D  extends World2dFx<OBJECT2D, WORLD2D>> 

       extends GraphicsContextNtro<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, World2dCanvasFx<OBJECT2D, WORLD2D>>

       implements World2dGraphicsContext<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, World2dCanvasFx<OBJECT2D, WORLD2D>> {

	private GraphicsContext gc;
	

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	public World2dGraphicsContextFx(GraphicsContext gc) {
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
	public double widthOnScreen(double worldWidth) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double heightOnScreen(double worldHeight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double widthInWorld(double screenWidth) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double heightInWorld(double screenHeight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public World2dCanvasFx<OBJECT2D, WORLD2D> getCanvas() {

		return null;
	}

	@Override
	public GraphicsContext getRawGraphicsContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearRect(double topLeftX, double topLeftY, double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillRect(double topLeftX, double topLeftY, double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void strokeRect(double topLeftX, double topLeftY, double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawImage(ca.ntro.app.frontend.views.elements.Image<Image> image, double topLeftX, double topLeftY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillText(String text, int topLeftX, int topLeftY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translate(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rect(double topLeftX, double topLeftY, double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransform(double scaleX, double shearX, double shearY, double scaleY, double translateX,
			double translateY) {
		// TODO Auto-generated method stub
		
	}

}
