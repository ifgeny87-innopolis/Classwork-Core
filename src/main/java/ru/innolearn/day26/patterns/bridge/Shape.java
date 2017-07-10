package ru.innolearn.day26.patterns.bridge;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public abstract class Shape
{
	protected Drawer drawer;

	protected Shape(Drawer drawer)
	{
		this.drawer = drawer;
	}

	public abstract void draw();

	public abstract void enlargeRadius(int multiplier);

}
