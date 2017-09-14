package Business;

import java.util.ArrayList;
import java.util.Arrays;


import Utility.Console;

public class Game {

	public static int rollDie() {
		int die = (int) (Math.random()*6 + 1);
		return die;
		
	}
	
	public static void displayHighestRoll(ArrayList<String> rollArray) {
		double [] dblArray = new double[rollArray.size()];
		
		for (int i = 0; i < rollArray.size(); i++) {
		     double nbr = Double.parseDouble(rollArray.get(i));
		     dblArray[i] = nbr;
		}
		Arrays.sort(dblArray);
		Console.displayString("Highest amount of rolls is: " + dblArray[dblArray.length-1]);
	}
	
	public static void displayHighestScore(ArrayList<String> scoreArray) {
		
		double [] dblArray = new double[scoreArray.size()];
		
		for (int i = 0; i < scoreArray.size(); i++) {
		     double nbr = Double.parseDouble(scoreArray.get(i));
		     dblArray[i] = nbr;
		}
		Arrays.sort(dblArray);
		Console.displayString("Highest score is: " + dblArray[dblArray.length-1]);
	}
	
	
	
	
	public static void displayAverageRoll(double totalRollCount, double gameCounter) {
		double avgRolls = totalRollCount/gameCounter;
		Console.displayString("Average rolls per game " + avgRolls);
	}
	
	public static void displayAvgScore(double totalDieCount, double gameCounter) {
		double avgScore = totalDieCount/gameCounter;
		Console.displayString("Average score per game: " + avgScore);
	}
	
//	public static void displayMostCommonNumber(ArrayList<String> allRollsArray) {
//		double [] dblArray = new double[allRollsArray.size()];
//		
//		for (int i = 0; i < allRollsArray.size(); i++) {
//		     double nbr = Double.parseDouble(allRollsArray.get(i));
//		     dblArray[i] = nbr;
//		}
//		
//		
//		
//		Console.displayString("The most common number rolled is: " +  dblArray[0]);
//	}
	
	
	
	
	
	
	
	
}
