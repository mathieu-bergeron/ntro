package ca.ntro.core.data_structures.trees.region_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class RegionTreeNode2dNtro<R extends Region2d> 

       extends AnonymousRegion2dNtro

       implements RegionTree2dNode<R> {

	
	private Map<String, AnonymousRegion2dNtro> subRegions = new HashMap<>();
	
	private Map<String, RegionTreeNode2dNtro<R>> subNodes = new HashMap<>();

	private Set<R> orphanRegions = new HashSet<>();


	public Map<String, RegionTreeNode2dNtro<R>> getSubNodes() {
		return subNodes;
	}

	public void setSubNodes(Map<String, RegionTreeNode2dNtro<R>> subNodes) {
		this.subNodes = subNodes;
	}

	public Set<R> getOrphanRegions() {
		return orphanRegions;
	}

	public void setOrphanRegions(Set<R> orphanRegions) {
		this.orphanRegions = orphanRegions;
	}

	public RegionTreeNode2dNtro(double topLeftX, double topLeftY, double width, double height) {
		super(topLeftX, topLeftY, width, height);
		
		initializeSubRegions();
	}

	private void initializeSubRegions() {
		for(RegionName regionName : RegionName.values()) {
			switch(regionName){
			case NORTH_WEST:
				subRegions.put(RegionName.NORTH_WEST.name(), new AnonymousRegion2dNtro(topLeftX(), 
						                                                               topLeftY(), 
						                                                               width()/2, 
						                                                               height()/2));
				break;

			case NORTH_EAST:
				subRegions.put(RegionName.NORTH_EAST.name(), new AnonymousRegion2dNtro(topLeftX() + width()/2, 
						                                                               topLeftY(), 
						                                                               width()/2, 
						                                                               height()/2));
				break;

			case SOUTH_WEST:
				subRegions.put(RegionName.NORTH_WEST.name(), new AnonymousRegion2dNtro(topLeftX(), 
						                                                               topLeftY() + height()/2, 
						                                                               width()/2, 
						                                                               height()/2));
				break;
				
			case SOUTH_EAST:
				subRegions.put(RegionName.NORTH_WEST.name(), new AnonymousRegion2dNtro(topLeftX() + width() /2, 
						                                                               topLeftY() + height()/2, 
						                                                               width()/2, 
						                                                               height()/2));
				break;
			}
		}
	}

	@Override
	public void add(R region, double epsilon) {
		Set<String> containedIn = containedInSubRegions(region, epsilon);

		if(containedIn.size() == 1) {
			containedIn.forEach(subNodeName -> {

				addToSubNode(region, subNodeName, epsilon);

			});

		}else {
			
			addToOrphans(region);
			
		}
	}
	
	private Set<String> containedInSubRegions(AnonymousRegion2d region, double epsilon){
		Set<String> containedIn = new HashSet<>();

		for(RegionName regionName : RegionName.values()) {
			if(region.isContainedIn(subRegions.get(regionName.name()), epsilon))
				containedIn.add(regionName.name());
		}
		
		return containedIn;
	}

	private void addToSubNode(R region, String subNodeName, double epsilon) {
		RegionTreeNode2dNtro<R> subNode = subNodes.get(subNodeName);

		if(subNode == null) {
			subNode = createSubNode(subNodeName);
		}
		
		subNode.add(region, epsilon);
	}

	private RegionTreeNode2dNtro<R> createSubNode(String subNodeName) {
		AnonymousRegion2dNtro subRegion = subRegions.get(subNodeName);

		return new RegionTreeNode2dNtro<R>(subRegion.topLeftX(),
				                           subRegion.topLeftY(),
				                           subRegion.width(),
				                           subRegion.height());
	}

	private void addToOrphans(R region) {
		orphanRegions.add(region);
	}


	@Override
	public void remove(R region, double epsilon) {
		Set<String> containedIn = containedInSubRegions(region, epsilon);

		if(containedIn.size() == 1) {
			containedIn.forEach(subNodeName -> {

				removeFromSubNode(region, subNodeName, epsilon);

			});

		}else {
			
			removeFromOrphans(region, epsilon);
		}
	}

	private void removeFromSubNode(R region, String subNodeName, double epsilon) {
		subNodes.get(subNodeName).remove(region, epsilon);
	}

	private void removeFromOrphans(R region, double epsilon) {
		Set<R> toRemove = new HashSet<>();
		
		for(R orphan : orphanRegions) {
			if(orphan.isEqualTo(region, epsilon)) {
				toRemove.add(orphan);
			}
		}

		orphanRegions.removeAll(toRemove);
	}

	@Override
	public Stream<R> get(AnonymousRegion2d regionSpec, double epsilon) {
		Stream<R> result = null;
		Set<String> containedIn = containedInSubRegions(regionSpec, epsilon);

		if(containedIn.size() == 1) {
			for(String subNodeName : containedIn) {
				result = subNodes.get(subNodeName).get(regionSpec, epsilon);
			}

		}else {
			
			result = getFromOrphans(regionSpec, epsilon);
			
		}
		
		return result;
	}

	private Stream<R> getFromOrphans(AnonymousRegion2d regionSpec, double epsilon) {
		return new StreamNtro<R>() {

			@Override
			public void forEach_(Visitor<R> visitor) throws Throwable {
				for(R orphan : orphanRegions) {
					if(orphan.isEqualTo(regionSpec, epsilon)) {
						visitor.visit(orphan);
					}
				}
			}
		};
	}

	@Override
	public Stream<R> get(double topLeftX, 
			             double topLeftY, 
			             double width, 
			             double height, 
			             double epsilon) {
		
		return get(new AnonymousRegion2dNtro(topLeftX, topLeftY, width, height), epsilon);
	}

	@Override
	public Stream<R> intersectWith(AnonymousRegion2d otherRegion, double epsilon) {
		return new StreamNtro<R>() {
			@Override
			public void forEach_(Visitor<R> visitor) throws Throwable {
				
				for(Map.Entry<String, AnonymousRegion2dNtro> entry : subRegions.entrySet()) {
					if(entry.getValue().intersectsWith(otherRegion, epsilon)) {
						RegionTreeNode2dNtro<R> subNode = subNodes.get(entry.getKey());
						if(subNode != null) {
							subNode.intersectWith(otherRegion, epsilon).forEach(r -> {
								visitor.visit(r);
							});
						}
					}
				}
				
				for(R orphan : orphanRegions) {
					if(orphan.intersectsWith(otherRegion, epsilon)) {
						visitor.visit(orphan);
					}
				}
			}
		};
	}

	@Override
	public Stream<R> intersectWith(double topLeftX, 
			                       double topLeftY, 
			                       double width, 
			                       double height,
			                       double epsilon) {
		
		return intersectWith(new AnonymousRegion2dNtro(topLeftX, topLeftY, width, height), epsilon);
	}

	@Override
	public Stream<R> containedIn(AnonymousRegion2d otherRegion, double epsilon) {
		return new StreamNtro<R>() {
			@Override
			public void forEach_(Visitor<R> visitor) throws Throwable {
				
			}
		};
	}

	@Override
	public Stream<R> containedIn(double topLeftX, 
			                     double topLeftY, 
			                     double width,
			                     double height,
			                     double epsilon) {

		return containedIn(new AnonymousRegion2dNtro(topLeftX, topLeftY, width, height), epsilon);
	}

}
