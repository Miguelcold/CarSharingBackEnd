package co.edu.udea.carsharing.model.entities;

import java.io.Serializable;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private static String AUTHOR = "author";
	private static String MESSAGE = "message";
	private static String CREATEDATE = "createDate";

	private User author;
	private String message;
	private Date createDate;

	public Comment() {
		super();
	}

	public Comment(User author, String message, Date createDate) {
		super();
		this.author = author;
		this.message = message;
		this.createDate = createDate;
	}

	public static Comment entityFromDBObject(DBObject dbObject) {
		Comment comment = new Comment();

		if (dbObject.containsField(AUTHOR)) {
			comment.setAuthor((User) dbObject.get(AUTHOR));
		}

		if (dbObject.containsField(MESSAGE)) {
			comment.setMessage((String) dbObject.get(MESSAGE));
		}

		if (dbObject.containsField(CREATEDATE)) {
			comment.setCreateDate((Date) dbObject.get(CREATEDATE));
		}

		return (comment);
	}

	public BasicDBObject entityToDBObject() {
		BasicDBObject basicDBObject = new BasicDBObject();

		if (null != this.getAuthor()) {
			basicDBObject.put(AUTHOR, this.getAuthor());
		}

		if (null != this.getMessage()) {
			basicDBObject.put(MESSAGE, this.getMessage());
		}

		if (null != this.getCreateDate()) {
			basicDBObject.put(CREATEDATE, this.getCreateDate());
		}

		return (basicDBObject);
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}