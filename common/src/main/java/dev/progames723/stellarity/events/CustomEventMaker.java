package dev.progames723.stellarity.events;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.progames723.stellarity.mixin.EventFactoryInvoker;

import java.lang.reflect.Proxy;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class CustomEventMaker {
	
	private CustomEventMaker() {} //nuh uh
	
	/**
	 * makes a custom event with a custom return parameter
	 * @param obj custom return parameter(can be null but not recommended)
	 * @param typeGetter yes
	 * @return a new {@link Event<T>}
	 * @param <T> {@link Object}
	 * @param <R> {@link Object}
	 */
	@SafeVarargs
	public static <T, R> Event<T> createEvent(R obj, T... typeGetter) {
		if (typeGetter.length != 0) throw new IllegalStateException("array must be empty!");
		return createEvent(obj,(Class<T>) typeGetter.getClass().getComponentType());
	}
	
	/**
	 * the same but different
	 * @param obj custom return parameter(can be null but not recommended)
	 * @param clazz class of the event
	 * @return a new {@link Event<T>}
	 * @param <T> {@link Object}
	 * @param <R> {@link Object}
	 */
	public static <T, R> Event<T> createEvent(R obj, Class<T> clazz) {
		return EventFactory.of(listeners -> (T) Proxy.newProxyInstance(EventFactory.class.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
			for (var listener : listeners) {
				return Objects.requireNonNull(EventFactoryInvoker.invokeMethod(listener, method, args));
			}
			return obj;
		}));
	}
}
