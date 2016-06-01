package TestConcurrency.CountDownLatchTest;

/**
 * 视频会议系统
 * 等待所有参与者到齐后才开始；
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {
		Videoconference conference = new Videoconference(10);
		Thread threadConference = new Thread(conference);
		threadConference.start();
		for (int i = 0; i < 10; i++) {
			Participant p = new Participant(conference, "participant " + i);
			Thread t = new Thread(p);
			t.start();
		}
	}

}
