package ru.innolearn.day26.patterns;

import java.util.List;

/**
 * Created in project Inno-Classroom-Work on 18.01.17
 */
public interface ISocialWeb
{
	List<String> getFriendList(int userId);
	int getBalance(int userId);
	void addMoney(double money, int userId);
	double getMoney(int userId, double money);
	boolean sendToWall(int userId, String message);
}
