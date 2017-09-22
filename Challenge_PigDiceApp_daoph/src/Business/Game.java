package Business;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Utility.Console;

public class Game {

	public static int rollDie() {
		int die = (int) (Math.random()*6 + 1);
		return die;
		
	}
	
	public static void displayHighestRoll(ArrayList<Integer> rollArray) {
		Collections.sort(rollArray);
		Collections.reverse(rollArray);
		Console.displayString("Highest number of rolls is: " + rollArray.get(0));
	}
	
	public static void displayHighestScore(ArrayList<Integer> scoreArray) {
		
		Collections.sort(scoreArray);
		Collections.reverse(scoreArray);
		Console.displayString("Highest scoring game is: " + scoreArray.get(0));
	}
	
	
	
	
	public static void displayAverageRoll(double totalRollCount, double gameCounter) {
		double avgRolls = totalRollCount/gameCounter;
		Console.displayString("Average rolls per game " + avgRolls);
	}
	
	public static void displayAvgScore(double totalDieCount, double gameCounter) {
		double avgScore = totalDieCount/gameCounter;
		NumberFormat formattedScore = NumberFormat.getNumberInstance();
		formattedScore.setMaximumFractionDigits(2);
		String score = formattedScore.format(avgScore);
		Console.displayString("Average score per game: " + score);
	}
	
//	public static void displayMostCommonNumber(ArrayList<Integer> allRollsArray) {
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
