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

package ca.ntro.app.views.controls;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class ResizableCanvas extends Pane {
	
	private Canvas canvas;
	private GraphicsContext gc;
	private int epsilon = 1;
	private int oldWidth = -1;
	private int oldHeight = -1;
	private int newWidth = -1;
	private int newHeight = -1;
	private double aspectRatio = 640.0/360.0;
	private int referenceWidth;
	private int referenceHeight = 1000;
	
	public GraphicsContext getGc() {
		return gc;
	}

	protected int getEpsilon() {
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
	}

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

		double canvasWidth = getWidth();
		double canvasHeight = getHeight();
		double currentAspectRatio = canvasWidth / canvasHeight;
		int newWidth;
		int newHeight;
				
		if(currentAspectRatio > aspectRatio) {

			newHeight = (int) Math.floor(canvasHeight);
			newWidth = newHeight * referenceWidth / referenceHeight;
			
		}else {

			newWidth = (int) Math.floor(canvasWidth);
			newHeight = newWidth * referenceHeight / referenceWidth;

		}
		
		if(Math.abs(canvasWidth - newWidth) > epsilon
				&& Math.abs(canvasHeight - newHeight) > epsilon) {
			
			canvas.setLayoutX((canvasWidth - newWidth) / 2);
			canvas.setLayoutY((canvasHeight - newHeight) / 2);
			
			resizeCanvas(newWidth, newHeight);
		}
	}

	private void resizeCanvas(int newWidth, int newHeight) {

		if(this.newWidth != -1) {
			this.oldWidth = this.newWidth;
		}

		if(this.newHeight != -1) {
			this.oldHeight = this.newHeight;
		}
		
		this.newWidth = newWidth;
		this.newHeight = newHeight;
		
		canvas.setWidth(newWidth);
		canvas.setHeight(newHeight);

		callOn();
	}
	
	private void callOn() {
		if(oldWidth == -1
				|| oldHeight == -1) {
			
			onInitialSize(newWidth, newHeight);
			
		} else {
				
			onNewSize(oldWidth, 
					  oldHeight, 
					  newWidth, 
					  newHeight);
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

	protected abstract void onInitialSize(int initialWidth, int initialHeight);
	protected abstract void onNewSize(int oldWidth, 
			                          int oldHeight, 
			                          int newWidth,
			                          int newHeight);

}
