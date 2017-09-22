package presentation;
import java.util.ArrayList;
import business.Store;
import db.BBFactory;
import utility.Console;
import utility.Formatter;
import utility.StringUtil;
import db.BBDAO;

public class BigBoxApp {
	private static BBDAO dao;
	private final static int DIV_NO_LENGTH = 3;
	private final static int STORE_NO_LENGTH = 5;
	private final static int NAME_LENGTH = 20;

	public static void main(String[] args) {
		Console.displayString("Welcome to the BigBoxApp!");
		dao = BBFactory.getBBDAO();
		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			Console.displayString();
			Console.displayString("Command Menu");
			Console.displayString("list      - List All Stores");
			Console.displayString("array     - Array of stores");
			Console.displayString("div       - List All Stores for a Division");
			Console.displayString("sales     - Sales Summary All Stores");
			Console.displayString("divsales  - Sales Summary for a Division");
			Console.displayString("exit      - Exit the Application");
			Console.displayString();
			String displayString = "";
			command = Console.getString("Enter command:  ");
		
			if (command!=null) {
				if (command.equalsIgnoreCase("list")) {
					displayString = listAllStores();
					Console.displayString(displayString);

				} else if (command.equalsIgnoreCase("div")) {
					String divNbr = Console.getStringNbr("Enter division #:  ");
					displayString = listAllStores(divNbr);
					Console.displayString(displayString);
				} else if (command.equalsIgnoreCase("add")) {
					Console.displayString("Not yet implemented");
				} else if (command.equalsIgnoreCase("sales")) {
						String formattedSales = Formatter.getFormattedDouble(dao.getSalesSummary());
						Console.displayString("Sales summary:  "+formattedSales);
				} else if (command.equalsIgnoreCase("divsales")) {
					String divNbr = Console.getStringNbr("Div #:  ");
					String formattedSales = Formatter.getFormattedDouble(dao.getSalesSummary(divNbr));
					Console.displayString("Sales summary for Division "+divNbr+":  "+formattedSales);
				} else if (command.equalsIgnoreCase("exit")) {
					Console.displayString("Bye");
				} else {
					Console.displayString("Invalid command.  Please try again");
				}
			}
		}		
	}
	
	private static String listAllStores() {
		String str = "";
		ArrayList<Store> stores = dao.listAllStores();
		str = generateStoresReport(stores);
		return str;
	}


	private static String listAllStores(String d) {
		String str = "";
		ArrayList<Store> stores = dao.listAllStores(d);
		str = generateStoresReport(stores);
		return str;
	}
	

	private static String generateStoresReport(ArrayList<Store> stores) {
		StringBuilder sb = new StringBuilder();
		sb.append(StringUtil.pad("Div#", DIV_NO_LENGTH+2));
		sb.append(StringUtil.pad("Store#", " ", STORE_NO_LENGTH+3));
		sb.append(StringUtil.pad("Name", " ", NAME_LENGTH));
		sb.append("\n");
		sb.append(StringUtil.pad("", "=", DIV_NO_LENGTH));
		sb.append("  ");
		sb.append(StringUtil.pad("", "=", STORE_NO_LENGTH+1));
		sb.append("  ");
		sb.append(StringUtil.pad("", "=", NAME_LENGTH));
		sb.append("\n");
		for (Store s: stores) {
			sb.append(StringUtil.pad(s.getDivisionNumber(), DIV_NO_LENGTH+2));
			sb.append(StringUtil.pad(s.getStoreNumber(), " ", STORE_NO_LENGTH+3));
			sb.append(StringUtil.pad(s.getName(), " ", NAME_LENGTH));
			sb.append("\n");
		}
		return sb.toString();
	}
}
