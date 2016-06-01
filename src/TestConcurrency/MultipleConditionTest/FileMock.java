package TestConcurrency.MultipleConditionTest;

public class FileMock {
	private String content[];
	private int index;

	public FileMock(int size, int length) {
		content = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuffer buffer = new StringBuffer(length);
			for (int j = 0; j < length; j++) {
				int indice = (int) Math.random() * 255;
				buffer.append((char) indice);
			}
			content[i] = buffer.toString();
		}
		index = 0;
	}

	public boolean hasMockLines() {
		return index < content.length;
	}

	public String getLine() {
		if (this.hasMockLines()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}

}
