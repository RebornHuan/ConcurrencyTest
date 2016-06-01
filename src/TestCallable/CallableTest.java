package TestCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> resultList = new ArrayList<Future>();

        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            // 最终会实例化一个FutureTask对象，其run方法会调用Callable的call方法，并且支持cancel等操作
            Future future = executorService.submit(new TaskWithResult(i));

            resultList.add(future);// 将任务执行结果存储到List中
        }
        executorService.shutdown();

        // 遍历任务的结果，未执行完会阻塞
        for (Future fs : resultList) {
            // 打印各个线程（任务）执行的结果
            System.out
                    .println(fs.isDone() + "=" + fs.get() + "=" + fs.isDone());
        }
    }
}

class TaskWithResult implements Callable {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被调用！" + Thread.currentThread().getName());

        boolean flag = new Random().nextBoolean();
        if (flag) {
            System.out.println("异常撞击！");
            throw new TaskException("Meet error in task."
                    + Thread.currentThread().getName());
        }

        Thread.sleep(2000);

        return "结果是：" + id;
    }
}

class TaskException extends Exception {

    TaskException(String message) {
        super(message);
    }
}