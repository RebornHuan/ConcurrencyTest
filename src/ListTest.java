import java.util.ArrayList;

public class ListTest {
	private String name;

	private ArrayList<String> courses;

	public ListTest(String name, ArrayList<String> courses) {
		this.name = name;
		this.courses = courses;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("001");
		list.add("002");
		ListTest s = new ListTest("Tom", list);

		ArrayList<String> anotherList = s.getCourses();

		anotherList.add("999");

		System.out.println("Tom's course.length = " + s.getCourses().size());
	}
}
