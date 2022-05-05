package ca.ntro.app.world2d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.GraphicsContext;
import ca.ntro.app.frontend.views.controls.canvas.InternalGraphicsContext;
import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
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
														WORLD2D,
														OPTIONS>,

							  WORLD2D  extends World2d<RAW_GC, 
													   RAW_CANVAS, 
													   RAW_IMAGE, 
													   RAW_FONT,
													   RAW_COLOR,
													   CANVAS,
													   GC,
													   OBJECT2D,
													   WORLD2D,
													   OPTIONS>,

                              OPTIONS extends World2dDrawingOptions>
                                                          
      implements Value {
	
	private double width;
	private double height;
	private List<OBJECT2D> objects = new ArrayList<>();
	private Map<String, OBJECT2D> objectsById = new HashMap<>();

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
		objectsById.put(object2d.id(), object2d);
		object2d.initialize();
	}
	
	public OBJECT2D objectById(String id) {
		return objectsById.get(id);
	}

	public void onTimePasses(double secondsElapsed) {
		for(OBJECT2D objet2d : objects) {
			objet2d.onTimePasses(secondsElapsed);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void draw(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> gc,
			         OPTIONS options) {
		
		// FIXME: select only objects that intersect with the viewport
		
		for(OBJECT2D object2d : objects) {

			gc.save();
			object2d.draw((World2dGraphicsContext) gc, options);
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

	public void removeObject2dNotIn(Set<String> ids) {
		List<OBJECT2D> oldObjects = objects;
		objects = new ArrayList<>();
		
		for(OBJECT2D object2d : oldObjects) {
			if(ids.contains(object2d.id())) {

				objects.add(object2d);

			}else {
				
				objectsById.remove(object2d.id());
			}
		}
		
	}

}
