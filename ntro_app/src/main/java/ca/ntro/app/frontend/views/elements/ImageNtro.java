package ca.ntro.app.frontend.views.elements;

public class ImageNtro<RAW_IMAGE extends Object> implements Image<RAW_IMAGE> {
	
	private RAW_IMAGE rawImage;

	@Override
	public RAW_IMAGE getRawImage() {
		return rawImage;
	}

}
