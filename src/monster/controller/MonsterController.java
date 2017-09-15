package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;


public class MonsterController 
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Good Ol' NoName", 8, 1, 4.5, true);
		
		System.out.println(realMonster);
		System.out.println("Preston is hungry, so he is going to eat a tentac");
		realMonster.setTentacleAmount(3.5);
		System.out.println(realMonster);
		
		interactWithTheMonster(realMonster);
	}

	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
		System.out.println("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount() + " arms left.");
		
	}
}
