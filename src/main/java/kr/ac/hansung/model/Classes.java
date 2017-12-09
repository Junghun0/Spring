package kr.ac.hansung.model;

public class Classes {

	private int year;
	private String name;
	private String semester;
	private String code;
	private String section;
	private int credit;

	public Classes() {
	}

	public Classes(int year, String name, String semester, String code, String section, int credit) {
		super();
		this.year = year;
		this.name = name;
		this.semester = semester;
		this.code = code;
		this.section = section;
		this.credit = credit;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
