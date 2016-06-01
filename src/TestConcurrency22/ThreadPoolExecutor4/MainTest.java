package TestConcurrency22.ThreadPoolExecutor4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 运行多个任务并处理第一个结果；
 * invokeAny() 收到一个任务列表，然后运行任务，
 * 并返回第一个完成任务并且没有抛出异常的任务的执行结果。
 * 
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {

		String username = "test";
		String password = "test";

		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");

		TaskValidator ldapTask = new TaskValidator(ldapValidator, username,
				password);
		TaskValidator dbTask = new TaskValidator(dbValidator, username,
				password);

		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);

		ExecutorService executorService = Executors.newCachedThreadPool();

		String result;

		try {
			result = executorService.invokeAny(taskList);
			System.out.printf("Main: Result: %s \n",result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
		System.out.printf("Main: End of the Execution \n");

	}

}
