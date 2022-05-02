package ca.ntro.core.data_structures.trees.region_tree;

import ca.ntro.core.stream.Stream;

public interface RegionTree2d<R extends Region2d> {

	void add(R region);
	
	void remove(String id);
	void remove(R region);

	void onRegionMoved(String id);

	R get(String id);

	Stream<R> intersectWith(AnonymousRegion2d otherRestion);

	Stream<R> intersectWith(double topLeftX,
			                double topLeftY,
			                double width,
			                double height);

	Stream<R> containedIn(AnonymousRegion2d otherRegion);

	Stream<R> containedIn(double topLeftX,
			              double topLeftY,
			              double width,
			              double height);

	Stream<R> get(AnonymousRegion2d regionSpec);

	Stream<R> get(double topLeftX,
			      double topLeftY,
			      double width,
			      double height);

}
