package dev.progames723.stellarity.items;

import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;

public interface SpecialAbilityItem {
	default boolean isProgressBarFull() {
		return getProgressBarMaxValue() == getProgressBarValue() || getProgressBarPercentage() == 1;
	}
	
	default boolean isProgressBarEmpty() {
		return getProgressBarValue() == 0 || getProgressBarPercentage() == 0;
	}
	
	void setProgressBarPercentage(double percentage);
	
	void setProgressBarValue(int value);
	
	void setProgressBarMaxValue(int value);
	
	double getProgressBarPercentage();//from 0 to 1
	
	int getProgressBarValue();
	
	int getProgressBarMaxValue();
	
	Vec3i getGradientColors1();
	
	void setGradientColors1(Vec3i colors);
	
	boolean shouldOverrideHiddenBar();
	
	default boolean showCustomBar() {return false;}
	
	default boolean shouldShowCustomBar() {
		return (!isProgressBarFull() && !isProgressBarEmpty() && showCustomBar()) || shouldOverrideHiddenBar();
	}
	
	default void setGradientColors1(int red, int green, int blue) {
		setGradientColors1(new Vec3i(red, green, blue));
	}
	
	Vec3i getGradientColors2();
	
	void setGradientColors2(Vec3i colors);
	
	default void setGradientColors2(int red, int green, int blue) {
		setGradientColors2(new Vec3i(red, green, blue));
	}
	
	default int getCustomBarWidth() {
		return (int) Mth.clamp(getProgressBarPercentage()*13, 0.0, 13.0);
	}
}
