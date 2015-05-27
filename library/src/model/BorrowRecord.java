package model;

/**
 * BorrowRecord entity. @author MyEclipse Persistence Tools
 */

public class BorrowRecord implements java.io.Serializable {

	// Fields

	private String recordId;
	private String bookId;
	private String borrowerId;

	// Constructors

	/** default constructor */
	public BorrowRecord() {
	}

	/** full constructor */
	public BorrowRecord(String recordId, String bookId, String borrowerId) {
		this.recordId = recordId;
		this.bookId = bookId;
		this.borrowerId = borrowerId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBorrowerId() {
		return this.borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

}