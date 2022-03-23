// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of ntro4f5
//
// ntro4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ntro4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

package ca.ntro.app.views.controls.canvas;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public abstract class ResizableCanvas extends Pane {
	
	private Canvas canvas;
	private GraphicsContext gc;
	private double epsilon = 1;
	private double oldWidth = -1;
	private double oldHeight = -1;

	private double baseWidth = 640.0;
	private double baseHeight = 360.0;

	private double aspectRatio = baseWidth / baseHeight;
	private double referenceWidth;
	private double referenceHeight = 1000;
	private double canvasWidth = -1;
	private double canvasHeight = -1;
	private double offsetX = 0;
	private double offsetY = 0;
	
	public GraphicsContext getGc() {
		return gc;
	}

	protected double getEpsilon() {
		return epsilon;
	}

	protected void setEpsilon(int epsilon) {
		this.epsilon = epsilon;
	}

	public double getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(double aspectRatio) {
		this.aspectRatio = aspectRatio;
		initializeReferenceWidth();
	}
	
	public double getCanvasWidth() {
		return canvasWidth;
	}


	public double getCanvasHeight() {
		return canvasHeight;
	}


	public double getOffsetX() {
		return offsetX;
	}

	public double getOffsetY() {
		return offsetY;
	}

	public ResizableCanvas() {
		initializeReferenceWidth();
		initializeCanvas();
		initialize();
	}
	
	protected abstract void initialize();
	
	private void initializeReferenceWidth() {
		referenceWidth = (int) Math.round(referenceHeight * aspectRatio);
	}

	private void initializeCanvas() {
		installCanvas();
		
		installWidthObserver();
		installHeightObserver();
		
		installMouseEventListener();
	}

	private void installMouseEventListener() {
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, evtFx -> {
			onMouseEvent(evtFx, evtFx.getX(), evtFx.getY());
		});
	}

	protected abstract void onMouseEvent(MouseEvent evtFx, double x, double y);

	private void installCanvas() {
		canvas = new Canvas();
		gc = canvas.getGraphicsContext2D();
		this.getChildren().add(canvas);
	}
	
	private void installWidthObserver() {
		
		this.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				resizeCanvas();
			}
		});
	}

	private void resizeCanvas() {
		
		if(Math.abs(getWidth() - oldWidth) > epsilon
				|| Math.abs(getHeight() - oldHeight) > epsilon) {

			resizeRelocateCanvas(0, 0, getWidth(), getHeight());
		}
		
		/*
		
		double currentAspectRatio = containerWidth / containerHeight;
		int newWidth;
		int newHeight;
				
		if(currentAspectRatio > aspectRatio) {

			newHeight = (int) Math.floor(containerHeight) - epsilon;
			newWidth = newHeight * referenceWidth / referenceHeight;
			
		}else {

			newWidth = (int) Math.floor(containerWidth) - epsilon;
			newHeight = newWidth * referenceHeight / referenceWidth;

		}
		
		int newOffsetX = (int) Math.floor((containerWidth - newWidth) / 2);
		int newOffsetY = (int) Math.floor((containerHeight - newHeight) / 2);
		
		if(Math.abs(newOffsetX + newWidth - containerWidth) > epsilon
				|| Math.abs(newOffsetY + newHeight - containerHeight) > epsilon) {
			
				
			resizeRelocateCanvas(newOffsetX,
								 newOffsetY,
								 newWidth, 
								 newHeight);
			
		}
		
		*/
	}

	private void resizeRelocateCanvas(double offsetX,
			                          double offsetY,
			                          double newWidth, 
			                          double newHeight) {

		if(this.canvasWidth != -1) {
			this.oldWidth = this.canvasWidth;
		}

		if(this.canvasHeight != -1) {
			this.oldHeight = this.canvasHeight;
		}
		
		this.canvasWidth = newWidth;
		this.canvasHeight = newHeight;
		
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		
		canvas.setLayoutX(offsetX);
		canvas.setLayoutY(offsetY);

		canvas.setWidth(newWidth);
		canvas.setHeight(newHeight);

		callOn();
	}
	
	private void callOn() {
		if(oldWidth == -1
				|| oldHeight == -1) {
			
			onInitialSize(canvasWidth, canvasHeight);
			
		} else {
				
			onNewSize(oldWidth, 
					  oldHeight, 
					  canvasWidth, 
					  canvasHeight);
		}
	}


	private void installHeightObserver() {

		this.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				resizeCanvas();
			}
		});
	}

	protected abstract void onInitialSize(double initialWidth, double initialHeight);
	protected abstract void onNewSize(double oldWidth, 
			                          double oldHeight, 
			                          double newWidth,
			                          double newHeight);

}
