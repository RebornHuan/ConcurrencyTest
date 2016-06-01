import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListTest {
	private String name;
	private ArrayList<String> courses;

	public UnmodifiableListTest(String name, ArrayList<String> courses) {
		this.name = name;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCourse(String course) {
		courses.add(course);
	}

	public String removeCourse(String course) {
		boolean removed = courses.remove(course);

		if (removed) {
			return course;
		} else {
			return null;
		}
	}

	public List<String> getCourses() {
		return Collections.unmodifiableList(courses);
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("001");
		list.add("002");
		UnmodifiableListTest s = new UnmodifiableListTest("Tom", list);

		List<String> anotherList = s.getCourses();

		/**
		 * throws java.lang.UnsupportedOperationException should replace with
		 * s.addCourse(String course)
		 */
//		anotherList.add("999");

		// never reached
		System.out.println("Tom's course.length = " + s.getCourses().size());
	}
}