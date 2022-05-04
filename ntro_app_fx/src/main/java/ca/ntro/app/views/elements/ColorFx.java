package ca.ntro.app.views.elements;

import ca.ntro.app.frontend.views.elements.Color;

public class ColorFx implements Color<javafx.scene.paint.Color> {
	
	private javafx.scene.paint.Color rawColor;


	public javafx.scene.paint.Color getRawColor() {
		return rawColor;
	}

	public void setRawColor(javafx.scene.paint.Color rawColor) {
		this.rawColor = rawColor;
	}

	public ColorFx(javafx.scene.paint.Color rawColor) {
		setRawColor(rawColor);
	}

	@Override
	public javafx.scene.paint.Color rawColor() {
		return getRawColor();
	}
}
