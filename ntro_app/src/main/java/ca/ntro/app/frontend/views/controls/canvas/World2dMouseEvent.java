package ca.ntro.app.frontend.views.controls.canvas;

public interface World2dMouseEvent <RAW_EVENT extends Object> extends World2dDimensions {
	
	RAW_EVENT rawMouseEvent();
	
	double canvasX();
	double canvasY();
	
	double worldX();
	double worldY();


}
