package ru.innolearn.day26.patterns.bridge;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class SmallCircleDrawer implements Drawer
{
	public static final double radiusMultiplier = 0.25;

	@Override
	public void drawCircle(int x, int y, int radius)
	{
		System.out.println("Small circle center = " + x + "," + y + " radius = " + radius * radiusMultiplier);
	}
}