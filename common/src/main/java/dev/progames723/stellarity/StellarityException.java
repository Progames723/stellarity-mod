package dev.progames723.stellarity;

import org.jetbrains.annotations.NotNull;

/**
 * idk why but good to know that its the exception cause
 */
public class StellarityException extends RuntimeException {
	@NotNull private final Class<?> exceptionThrowerClass;
	
	public StellarityException(@NotNull Class<?> exceptionThrowerClass) {
		super("%s class caused this exception.\n".formatted(exceptionThrowerClass));
		this.exceptionThrowerClass = exceptionThrowerClass;
	}
	
	public StellarityException(@NotNull Class<?> exceptionThrowerClass, String message) {
		super("%s class caused this exception.\n".formatted(exceptionThrowerClass) + message);
		this.exceptionThrowerClass = exceptionThrowerClass;
	}
	
	public StellarityException(@NotNull Class<?> exceptionThrowerClass, String message, Throwable cause) {
		super("%s class caused this exception.\n".formatted(exceptionThrowerClass) + message, cause);
		this.exceptionThrowerClass = exceptionThrowerClass;
	}
	
	public StellarityException(@NotNull Class<?> exceptionThrowerClass, Throwable cause) {
		super("%s class caused this exception.\n".formatted(exceptionThrowerClass), cause);
		this.exceptionThrowerClass = exceptionThrowerClass;
	}
	
	protected StellarityException(@NotNull Class<?> exceptionThrowerClass, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super("%s class caused this exception.\n".formatted(exceptionThrowerClass) + message, cause, enableSuppression, writableStackTrace);
		this.exceptionThrowerClass = exceptionThrowerClass;
	}
	
	@NotNull
	public Class<?> getExceptionThrowerClass() {
		return exceptionThrowerClass;
	}
}
