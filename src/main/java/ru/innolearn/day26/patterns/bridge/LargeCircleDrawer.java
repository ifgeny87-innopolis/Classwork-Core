package ru.innolearn.day26.patterns.bridge;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class LargeCircleDrawer implements Drawer
{
	public static final int radiusMultiplier = 10;

	@Override
	public void drawCircle(int x, int y, int radius)
	{
		System.out.println("Large circle center = " + x + "," + y + " radius = " + radius * radiusMultiplier);
	}

}