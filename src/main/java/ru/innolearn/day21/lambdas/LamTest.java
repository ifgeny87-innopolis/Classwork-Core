package ru.innolearn.day21.lambdas;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Тестирование
 *
 * Created in project untitled in 11.01.17
 */
@FunctionalInterface
interface IMyFunctional<F, T>
{
	void collect(F f, T t);
}

public class LamTest
{
	public static void main(String[] args)
	{
		// 1. Функциональный интерфейс
		IMyFunctional imf = (i1, i2) -> {
			System.out.printf("1. Functional interface result: %d, %d \n", i1, i2);
		};
		imf.collect(123, 234);

		// 2. Предикат
		Predicate<Integer> predIsFive = (j) -> j == 5;
		System.out.println("2. Predicat result: " + predIsFive.test(123));

		// 3. Функция
		Function<String, Integer> lengthFunc = (s) -> s.length();
		System.out.println("3. Function result: " + lengthFunc.apply("Cry baby cry"));

		// 4. Подстановщик
		Supplier<String> supplier = String::new;
		System.out.println("4. Supplier result: " + supplier.get().getClass());

		// 5. Потребитель
		Consumer<Integer> consumer = (i) -> System.out.println("5. Consumer says: " + i);
		consumer.accept(2048);

		// 6. Сравниватель
		Comparator<Boolean> trueComparator = (b1, b2) -> b1 && b2 ? 1 : 0;
		System.out.println("6. Comparator result: " + trueComparator.compare(false, true));

		// 7. Опшн
		Optional<String> optional = Optional.of("Genky");
		System.out.printf("7. Optional result: %s, %s\n",
				optional.get(),
				optional.isPresent());
		optional.ifPresent(s -> {s = "Genky";});
	}
}