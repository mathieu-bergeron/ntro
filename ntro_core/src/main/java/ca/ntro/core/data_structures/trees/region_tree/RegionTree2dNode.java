package ca.ntro.core.data_structures.trees.region_tree;

import ca.ntro.core.stream.Stream;

public interface RegionTree2dNode<R extends Region2d> extends AnonymousRegion2d {

	void add(R region, double epsilon);

	void remove(R region, double epsilon);

	Stream<R> get(AnonymousRegion2d regionSpec, double epsilon);

	Stream<R> get(double topLeftX,
			      double topLeftY,
			      double width,
			      double height,
			      double epsilon);

	Stream<R> intersectWith(AnonymousRegion2d otherRegion, double epsilon);

	Stream<R> intersectWith(double topLeftX,
			                double topLeftY,
			                double width,
			                double height,
			                double epsilon);

	Stream<R> containedIn(AnonymousRegion2d otherRegion, double epsilon);

	Stream<R> containedIn(double topLeftX,
			              double topLeftY,
			              double width,
			              double height,
			              double epsilon);

}
