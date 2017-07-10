package ru.innolearn.day26.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public class VkAdapter implements ISocialWeb
{
	List<String> getFriendsVk(int userId) {
		return Arrays.asList("Kolya_123", "Sasha", "Petr1", "Pert_1");
	}

	@Override
	public List<String> getFriendList(int userId)
	{
		List<String> friends = getFriendsVk(userId);

		// удаляем id из имени
		return friends.stream()
				.map(s -> s.replaceAll("_.*", ""))
				.collect(Collectors.toList());
	}

	@Override
	public int getBalance(int userId)
	{
		return 0;
	}

	@Override
	public void addMoney(double money, int userId)
	{

	}

	@Override
	public double getMoney(int userId, double money)
	{
		return 0;
	}

	@Override
	public boolean sendToWall(int userId, String message)
	{
		return false;
	}
}
