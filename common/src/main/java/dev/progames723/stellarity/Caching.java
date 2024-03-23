package dev.progames723.stellarity;

import com.google.common.collect.Lists;
import net.minecraft.network.chat.Component;

import java.util.List;

/**
 * this will contain variables that can be "cached"
 */
public class Caching {
	private Caching() {}
	public static Caching getInstance() {
		return new Caching();
	}
	private int tooltipLinesCached = -1;
	private List<Component> finalListCached = Lists.newArrayList();
	
	public int getTooltipLinesCached() {
		return tooltipLinesCached;
	}
	
	public void setTooltipLinesCached(int stellarity$tooltipLinesCached) {
		this.tooltipLinesCached = stellarity$tooltipLinesCached;
	}
	
	public List<Component> getFinalListCached() {
		return finalListCached;
	}
	
	public void setFinalListCached(List<Component> finalListCached) {
		this.finalListCached = finalListCached;
	}
}
