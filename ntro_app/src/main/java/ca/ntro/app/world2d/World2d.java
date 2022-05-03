package ca.ntro.app.world2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.GraphicsContext;
import ca.ntro.app.frontend.views.controls.canvas.InternalGraphicsContext;
import ca.ntro.app.frontend.views.controls.canvas.World2dCanvas;
import ca.ntro.app.models.Value;

public abstract class World2d<RAW_GC extends Object,
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
                                                          
      implements Value {
	
	private double width;
	private double height;
	private List<OBJECT2D> objects = new ArrayList<>();

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public List<OBJECT2D> getObjects() {
		return objects;
	}

	public void setObjects(List<OBJECT2D> objects) {
		this.objects = objects;
	}
	
	public World2d() {
		initialize();
	}
	
	protected abstract void initialize();

	@SuppressWarnings("unchecked")
	public void addObject2d(OBJECT2D object2d) {
		object2d.setWorld((WORLD2D) this);
		objects.add(object2d);
		object2d.initialize();
	}

	public void onTimePasses(double secondsElapsed) {
		for(OBJECT2D objet2d : objects) {
			objet2d.onTimePasses(secondsElapsed);
		}
	}

	@SuppressWarnings("unchecked")
	public void draw(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> gc,
			         World2dDrawingOptions options) {
		
		// FIXME: select only objects that intersect with the viewport
		
		for(OBJECT2D object2d : objects) {

			gc.save();
			object2d.draw((GC) gc, options.toObject2dDrawingOptions());
			gc.restore();

		}
	}

	public void copyDataFrom(WORLD2D world2d) {
		for(int i = 0; i < objects.size(); i++) {
			world2d.copyDataTo(i, objects.get(i));
		}
	}

	protected void copyDataTo(int i, OBJECT2D object2d) {
		if(i < objects.size()) {
			object2d.copyDataFrom(objects.get(i));
		}
	}

}
