package ntro.core.services;

import ca.ntro.app.frontend.views.elements.Color;
import ca.ntro.app.services.ColorService;
import ca.ntro.app.views.elements.ColorFx;

public class ColorServiceFx implements ColorService {

	@Override
	public Color colorFromString(String colorString) {
		return new ColorFx(javafx.scene.paint.Color.web(colorString));
	}

}
