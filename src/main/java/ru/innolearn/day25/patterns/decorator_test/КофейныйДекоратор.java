package ru.innolearn.day25.patterns.decorator_test;

/**
 * Created in project Inno-Classroom-Work on 17.01.17
 */
public abstract class КофейныйДекоратор implements КофейныйКомпонент
{
	protected КофейныйКомпонент component;

	public КофейныйДекоратор(КофейныйКомпонент component)
	{
		this.component = component;
	}

	@Override
	public void показатьИнгридиенты()
	{
		component.показатьИнгридиенты();
	}
}
