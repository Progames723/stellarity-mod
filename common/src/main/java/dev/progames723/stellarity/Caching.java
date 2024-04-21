package dev.progames723.stellarity;

import java.util.ArrayList;
import java.util.List;

public class Caching<T> {//use later instead of OldCaching
	private final List<T> caches = new ArrayList<>();
	
	private T defaultVal;
	
	public Caching(T defaultVal) {
		this.defaultVal = defaultVal;
	}
	
	public List<T> getCaches() {
		return caches;
	}
	
	public T getDefaultVal() {
		return defaultVal;
	}
	
	public void addCachedObject(T obj) {
		if (obj != null) caches.add(obj);
		else caches.add(defaultVal);
	}
	
	public void setDefaultVal(T defaultVal) {
		this.defaultVal = defaultVal;
	}
}
