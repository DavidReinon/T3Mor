package es.florida.hibernate.MiniProjecte;

public class Llibre {
	private int id;
	private String title;
	private int author;
	private int year;
	private int editorial;
	private int pages;

	public Llibre(String title, int author, int year, int editorial, int pages) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.editorial = editorial;
		this.pages = pages;
	}

	public Llibre() {
		super();
	}

	public int getAuthor() {
		return author;
	}

	public int getEditorial() {
		return editorial;
	}

	public int getId() {
		return id;
	}

	public int getPages() {
		return pages;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public void setEditorial(int editorial) {
		this.editorial = editorial;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
