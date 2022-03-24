package ca.ntro.app.world2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Value;

public abstract class World2d<GC extends Object,
                              OBJECT2D extends Object2d<GC,OBJECT2D,WORLD2D>,
                              WORLD2D  extends World2d <GC,OBJECT2D,WORLD2D>> implements Value {
	
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
	
	public void addObject2d(OBJECT2D object2d) {
		object2d.setWorld(this);
		objects.add(object2d);
	}

	public void onTimePasses(double secondsElapsed) {
		for(OBJECT2D objet2d : objects) {
			objet2d.onTimePasses(secondsElapsed);
		}
	}

	public void draw(GC gc) {
		for(OBJECT2D object2d : objects) {
			object2d.draw(gc);
		}
	}

	public void copyDataFrom(WORLD2D pong2d) {
		for(int i = 0; i < objects.size(); i++) {
			pong2d.copyDataTo(i, objects.get(i));
		}
	}

	protected void copyDataTo(int i, OBJECT2D object2d) {
		OBJECT2D from = objects.get(i);
		
		if(from != null) {
			object2d.copyDataFrom(objects.get(i));
		}
	}

}
