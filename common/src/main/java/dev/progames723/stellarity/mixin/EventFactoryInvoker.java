package dev.progames723.stellarity.mixin;

import dev.architectury.event.EventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

@Mixin(EventFactory.class)
public interface EventFactoryInvoker {
	@Invoker("invokeMethod")
	static <T, R> R invokeMethod(T listener, Method method, Object[] args) throws Throwable {
		throw new AssertionError();
	}
}
