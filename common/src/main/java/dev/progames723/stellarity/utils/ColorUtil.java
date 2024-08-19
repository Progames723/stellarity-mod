package dev.progames723.stellarity.utils;

import net.minecraft.core.Vec3i;
import org.jetbrains.annotations.Range;
import org.joml.Vector4i;

public class ColorUtil {
	public static long RGBToDecimalColor(Vec3i colors) {
		return RGBToDecimalColor(colors.getX(), colors.getY(), colors.getZ());
	}
	
	public static Vector4i RGBToARGB(Vec3i colors) {
		return RGBToARGB(0, colors);
	}
	
	public static Vector4i RGBToARGB(@Range(from = 0, to = 255) int a, Vec3i colors) {
		return new Vector4i(a, colors.getX(), colors.getY(), colors.getZ());
	}
	
	public static Vector4i RGBToARGB(@Range(from = 0, to = 255) int a, @Range(from = 0, to = 255) int r, @Range(from = 0, to = 255) int g, @Range(from = 0, to = 255) int b) {
		return new Vector4i(a, r, g, b);
	}
	
	public static long RGBToDecimalColor(@Range(from = 0, to = 255) int r, @Range(from = 0, to = 255) int g, @Range(from = 0, to = 255) int b) {
		return (long) r << 16 + g << 8 + b;//easy
	}
	
	public static long ARGBToDecimalColor(Vector4i colors) {
		return ARGBToDecimalColor(colors.x, colors.y, colors.z, colors.w);
	}
	
	public static long ARGBToDecimalColor(@Range(from = 0, to = 255) int a, @Range(from = 0, to = 255) int r, @Range(from = 0, to = 255) int g, @Range(from = 0, to = 255) int b) {
		return (long) a << 24 + r << 16 + g << 8 + b;//easy
	}
	
	public static Vec3i decimalToRGBColor(int decimal) {//help me
		int red = (decimal >> 16) & 0xff;
		int green = (decimal >> 8) & 0xff;
		int blue = decimal & 0xff;
		return new Vec3i(red, green, blue);
	}
	
	public static Vector4i decimalToARGBColor(int decimal) {//help me
		int alpha = (decimal >> 24) & 0xff;
		int red = (decimal >> 16) & 0xff;
		int green = (decimal >> 8) & 0xff;
		int blue = decimal & 0xff;
		return new Vector4i(alpha, red, green, blue);
	}
}
