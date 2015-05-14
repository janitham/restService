package rest.com;

public class Track {

	////{"id":1,"content":"Hello, World!"}

	int id;
	String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", content=" + content + "]";
	}

}
