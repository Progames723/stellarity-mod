package dev.progames723.stellarity;

import io.netty.util.concurrent.DefaultEventExecutorGroup;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunTaskLater {
	private static final ScheduledExecutorService scheduledExecutorService = new DefaultEventExecutorGroup(Runtime.getRuntime().availableProcessors() < 4 ? 1 : 2);
	
	public static void runTaskLater(Runnable runnable, long ticks) {//straightforward
		scheduledExecutorService.schedule(runnable, ticks * 50L, TimeUnit.MILLISECONDS);
	}
	
	public static void runRepeatingTask(Runnable runnable, long initialDelayTicks, long ticks) {
		scheduledExecutorService.scheduleAtFixedRate(runnable, initialDelayTicks, ticks * 50L, TimeUnit.MILLISECONDS);
	}
	
	public static void runTaskLaterPrecise(Runnable runnable, long timeToWait, TimeUnit timeUnit) {
		scheduledExecutorService.schedule(runnable, timeToWait, timeUnit);
	}
	
	public static void runRepeatingTaskPrecise(Runnable runnable, long initialDelay, long timeToWait, TimeUnit timeUnit) {
		scheduledExecutorService.scheduleAtFixedRate(runnable, initialDelay, timeToWait, timeUnit);
	}
}
