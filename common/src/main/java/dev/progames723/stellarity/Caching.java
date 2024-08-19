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
	
	public void changeCaches(List<T> newCaches) {
		for (int i = 0; i < newCaches.size(); i++) {
			T obj = newCaches.get(i);
			if (caches.get(i) == null) caches.add(obj);
			else caches.set(i, obj);
		}
	}
	
	public T getDefaultVal() {
		return defaultVal;
	}
	
	public void addCachedObject(T obj) {
		if (obj != null) caches.add(obj);
		else caches.add(defaultVal);
	}
	
	public boolean removeCachedObject(T obj) {
		return caches.remove(obj);
	}
	
	public void setDefaultVal(T defaultVal) {
		this.defaultVal = defaultVal;
	}
}
