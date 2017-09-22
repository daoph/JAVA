
public class Task {

	public static void main(String[] args) {
		TaskDB db = new TaskDB();
		String command = "";

		Console.displayString("Task List");
		System.out.println();
		Console.displayString("Command Menu");
		Console.displayString("view		-View Pending Tasks");
		Console.displayString("history		-View Completed Tasks");
		Console.displayString("add		-Add a Task");
		Console.displayString("complete	-Complete a Task");
		Console.displayString("delete		-Delete a Task");
		Console.displayString("exit		-Exit App");

		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Command: ");

			switch (command) {

			case "view":
				Console.displayString(db.viewTasks());
				break;
			case "history":
				Console.displayString(db.viewCompleted());
				break;
			case "complete":
				db.completeTask();
				break;
			case "add":
				db.addTask();
				break;
			case "delete":
				db.deleteTask();
				break;
				
			case "exit":
				command = "exit";
				break;

			}
		}

	}

}
