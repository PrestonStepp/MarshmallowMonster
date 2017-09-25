package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController 
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
//		System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Good Ol' NoName", 8, 1, 4.5, true);
		
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
//		System.out.println("Preston is hungry, so he is going to eat a tentacle");
		popup.displayText("Preston is hungry, so he is going to eat a tentacle");
		realMonster.setTentacleAmount(3.5);
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		interactWithTheMonster(realMonster);
	}

	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
//		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
//		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		popup.displayText(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
//		System.out.println("How many do you want to eat?");
		int specialAnswer;
		String unconverted = popup.getResponse("How many do you want to eat?");
		if(isValidInteger(unconverted))
		{
			specialAnswer = Integer.parseInt(unconverted);
		}
		
		
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		
		if(consumed < 0)
		{
			System.out.println("You cannot eat a negative amount silly human");
		}
		else if(consumed == 0)
		{
			System.out.println("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
		}	
		if(consumed < 0)
		{
			System.out.println("Cant eat that sorry");
		}
		else if(consumed == 0)
		{
			System.out.println("Methinks you are not hungry");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
			System.out.println("Thanks! I only have this many eyes now: " + currentMonster.getEyeCount());
		}
		
		popup.displayText("Hey look at me!!!!");
		String answer = popup.getResponse("How many meals are you eating today");
		System.out.println(answer);
		popup.displayText(answer);
		
	}
	
	//Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only integer calues are valid: " +sample + " is not");
		}
		
		return valid;
	}
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " + sampleDouble + " is not.");
		}
		
		return valid;
	}
}