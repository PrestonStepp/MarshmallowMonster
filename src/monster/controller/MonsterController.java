package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController 
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	public void start()
	{
		boolean finished = true;
		int count = 0;
//		while(count < 100)
//		{
//			popup.displayText("I am so neat! " + count);
//			count += 1;
//		}
//		
		for(int loop = 0; loop < 15; loop += 1)
		{
			popup.displayText("I am looping " + (loop + 1) + " times out of 15");
		}
		
		MarshmallowMonster sample = new MarshmallowMonster();
//		System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Good Ol' NoName", 8, 1, 4.5, true);
		
//		System.out.println(realMonster);
//		popup.displayText(realMonster.toString());
//		System.out.println("Preston is hungry, so he is going to eat a tentacle");
//		popup.displayText("Preston is hungry, so he is going to eat a tentacle");
		realMonster.setTentacleAmount(3.5);
//		System.out.println(realMonster);
//		popup.displayText(realMonster.toString());
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
		interactWithTheMonster(realMonster);
	}

	private void testList()
	{
		for(int index = 0; index < monsterList.size();  index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What should my new name be???");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
		}
		
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("What should my new name be?");
			current.setName(newName);
			popup.displayText(current.getName());
		}
	
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
		
		while(! isValidInteger(unconverted)) 
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms?????");
		}
		
//		if(isValidInteger(unconverted))
//		{
			specialAnswer = Integer.parseInt(unconverted);
//		}
		
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