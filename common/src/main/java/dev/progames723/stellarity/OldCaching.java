package dev.progames723.stellarity;

import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * this will contain variables that can be "cached"
 */
public class OldCaching {
	private static OldCaching caching = null;
	
	private OldCaching() {caching = this;}
	
	public static OldCaching getInstance() {// me when singleton
		if (caching == null) caching = new OldCaching();
		return caching;
	}
	private int tooltipLinesCached = -1;
	private List<Component> finalListCached = new ArrayList<>();
	
	public int getTooltipLinesCached() {
		return tooltipLinesCached;
	}
	
	public void setTooltipLinesCached(int tooltipLinesCached) {
		this.tooltipLinesCached = tooltipLinesCached;
	}
	
	public List<Component> getFinalListCached() {
		return finalListCached;
	}
	
	public void setFinalListCached(List<Component> finalListCached) {
		this.finalListCached = finalListCached;
	}
}
