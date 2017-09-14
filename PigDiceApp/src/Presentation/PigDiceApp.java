package Presentation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

import Business.Game;
import Utility.Console;

public class PigDiceApp {

	public static void main(String[] args) {

		String choice = "";
		double totalDieCount = 0;
		double totalRollCount = 0;
		double gameCounter = 0;

		ArrayList<String> rollArray = new ArrayList<>();
		ArrayList<String> scoreArray = new ArrayList<>();
		ArrayList<String> allRollsArray = new ArrayList<>();
		

		// start the game
		Console.displayString("Welcome to the Roll Dice Game");

		choice = Console.getString("Roll Die? (y/n): ");
		
		LocalTime startTime = LocalTime.now();

		while (choice.equalsIgnoreCase("y")) {
			int totalScoreCount = 0;
			int rollCount = 0;
			int rolls = Console.getInt("Maximum amount of rolls: ");
			gameCounter++;

			boolean isValid = false;

			int die = 0;
			while (!isValid) {

				for (int i = 0; i < rolls; i++) {
					// check roll count
					if (i == rolls) {
						System.out.println("i = rolls");
						isValid = true;
						break;
					}
					// roll die
					die = Game.rollDie();
					rollCount++;
					totalRollCount++;
					
					//convert to string to add to ArrayList
					String dieString = Integer.toString(die);
					allRollsArray.add(dieString);

					// check if die equals 1
					if (die == 1) {
						System.out.println(die);
						// add to total count
						totalDieCount += die;
						totalScoreCount += die;

						isValid = true;
						break;
					}
					// else print
					else {
						System.out.println(die);
						totalScoreCount += die;
						totalDieCount += die;
					}
				}
				isValid = true;
			}

			// count and combine totals
			Console.displayString("Score is: " + totalScoreCount);
			String scoreString = Integer.toString(totalScoreCount);
			scoreArray.add(scoreString);
			
			
			
			
			String rollString = Integer.toString(rollCount);
			rollArray.add(rollString);

			
			
			
			
			// play again?
			choice = Console.getString("continue? y/n: ");
		}

		LocalTime endTime = LocalTime.now();
		
		long timePlayed = ChronoUnit.SECONDS.between(startTime, endTime);
		
		
		
		
		
		
		System.out.println();
		Console.displayString("*****GAME ENDED!*****");
		Game.displayHighestScore(scoreArray);
		Console.displayString("Total Overall Score: " + totalDieCount);
		Console.displayString("Total Rolls: " + totalRollCount);
		Game.displayHighestRoll(rollArray);
		Game.displayAverageRoll(totalRollCount, gameCounter);
		Game.displayAvgScore(totalDieCount, gameCounter);
//		Game.displayMostCommonNumber(allRollsArray);
		Console.displayString("How long did we play?: " + timePlayed + " seconds");

		
	}





}
