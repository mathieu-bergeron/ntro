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
	private int epsilon = 0;
	private int oldWidth = -1;
	private int oldHeight = -1;
	private int newWidth = -1;
	private int newHeight = -1;
	
	public GraphicsContext getGc() {
		return gc;
	}

	protected int getEpsilon() {
		return epsilon;
	}

	protected void setEpsilon(int epsilon) {
		this.epsilon = epsilon;
	}

	public ResizableCanvas() {
		initializeCanvas();
		initialize();
	}
	
	protected abstract void initialize();

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
				
				int newWidth = (int) Math.round((double) newValue);
				
				if(newWidth < epsilon
						|| Math.abs(newWidth - oldWidth) > epsilon) {

					oldWidth = (int) Math.round((double) oldValue);
					ResizableCanvas.this.newWidth = newWidth;

					canvas.setWidth(newWidth);
					callOn();
				}
			}
		});
	}
	
	private void callOn() {
		if(oldWidth == 0
				&& oldHeight == 0) {
			
			onInitialSize(newWidth, newHeight);

		}else if(newWidth > 0
				&& newHeight > 0) {
			
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

				int newHeight = (int) Math.round((double) newValue);
				
				if(newHeight < epsilon
						|| Math.abs(newHeight - oldHeight) > epsilon) {

					oldHeight = (int) Math.round((double) oldValue);
					ResizableCanvas.this.newHeight = newHeight;

					canvas.setHeight(newHeight);
					callOn();
				}
			}
		});
	}

	protected abstract void onInitialSize(int initialWidth, int initialHeight);
	protected abstract void onNewSize(int oldWidth, 
			                          int oldHeight, 
			                          int newWidth,
			                          int newHeight);

}
