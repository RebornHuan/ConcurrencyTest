package TestConcurrency22.ThreadPoolExecutor2;

public class MainTest {
	public static void main(String[] args) {
		Server server = new Server();
		for (int i = 0; i < 20; i++) {
			Task task = new Task("Task " + i);
			server.executorTask(task);
		}
		server.endServer();
	}
}
