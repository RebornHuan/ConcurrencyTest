package TestConcurrency22.ThreadPoolExecutorTest;

public class MainTest {
	public static void main(String[] args) {
		Server server = new Server();
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task " + i);
			server.executorTask(task);
		}
		server.endServer();
	}
}
