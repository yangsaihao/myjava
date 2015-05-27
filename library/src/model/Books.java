package model;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */

public class Books implements java.io.Serializable {

	// Fields

	private String bookId;
	private String bookName;
	private String borrowerId;

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(String bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}

	/** full constructor */
	public Books(String bookId, String bookName, String borrowerId) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.borrowerId = borrowerId;
	}

	// Property accessors

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBorrowerId() {
		return this.borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

}